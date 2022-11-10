/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;

/**
 *
 * @author ROG Zephyrus M
 */
public enum Color {
    BLACK,
    WHITE;

    public Color opposite() {
        if(this == WHITE) {
            return BLACK;
        } else {
            return WHITE;
        }
    }

}
