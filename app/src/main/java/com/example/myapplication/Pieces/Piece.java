package com.example.myapplication.Pieces;

import java.util.ArrayList;


public abstract class Piece {
    protected String name;

    private boolean white = false;
    public boolean isCaptured = false;

    //Icon is to be changed into "drawable instead"

    public Piece(boolean isWhite){
        this.name = "emptyPiece";
        this.white = isWhite;
    }

    public void isCaptured(){
        this.isCaptured = true;
    }

    public String getName(){
        return this.name;
    }


    public abstract boolean canMove();


}
