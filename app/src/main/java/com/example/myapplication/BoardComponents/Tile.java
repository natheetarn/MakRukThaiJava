package com.example.myapplication.BoardComponents;

import com.example.myapplication.Pieces.Piece;

public class Tile {
    private Piece piece;
    private boolean isOccupied = false;
    private boolean isSelected = false;

    public boolean getOccupied() {
        return this.isOccupied;
    }

    public boolean getSelected() {
        return this.isSelected;
    }

    public boolean setSelected(boolean selected) {
        return this.isSelected = selected;
    }

    public void setOccupied(boolean o) {
        this.isOccupied = o;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
        if (p != null) {
            this.setOccupied(true);
        } else {
            this.setOccupied(false);
        }
    }

}
