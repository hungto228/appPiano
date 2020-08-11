package com.example.piano_phantom;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static com.example.piano_phantom.MainActivity.mFileName1;
import static com.example.piano_phantom.MainActivity.mFileName2;
import static com.example.piano_phantom.MainActivity.mFileName3;
import static com.example.piano_phantom.MainActivity.mFileName4;
import static com.example.piano_phantom.MainActivity.mFileName5;
import static com.example.piano_phantom.MainActivity.mFileName6;


public class PlayingActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button mPlaysong1, mPlaysong2, mPlaysong3, mPlaysong4, mPlaysong5, mPlaysong6;

    private boolean isPlaying1, isPlaying2, isPlaying3, isPlaying4, isPlaying5, isPlaying6;

    private boolean isPlaying;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);

        mPlaysong1 = findViewById(R.id.btn_playsong1);
        mPlaysong2 = findViewById(R.id.btn_playsong2);
        mPlaysong3 = findViewById(R.id.btn_playsong3);
        mPlaysong4 = findViewById(R.id.btn_playsong4);
        mPlaysong5 = findViewById(R.id.btn_playsong5);
        mPlaysong6 = findViewById(R.id.btn_playsong6);

        mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
        mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
        mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
        mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
        mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
        mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

        isPlaying = false;
        isPlaying1 = false;
        isPlaying2 = false;
        isPlaying3 = false;
        isPlaying4 = false;
        isPlaying5 = false;
        isPlaying6 = false;

//TODO:playsong1
        mPlaysong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying1 && !isPlaying) {
                    mPlaysong1.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying = true;
                    isPlaying1 = true;
                } else if (!isPlaying1 && !isPlaying) {
                    stopPlaying();

                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

                    isPlaying1 = false;
                    isPlaying2 = false;
                    isPlaying3 = false;
                    isPlaying4 = false;
                    isPlaying5 = false;
                    isPlaying6 = false;
                    mPlaysong1.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying1 = true;
                } else {
                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    stopPlaying();
                    isPlaying1 = false;
                    isPlaying = false;
                }
            }
        });
        //TODO:playsong 2
        mPlaysong2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying2 && !isPlaying) {
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying = true;
                    isPlaying2 = true;
                } else if (!isPlaying2 && !isPlaying) {
                    stopPlaying();
                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

                    isPlaying1 = false;
                    isPlaying2 = false;
                    isPlaying3 = false;
                    isPlaying4 = false;
                    isPlaying5 = false;
                    isPlaying6 = false;

                    mPlaysong2.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying2 = true;
                } else {
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    stopPlaying();
                    isPlaying2 = false;
                    isPlaying = false;
                }
            }
        });
        //TODO:playsong 3
        mPlaysong3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying3 && !isPlaying) {
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying = true;
                    isPlaying3 = true;
                } else if (!isPlaying3 && !isPlaying) {
                    stopPlaying();
                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

                    isPlaying1 = false;
                    isPlaying2 = false;
                    isPlaying3 = false;
                    isPlaying4 = false;
                    isPlaying5 = false;
                    isPlaying6 = false;

                    mPlaysong3.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying3 = true;

                } else {
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    stopPlaying();
                    isPlaying3 = false;
                    isPlaying = false;
                }
            }
        });
        //TODO: playing4
        mPlaysong4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying4 && !isPlaying) {
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying = true;
                    isPlaying4 = true;
                } else if (!isPlaying4 && !isPlaying) {
                    stopPlaying();

                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

                    isPlaying1 = false;
                    isPlaying2 = false;
                    isPlaying3 = false;
                    isPlaying4 = false;
                    isPlaying5 = false;
                    isPlaying6 = false;

                    mPlaysong4.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying4 = true;
                } else {
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    stopPlaying();
                    isPlaying4 = false;
                    isPlaying = false;

                }
            }
        });
        //TODO: playing 5
        mPlaysong5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying5 && !isPlaying) {
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying5 = true;
                    isPlaying = true;
                } else if (!isPlaying5 && !isPlaying) {
                    stopPlaying();

                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

                    isPlaying1 = false;
                    isPlaying2 = false;
                    isPlaying3 = false;
                    isPlaying4 = false;
                    isPlaying5 = false;
                    isPlaying6 = false;

                    mPlaysong5.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying5 = true;
                } else {
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    stopPlaying();
                    isPlaying5 = false;
                    isPlaying = false;
                }
            }
        });

        //TODO:playing 6
        mPlaysong6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying6 && !isPlaying) {
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);
                    isPlaying6 = true;
                    isPlaying = true;
                } else if (!isPlaying6 && !isPlaying) {
                    stopPlaying();
                    mPlaysong1.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong2.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong3.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong4.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong5.setBackgroundResource(R.drawable.playsongshape);
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);

                    isPlaying1 = false;
                    isPlaying2 = false;
                    isPlaying3 = false;
                    isPlaying4 = false;
                    isPlaying5 = false;
                    isPlaying6 = false;
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshapepressed);
                    startPlaying(1);

                    isPlaying6 = true;
                } else {
                    mPlaysong6.setBackgroundResource(R.drawable.playsongshape);
                    stopPlaying();
                    isPlaying6 = false;
                    isPlaying = false;
                }
            }
        });

    }

    private void startPlaying(int recorddingno) {
        mediaPlayer = new MediaPlayer();
        try {
            switch (recorddingno) {
                case 1:
                    mediaPlayer.setDataSource(mFileName1);
                    break;
                case 2:
                    mediaPlayer.setDataSource(mFileName2);
                    break;
                case 3:
                    mediaPlayer.setDataSource(mFileName3);
                    break;
                case 4:
                    mediaPlayer.setDataSource(mFileName4);
                    break;
                case 5:
                    mediaPlayer.setDataSource(mFileName5);
                    break;
                case 6:
                    mediaPlayer.setDataSource(mFileName6);
                    break;

            }
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (Exception e) {
            Log.d("playing", "error ");
        }
    }

    private void stopPlaying() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
