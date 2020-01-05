package com.example.android.androidarchitectures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.android.androidarchitectures.MVC.MVCActivity;
import com.example.android.androidarchitectures.MVP.MVPActivity;
import com.example.android.androidarchitectures.MVVM.MVVMActivity;

public class ArchitecturesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_architectures);
    }

    public void onMVC(View view) {
        Toast.makeText(ArchitecturesActivity.this, "You clicked MVC", Toast.LENGTH_SHORT).show();
        startActivity(MVCActivity.getIntent(this));
    }

    public void onMVP(View view) {
        Toast.makeText(ArchitecturesActivity.this, "You clicked MVP", Toast.LENGTH_SHORT).show();
        startActivity(MVPActivity.getIntent(this));
    }

    public void onMVVM(View view) {
        Toast.makeText(ArchitecturesActivity.this, "You clicked MVVM", Toast.LENGTH_SHORT).show();
        startActivity(MVVMActivity.getIntent(this));
    }
}
