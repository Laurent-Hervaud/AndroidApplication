package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextMessage;
    private FrameLayout myFrame1;
    private FrameLayout myFrame2;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            myFrame1.setVisibility(FrameLayout.INVISIBLE);
            myFrame2.setVisibility(FrameLayout.INVISIBLE);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    myFrame1.setVisibility(FrameLayout.VISIBLE);

                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    myFrame2.setVisibility(FrameLayout.VISIBLE);
                    return true;
            }
            return false;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button mClickButton1 = (Button)findViewById(R.id.button1);
        mClickButton1.setOnClickListener(this);

        ImageButton mClickImgButton1 = (ImageButton)findViewById(R.id.imagebt1);
        mClickImgButton1.setOnClickListener(this);

        myFrame1 = findViewById(R.id.frame1);
        myFrame2 = findViewById(R.id.frame2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.button1: {
                mTextMessage.setText("click bouton");
                break;
            }
            case  R.id.imagebt1: {
                mTextMessage.setText("click image bouton");
                break;
            }
            //.... etc
        }
    }
}
