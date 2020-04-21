package login.kit.account.example.exampleaccountkitlogin.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import login.kit.account.example.exampleaccountkitlogin.Common.Common;
import login.kit.account.example.exampleaccountkitlogin.Model.APIResponse;
import login.kit.account.example.exampleaccountkitlogin.R;
import login.kit.account.example.exampleaccountkitlogin.Remote.IAccountAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    // Implement components
    MaterialEditText fieldRegEmailEditText, fieldRegNameEditText, fieldRegPasswordEditText;
    Button buttonRegSubmitIn;
    //
    IAccountAPI Iservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //
        // initializable component
        fieldRegEmailEditText = (MaterialEditText)findViewById(R.id.register_field_email);
        fieldRegNameEditText = (MaterialEditText)findViewById(R.id.register_field_name);
        fieldRegPasswordEditText = (MaterialEditText)findViewById(R.id.register_field_password);
        buttonRegSubmitIn = (Button)findViewById(R.id.register_button_submit_action);
        //
        Iservice = Common.getAPI();

        // Action event
        buttonRegSubmitIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createRegisterUser(fieldRegEmailEditText.getText().toString(), fieldRegNameEditText.getText().toString(), fieldRegPasswordEditText.getText().toString());
            }
        });
    }

    /**
     *
     * @param email
     * @param name
     * @param password
     */
    private void createRegisterUser(String email, String name, String password)
    {
        // Register user
        // Call service register
        Iservice.registerUser(name, email, password)
                .enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                        APIResponse result = response.body();
                        if(result.isError())
                        {
                            Toast.makeText(RegisterActivity.this, result.getError_msg(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(RegisterActivity.this, "User created: " + result.getUid(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<APIResponse> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
