/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thaichessui;

import java.awt.Color;

import thaichessui.Pieces.*;

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
    void populateBoardWithTiles(boolean isHostView) {
        for (int ii = 0; ii < BOARD_SIZE; ii++) {
            for (int jj = 0; jj < BOARD_SIZE; jj++) {
                if (isHostView) {
                    if (ii % 2 == 0) {
                        if (jj % 2 == 0)
                            board[ii][jj] = new Tile(Color.WHITE, ii, jj);
                        else
                            board[ii][jj] = new Tile(Color.green, ii, jj);
                    } else {
                        if (jj % 2 == 0)
                            board[ii][jj] = new Tile(Color.green, ii, jj);
                        else
                            board[ii][jj] = new Tile(Color.WHITE, ii, jj);
                    }
                } else {
                    if (ii % 2 == 0) {
                        if (jj % 2 == 0)
                            board[getOpposite(ii)][getOpposite(jj)] = new Tile(Color.WHITE, getOpposite(ii),
                                    getOpposite(jj));
                        else
                            board[getOpposite(ii)][getOpposite(jj)] = new Tile(Color.green, getOpposite(ii),
                                    getOpposite(jj));
                    } else {
                        if (jj % 2 == 0)
                            board[getOpposite(ii)][getOpposite(jj)] = new Tile(Color.GREEN, getOpposite(ii),
                                    getOpposite(jj));
                        else
                            board[getOpposite(ii)][getOpposite(jj)] = new Tile(Color.WHITE, getOpposite(ii),
                                    getOpposite(jj));
                    }
                }
            }
        }
    }

    void setStartingPiecesWhite(boolean isHostView) {
        if (isHostView) {
            for (int i = 0; i < 8; i++) {
                board[5][i].setPiece(new BiaPiece(Color.WHITE));
            }

            board[3][3].setPiece(new ConePiece(Color.WHITE));
            // board[3][6].setPiece(new RuaPiece(Color.BLACK));
        } else {
            for (int i = 0; i < 8; i++) {
                board[getOpposite(5)][getOpposite(i)].setPiece(new BiaPiece(Color.WHITE));
            }

            board[getOpposite(3)][getOpposite(3)].setPiece(new ConePiece(Color.WHITE));
            // board[4][3].setPiece(new RuaPiece(Color.WHITE));
        }
    }

    void setStartingPiecesBlack(boolean isHostView) {
        if (isHostView) {
            for (int i = 0; i < 8; i++) {
                board[getOpposite(5)][getOpposite(i)].setPiece(new BiaPiece(Color.BLACK));
            }

            board[getOpposite(3)][getOpposite(3)].setPiece(new ConePiece(Color.BLACK));

            // board[3][6].setPiece(new RuaPiece(Color.BLACK));
        } else {
            for (int i = 0; i < 8; i++) {
                board[5][i].setPiece(new BiaPiece(Color.BLACK));

            }

            board[3][3].setPiece(new ConePiece(Color.BLACK));
            // board[4][3].setPiece(new RuaPiece(Color.WHITE));
        }
    }

    public int getOpposite(int n) {
        return 7 - n;
    }

}
