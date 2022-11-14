package thaichessui.Pieces;

import thaichessui.Board;
import thaichessui.Tile;

import java.awt.Color;
import java.util.ArrayList;

public class BeaPiece extends Piece {

    public BeaPiece(java.awt.Color color) {
        super(color);
        this.name = "BeaPiece";
    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView) {
        
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();
        if (this.getColor() == Color.white) { // move forward
            int val = 1;
            if (isHostView) {
                val = -1;
            }
            if (row + 1 >= 0 && row + 1 * val <= 7 &&
                    col >= 0 && col <= 7 &&
                    !board.board[row + 1 * val][col].getOccupied()) {
                legalMoves.add(board.board[row + 1 * val][col]);
                // System.out.println("1stCase : " + (row+1) + col);
            }

            // if( row >= 0 && row+1 <= 7 && //capture
            // col+1 >= 0 && col+1 <= 7 &&
            // board.board[row+1][col+1].getOccupied()){
            // legalMoves.add(board.board[row+1][col+1]);

            // }

            // if( row-1 >= 0 && row <= 7 && //capture
            // col+1 >= 0 && col+1 <= 7 &&
            // board.board[row+1][col+1].getOccupied()){
            // legalMoves.add(board.board[row-1][col+1]);
            // }
        }

        if (this.getColor() == Color.BLACK) { // move forward
            if (row >= 0 && row <= 7 &&
                    col >= 1 && col <= 7 &&
                    !board.board[row - 1][col].getOccupied()) {
                legalMoves.add(board.board[row - 1][col]);
                System.out.println("2ndCase");
            }
        }

        System.out.println("MOVES FROM" + row + col);
        return legalMoves;
    }

    // @Override
    // public boolean canMove(Board board, Tile begin, Tile dest) {
    //
    // return false;
    // }

}
