package tjeit.kr.deliveryserverpractice;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONObject;

import tjeit.kr.deliveryserverpractice.utils.ConnectServer;

public class SignUpActivity extends BaseActivity {

    private android.widget.EditText userIdEdt;
    private android.widget.EditText passwordEdt;
    private android.widget.EditText nameEdt;
    private android.widget.EditText phoneEdt;
    private android.widget.EditText emailEdt;
    private android.widget.Button signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                서버에 회원가입 신청 요청.

                ConnectServer.putRequestSignUp(mContext,
                        userIdEdt.getText().toString(),
                        passwordEdt.getText().toString(),
                        nameEdt.getText().toString(),
                        phoneEdt.getText().toString(),
                        emailEdt.getText().toString(),
                        "3",
                        "123-45678-90",
                        "임시이미지",
                        new ConnectServer.JsonResponseHandler() {
                            @Override
                            public void onResponse(JSONObject json) {
                                Log.d("회원가입응답", json.toString());
                            }
                        });

            }
        });
    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.phoneEdt = (EditText) findViewById(R.id.phoneEdt);
        this.nameEdt = (EditText) findViewById(R.id.nameEdt);
        this.passwordEdt = (EditText) findViewById(R.id.passwordEdt);
        this.userIdEdt = (EditText) findViewById(R.id.userIdEdt);

    }
}
