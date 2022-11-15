
package thaichessui.Pieces;

import java.util.ArrayList;

import thaichessui.Board;
import thaichessui.Tile;
public class ConePiece extends Piece{

    public ConePiece(java.awt.Color color) {
        super(color);
        this.name = "ConePiece";
    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView) {
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();

        // top left
        if (row - 1 >= 0 && row - 1 <= 7
                && col - 1 >= 0 && col - 1 <= 7) {
            Tile t = board.board[row - 1][col - 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        // top right
        if (row - 1 >= 0 && row - 1 <= 7
                && col + 1 >= 0 && col + 1 <= 7) {
            Tile t = board.board[row - 1][col + 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        //top middle
        if (row - 1 >= 0 && row - 1 <= 7
                && col >= 0 && col <= 7) {
            Tile t = board.board[row - 1][col];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }

        // bottom left
        if (row + 1 >= 0 && row + 1 <= 7
                && col - 1 >= 0 && col - 1 <= 7) {
            Tile t = board.board[row + 1][col - 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }
        // bottom right

        if (row + 1 >= 0 && row + 1 <= 7
                && col + 1 >= 0 && col + 1 <= 7) {
            Tile t = board.board[row + 1][col + 1];
            if (!t.getOccupied()//free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { //capture
                legalMoves.add(t);
            }
        }
        return legalMoves;

    }
}
