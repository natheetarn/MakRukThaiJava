/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package thaichessui;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author kaikaew
 */
public class GamePanelServer extends javax.swing.JPanel {
    private static Socket socket = null;
    private static ServerSocket server = null;
    private static ObjectInputStream in = null;
    private static ObjectOutputStream out = null;

    private int myCurTime = 0;
    private int opponentCurTime = 0;
    private Timer myTimer = null;
    private Timer opponentTimer = null;

    BoardPanel boardPanel = null;

    /**
     * Creates new form BoardPanel
     */
    public GamePanelServer() {
        initComponents();
        initTimer();
    }

    public void initTimer() {
        myTimer = new Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                myTime.setText(String.valueOf(myCurTime));
                myCurTime++;
            }
        });

        opponentTimer = new Timer(1000, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                opponentTime.setText(String.valueOf(opponentCurTime));
                opponentCurTime++;
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
                server.close();
            }

            socket = null;
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public void chatPrintln(String str) {
        jTextArea1.append(str + "\n");
    }

    public void run(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("server started");

            System.out.println("Waiting for a client ...");
            chatPrintln("Waiting for a client...");

            socket = server.accept();
            System.out.println("Client accepted");
            chatPrintln("Client connected!");
            myButton.setEnabled(true);
            boardPanel.setEnable(true);

            startMyTimer();

            chatPrintln("GLHF!!!");

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            boardPanel.listenToEvent(boardPanel, out, myTimer, opponentTimer);
            whileChatting();

            System.out.println("closing connection");

            socket.close();
            in.close();
            out.close();
            server.close();

            JOptionPane.showMessageDialog(null, "Oops! Your opponent disconnected, guess its your win!", "🗿",
                    JOptionPane.PLAIN_MESSAGE);
            MenuPanel menuPanel = new MenuPanel();

            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(menuPanel);
            this.revalidate();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void whileChatting() throws IOException {
        String message = "";
        do {
            try {
                Object o = in.readObject();
                if (o instanceof Integer) {
                    if ((int) o == Main.FORCE_EXIT_CODE) {
                        return;
                    } else if ((int) o == Main.YOUR_TURN_CODE) {
                        myButton.setEnabled(true);
                        boardPanel.setEnable(true);
                        stopOpponentTimer();
                        startMyTimer();
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
                }
            } catch (ClassNotFoundException ex) {
            }
        } while (!message.equals("Client: END"));
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        opponentTime = new javax.swing.JLabel();
        myTime = new javax.swing.JLabel();
        myButton = new javax.swing.JButton();
        leftPanel = new javax.swing.JPanel();

        jLabel1.setText("Chat");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        opponentTime.setText("0");

        myTime.setText("0");

        myButton.setText("press");
        myButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButtonActionPerformed(evt);
            }
        });
        myButton.setEnabled(false);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 295, Short.MAX_VALUE));
        leftPanelLayout.setVerticalGroup(
                leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 263, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(myButton)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(22, 22, 22)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(opponentTime)
                                                                        .addComponent(myTime)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(leftPanel,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        192, Short.MAX_VALUE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addGap(77, 77, 77))
                                                        .addComponent(jScrollPane2,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(17, 17, 17)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(opponentTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(myTime)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(myButton))
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(24, Short.MAX_VALUE)));

        boardPanel = new BoardPanel(true);
        leftPanel.setLayout(new java.awt.BorderLayout());
        leftPanel.removeAll();
        leftPanel.add(boardPanel);
        leftPanel.revalidate();
        boardPanel.setEnable(false);
    }// </editor-fold>//GEN-END:initComponents

    private void myButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_myButtonActionPerformed
        // TODO add your handling code here:
        myButton.setEnabled(false);
        stopMyTimer();
        startOpponentTimer();

        try {
            out.writeObject(Main.YOUR_TURN_CODE);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }// GEN-LAST:event_myButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        try {
            if (socket == null) {
                chatPrintln("Client has not joined yet!");
            } else {
                chatPrintln("Server: " + jTextField1.getText());
                out.writeObject("Server: " + jTextField1.getText());
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

        jTextField1.setText("");

    }// GEN-LAST:event_jTextField1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JButton myButton;
    private javax.swing.JLabel myTime;
    private javax.swing.JLabel opponentTime;
    // End of variables declaration//GEN-END:variables
}
