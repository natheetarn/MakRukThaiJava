package com.example.myapplication.Pieces;

import java.util.ArrayList;

public class BiaPiece extends Piece {


    public BiaPiece(boolean isWhite) {
        super(isWhite);
        this.name = "BiaPiece";
    }

    @Override
    public boolean canMove() {
        return false;
    }
}
