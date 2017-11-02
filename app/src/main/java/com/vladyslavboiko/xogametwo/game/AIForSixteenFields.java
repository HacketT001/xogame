package com.vladyslavboiko.xogametwo.game;

/**
 * Created by Tom on 09.10.2017.
 */

public class AIForSixteenFields implements AIPlayer {

    private PlayebleButton field[][];

    public AIForSixteenFields(PlayebleButton field[][]){
        this.field = field;
    }

    @Override
    public String getMove() {
        return null;
    }

}
