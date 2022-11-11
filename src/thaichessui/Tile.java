/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;
import javax.swing.*;
/**
 *
 * @author ROG Zephyrus M
 */
public class Tile extends JPanel{
    private boolean isOccupied;
    private String color;
    private Piece piece;
    
    Tile(boolean isOccupied, String color) {
        this.isOccupied = isOccupied;
        this.color = color;
        this.piece = null;
    }
    
    public String getColor(){
        return this.color;
    }
}
