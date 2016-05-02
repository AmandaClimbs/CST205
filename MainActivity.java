package com.example.hamzeh.playpausestop;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    MediaPlayer Sound;
    int pause;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Sound = MediaPlayer.create(MainActivity.this, R.raw.music);
    }

    public void stop(View view)
    {
        Sound.release();
    }

    public void onToggleClicked(View view)
    {
        boolean checked = ((ToggleButton)view).isChecked();

        if (checked && !Sound.isPlaying() && Sound!=null)
        {
            Sound.start();
            //Play
        }
        else if (Sound.isPlaying())
        {
            Sound.pause();
            pause = Sound.getCurrentPosition();
            //Pause
        }
        else
        {
            Toast.makeText(MainActivity.this, "SomethingIsWrong", Toast.LENGTH_SHORT).show();
        }

    }

}