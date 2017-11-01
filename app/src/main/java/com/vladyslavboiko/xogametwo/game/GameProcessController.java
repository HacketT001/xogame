package com.vladyslavboiko.xogametwo.game;

/**
 * Created by Tom on 09.10.2017.
 */

public class GameProcessController {

    private AIPlayer player;

    private int fieldForAI[][];

    public GameProcessController(){

    }
    public GameProcessController(int instruction){
        if(instruction == GameControllerInstructions.FIELD_INSTRUCTION_9){
            fieldForAI = new int[3][3];
            for (int i = 0;i < 3; i++)
                for (int j = 0; j < 3; j++)

                    fieldForAI[i][j] = GameControllerInstructions.NEUTRAL_FIELD;

            player = new AIForNineFileds(fieldForAI);
        }
        else{
            player = new AIForSixteenFields(fieldForAI);
            fieldForAI = new int[4][4];
            for (int i = 0;i < 4; i++)
                for (int j = 0; j < 4; j++)

                    fieldForAI[i][j] = GameControllerInstructions.NEUTRAL_FIELD;
        }
    }


    //Проверка на победу
    //Проверка на свободные клетки
    //Проверка на ничью
}
