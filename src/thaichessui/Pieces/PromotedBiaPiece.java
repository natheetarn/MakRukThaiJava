package thaichessui.Pieces;

import thaichessui.Board;
import thaichessui.Tile;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class PromotedBiaPiece extends MetPiece {
    protected String name;
    private java.awt.Color color;

    public PromotedBiaPiece(java.awt.Color color) {
        super(color);
        this.name = "PromotedBiaPiece";
        if (color == java.awt.Color.WHITE) {
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/white_promoted.png"));
        } else {
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/black_promoted.png"));
        }
    }

}