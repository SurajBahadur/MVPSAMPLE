package krescent.com.mvpsample;

import krescent.com.mvpsample.LoginModel.UserData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Contract contain the interface method whether related to view ,webservice and action etc.
 * Implemented in LoginActivity and call from loginPresenter class
 */
class LoginContract {

    public interface View {

        void showLoader();

        void hideLoader();

        void showUserPost(UserData data);

        void showEmptyFieldError();

        String getUserid();

        void showErrorMessage();

    }

    //https://jsonplaceholder.typicode.com/posts?userId=1
    public interface Service {

        @GET("posts")
        Call<UserData> getPost(@Query("userId") String userId);

    }
}
