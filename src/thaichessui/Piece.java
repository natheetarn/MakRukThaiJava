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
    private Color color;
    private boolean killed = false;

    public Piece(Color color){
        this.setColor(color)
    }

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
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
