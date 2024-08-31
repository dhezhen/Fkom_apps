package com.pab.fkom_apps;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_detail);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");

        TextView txtUsername = findViewById(R.id.txt_username);
        TextView txtPassword = findViewById(R.id.txt_password); // Perbaikan nama variabel

        txtUsername.setText(username);
        txtPassword.setText(password);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FragmentLogin.REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String receivedData = data.getStringExtra("result");

                // Tidak perlu mendapatkan username dan password lagi di sini
            }
        }
    }
}
