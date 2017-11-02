package com.vladyslavboiko.xogametwo.game;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.Button;

import com.vladyslavboiko.xogametwo.game.GameControllerInstructions;

/**
 * Created by Tom on 13.10.2017.
 */

public class PlayebleButton extends android.support.v7.widget.AppCompatButton {

    private boolean isEmpty;
    private int player;
    private String[] symbol = {" ","X","O"};


    public PlayebleButton(Context context) {
        super(context);
        initButton();
    }

    public PlayebleButton(Context context, AttributeSet attrs) {
        super(context, attrs);
         initButton();
    }

    public PlayebleButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
         initButton();
    }

    public void initButton(){
        isEmpty = true;
        setText(symbol[GameControllerInstructions.NEUTRAL_FIELD]);
    }

    public void setSymbol(int player){
        if (isEmpty){
            this.player = player;
            setText(symbol[player]);
            isEmpty = false;
            setClickable(false);
        }
    }
    public boolean isEmpty(){
        return isEmpty;
    }

    public int getPlayer(){return player;}
}
