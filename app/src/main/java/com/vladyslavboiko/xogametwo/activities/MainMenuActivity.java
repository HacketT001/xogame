package com.vladyslavboiko.xogametwo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.vladyslavboiko.xogametwo.R;
import com.vladyslavboiko.xogametwo.game.GameControllerInstructions;


public class MainMenuActivity extends AppCompatActivity {

    private Button mButtonSingleplayerThree;
    private Button mButtonSingleplayerFour;
    private Button mButtonMultiplayerHost;
    private Button mButtonMutliplayerClient;
    private Button mButtonStatistic;

    private TextView mTextViewUsernameForLogOut;
    private TextView mTextViewScore;

    private SwipeMenuLayout firstMenuItem;
    private SwipeMenuLayout secondMenuItem;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        mButtonSingleplayerThree = (Button)findViewById(R.id.first_item_btnfirst);
        mButtonSingleplayerFour = (Button)findViewById(R.id.first_item_btnsecond);
        mButtonMultiplayerHost = (Button)findViewById(R.id.second_item_btnfirst);
        mButtonMutliplayerClient = (Button)findViewById(R.id.second_item_btnsecond);
        mButtonStatistic = (Button)findViewById(R.id.btnStat);

        mTextViewUsernameForLogOut = (TextView)findViewById(R.id.menu_username_tv);
        mTextViewScore = (TextView)findViewById(R.id.menu_score_value);


        final SwipeMenuLayout firstMenuItem = (SwipeMenuLayout)findViewById(R.id.menu_first);
        SwipeMenuLayout secondMenuItem = (SwipeMenuLayout)findViewById(R.id.menu_second);
        firstMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firstMenuItem.dispatchTouchEvent(MotionEvent.obtain(100,100,MotionEvent.ACTION_MOVE,firstMenuItem.getX(),firstMenuItem.getY(),1));

            }
        });

        mButtonSingleplayerThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ActivityGamingFiled.class);

                intent.putExtra("FieldInstruction", GameControllerInstructions.FIELD_INSTRUCTION_9);
                intent.putExtra("PlayerInstruction",GameControllerInstructions.PLAYERTYPE_INSTRUCTION_SINGLEPLAYER);
                startActivity(intent);
            }
        });

        mButtonSingleplayerFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this, ActivityGamingFiled.class);

                intent.putExtra("FieldInstruction",GameControllerInstructions.FIELD_INSTRUCTION_16);
                intent.putExtra("PlayerInstruction",GameControllerInstructions.PLAYERTYPE_INSTRUCTION_SINGLEPLAYER);
                startActivity(intent);
            }
        });



    }
}
