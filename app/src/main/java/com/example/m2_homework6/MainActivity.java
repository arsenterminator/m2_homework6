package com.example.m2_homework6;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m2_homework6.R;

public class MainActivity extends AppCompatActivity {
    private TextView first, second, third;
    private Button btn_1;
    private EditText editText, password;
    private LinearLayout last;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        btn_1 = findViewById(R.id.btn_1);
        editText = findViewById(R.id.editText);
        password = findViewById(R.id.password);
        last = findViewById(R.id.last);



        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(editText.getText().toString().length() == 0) {
                    btn_1.setBackgroundColor(getColor(R.color.gray));
                } else {
                    btn_1.setBackgroundColor(getColor(R.color.orange));
                }
                return true;
            }
        });


        btn_1.setOnClickListener(view -> {
            Toast toast = new Toast(MainActivity.this);
            if (editText.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                first.setVisibility(View.GONE);
                third.setVisibility(View.GONE);
                btn_1.setVisibility(View.GONE);
                editText.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                last.setVisibility(View.GONE);

                toast.setText("Вы успешно зарегистрировались.");
            } else {
                toast.setText("Неправильный логин и пароль");
            }

            toast.show();
        });

    }
}