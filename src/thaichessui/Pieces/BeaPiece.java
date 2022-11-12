package thaichessui.Pieces;
import thaichessui.Board;
import thaichessui.Tile;
import java.util.ArrayList;

public class BeaPiece extends Piece {

    public BeaPiece(String color){
        super(color);
    }

    public ArrayList<Tile> getLegalMoves(Board board,int file, int rank){
        ArrayList<Tile>legalMoves = new ArrayList<Tile>();
        if (this.getColor() == "WHITE"){ //move forward
            if( file >= 0 && file <= 7 && 
                rank+1 >= 0 && rank+1 <= 7 && 
                board.board[file][rank+1].getOccupied()){
                legalMoves.add(board.board[file][rank+1]);
            }

            if( file >= 0 && file+1 <= 7 && //capture
                rank+1 >= 0 && rank+1 <= 7 && 
                board.board[file+1][rank+1].getOccupied()){
                legalMoves.add(board.board[file+1][rank+1]);
            }

            if( file-1 >= 0 && file <= 7 && //capture
                rank+1 >= 0 && rank+1 <= 7 && 
                board.board[file+1][rank+1].getOccupied()){
                legalMoves.add(board.board[file-1][rank+1]);
            }
        }

        if (this.getColor() == "BLACK"){ //move forward
            if( file >= 0 && file <= 7 && 
                rank >= 1 && rank <= 7 &&
                board.board[file][rank-1].getOccupied()){
                legalMoves.add(board.board[file][rank-1]);
            }
        }


        return legalMoves;
    }

    // @Override
    // public boolean canMove(Board board, Tile begin, Tile dest) {
    //
    //     return false;
    // }   


}
