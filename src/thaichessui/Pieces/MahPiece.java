
package thaichessui.Pieces;

import java.awt.Color;
import java.util.ArrayList;

import thaichessui.Board;
import thaichessui.Tile;
import javax.swing.ImageIcon;
public class MahPiece extends Piece{

    public MahPiece(java.awt.Color color) {
        super(color);
        this.name = "ConePiece";
        if(color == java.awt.Color.WHITE){
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/ma_white.png"));
        }
        else{
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/ma_black.png"));
        }
    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView) {
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();
        if((this.getColor() == Color.WHITE && !isHostView) || (this.getColor() == Color.BLACK && isHostView)){
            return legalMoves;
        }
        // row+1 col -2
        if (row + 1 >= 0 && row + 1 <= 7
                && col - 2 >= 0 && col - 2 <= 7) {
            Tile t = board.board[row + 1][col - 2];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        // row + 2 col -1
        if (row +2 >= 0 && row + 2 <= 7
                && col - 1 >= 0 && col - 1 <= 7) {
            Tile t = board.board[row + 2][col - 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }


        // row + 2 col + 1
        if (row +2 >= 0 && row + 2 <= 7
                && col+1 >= 0 && col+1 <= 7) {
            Tile t = board.board[row + 2][col+1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        // row + 1 col + 2
        if (row + 1 >= 0 && row + 1 <= 7
                && col +2 >= 0 && col +2 <= 7) {
            Tile t = board.board[row + 1][col +2];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }
        // row - 1 col + 2

        if (row - 1 >= 0 && row - 1 <= 7
                && col + 2 >= 0 && col + 2 <= 7) {
            Tile t = board.board[row - 1][col + 2];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        //row - 2 col + 1
        if (row - 2 >= 0 && row - 2  <= 7
                && col + 1 >= 0 && col + 1 <= 7) {
            Tile t = board.board[row -2 ][col + 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        //row - 2 col -1
        if (row -2  >= 0 && row -2  <= 7
                && col -1 >= 0 && col - 1 <= 7) {
            Tile t = board.board[row - 2][col - 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        
        //row - 1 col -2
        if (row -1  >= 0 && row -1  <= 7
                && col -2 >= 0 && col - 2 <= 7) {
            Tile t = board.board[row - 1][col - 2];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }
        return legalMoves;

    }
}
