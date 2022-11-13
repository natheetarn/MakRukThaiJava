/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;

import java.awt.Color;

import thaichessui.Pieces.BeaPiece;

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
        for (int ii= 0; ii < BOARD_SIZE; ii++) {
            for (int jj = 0; jj < BOARD_SIZE; jj++) {
                if (ii % 2 == 0) {
                    if (jj % 2 == 0)
                        board[ii][jj] = new Tile( Color.BLACK,ii,jj);
                    else
                        board[ii][jj] = new Tile( Color.WHITE,ii,jj);
                }
                else {
                    if (jj % 2 == 0)
                        board[ii][jj] = new Tile(Color.WHITE,ii,jj);
                    else
                        board[ii][jj] = new Tile( Color.BLACK,ii,jj);
                }
            }
        }
    }

    void setStartingPiecesWhite(){
        for (int i = 0; i < 8; i++){
            board[2][i].setPiece(new BeaPiece(Color.WHITE));
        }
    }
}
