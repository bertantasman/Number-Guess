package com.example.sayitahmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView Guess;
    Button button;
    TextView Result;
    TextView Number;

    private int random;
    private int score = 100;
    private int attempts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Guess = findViewById(R.id.Guess);
        button = findViewById(R.id.button);
        Result = findViewById(R.id.Result);
        Number = findViewById(R.id.Number);

        Random r = new Random();
        random = r.nextInt(50) + 1;
    }

    public void buClick(View View) {
        int num1 = Integer.parseInt(Guess.getText().toString());

        if (attempts < 5) {
            if (num1 > random) {
                Result.setText("GO DOWN!");
                score -= 20;
            } else if (num1 < random) {
                Result.setText("GO UP!");
                score -= 20;
            } else {
                Result.setText("True your score is: " + score);
                score = 100;
                button.setEnabled(false);
            }

            if (score < 0) {
                score = 0;
            }

            attempts++;
        } else {
            Result.setText("Game Over! The number was: " + random);
            button.setEnabled(false); // Düğmeyi devre dışı bırak
        }
    }
}
