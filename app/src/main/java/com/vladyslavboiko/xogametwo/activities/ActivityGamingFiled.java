package com.vladyslavboiko.xogametwo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vladyslavboiko.xogametwo.R;
import com.vladyslavboiko.xogametwo.game.PlayebleButton;
import com.vladyslavboiko.xogametwo.game.GameControllerInstructions;
import com.vladyslavboiko.xogametwo.game.GameProcessController;

public class ActivityGamingFiled extends AppCompatActivity {

    private PlayebleButton[][] gameField;
    private GameProcessController gameProcessController;
    private Intent thisIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_3_fields);
        thisIntent = getIntent();

        int fieldInstruction = thisIntent.getIntExtra("FieldInstruction",0);
        int playerInstruction = thisIntent.getIntExtra("PlayerInstruction",0);

        if(fieldInstruction == 0) {

            setContentView(R.layout.activity_3_fields);
            initializationForNineButton();
            gameProcessController = new GameProcessController(GameControllerInstructions.FIELD_INSTRUCTION_9, gameField);

        }
        else {
            setContentView(R.layout.activity_4_fileds);
            initializationForSixteenButton();
            gameProcessController = new GameProcessController(GameControllerInstructions.FIELD_INSTRUCTION_16,gameField);
        }
    }


    public void initializationForNineButton(){
        gameField = new PlayebleButton[3][3];

        gameField[0][0] = (PlayebleButton)findViewById(R.id.buttonThree_field_00);
        gameField[0][1] = (PlayebleButton)findViewById(R.id.buttonThree_field_01);
        gameField[0][2] = (PlayebleButton)findViewById(R.id.buttonThree_field_02);

        gameField[1][0] = (PlayebleButton)findViewById(R.id.buttonThree_field_10);
        gameField[1][1] = (PlayebleButton)findViewById(R.id.buttonThree_field_11);
        gameField[1][2] = (PlayebleButton)findViewById(R.id.buttonThree_field_12);

        gameField[2][0] = (PlayebleButton)findViewById(R.id.buttonThree_field_20);
        gameField[2][1] = (PlayebleButton)findViewById(R.id.buttonThree_field_21);
        gameField[2][2] = (PlayebleButton)findViewById(R.id.buttonThree_field_22);

    }

    public void initializationForSixteenButton(){
        gameField = new PlayebleButton[4][4];

        gameField[0][0] = (PlayebleButton)findViewById(R.id.buttonFour_field_00);
        gameField[0][1] = (PlayebleButton)findViewById(R.id.buttonFour_field_01);
        gameField[0][2] = (PlayebleButton)findViewById(R.id.buttonFour_field_02);
        gameField[0][3] = (PlayebleButton)findViewById(R.id.buttonFour_field_03);

        gameField[1][0] = (PlayebleButton)findViewById(R.id.buttonFour_field_10);
        gameField[1][1] = (PlayebleButton)findViewById(R.id.buttonFour_field_11);
        gameField[1][2] = (PlayebleButton)findViewById(R.id.buttonFour_field_12);
        gameField[1][3] = (PlayebleButton)findViewById(R.id.buttonFour_field_13);

        gameField[2][0] = (PlayebleButton)findViewById(R.id.buttonFour_field_20);
        gameField[2][1] = (PlayebleButton)findViewById(R.id.buttonFour_field_21);
        gameField[2][2] = (PlayebleButton)findViewById(R.id.buttonFour_field_22);
        gameField[2][3] = (PlayebleButton)findViewById(R.id.buttonFour_field_23);

        gameField[3][0] = (PlayebleButton)findViewById(R.id.buttonFour_field_30);
        gameField[3][1] = (PlayebleButton)findViewById(R.id.buttonFour_field_31);
        gameField[3][2] = (PlayebleButton)findViewById(R.id.buttonFour_field_32);
        gameField[3][3] = (PlayebleButton)findViewById(R.id.buttonFour_field_33);

    }
}
