package com.vladyslavboiko.xogametwo.game;

/**
 * Created by Tom on 09.10.2017.
 */

public class GameProcessController {

    private static final int ENEMY_TRUE_RESULT = -1;
    private static final int PLAYER_TRUE_RESULT = 1;
    private static final int FALSE = 0;

    private int fieldLenght;

    private AIPlayer player;

    private PlayebleButton[][] field;


    public GameProcessController(int instruction, PlayebleButton[][] field) {

        this.field = field;

        if (instruction == GameControllerInstructions.FIELD_INSTRUCTION_9) {
            player = new AIForNineFileds(field);
            fieldLenght = 3;
        } else {
            player = new AIForSixteenFields(field);
            fieldLenght = 4;
        }
    }


    public int getGameResult() {
        return GameControllerInstructions.TIE;
    }


    private boolean isTie() {
        return !isVictory() && !isDefeat() && !isExistEmptyFields();
    }

    private boolean isVictory() {
        return checkDiagonal() == PLAYER_TRUE_RESULT || checkHorizontal() == PLAYER_TRUE_RESULT ||
                checkVertical() == PLAYER_TRUE_RESULT;
    }

    private boolean isDefeat() {
        return checkDiagonal() == ENEMY_TRUE_RESULT || checkHorizontal() == ENEMY_TRUE_RESULT ||
                checkVertical() == ENEMY_TRUE_RESULT;
    }

    private boolean isExistEmptyFields() {
        for (int i = 0; i < fieldLenght; i++)
            for (int j = 0; j < fieldLenght; j++)
                if(field[i][j].isEmpty())
                    return true;
        return false;

    }

    private int checkDiagonal() {

        int PrimaryRowForCheckPlayer = 0;
        int SecondaryRowForCheckPlayer = 0;
        int PrimaryRowForCheckEnemy = 0;
        int SecondaryRowForCheckEnemy = 0;

        //Checking primary diagonal
        for (int i = 0; i < fieldLenght; i++)
            for (int j = 0; j < fieldLenght; j++) {
                if (field[i][j].getPlayer() == GameControllerInstructions.PLAYERS_FIELD)
                    ++PrimaryRowForCheckPlayer;
                if (field[i][j].getPlayer() == GameControllerInstructions.ENEMY_FIELD)
                    ++PrimaryRowForCheckEnemy;
            }
        if (PrimaryRowForCheckEnemy == fieldLenght)
            return ENEMY_TRUE_RESULT;
        if (PrimaryRowForCheckPlayer == fieldLenght)
            return PLAYER_TRUE_RESULT;

        //Checking secondary diagonal
        for (int i = 0; i < fieldLenght; i++)
            for (int j = fieldLenght; j < 0; j--) {
                if (field[i][j].getPlayer() == GameControllerInstructions.PLAYERS_FIELD)
                    ++SecondaryRowForCheckPlayer;
                if (field[i][j].getPlayer() == GameControllerInstructions.ENEMY_FIELD)
                    ++SecondaryRowForCheckPlayer;
            }
        if (SecondaryRowForCheckEnemy == fieldLenght)
            return ENEMY_TRUE_RESULT;
        if (SecondaryRowForCheckPlayer == fieldLenght)
            return PLAYER_TRUE_RESULT;
        return FALSE;
    }

    private int checkHorizontal() {

        for (int i = 0; i < fieldLenght; i++) {

            int playerCount = 0;
            int enemyCount = 0;

            for (int j = 0; j < fieldLenght; j++) {
                if (field[i][j].getPlayer() == GameControllerInstructions.PLAYERS_FIELD)
                    ++playerCount;
                if (field[i][j].getPlayer() == GameControllerInstructions.ENEMY_FIELD)
                    ++enemyCount;
            }
            if (playerCount == fieldLenght)
                return PLAYER_TRUE_RESULT;
            if (enemyCount == fieldLenght)
                return ENEMY_TRUE_RESULT;
        }
        return FALSE;
    }

    private int checkVertical() {

        for (int i = 0; i < fieldLenght; i++) {

            int playerCount = 0;
            int enemyCount = 0;

            for (int j = 0; j < fieldLenght; j++) {
                if (field[j][i].getPlayer() == GameControllerInstructions.PLAYERS_FIELD)
                    ++playerCount;
                if (field[j][i].getPlayer() == GameControllerInstructions.ENEMY_FIELD)
                    ++enemyCount;
            }
            if (playerCount == fieldLenght)
                return PLAYER_TRUE_RESULT;
            if (enemyCount == fieldLenght)
                return ENEMY_TRUE_RESULT;
        }
        return FALSE;

    }
    //Проверка на победу
    //Проверка на свободные клетки
    //Проверка на ничью
}
