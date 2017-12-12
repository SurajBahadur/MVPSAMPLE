package krescent.com.mvpsample;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import krescent.com.mvpsample.LoginModel.UserData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sys-roid on 11/12/17.
 */

public class LoginPresenter {
    private LoginContract.View view;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    LoginPresenter(LoginContract.View view) {
        this.view = view;
    }

    void validateField() {
        if (view.getUserid().isEmpty()) {
            view.showEmptyFieldError();
        } else {
            getUserData(view.getUserid());
        }

    }

    private void getUserData(String userId) {

        view.showLoader();

        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();


        LoginContract.Service service = retrofit.create(LoginContract.Service.class);
        Call<UserData> call = service.getPost(userId);
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, Response<UserData> response) {

                view.hideLoader();
                Log.d("TAG", "dfsd");

                //view.showUserPost(response.body());
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                Log.d("TAG=", t.getLocalizedMessage());
                view.hideLoader();
                view.showErrorMessage();
            }
        });
    }

}
