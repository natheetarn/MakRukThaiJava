package thaichessui;

import java.awt.*;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.Timer;

import thaichessui.Pieces.BiaPiece;
import thaichessui.Pieces.KhunPiece;
import thaichessui.Pieces.Piece;
import thaichessui.Pieces.PromotedBiaPiece;

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
                    boolean flag = false;
                    System.out.println("row: " + row + " col: " + col);
                    if (t.getOccupied() == true) {
                        if (findSelected()) {
                            Tile a = returnSelectedTile();
                            try {
                                Tile oldTile = boardData.board[returnSelectedTile()
                                        .getRank()][returnSelectedTile().getFile()];
                                Tile newTile = t;

                                Tile opOldTile = getOppositeTile(oldTile);
                                Tile opNewTile = getOppositeTile(newTile);

                                if (newTile.getPiece().getColor() != oldTile.getPiece().getColor()) {
                                    ArrayList<Tile> validMoves = a.getPiece().getLegalMoves(boardData,
                                            a.getRank(),
                                            a.getFile(), isHostView, false);
                                    returnColor(validMoves);
                                    if (a.getPiece() instanceof KhunPiece) {
                                        validMoves = getSafeKhunMoves(validMoves, true);
                                        
                                    }

                                    if (getChecked()) {
                                        validMoves = getMovesThatSaveKhun(a, validMoves);
                        
                                    }

                                    // capture
                                    if (move(validMoves,
                                            boardData.board[returnSelectedTile().getRank()][returnSelectedTile()
                                                    .getFile()],
                                            t, boardData)) {
                                        returnColor(validMoves);
                                        boardPanel.setEnable(false);
                                        int arr[] = { opOldTile.getRank(), opOldTile.getFile(), opNewTile.getRank(),
                                                opNewTile.getFile() };
                                        out.writeObject(arr);
                                        myTimer.stop();
                                        if (isCheck()) {
                                            setKhunTileToRed(false);
                                            // Tile khunTile = boardData.getKhunTile(!isHostView);
                                            // chessBoardSquares[khunTile.getRank()][khunTile.getFile()]
                                            // .setBackground(Color.red);

                                            out.writeObject(Main.CHECK_CODE);
                                            if (isCheckmate()) {
                                                System.out.println("Checkmate");
                                                out.writeObject(Main.CHECKMATE_CODE);
                                            }
                                        }
                                        
                                        

                                        opponentTimer.start();
                                        flag = true;
                                    }
                                    // cature
                                }

                            } catch (Exception ex) {
                                System.out.println("no legal moves");
                            }

                            a.setSelected(false);
                        }

                        if (flag == false) {
                            t.setSelected(true);
                            ArrayList<Tile> legalMoves = t.getPiece().getLegalMoves(
                                    boardData, row, col, isHostView, false);
                            if (t.getPiece() instanceof KhunPiece) {
                                legalMoves = getSafeKhunMoves(legalMoves, true);
                            }

                            if (getChecked()) {
                                legalMoves = getMovesThatSaveKhun(t, legalMoves);
                            }

                            try {
                                resetboardcolor();
                                showLegal(legalMoves, Color.CYAN);
                                flag = true;
                            } catch (Exception ex) {
                                System.out.println("no legal moves");

                            }
                        }

                    } else {
                        System.out.println(findSelected());
                        if (findSelected()) {
                            Tile oldTile = returnSelectedTile();

                            Tile newTile = boardData.board[row][col];

                            Tile opOldTile = getOppositeTile(oldTile);
                            Tile opNewTile = getOppositeTile(newTile);
                            try {
                                ArrayList<Tile> validMoves = oldTile.getPiece().getLegalMoves(boardData,
                                        oldTile.getRank(), oldTile.getFile(), isHostView, false);
                                if (oldTile.getPiece() instanceof KhunPiece) {
                                    validMoves = getSafeKhunMoves(validMoves, true);
                                }

                                if (getChecked()) {
                                    validMoves = getMovesThatSaveKhun(oldTile, validMoves);
                                }

                                returnColor(validMoves);

                                if (move(validMoves, oldTile, newTile, boardData)) {
                                    boardPanel.setEnable(false);
                                    int arr[] = { opOldTile.getRank(), opOldTile.getFile(), opNewTile.getRank(),
                                            opNewTile.getFile() };
                                    out.writeObject(arr);
                                    myTimer.stop();
                                    if (isCheck()) {
                                        setKhunTileToRed(false);
                                        // Tile khunTile = boardData.getKhunTile(!isHostView);
                                        // chessBoardSquares[khunTile.getRank()][khunTile.getFile()]
                                        // .setBackground(Color.red);

                                        out.writeObject(Main.CHECK_CODE);
                                        System.out.println("Check");
                                        if (isCheckmate()) {
                                            System.out.println("Checkmate");
                                            out.writeObject(Main.CHECKMATE_CODE);
                                        }
                                    }

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

    public ArrayList<Tile> getMovesThatSaveKhun(Tile t, ArrayList<Tile> legalmoves) {
        if (t.getPiece() instanceof KhunPiece) {
            return legalmoves;
        }

        Tile khunTile = boardData.getKhunTile(isHostView);

        ArrayList<Tile> newLegalmoves = new ArrayList<Tile>();
        for (Tile lm : legalmoves) {
            newLegalmoves.add(lm);
        }

        ArrayList<Tile> opponentTiles = getOpponentTiles();
        for (Tile lm : legalmoves) {
            boolean moveFlag = false;
            boolean isCapture = false;
            Piece tmp = lm.getPiece();
            if (lm.getPiece() != null) {
                isCapture = true;
            }

            simulateMove(t, lm);
            for (Tile ot : opponentTiles) {
                if (ot.getPiece() != null) {
                    ArrayList<Tile> opponentMoves = ot.getPiece().getLegalMoves(
                            boardData, ot.getRank(), ot.getFile(), !isHostView, true);
                    for (Tile om : opponentMoves) {
                        if (om.getRank() == khunTile.getRank() && om.getFile() == khunTile.getFile()) {
                            newLegalmoves.remove(lm);
                            moveFlag = true;
                            break;
                        }
                    }

                    if (moveFlag) {
                        break;
                    }
                }
            }

            simulateMove(lm, t);
            if (isCapture) {
                lm.setPiece(tmp);
                lm.setOccupied(true);
            }
        }

        return newLegalmoves;
    }

    public Board getBoardData() {
        return boardData;
    }

    public Tile getOppositeTile(Tile tile) {
        return boardData.board[7 - tile.getRank()][7 - tile.getFile()];
    }

    public boolean move(ArrayList<Tile> possibleMoves, Tile oldTile, Tile newTile, Board board) {

        for (Tile d : possibleMoves) {
            if (d == newTile) {

                newTile.setPiece(oldTile.getPiece());
                if (isHostView) {
                    if ((oldTile.getPiece().getColor() == Color.WHITE) && oldTile.getPiece() instanceof BiaPiece) {
                        if (newTile.getRank() == 2) {
                            newTile.setPiece(new PromotedBiaPiece(Color.WHITE));
                        }
                    } else if ((oldTile.getPiece().getColor() == Color.BLACK)
                            && oldTile.getPiece() instanceof BiaPiece) {
                        if (newTile.getRank() == 5) {
                            newTile.setPiece(new PromotedBiaPiece(Color.BLACK));
                        }
                    }
                } else if (!isHostView) {
                    if ((oldTile.getPiece().getColor() == Color.WHITE) && oldTile.getPiece() instanceof BiaPiece) {
                        if (newTile.getRank() == 5) {
                            newTile.setPiece(new PromotedBiaPiece(Color.WHITE));
                        }
                    } else if ((oldTile.getPiece().getColor() == Color.BLACK)
                            && oldTile.getPiece() instanceof BiaPiece) {
                        if (newTile.getRank() == 2) {
                            newTile.setPiece(new PromotedBiaPiece(Color.BLACK));
                        }
                    }
                }

                newTile.setOccupied(true);
                oldTile.setPiece(null);
                oldTile.setOccupied(false);
                oldTile.setSelected(false);
                updateBoard();
                // lookForCheck(newTile.getPiece().getColor());
                return true;

            }
        }

        return false;
    }

    public void updateOpponent(Tile oldTile, Tile newTile) {
        newTile.setPiece(oldTile.getPiece());

        if (isHostView) {
            if ((oldTile.getPiece().getColor() == Color.WHITE) && oldTile.getPiece() instanceof BiaPiece) {
                if (newTile.getRank() == 2) {
                    newTile.setPiece(new PromotedBiaPiece(Color.WHITE));
                }
            } else if ((oldTile.getPiece().getColor() == Color.BLACK)
                    && oldTile.getPiece() instanceof BiaPiece) {
                if (newTile.getRank() == 5) {
                    newTile.setPiece(new PromotedBiaPiece(Color.BLACK));
                }
            }
        } else if (!isHostView) {
            if ((oldTile.getPiece().getColor() == Color.WHITE) && oldTile.getPiece() instanceof BiaPiece) {
                if (newTile.getRank() == 5) {
                    newTile.setPiece(new PromotedBiaPiece(Color.WHITE));
                }
            } else if ((oldTile.getPiece().getColor() == Color.BLACK)
                    && oldTile.getPiece() instanceof BiaPiece) {
                if (newTile.getRank() == 2) {
                    newTile.setPiece(new PromotedBiaPiece(Color.BLACK));
                }
            }
        }

        newTile.setOccupied(true);
        oldTile.setPiece(null);
        oldTile.setOccupied(false);
        oldTile.setSelected(false);
        updateBoard();
        resetboardcolor();
    }

    public ArrayList<Tile> getSafeKhunMoves(ArrayList<Tile> legalmoves, boolean isOpposed) {
        ArrayList<Tile> newLegalmoves = new ArrayList<Tile>();

        for (Tile lm : legalmoves) {
            newLegalmoves.add(lm);
        }

        Tile khunTile = boardData.getKhunTile(isHostView);

        ArrayList<Tile> opposedTiles = getMyTiles();
        if (isOpposed) {
            opposedTiles = getOpponentTiles();
        }

        for (Tile lm : legalmoves) {
            boolean moveFlag = false;
            boolean isCapture = false;
            Piece tmp = lm.getPiece();
            if (lm.getPiece() != null) {
                isCapture = true;
            }

            simulateMove(khunTile, lm);

            // khunTile.setOccupied(false);
            for (Tile ot : opposedTiles) {
                if (ot.getPiece() != null) {
                    ArrayList<Tile> opposedMoves = ot.getPiece().getLegalMoves(boardData, ot.getRank(), ot.getFile(),
                            isOpposed ? !isHostView : isHostView, true);
                    // !isHostView because we tryna get legal moves for the opponent

                    for (Tile om : opposedMoves) {
                        if (om.getRank() == lm.getRank() && om.getFile() == lm.getFile()) {
                            newLegalmoves.remove(lm);
                            moveFlag = true;
                            break;
                        }
                    }

                    if (moveFlag) {
                        break;
                    }
                }
            }

            simulateMove(lm, khunTile);
            if (isCapture) {
                lm.setPiece(tmp);
                lm.setOccupied(true);
            }
            // khunTile.setOccupied(true);
        }

        return newLegalmoves;
    }

    public ArrayList<Tile> getOpponentTiles() {
        ArrayList<Tile> opponentTiles = new ArrayList<Tile>();
        for (int i = 0; i < boardData.board.length; i++) {
            for (int j = 0; j < boardData.board.length; j++) {
                Piece p = boardData.board[i][j].getPiece();
                if (isHostView) {
                    if (p != null && p.getColor() == Color.BLACK) {
                        opponentTiles.add(boardData.board[i][j]);
                    }
                } else {
                    if (p != null && p.getColor() == Color.WHITE) {
                        opponentTiles.add(boardData.board[i][j]);
                    }
                }
            }
        }

        return opponentTiles;
    }

    public ArrayList<Tile> getMyTiles() {
        ArrayList<Tile> myTiles = new ArrayList<Tile>();
        for (int i = 0; i < boardData.board.length; i++) {
            for (int j = 0; j < boardData.board.length; j++) {
                Piece p = boardData.board[i][j].getPiece();
                if (isHostView) {
                    if (p != null && p.getColor() == Color.WHITE) {
                        myTiles.add(boardData.board[i][j]);
                    }
                } else {
                    if (p != null && p.getColor() == Color.BLACK) {
                        myTiles.add(boardData.board[i][j]);
                    }
                }
            }
        }

        return myTiles;
    }

    public void setKhunTileToRed(boolean mySide) {
        Tile khunTile = boardData.getKhunTile(mySide ? isHostView : !isHostView);
        chessBoardSquares[khunTile.getRank()][khunTile.getFile()]
                .setBackground(Color.red);
    }

    // check if our khun is checked
    public boolean getChecked() {
        Tile khunTile = boardData.getKhunTile(isHostView);

        ArrayList<Tile> opponentTiles = getOpponentTiles();

        for (Tile ot : opponentTiles) {
            ArrayList<Tile> opponentMoves = ot.getPiece().getLegalMoves(boardData, ot.getRank(), ot.getFile(),
                    !isHostView, true);

            for (Tile om : opponentMoves) {
                if (om.getRank() == khunTile.getRank() && om.getFile() == khunTile.getFile()) {
                    return true;
                }
            }
        }

        return false;

    }

    // check if the we check opponent's khun
    public boolean isCheck() {
        // get khun tile of the opponent
        Tile khunTile = boardData.getKhunTile(!isHostView);

        ArrayList<Tile> myTiles = getMyTiles();

        for (Tile mt : myTiles) {
            if (mt.getPiece() != null) {
                ArrayList<Tile> myMoves = mt.getPiece().getLegalMoves(boardData, mt.getRank(), mt.getFile(),
                        isHostView, false);

                for (Tile mm : myMoves) {
                    if (mm.getRank() == khunTile.getRank() && mm.getFile() == khunTile.getFile()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isCheckmate() {
        Tile khunTile = boardData.getKhunTile(!isHostView);

        if (isCheck()) {
            ArrayList<Tile> safeMoves = getSafeKhunMoves(khunTile.getPiece().getLegalMoves(
                    boardData, khunTile.getRank(), khunTile.getFile(), !isHostView, true),
                    false);
            if (safeMoves.size() > 0) {
                return false;
            }
        }

        ArrayList<Tile> opponentTiles = getOpponentTiles();

        for (Tile ot : opponentTiles) {
            ArrayList<Tile> opponentMoves = ot.getPiece().getLegalMoves(boardData,
                    ot.getRank(), ot.getFile(), !isHostView, true);
            for (Tile mm : opponentMoves) {
                boolean isCapture = false;
                // in case you capture a piece when backtrack after simulateMove
                Piece tmp = mm.getPiece();
                if (mm.getPiece() != null) {
                    isCapture = true;
                }

                simulateMove(ot, mm);
                if (!isCheck()) {
                    simulateMove(mm, ot);
                    if (isCapture) {
                        mm.setPiece(tmp);
                        mm.setOccupied(true);
                    }
                    return false;
                }

                simulateMove(mm, ot);
                if (isCapture) {
                    mm.setPiece(tmp);
                    mm.setOccupied(true);
                }
            }
        }

        return true;
    }


    public boolean isStaleMate(){
        Tile khunTile = boardData.getKhunTile(!isHostView);

        if (!isCheck()) {
            ArrayList<Tile> safeMoves = getSafeKhunMoves(khunTile.getPiece().getLegalMoves(
                    boardData, khunTile.getRank(), khunTile.getFile(), !isHostView, true),
                    false);
            if (safeMoves.size() == 0) {
                return true;
            }
        }
        return false;
    }

    // move without updating board, use for when checking for checkmate
    public void simulateMove(Tile oldTile, Tile newTile) {
        newTile.setPiece(oldTile.getPiece());
        newTile.setOccupied(true);
        oldTile.setPiece(null);
        oldTile.setOccupied(false);
        // oldTile.setSelected(false);
    }

    // private boolean lookForCheck(Color c) {
    // ArrayList<Tile> legalMoves = new ArrayList<Tile>();
    // for (int ii = 0; ii < chessBoardSquares.length; ii++) {
    // for (int jj = 0; jj < chessBoardSquares[ii].length; jj++) {
    // Piece p = boardData.board[ii][jj].getPiece();
    // if (p != null && p.getColor() == c) {
    // legalMoves.addAll(p.getLegalMoves(boardData, ii, jj, isHostView));
    // }
    // }
    // }

    // for (Tile d : legalMoves) {
    // if (d.getOccupied() && d.getPiece() instanceof KhunPiece &&
    // d.getPiece().getColor() != c) {
    // ((KhunPiece) d.getPiece()).setChecked(true);
    // chessBoardSquares[d.getRank()][d.getFile()].setBackground(Color.red);// for
    // testing
    // return true;

    // }
    // }

    // return false;
    // }

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

    void resetboardcolor() {
        for (int ii = 0; ii < 8; ii++) {
            for (int jj = 0; jj < 8; jj++) {
                if (isHostView) {
                    if (ii % 2 == 0) {
                        if (jj % 2 == 0)
                            chessBoardSquares[ii][jj].setBackground(Color.WHITE);
                        else
                            chessBoardSquares[ii][jj].setBackground(Color.GREEN);
                    } else {
                        if (jj % 2 == 0)
                            chessBoardSquares[ii][jj].setBackground(Color.GREEN);
                        else
                            chessBoardSquares[ii][jj].setBackground(Color.WHITE);
                    }
                } else {
                    if (ii % 2 == 0) {
                        if (jj % 2 == 0)
                            chessBoardSquares[ii][jj].setBackground(Color.WHITE);
                        else
                            chessBoardSquares[ii][jj].setBackground(Color.green);
                    } else {
                        if (jj % 2 == 0)
                            chessBoardSquares[ii][jj].setBackground(Color.green);
                        else
                            chessBoardSquares[ii][jj].setBackground(Color.WHITE);
                    }
                }
                ;
            }
        }
    }

}
