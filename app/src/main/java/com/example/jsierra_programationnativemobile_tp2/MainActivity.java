package com.example.jsierra_programationnativemobile_tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //le interface doit s'afficher à l'écran pendant 5 secondes puis automatiquement lancer
        //l'activité de la calculatrice.
        new CountDownTimer(5000,1000){
            TextView MonAppCalculatrice = (TextView)findViewById(R.id.AppCalculatrice);
            public void onTick(long millisecondeAvantFin){
                MonAppCalculatrice.setText("Dèbut de l'application: "+millisecondeAvantFin/1000+" seconds.");
            }
            public void onFinish(){
                MonAppCalculatrice.setText("Bienvenue à la calculatrice");
                Intent interface2Intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(interface2Intent);
                finish();
            }
        }.start();
    }
}
