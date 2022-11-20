/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package thaichessui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author kaikaew
 */
public class GamePanelClient extends javax.swing.JPanel {

    private static Socket socket = null;
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;

    private double myCurTime = 0;
    private double opponentCurTime = 0;
    private Timer myTimer = null;
    private Timer opponentTimer = null;

    private BoardPanel boardPanel = null;
    private boolean timeoutFlag = false;

    /**
     * Creates new form BoardPanel
     */
    public GamePanelClient() {
        initComponents();
        initBoard();
        // initTimer();
    }

    public void initTimer(String timeOption) {
        switch (timeOption) {
            case Main.TIME_OPTION_1_MIN:
                myCurTime = 60;
                opponentCurTime = 60;
                break;
            case Main.TIME_OPTION_3_MIN:
                myCurTime = 60 * 3;
                opponentCurTime = 60 * 3;
                break;
            case Main.TIME_OPTION_5_MIN:
                myCurTime = 60 * 5;
                opponentCurTime = 60 * 5;
                break;
            case Main.TIME_OPTION_10_MIN:
                myCurTime = 60 * 10;
                opponentCurTime = 60 * 10;
                break;
            case Main.TIME_OPTION_30_MIN:
                myCurTime = 60 * 30;
                opponentCurTime = 60 * 30;
                break;
            case Main.TIME_OPTION_1_HR:
                myCurTime = 60 * 60;
                opponentCurTime = 60 * 60;
                break;
            case Main.TIME_OPTION_UNLIMITED:
                myCurTime = Double.POSITIVE_INFINITY;
                opponentCurTime = Double.POSITIVE_INFINITY;
                break;
            default:
                myCurTime = 60 * 60;
                opponentCurTime = 60 * 60;
        }

        myTime.setText(String.format("%.0f", myCurTime));
        opponentTime.setText(String.format("%.0f", opponentCurTime));

        GamePanelClient gpc = this;

        myTimer = new Timer(1000, new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                myTime.setText(String.format("%.0f", myCurTime));
                myCurTime--;
                if (myCurTime <= 0) {
                    // JOptionPane.showMessageDialog(null, "You are out of time! Your opponent get
                    // the dubs!", "😭😭",
                    // JOptionPane.PLAIN_MESSAGE);
                    ResultPanel resultPanel = new ResultPanel(Main.RESULT_LOSE, "You are out of time!");
                    gpc.setLayout(new java.awt.BorderLayout());
                    gpc.removeAll();
                    gpc.add(resultPanel);
                    gpc.revalidate();

                    stopMyTimer();
                    stopOpponentTimer();
                    timeoutFlag = true;
                }
            }
        });

        opponentTimer = new Timer(1000, new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                opponentTime.setText(String.format("%.0f", opponentCurTime));
                opponentCurTime--;
                if (opponentCurTime <= 0) {
                    // JOptionPane.showMessageDialog(null, "The opponent is out of time! Winner
                    // winner chicken dinner!",
                    // "🥳🥳",
                    // JOptionPane.PLAIN_MESSAGE);

                    ResultPanel resultPanel = new ResultPanel(Main.RESULT_WIN, "The opponent is out of time!");
                    gpc.setLayout(new java.awt.BorderLayout());
                    gpc.removeAll();
                    gpc.add(resultPanel);
                    gpc.revalidate();

                    stopMyTimer();
                    stopOpponentTimer();
                    timeoutFlag = true;
                }
            }
        });
    }

    public static void closeConnection() {
        try {
            if (socket != null) {
                out.writeObject(Main.FORCE_EXIT_CODE);
                socket.close();
                in.close();
                out.close();
            }

            socket = null;
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public void chatPrintln(String str) {
        jTextArea1.append(str + "\n");
    }

    public void run(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            // opponentTimer.start();

            chatPrintln("GLHF!!!");

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(
                    null, "There is no host right now!", "Oh no!",
                    JOptionPane.WARNING_MESSAGE);

            HostPanel hostPanel = new HostPanel();

            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(hostPanel);
            this.revalidate();
            return;
        }

        try {
            whileGaming();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        try {
            if (socket != null) {
                in.close();
                out.close();
                socket.close();
                socket = null;
            }

            stopMyTimer();
            stopOpponentTimer();
            if (!timeoutFlag) {
                // JOptionPane.showMessageDialog(null, "Oops! Your opponent disconnected, guess
                // its your win!", "🗿",
                // JOptionPane.PLAIN_MESSAGE);
                ResultPanel resultPanel = new ResultPanel(Main.RESULT_WIN, "Your opponent disconnected");

                this.setLayout(new java.awt.BorderLayout());
                this.removeAll();
                this.add(resultPanel);
                this.revalidate();
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void whileGaming() throws IOException {
        String message = "";
        do {
            try {
                Object o = in.readObject();
                if (o instanceof Integer) {
                    if ((int) o == Main.FORCE_EXIT_CODE) {
                        return;
                    } else if ((int) o == Main.YOUR_TURN_CODE) {
                        boardPanel.setEnable(true);
                        stopOpponentTimer();
                        startMyTimer();
                    } else if ((int) o == Main.CHECK_CODE) {
                        boardPanel.setKhunTileToRed(true);
                    } else if ((int) o == Main.CHECKMATE_CODE) {
                        out.writeObject(Main.GOT_CHECKMATED_CODE);
                        stopMyTimer();
                        stopOpponentTimer();
                        JOptionPane.showMessageDialog(null, "You just got checkmated!!", "😭😭",
                                JOptionPane.PLAIN_MESSAGE);

                        ResultPanel resultPanel = new ResultPanel(Main.RESULT_LOSE, "You just got checkmated!");
                        this.setLayout(new java.awt.BorderLayout());
                        this.removeAll();
                        this.add(resultPanel);
                        this.revalidate();

                        timeoutFlag = true;
                    } else if ((int) o == Main.GOT_CHECKMATED_CODE) {
                        stopMyTimer();
                        stopOpponentTimer();
                        JOptionPane.showMessageDialog(null, "You just checkmated your opponent!!", "🥳🥳",
                                JOptionPane.PLAIN_MESSAGE);

                        ResultPanel resultPanel = new ResultPanel(Main.RESULT_WIN,
                                "You just checkmated your opponent!");
                        this.setLayout(new java.awt.BorderLayout());
                        this.removeAll();
                        this.add(resultPanel);
                        this.revalidate();

                        timeoutFlag = true;
                    } else if ((int) o == Main.STALEMATE_CODE) {
                        out.writeObject(Main.GOT_STALEMATED_CODE);
                        stopMyTimer();
                        stopOpponentTimer();
                        JOptionPane.showMessageDialog(null, "Stalemate!!", "😬😬",
                                JOptionPane.PLAIN_MESSAGE);

                        ResultPanel resultPanel = new ResultPanel(Main.RESULT_TIE,
                                "A stalemate!");
                        this.setLayout(new java.awt.BorderLayout());
                        this.removeAll();
                        this.add(resultPanel);
                        this.revalidate();

                        timeoutFlag = true;
                    } else if ((int) o == Main.GOT_STALEMATED_CODE) {
                        stopMyTimer();
                        stopOpponentTimer();
                        JOptionPane.showMessageDialog(null, "Stalemate!!", "😬😬",
                                JOptionPane.PLAIN_MESSAGE);

                        ResultPanel resultPanel = new ResultPanel(Main.RESULT_TIE,
                                "A stalemate!");
                        this.setLayout(new java.awt.BorderLayout());
                        this.removeAll();
                        this.add(resultPanel);
                        this.revalidate();

                        timeoutFlag = true;
                    } else if ((int) o == Main.WON_BY_RESIGNED_CODE) {
                        out.writeObject(Main.RESIGNED_CODE);
                        stopMyTimer();
                        stopOpponentTimer();
                        JOptionPane.showMessageDialog(null, "Katang Resigned!!", "🤡🤡🤡",
                                JOptionPane.PLAIN_MESSAGE);

                        ResultPanel resultPanel = new ResultPanel(Main.RESULT_WIN,
                                "Opponent resigned");
                        this.setLayout(new java.awt.BorderLayout());
                        this.removeAll();
                        this.add(resultPanel);
                        this.revalidate();

                        timeoutFlag = true;
                    } else if ((int) o == Main.RESIGNED_CODE) {
                        stopMyTimer();
                        stopOpponentTimer();
                        JOptionPane.showMessageDialog(null, "You Resigned!!", "🤡🤡🤡",
                                JOptionPane.PLAIN_MESSAGE);

                        ResultPanel resultPanel = new ResultPanel(Main.RESULT_LOSE,
                                "You resigned");
                        this.setLayout(new java.awt.BorderLayout());
                        this.removeAll();
                        this.add(resultPanel);
                        this.revalidate();

                        timeoutFlag = true;
                    }
                    

                } else if (o instanceof String) {
                    message = (String) o;
                    chatPrintln(message);
                } else if (o instanceof int[]) {
                    int arr[] = (int[]) o;
                    Tile oldTile = boardPanel.getBoardData().board[arr[0]][arr[1]];
                    Tile newTile = boardPanel.getBoardData().board[arr[2]][arr[3]];
                    boardPanel.setEnable(true);
                    stopOpponentTimer();
                    startMyTimer();
                    boardPanel.updateOpponent(oldTile, newTile);
                } else if (o instanceof String[]) {
                    String timeOption[] = (String[]) o;
                    initTimer(timeOption[0]);
                    boardPanel.listenToEvent(boardPanel, out, myTimer, opponentTimer);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
            }
        } while (!message.equals("Client - END"));
    }

    public void startMyTimer() {
        myTimer.start();
    }

    public void stopMyTimer() {
        myTimer.stop();
    }

    public void startOpponentTimer() {
        opponentTimer.start();
    }

    public void stopOpponentTimer() {
        opponentTimer.stop();
    }

    private void initBoard(){
        boardPanel = new BoardPanel(false);
        leftPanel.setLayout(new java.awt.BorderLayout());
        leftPanel.removeAll();
        leftPanel.add(boardPanel);
        leftPanel.revalidate();
        boardPanel.setEnable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        opponentTime = new javax.swing.JLabel();
        myTime = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        drawButton = new javax.swing.JButton();
        resignButton = new javax.swing.JButton();

        jLabel1.setText("Chat");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane2.setViewportView(jTextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        opponentTime.setText("0");

        myTime.setText("0");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 295, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );

        drawButton.setText("Offer Draw");
        drawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawButtonActionPerformed(evt);
            }
        });

        resignButton.setText("Resign");
        resignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resignButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opponentTime)
                    .addComponent(myTime)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 544, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(drawButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(resignButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(77, 77, 77))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(opponentTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(drawButton)
                            .addComponent(resignButton))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(myTime)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void drawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_drawButtonActionPerformed

    private void resignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resignButtonActionPerformed
        // TODO add your handling code here:
        try {
            out.writeObject(Main.WON_BY_RESIGNED_CODE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_resignButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        try {
            if (socket == null) {
                System.out.println("should not reach here");
            } else {
                chatPrintln("Client: " + jTextField1.getText());
                out.writeObject("Client: " + jTextField1.getText());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        jTextField1.setText("");

    }// GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton drawButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel myTime;
    private javax.swing.JLabel opponentTime;
    private javax.swing.JButton resignButton;
    // End of variables declaration//GEN-END:variables
}
