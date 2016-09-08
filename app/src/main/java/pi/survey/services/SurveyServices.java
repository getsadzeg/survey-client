package pi.survey.services;


import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public interface SurveyServices {
    @FormUrlEncoded
    @POST("/survey.php")
    void submit(@Field("surveyobj") String obj,
                Callback<submitResponse> responseCallback);
}
