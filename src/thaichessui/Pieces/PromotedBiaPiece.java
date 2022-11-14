package thaichessui.Pieces;

import thaichessui.Board;
import thaichessui.Tile;

import java.awt.Color;
import java.util.ArrayList;

public class PromotedBiaPiece extends MetPiece {
    protected String name;
    private java.awt.Color color;

    public PromotedBiaPiece(java.awt.Color color){
        super(color);
        this.name = "PromotedBiaPiece";
    }

}