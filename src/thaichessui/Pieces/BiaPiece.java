package thaichessui.Pieces;

import thaichessui.Board;
import thaichessui.Tile;

import java.awt.Color;
import java.util.ArrayList;



public class BiaPiece extends Piece {

    public BiaPiece(java.awt.Color color) {
        super(color);
        this.name = "BeaPiece";
        //We have to change this later depending on the color
        if(this.getColor() == Color.BLACK){
        this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/bia_black.png"));}
        else{
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/bia_white.png"));
        }

    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView) {
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();
        if (this.getColor() == Color.WHITE && isHostView) { // move forward
            if (row - 1 >= 0 && row - 1 <= 7 &&
                    col >= 0 && col <= 7 &&
                    !board.board[row - 1][col].getOccupied()) {
                legalMoves.add(board.board[row - 1][col]);

                // System.out.println("1stCase : " + (row+1) + col);
            }
            // capture front left
            if (row - 1 >= 0 && row - 1 <= 7 &&
                    col - 1 >= 0 && col - 1 <= 7 &&
                    board.board[row - 1][col - 1].getOccupied()) {
                if (board.board[row - 1][col - 1].getPiece().getColor() != Color.WHITE) {
                    legalMoves.add(board.board[row - 1][col - 1]);
                }
            }

            //capture front right
            if (row - 1 >= 0 && row - 1 <= 7 &&
                    col + 1 >= 0 && col + 1 <= 7 &&
                    board.board[row - 1][col + 1].getOccupied()) {
                if (board.board[row - 1][col + 1].getPiece().getColor() != Color.WHITE) {

                    legalMoves.add(board.board[row - 1][col + 1]);
                }
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

        if (this.getColor() == Color.BLACK && !isHostView) { // move forward
            if (row - 1 >= 0 && row - 1 <= 7 &&
                    col >= 0 && col <= 7 &&
                    !board.board[row - 1][col].getOccupied()) {
                legalMoves.add(board.board[row - 1][col]);
                // System.out.println("1stase : " + (row+1) + col);
            }

            // capture front left
            if (row - 1 >= 0 && row - 1 <= 7 &&
                    col - 1 >= 0 && col - 1 <= 7 &&
                    board.board[row - 1][col - 1].getOccupied()) {
                if (board.board[row - 1][col - 1].getPiece().getColor() != Color.BLACK) {

                    legalMoves.add(board.board[row - 1][col - 1]);
                }
            }

            //capture front right
            if (row - 1 >= 0 && row - 1 <= 7 &&
                    col + 1 >= 0 && col + 1 <= 7 &&
                    board.board[row - 1][col + 1].getOccupied()) {
                if (board.board[row - 1][col + 1].getPiece().getColor() != Color.BLACK) {

                    legalMoves.add(board.board[row - 1][col + 1]);
                }
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
