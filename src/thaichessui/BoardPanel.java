package thaichessui;

import java.awt.*;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.SwingPropertyChangeSupport;

import thaichessui.Pieces.Piece;

public class BoardPanel extends JPanel {

    private JPanel chessBoard;
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Board boardData = new Board();
    private boolean isHostView;

    public BoardPanel(boolean isHostView) {
        this.isHostView = isHostView;
        initComponents();
        boardData.setStartingPiecesWhite(this.isHostView);
        boardData.setStartingPiecesBlack(this.isHostView);
        updateBoard();
    }

    private void initComponents() {
        this.setPreferredSize(new Dimension(450, 400));
        boardData.populateBoardWithTiles(this.isHostView);
        GridLayout g = new GridLayout(8, 8);
        g.setHgap(-2);
        g.setVgap(-2);
        chessBoard = new JPanel(g);
        this.add(chessBoard);

        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                JButton b = new JButton();
                b.putClientProperty("row", ii);
                b.putClientProperty("col", jj);
                b.setPreferredSize(new Dimension(50, 50));
                b.setBorder(new LineBorder(Color.GRAY));
                // b.addActionListener(new java.awt.event.ActionListener() {
                // public void actionPerformed(java.awt.event.ActionEvent evt) {
                // tileActionPerformed(evt);
                // }
                // });

                // b.addMouseListener(new MouseInputAdapter() {
                // public void mouseEntered(java.awt.event.MouseEvent evt) {
                // int row = (int) ((JButton) evt.getSource()).getClientProperty("row");
                // int col = (int) ((JButton) evt.getSource()).getClientProperty("col");
                // Piece p = boardData.board[row][col].getPiece();
                // if (p == null) {
                // System.out.println("NO PIECE");
                // }
                // if (p != null) {
                // boolean sameColor = (isHostView && (p.getColor() == Color.WHITE))
                // || (!isHostView && (p.getColor() == Color.BLACK));
                // if (sameColor) {
                // System.out.println(p.getLegalMoves(boardData, row, col, isHostView));
                // showLegal(p.getLegalMoves(boardData, row, col, isHostView), Color.CYAN);
                // }
                // System.out.println("row " + row + "col " + col);
                // }
                // }

                // this one
                // b.addActionListener(e -> {
                // int row = (int) b.getClientProperty("row");
                // int col = (int) b.getClientProperty("col");
                // Tile t = boardData.board[row][col];
                // System.out.println("row: " + row + " col: " + col);
                // if (t.getOccupied() == true) {
                // if (findSelected()) {
                // Tile a = returnSelectedTile();
                // try {
                // ArrayList<Tile> validMoves = a.getPiece().getLegalMoves(boardData,
                // a.getRank(),
                // a.getFile(), isHostView);
                // returnColor(validMoves);
                // } catch (Exception ex) {
                // System.out.println("no legal moves");
                // }
                // a.setSelected(false);
                // }
                // t.setSelected(true);
                // try {
                // showLegal(t.getPiece().getLegalMoves(boardData, row, col, isHostView),
                // Color.CYAN);
                // } catch (Exception ex) {
                // System.out.println("no legal moves");
                // }
                // } else {
                // if (findSelected()) {
                // Tile oldTile = returnSelectedTile();
                // Tile newTile = boardData.board[row][col];
                // try {
                // ArrayList<Tile> validMoves = oldTile.getPiece().getLegalMoves(boardData,
                // oldTile.getRank(), oldTile.getFile(), isHostView);
                // returnColor(validMoves);
                // move(validMoves, oldTile, newTile, boardData);
                // } catch (Exception ex) {
                // System.out.println("no legal moves");
                // }
                // }
                // }
                // });
                // this one

                // b.addMouseListener(new MouseInputAdapter() {
                // public void mouseEntered(java.awt.event.MouseEvent evt) {
                // int row = (int) ((JButton) evt.getSource()).getClientProperty("row");
                // int col = (int) ((JButton) evt.getSource()).getClientProperty("col");
                // Piece p = boardData.board[row][col].getPiece();
                // if (p == null) {
                // System.out.println("NO PIECE");
                // }
                // if (p != null) {
                // System.out.println(p.getLegalMoves(boardData, row, col, isHostView));
                // showLegal(p.getLegalMoves(boardData, row, col, isHostView), Color.CYAN);
                // }
                // System.out.println("row " + row + "col " + col);
                // }

                // public void mouseExited(java.awt.event.MouseEvent evt) {
                // int row = (int) ((JButton) evt.getSource()).getClientProperty("row");
                // int col = (int) ((JButton) evt.getSource()).getClientProperty("col");
                // Piece p = boardData.board[row][col].getPiece();
                // if (p == null) {
                // System.out.println("NO PIECE");
                // }
                // if (p != null) {
                // System.out.println(p.getLegalMoves(boardData, row, col, isHostView));
                // returnColor(p.getLegalMoves(boardData, row, col, isHostView));
                // }
                // System.out.println("row " + row + "col " + col);
                // }
                // });

                // b.setMargin(buttonMargin);
                // our chess pieces are 64x64 px in size, so we'll
                // 'fill this in' using a transparent icon..
                // ImageIcon icon = new ImageIcon(
                // new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
                // b.setIcon(icon);
                // if ((jj % 2 == 1 && ii % 2 == 1)
                // // ) {
                // || (jj % 2 == 0 && ii % 2 == 0)) {
                // b.setBackground(Color.WHITE);
                // } else {
                // b.setBackground(Color.BLACK);
                // }
                if (boardData.board[ii][jj].getColor() == Color.WHITE) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.GREEN);
                }
                chessBoardSquares[ii][jj] = b;

            }
        }
        if (this.isHostView) {
            for (int ii = 0; ii < 8; ii++) {
                for (int jj = 0; jj < 8; jj++) {
                    switch (jj) {
                        case 0:
                            chessBoard.add(new JLabel("" + (8 - ii),
                                    SwingConstants.CENTER));
                        default:
                            chessBoard.add(chessBoardSquares[ii][jj]);
                    }
                }
            }
        } else {
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
    }

    public void listenToEvent(BoardPanel boardPanel, ObjectOutputStream out, Timer myTimer, Timer opponentTimer) {
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                JButton b = chessBoardSquares[i][j];
                b.addActionListener(e -> {
                    int row = (int) b.getClientProperty("row");
                    int col = (int) b.getClientProperty("col");
                    Tile t = boardData.board[row][col];
                    System.out.println("row: " + row + " col: " + col);
                    if (t.getOccupied() == true) {
                        if (findSelected()) {
                            Tile a = returnSelectedTile();
                            try {
                                ArrayList<Tile> validMoves = a.getPiece().getLegalMoves(boardData,
                                        a.getRank(),
                                        a.getFile(), isHostView);
                                returnColor(validMoves);
                            } catch (Exception ex) {
                                System.out.println("no legal moves");
                            }
                            a.setSelected(false);
                        }
                        t.setSelected(true);
                        try {
                            showLegal(t.getPiece().getLegalMoves(boardData, row, col, isHostView),
                                    Color.CYAN);
                        } catch (Exception ex) {
                            System.out.println("no legal moves");
                        }
                    } else {
                        if (findSelected()) {
                            Tile oldTile = returnSelectedTile();
                            Tile newTile = boardData.board[row][col];
                            try {
                                ArrayList<Tile> validMoves = oldTile.getPiece().getLegalMoves(boardData,
                                        oldTile.getRank(), oldTile.getFile(), isHostView);
                                returnColor(validMoves);
                                if (move(validMoves, oldTile, newTile, boardData)) {
                                    boardPanel.setEnable(false);
                                    out.writeObject(Main.YOUR_TURN_CODE);
                                    myTimer.stop();
                                    opponentTimer.start();
                                }
                            } catch (Exception ex) {
                                System.out.println("no legal moves");
                            }
                        }
                    }
                });
            }
        }
    }

    public boolean move(ArrayList<Tile> possibleMoves, Tile oldTIle, Tile newTile, Board board) {
        for (Tile d : possibleMoves) {
            if (d == newTile) {
                newTile.setPiece(oldTIle.getPiece());
                newTile.setOccupied(true);
                oldTIle.setPiece(null);
                oldTIle.setOccupied(false);
                oldTIle.setSelected(false);
                updateBoard();
                return true;

            }
        }

        return false;
    }

    void updateBoard() {
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                Piece p = boardData.board[ii][jj].getPiece();
                if (p != null) {
                    chessBoardSquares[ii][jj]
                            .setText((boardData.board[ii][jj].getPiece().getColor() == Color.BLACK ? "B" : "W")
                                    + boardData.board[ii][jj].getPiece().getName());
                    if (boardData.board[ii][jj].getPiece().getIcon() != null) {
                        chessBoardSquares[ii][jj].setText("");
                        chessBoardSquares[ii][jj].setIcon(boardData.board[ii][jj].getPiece().getIcon());
                    }
                }
                if (p == null) {
                    chessBoardSquares[ii][jj].setText("");
                    chessBoardSquares[ii][jj].setIcon(null);
                }
            }
        }
    }

    public void setEnable(boolean isEnable) {
        for (int i = 0; i < chessBoardSquares.length; i++) {
            for (int j = 0; j < chessBoardSquares[i].length; j++) {
                chessBoardSquares[i][j].setEnabled(isEnable);
            }
        }
    }

    Tile returnSelectedTile() {
        for (int ii = 0; ii < chessBoardSquares.length; ii++) {
            for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
                if (boardData.board[ii][jj].getSelected() == true) {
                    return boardData.board[ii][jj];
                }
            }
        }
        return null;
    }

    boolean findSelected() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (boardData.board[i][j].getSelected()) {
                    System.out.println("Found Seceted Piece");
                    return true;
                }
            }
        }
        return false;
    }

    private void tileActionPerformed(java.awt.event.ActionEvent evt) {
        int row = (int) ((JButton) evt.getSource()).getClientProperty("row");
        int col = (int) ((JButton) evt.getSource()).getClientProperty("col");
        Piece p = boardData.board[row][col].getPiece();
        if (p == null) {
            System.out.println("NO PIECE");
        }
        if (p != null) {
            System.out.println(p.getLegalMoves(boardData, col, row, isHostView));
            showLegal(p.getLegalMoves(boardData, row, col, isHostView), boardData.board[row][col].getColor());
        }
        System.out.println("row " + row + "col " + col);
    }
    // private void tileActionPerformed(java.awt.event.ActionEvent evt) {
    // int row = (int) ((JButton) evt.getSource()).getClientProperty("row");
    // int col = (int) ((JButton) evt.getSource()).getClientProperty("col");
    // Piece p = boardData.board[row][col].getPiece();
    // if (p == null) {
    // System.out.println("NO PIECE");
    // }
    // if (p != null) {
    // System.out.println(p.getLegalMoves(boardData, col, row, isHostView));
    // showLegal(p.getLegalMoves(boardData, row, col, isHostView),
    // boardData.board[row][col].getColor());
    // }
    // System.out.println("row " + row + "col " + col);

    // }

    private void showLegal(ArrayList<Tile> legalTiles, Color c) {
        for (Tile t : legalTiles) {
            chessBoardSquares[t.getRank()][t.getFile()].setBackground(c);
        }
    }

    private void returnColor(ArrayList<Tile> legalTiles) {
        for (Tile t : legalTiles) {
            chessBoardSquares[t.getRank()][t.getFile()].setBackground(t.getColor());
        }
    }

}
