package krescent.com.mvpsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import krescent.com.mvpsample.LoginModel.UserData;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private EditText et_user_id;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        et_user_id=findViewById(R.id.et_user_id);


        findViewById(R.id.btn_show_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }


    @Override
    public void showLoader() {

    }

    @Override
    public void hideLoader() {

    }

    @Override
    public void getUserId(UserData data) {

    }

}
