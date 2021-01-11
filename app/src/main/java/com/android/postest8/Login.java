package com.android.postest8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button login, reset;
    EditText user, pass;
    String password = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DataHelper(this);
        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.pass);

        login = (Button) findViewById(R.id.login);
        reset = (Button) findViewById(R.id.reset);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                checklogin(user.getText().toString());
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                user.setText("");
                pass.setText("");
            }
        });
    }
///////////////////////////////////////////////
    private void checklogin(String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM login WHERE username = '" + username + "'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            password = cursor.getString(2);
        }

        if (password.equalsIgnoreCase(pass.getText().toString())){
            Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}