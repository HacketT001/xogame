package com.vladyslavboiko.xogametwo.game;

import android.icu.text.TimeZoneFormat;

/**
 * Created by Tom on 09.10.2017.
 */

public class GameProcessController {

    private AIPlayer player;

    private PlayebleButton[][] field;

    public GameProcessController(){

    }
    public GameProcessController(int instruction, PlayebleButton[][] field){

        this.field = field;

        if(instruction == GameControllerInstructions.FIELD_INSTRUCTION_9)
            player = new AIForNineFileds(field);
        else player = new AIForSixteenFields(field);


    }

    public boolean isPossibleToContinue(){
        return false;
    }

    public int getGameResult(){
        return GameControllerInstructions.TIE;
    }




    //Проверка на победу
    //Проверка на свободные клетки
    //Проверка на ничью
}
