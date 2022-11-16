package thaichessui.Pieces;

import java.util.ArrayList;

import thaichessui.Board;
import thaichessui.Tile;
import javax.swing.ImageIcon;
public class RuaPiece extends Piece {


    public RuaPiece(java.awt.Color color) {
        super(color);
        this.name = "RuaPiece";
        if(color == java.awt.Color.WHITE){
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/ruea_white.png"));
        }
        else{
            this.icon = new ImageIcon(getClass().getResource("/thaichessui/images/ruea_black.png"));
        }
    }

    public ArrayList<Tile> getLegalMoves(Board board, int row, int col, boolean isHostView){
        ArrayList<Tile> legalMoves = new ArrayList<Tile>();
    
        int currRow = row+1;
        
        //down
        while(currRow <= 7 && !board.board[currRow][col].getOccupied()){ // check rows until end or until found another piece
            legalMoves.add(board.board[currRow][col]);
            currRow++;
        }

        if(currRow <= 7 && board.board[currRow][col].getOccupied() && board.board[currRow][col].getPiece().getColor() != board.board[row][col].getPiece().getColor()){ // capture
            legalMoves.add(board.board[currRow][col]);
        }

        //up
        currRow = row - 1;
        while(currRow >= 0 && !board.board[currRow][col].getOccupied()){ // check rows until end or until found another piece
            legalMoves.add(board.board[currRow][col]);
            currRow--;
        }

        if(currRow >= 0 && board.board[currRow][col].getOccupied() && board.board[currRow][col].getPiece().getColor() != board.board[row][col].getPiece().getColor()){ // capture
            legalMoves.add(board.board[currRow][col]);
        }

        int currCol = col+1;
        //right
        while(currCol <= 7 && !board.board[row][currCol].getOccupied()){
            legalMoves.add(board.board[row][currCol]);
            currCol++;
        }

        if(currCol <= 7 && board.board[row][currCol].getOccupied() && board.board[row][currCol].getPiece().getColor() != board.board[row][col].getPiece().getColor()){ // capture
            legalMoves.add(board.board[row][currCol]);
        }

        currCol = col - 1 ;
        while(currCol >= 0 && !board.board[row][currCol].getOccupied()){
            legalMoves.add(board.board[row][currCol]);
            currCol--;
        }

        if(currCol >= 0 && board.board[row][currCol].getOccupied() && board.board[row][currCol].getPiece().getColor() != board.board[row][col].getPiece().getColor()){ // capture
            legalMoves.add(board.board[row][currCol]);
        }

        return legalMoves;




    }
}
