package com.vladyslavboiko.xogametwo.game;

/**
 * Created by Tom on 15.10.2017.
 */

public interface GameControllerInstructions {
     int FIELD_INSTRUCTION_16 = 1;
     int FIELD_INSTRUCTION_9 = 0;

     int PLAYERTYPE_INSTRUCTION_SINGLEPLAYER = 1;
     int PLAYERTYPE_INSTRUCTION_MULTIPLAYER = 0;

     int NEUTRAL_FIELD = 0;
     int PLAYERS_FIELD = 1;
     int AI_FIELD = 2;
}
