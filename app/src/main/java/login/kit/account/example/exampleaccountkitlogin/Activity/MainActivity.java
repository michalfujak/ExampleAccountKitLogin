package login.kit.account.example.exampleaccountkitlogin.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import login.kit.account.example.exampleaccountkitlogin.Common.Common;
import login.kit.account.example.exampleaccountkitlogin.Model.APIResponse;
import login.kit.account.example.exampleaccountkitlogin.R;
import login.kit.account.example.exampleaccountkitlogin.Remote.IAccountAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // Initializable component
    TextView textViewJustRegister, textViewDontHaveAccount;
    Button buttonLoginSubmitIn;
    MaterialEditText fieldLoginEmailEditText, fieldLoginPasswordEditText;
    // interface
    IAccountAPI Iservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Iservice init
        Iservice = Common.getAPI();
        // active clicked register

        // initializable component
        textViewJustRegister = (TextView)findViewById(R.id.text_view_account_login_form_next_message_register_txt2);
        fieldLoginEmailEditText = (MaterialEditText)findViewById(R.id.login_field_email);
        fieldLoginPasswordEditText = (MaterialEditText)findViewById(R.id.login_field_password);
        buttonLoginSubmitIn = (Button)findViewById(R.id.login_button_submit_action);

        // Action start active register
        textViewJustRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        // Button action clicked
        buttonLoginSubmitIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authUserAction(fieldLoginEmailEditText.getText().toString(), fieldLoginPasswordEditText.getText().toString());
            }
        });
    }

    private void authUserAction(String email, String password)
    {
        // login user...
        // call service
        Iservice.loginUser(email, password)
                .enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                        // Response
                        APIResponse result = response.body();
                        if(result.isError())
                        {
                            Toast.makeText(MainActivity.this, result.getError_msg(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            // Login done, activityHome start
                            Toast.makeText(MainActivity.this, "Login success: " + result.getUid(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity.this, HomeActivity.class));
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<APIResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
