/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;

/**
 *
 * @author ROG Zephyrus M
 */
public class Board {

    public static final int BOARD_SIZE = 8; // constant variable that sets the size of Chess board
    public Tile[][] board;

    

    /**
     * Constructor for Board
     */
    public Board() {
        board = new Tile[BOARD_SIZE][BOARD_SIZE];
    }

    /**
     * Method to populate board with black and white tiles
     */
    void populateBoardWithTiles() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i % 2 == 0) {
                    if (j % 2 == 0)
                        board[i][j] = new Tile(false, "BLACK");
                    else
                        board[i][j] = new Tile(false, "WHITE");
                }
                else {
                    if (j % 2 == 0)
                        board[i][j] = new Tile(false, "WHITE");
                    else
                        board[i][j] = new Tile(false, "BLACK");
                }
            }
        }
    }
}
