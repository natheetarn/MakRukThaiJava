/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;

/**
 *
 * @author ROG Zephyrus M
 */
public abstract class Piece {
    private String color;
    private boolean killed = false;

    public Piece(String color){
        this.setColor(color);
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isKilled(){
        return this.killed;
    }

    public void setKilled(boolean killed){
        this.killed = killed;
    }

    public abstract boolean canMove(Board board, Tile begin, Tile dest);



}
