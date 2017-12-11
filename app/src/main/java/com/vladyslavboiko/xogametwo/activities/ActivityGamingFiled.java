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
    private int[][] buttonIDs;
    private GameProcessController gameProcessController;
    private Intent thisIntent;
    private int fieldsLenght;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_3_fields);
        thisIntent = getIntent();

        int fieldInstruction = thisIntent.getIntExtra("FieldInstruction", 0);
        int playerInstruction = thisIntent.getIntExtra("PlayerInstruction", 0);

        if (fieldInstruction == 0) {
            fieldsLenght = 3;
            setContentView(R.layout.activity_3_fields);
            initForNineButton();
            gameProcessController = new GameProcessController(GameControllerInstructions.FIELD_INSTRUCTION_9, gameField, fieldsLenght);

        } else {
            fieldsLenght = 4;
            setContentView(R.layout.activity_4_fileds);
            initForSixteenButton();
            gameProcessController = new GameProcessController(GameControllerInstructions.FIELD_INSTRUCTION_16, gameField, fieldsLenght);
        }
    }


    public void initForNineButton() {
        gameField = new PlayebleButton[fieldsLenght][fieldsLenght];
        buttonIDs = new int[fieldsLenght][fieldsLenght];


        gameField[0][0] = (PlayebleButton) findViewById(R.id.buttonThree_field_00);
        gameField[0][1] = (PlayebleButton) findViewById(R.id.buttonThree_field_01);
        gameField[0][2] = (PlayebleButton) findViewById(R.id.buttonThree_field_02);

        gameField[1][0] = (PlayebleButton) findViewById(R.id.buttonThree_field_10);
        gameField[1][1] = (PlayebleButton) findViewById(R.id.buttonThree_field_11);
        gameField[1][2] = (PlayebleButton) findViewById(R.id.buttonThree_field_12);

        gameField[2][0] = (PlayebleButton) findViewById(R.id.buttonThree_field_20);
        gameField[2][1] = (PlayebleButton) findViewById(R.id.buttonThree_field_21);
        gameField[2][2] = (PlayebleButton) findViewById(R.id.buttonThree_field_22);

 
    }


}
