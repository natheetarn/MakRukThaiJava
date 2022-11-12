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
    private boolean isOccupied;
    private String color;
    private Piece piece;
    private int rank;
    private int file;
    Tile(String color, int file, int rank) {
        this.color = color;
        this.piece = null;
        this.isOccupied = false;
        this.file = file;
        this.rank = rank;
    }
    
    public String getColor(){
        return this.color;
    }

    public boolean getOccupied(){
        return this.isOccupied;
    }

    public void setOccupied(){
        this.isOccupied = !this.isOccupied;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece p){
        this.piece = p;
    }

    public int getFile(){
        return this.file;
    }

    public int getRank(){
        return this.rank;
    }

}
