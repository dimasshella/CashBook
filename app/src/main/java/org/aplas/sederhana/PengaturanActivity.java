package org.aplas.sederhana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.aplas.sederhana.DataBase.DataBaseAccess;

public class PengaturanActivity extends AppCompatActivity {

    Button simpan, kembali;
    EditText oldpass, newpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        simpan = findViewById(R.id.simpan);
        kembali = findViewById(R.id.kembali);
        oldpass = findViewById(R.id.oldpass);
        newpass = findViewById(R.id.newpass);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseAccess dataBaseAccess = DataBaseAccess.getInstance(PengaturanActivity.this);
                dataBaseAccess.open();

                Cursor data = dataBaseAccess.Where("user", "username = 'USER' AND password ='" + oldpass.getText().toString() + "'");

                    if (data.getCount() == 0) {
                        Toast.makeText(PengaturanActivity.this, "Password Lama yang Anda Masukkan Salah", Toast.LENGTH_SHORT).show();
                    } else {
                        boolean isUpdated = dataBaseAccess.updateUser(newpass.getText().toString(), "USER");

                        if(isUpdated){
                            Toast.makeText(PengaturanActivity.this, "Password Anda Berhasil Diganti", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(PengaturanActivity.this, MenuActivity.class));
                        } else {
                            Toast.makeText(PengaturanActivity.this, "Password Anda Gagal Diganti", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        );

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PengaturanActivity.this, MenuActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(PengaturanActivity.this, MenuActivity.class));
    }
}