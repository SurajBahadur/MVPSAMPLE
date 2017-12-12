package krescent.com.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import krescent.com.mvpsample.LoginModel.UserData;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText et_user_id;
    private ProgressBar pb_loader;
    private LoginPresenter loginPresenter;
    private static final String TAG = "TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize the construction of loginPresenter with the login activity context
        loginPresenter = new LoginPresenter(this);
        et_user_id = findViewById(R.id.et_user_id);
        pb_loader = findViewById(R.id.pb_loader);

        findViewById(R.id.btn_show_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateField();
            }
        });
    }


    @Override
    public void showLoader() {
        pb_loader.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        pb_loader.setVisibility(View.GONE);
    }

    @Override
    public void showUserPost(UserData data) {
        Log.d(TAG, data.toString());
    }

    @Override
    public void showEmptyFieldError() {
        Toast.makeText(this, "Please enter user id", Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUserid() {
        return et_user_id.getText().toString();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(this, "Please try again later", Toast.LENGTH_SHORT).show();
    }

}
