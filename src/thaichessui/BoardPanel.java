package thaichessui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.MouseInputAdapter;

import thaichessui.Pieces.Piece;

public class BoardPanel extends JPanel {

    private JPanel chessBoard;
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Board boardData = new Board();

    public BoardPanel() {
        initComponents();
        boardData.setStartingPiecesWhite();
        updateBoard();
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(720,1080));
        boardData.populateBoardWithTiles();
        GridLayout g = new GridLayout(8, 8);
        g.setHgap(-3);
        g.setVgap(-3);
        chessBoard = new JPanel(g);
        this.add(chessBoard);

        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.putClientProperty("row", ii);
                b.putClientProperty("col", jj);
                b.setPreferredSize(new Dimension(80, 80));
                b.setBorder(new LineBorder(Color.GRAY));
                // b.addActionListener(new java.awt.event.ActionListener() {
                //     public void actionPerformed(java.awt.event.ActionEvent evt) {
                //         tileActionPerformed(evt);
                //     }
                // });
                b.addMouseListener(new MouseInputAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        int row = (int) ((JButton)evt.getSource()).getClientProperty("row");
                        int col = (int) ((JButton)evt.getSource()).getClientProperty("col");
                        Piece p = boardData.board[row][col].getPiece();
                        if(p==null){
                            System.out.println("NO PIECE");
                        }
                        if(p!=null){
                            System.out.println(p.getLegalMoves(boardData,row,col));
                            showLegal(p.getLegalMoves(boardData,row,col),Color.CYAN);
                        }
                        System.out.println("row " + row + "col " + col);
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        int row = (int) ((JButton)evt.getSource()).getClientProperty("row");
                        int col = (int) ((JButton)evt.getSource()).getClientProperty("col");
                        Piece p = boardData.board[row][col].getPiece();
                        if(p==null){
                            System.out.println("NO PIECE");
                        }
                        if(p!=null){
                            System.out.println(p.getLegalMoves(boardData,row,col));
                            returnColor(p.getLegalMoves(boardData, row, col));
                        }
                        System.out.println("row " + row + "col " + col);
                    }
                 });
                // b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                // ImageIcon icon = new ImageIcon(
                // new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                // b.setIcon(icon);
                // if ((jj % 2 == 1 && ii % 2 == 1)
                //         // ) {
                //         || (jj % 2 == 0 && ii % 2 == 0)) {
                //     b.setBackground(Color.WHITE);
                // } else {
                //     b.setBackground(Color.BLACK);
                // }
                if(boardData.board[ii][jj].getColor() == Color.WHITE){
                    b.setBackground(Color.WHITE);
                }
                else{
                    b.setBackground(Color.BLACK);
                }
                chessBoardSquares[ii][jj] = b;
                
            }
        }
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                switch (jj) {
                    case 0:
                        chessBoard.add(new JLabel("" + (ii + 1),
                                SwingConstants.CENTER));
                    default:
                        chessBoard.add(chessBoardSquares[ii][jj]);
                }
            }
        }
    }

    void updateBoard(){
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++){
                Piece p = boardData.board[ii][jj].getPiece();
                if (p!=null){
                chessBoardSquares[ii][jj].setText(boardData.board[ii][jj].getPiece().getName());
                }
            }
        }
    }

    private void tileActionPerformed(java.awt.event.ActionEvent evt){
        int row = (int) ((JButton)evt.getSource()).getClientProperty("row");
        int col = (int) ((JButton)evt.getSource()).getClientProperty("col");
        Piece p = boardData.board[row][col].getPiece();
        if(p==null){
            System.out.println("NO PIECE");
        }
        if(p!=null){
            System.out.println(p.getLegalMoves(boardData,col,row));
            showLegal(p.getLegalMoves(boardData,row,col),boardData.board[row][col].getColor());
        }
        System.out.println("row " + row + "col " + col);
        
        
    }

    private void showLegal(ArrayList<Tile> legalTiles, Color c){
        for (Tile t: legalTiles){
            chessBoardSquares[t.getRank()][t.getFile()].setBackground(c);
        }
    }

    private void returnColor(ArrayList<Tile> legalTiles){
        for (Tile t: legalTiles){
            chessBoardSquares[t.getRank()][t.getFile()].setBackground(t.getColor());
        }
    }
}
