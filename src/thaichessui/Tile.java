/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;
import javax.swing.*;

import thaichessui.Pieces.Piece;
/**
 *
 * @author ROG Zephyrus M
 */
public class Tile{
    private boolean isOccupied = false;
    private java.awt.Color color;
    private Piece piece;
    private int rank;
    private int file;
    private boolean isSelected = false;
    Tile(java.awt.Color color, int row, int col) {
        this.color = color;
        this.piece = null;
        this.isOccupied = false;
        this.rank = row;
        this.file = col;
    }
    
    public java.awt.Color getColor(){
        return this.color;
    }

    public boolean getOccupied(){
        return this.isOccupied;
    }

    public boolean getSelected(){
        return this.isSelected;
    }
    public boolean setSelected(boolean selected){
        return this.isSelected = selected;
    }

    public void setOccupied(boolean o){
        this.isOccupied = o;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece p){
        this.piece = p;
        if (p!=null){
            this.setOccupied(true);
        } else {
            this.setOccupied(false);
        }
    }

    public int getFile(){
        return this.file;
    }

    public int getRank(){
        return this.rank;
    }

}
