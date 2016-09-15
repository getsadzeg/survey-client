package pi.survey.services;

import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
public class ServiceGenerator {
    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass, Context context) {

        OkHttpClient client = new OkHttpClient();

        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint("http://192.168.1.21/")
                .setConverter(new LoganSquareConverter())
                .setClient(new OkClient(client))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}
