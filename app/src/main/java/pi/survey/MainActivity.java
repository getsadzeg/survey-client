package pi.survey;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.support.v7.app.AlertDialog;

import pi.survey.model.Survey;
import pi.survey.services.ServiceGenerator;
import pi.survey.services.SurveyServices;
import pi.survey.services.submitResponse;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText surname;
    EditText middle_name;
    EditText members;
    int int_members;
    Survey survey = null;
    SurveyServices ss;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static final String TAG = "MyActivity";
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText);
        surname = (EditText) findViewById(R.id.editText2);
        middle_name = (EditText) findViewById(R.id.editText3);
        members = (EditText) findViewById(R.id.editText4);


    }

    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // storage-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }

            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public SurveyServices returnService() {
        return ServiceGenerator.createService(SurveyServices.class, this);
    }

    public void submitOnClick(View v) {
        verifyStoragePermissions(this);
        if(members.getText().toString().matches("[0-9]+")) {
            int_members = Integer.parseInt(members.getText().toString());
            if(int_members > 25) errorDialog(R.string.error_msg);
        }
        else {
            int_members = 0; //temporary. will throw exception in the future
            android.util.Log.e(TAG, "Members should be provided!");
        }
        survey = new Survey(name.getText().toString(), surname.getText().toString(),
                middle_name.getText().toString(), int_members );
        ss = returnService();
        ss.submit(survey.returnJSON(), new Callback<submitResponse>() {
            @Override
            public void success(submitResponse submitResponse, Response response) {
                System.out.println("inside success method. response: " + submitResponse);
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                error.getResponse().getReason();
            }
        });
    }

    private void errorDialog(int message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle(message);
        builder.setPositiveButton(R.string.dialog_button_ok, null);
        builder.show();
    }

}
