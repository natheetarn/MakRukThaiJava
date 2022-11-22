package com.example.myapplication.Pieces;

import java.util.ArrayList;


public abstract class Piece {
    protected String name;
    public int id;
    private boolean white = false;
    private boolean isCaptured = false;
    //Id attribute is for view Id
    //Icon is to be changed into "drawable instead"

    public Piece(boolean isWhite){
        this.name = "emptyPiece";
        this.white = isWhite;
    }

    public boolean isCaptured(){
        this.isCaptured = true;
        return this.isCaptured;
    }

    public String getName(){
        return this.name;
    }


    public abstract boolean canMove();


}
