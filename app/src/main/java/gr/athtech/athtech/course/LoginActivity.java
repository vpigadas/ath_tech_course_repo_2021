package gr.athtech.athtech.course;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AbstractActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    int getLayout() {
        return R.layout.activity_login_v2;
    }

    @Override
    void initLayout() {
        Button btnLogin = findViewById(R.id.login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button btnCancel = findViewById(R.id.cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

    }

    @Override
    void runOperations() {

    }

    @Override
    void stopOperations() {

    }
}