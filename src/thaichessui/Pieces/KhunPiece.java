
package thaichessui.Pieces;

import java.awt.Color;
import java.util.ArrayList;

import thaichessui.Board;
import thaichessui.Tile;
import javax.swing.ImageIcon;

public class KhunPiece extends Piece {

    private boolean isChecked = false;

    public KhunPiece(java.awt.Color color) {
        super(color);
        this.name = "ConePiece";
        if (color == java.awt.Color.WHITE) {
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/Khun_white.png"));
        } else {
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/Khun_black.png"));
        }
    }

    public void setChecked(boolean b) {
        this.isChecked = b;
    }

    public boolean getChecked() {
        return this.isChecked;
    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView, boolean isUpSideDown) {
        int factor = isUpSideDown ? -1 : 1;
        int step = 1 * factor;
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();
        if ((this.getColor() == Color.WHITE && !isHostView) || (this.getColor() == Color.BLACK && isHostView)) {
            return legalMoves;
        }
        // top left
        if (row - step >= 0 && row - step <= 7
                && col - step >= 0 && col - step <= 7) {
            Tile t = board.board[row - step][col - step];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // top right
        if (row - step >= 0 && row - step <= 7
                && col + step >= 0 && col + step <= 7) {
            Tile t = board.board[row - step][col + step];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // top middle
        if (row - step >= 0 && row - step <= 7
                && col >= 0 && col <= 7) {
            Tile t = board.board[row - step][col];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // bottom left
        if (row + step >= 0 && row + step <= 7
                && col - step >= 0 && col - step <= 7) {
            Tile t = board.board[row + step][col - step];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }
        // bottom right

        if (row + step >= 0 && row + step <= 7
                && col + step >= 0 && col + step <= 7) {
            Tile t = board.board[row + step][col + step];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // bottom middle

        if (row + step >= 0 && row + step <= 7
                && col >= 0 && col <= 7) {
            Tile t = board.board[row + step][col];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // left
        if (row >= 0 && row <= 7
                && col - step >= 0 && col - step <= 7) {
            Tile t = board.board[row][col - step];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }

        // right
        if (row >= 0 && row <= 7
                && col + step >= 0 && col + step <= 7) {
            Tile t = board.board[row][col + step];
            if (!t.getOccupied()// free
                    || (t.getPiece().getColor() != board.board[row][col].getPiece().getColor())) { // capture
                legalMoves.add(t);
            }
        }
        return legalMoves;

    }
}
