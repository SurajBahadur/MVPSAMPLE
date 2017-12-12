package krescent.com.mvpsample;

import krescent.com.mvpsample.LoginModel.UserData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sys-roid on 11/12/17.
 */

public class LoginContract {

    public interface View {
        void showLoader();

        void hideLoader();

        void getUserId(UserData data);

    }

    //https://jsonplaceholder.typicode.com/posts?userId=1
    public interface Service {

        @GET("posts")
        Call<UserData> getPost(@Query("userId") String userId);

    }
}
