package com.example.poeb36;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    Button button;
    TextView ans;
    ArrayList<Integer>mainFib = null;
    private int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editText1);
        ans = findViewById(R.id.ans);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = Integer.parseInt(editText1.getText().toString());
                if(mainFib == null){
                    findFibbo(num);
                }
                else{
                   try{
                       Object[] fibs = mainFib.toArray();
                       ans.setText(ans.getText().toString()+" "+fibs[i]);
                       i++;
                   }
                   catch (Exception e){
                       Toast.makeText(MainActivity.this, "Series Completed", Toast.LENGTH_SHORT).show();
                       i=0;
                       mainFib=null;
                       ans.setText("");
                   }
                }
            }
        });
    }

    private void findFibbo(int n){
        ArrayList<Integer> fib = new ArrayList<>();
        int n1=0,n2=1,n3;
        if(n==1){
            fib.add(0);
        }
        else if(n==2)
        {
            fib.add(0);
            fib.add(1);
        }
        else if(n>2) {
            fib.add(0);
            fib.add(1);
            for (int i = 2; i < n; i++) {
                n3 = n1 + n2;
                fib.add(n3);
                n1 = n2;
                n2 = n3;
            }

        }
        mainFib = fib;
    }
}