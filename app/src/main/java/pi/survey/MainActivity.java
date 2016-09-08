package pi.survey;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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
    Survey survey = null;
    SurveyServices ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.editText);
        surname = (EditText) findViewById(R.id.editText2);
        middle_name = (EditText) findViewById(R.id.editText3);
        members = (EditText) findViewById(R.id.editText4);
        survey = new Survey(name.getText().toString(), surname.getText().toString(),
                middle_name.getText().toString(), Integer.parseInt(members.getText().toString()));


    }
    public void submitOnClick(View v) {
        ss = ServiceGenerator.createService(SurveyServices.class, this);
        ss.submit(survey.returnJSON(), new Callback<submitResponse>() {
            @Override
            public void success(submitResponse submitResponse, Response response) {
                System.out.println("response: " + submitResponse);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
