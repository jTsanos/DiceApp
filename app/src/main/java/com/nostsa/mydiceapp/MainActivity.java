package com.nostsa.mydiceapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ImageDice1=(ImageView)findViewById(R.id.diceOne);
        final ImageView ImageDice2=(ImageView)findViewById(R.id.diceTwo);
        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dice_sound);


        final int [] ImagesDice = {R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};




        Button btn =(Button)findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rnd = new Random();
                int randomNumber1=rnd.nextInt(6);       // 0...5

                ImageDice1.setImageResource(ImagesDice[randomNumber1]);



                int randomNumber2=rnd.nextInt(6);       // 0...5

                ImageDice2.setImageResource(ImagesDice[randomNumber2]);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(ImageDice1);


                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(ImageDice2);




                mp.start();

            }
        });

    }
}
