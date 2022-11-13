/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui.Pieces;
import java.util.ArrayList;

import thaichessui.Board;
import thaichessui.Tile;

/**
 *
 * @author ROG Zephyrus M
 */
public abstract class Piece {
    protected String name;
    private java.awt.Color color;
    private boolean killed = false;
    

    public Piece(java.awt.Color color){
        this.setColor(color);
        this.name = "emptyPiece";
    }

    public java.awt.Color getColor(){
        return this.color;
    }

    public void setColor(java.awt.Color color){
        this.color = color;
    }

    public boolean isKilled(){
        return this.killed;
    }

    public void setKilled(boolean killed){
        this.killed = killed;
    }

    public String getName(){
        return this.name;
    }

    public abstract ArrayList<Tile> getLegalMoves(Board board, int file, int rank);

    // public abstract boolean canMove(Board board, Tile begin, Tile dest);



}
