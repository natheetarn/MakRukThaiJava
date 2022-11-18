
package thaichessui.Pieces;

import java.awt.Color;
import java.util.ArrayList;

import thaichessui.Board;
import thaichessui.Tile;
import javax.swing.ImageIcon;

public class MahPiece extends Piece {

    public MahPiece(java.awt.Color color) {
        super(color);
        this.name = "ConePiece";
        if (color == java.awt.Color.WHITE) {
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/ma_white.png"));
        } else {
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/ma_black.png"));
        }
    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView, boolean isUpSideDown) {
        int factor = isUpSideDown ? -1 : 1;
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();
        if ((this.getColor() == Color.WHITE && !isHostView) || (this.getColor() == Color.BLACK && isHostView)) {
            return legalMoves;
        }
        // row+1 col -2
        if (row + 1 * factor >= 0 && row + 1 * factor <= 7
                && col - 2 * factor >= 0 && col - 2 * factor <= 7) {
            Tile t = board.board[row + 1 * factor][col - 2 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // row + 2 col -1
        if (row + 2 * factor >= 0 && row + 2 * factor <= 7
                && col - 1 * factor >= 0 && col - 1 * factor <= 7) {
            Tile t = board.board[row + 2 * factor][col - 1 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // row + 2 col + 1
        if (row + 2 * factor >= 0 && row + 2 * factor <= 7
                && col + 1 * factor >= 0 && col + 1 * factor <= 7) {
            Tile t = board.board[row + 2 * factor][col + 1 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // row + 1 col + 2
        if (row + 1 * factor >= 0 && row + 1 * factor <= 7
                && col + 2 * factor >= 0 && col + 2 * factor <= 7) {
            Tile t = board.board[row + 1 * factor][col + 2 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }
        // row - 1 col + 2

        if (row - 1 * factor >= 0 && row - 1 * factor <= 7
                && col + 2 * factor >= 0 && col + 2 * factor <= 7) {
            Tile t = board.board[row - 1 * factor][col + 2 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // row - 2 col + 1
        if (row - 2 * factor >= 0 && row - 2 * factor <= 7
                && col + 1 * factor >= 0 && col + 1 * factor <= 7) {
            Tile t = board.board[row - 2 * factor][col + 1 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // row - 2 col -1
        if (row - 2 * factor >= 0 && row - 2 * factor <= 7
                && col - 1 * factor >= 0 && col - 1 * factor <= 7) {
            Tile t = board.board[row - 2 * factor][col - 1 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // row - 1 col -2
        if (row - 1 * factor >= 0 && row - 1 * factor <= 7
                && col - 2 * factor >= 0 && col - 2 * factor <= 7) {
            Tile t = board.board[row - 1 * factor][col - 2 * factor];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }
        return legalMoves;

    }
}
