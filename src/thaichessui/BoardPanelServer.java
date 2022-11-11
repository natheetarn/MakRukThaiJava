/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package thaichessui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 *
 * @author kaikaew
 */
public class BoardPanelServer extends javax.swing.JPanel {
    public static Socket socket = null;
    public static ServerSocket server = null;
    public static ObjectInputStream in = null;
    public static ObjectOutputStream out = null;

    /**
     * Creates new form BoardPanel
     */
    public BoardPanelServer() {
        initComponents();

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

            chatPrintln("GLHF!!!");

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
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
                    }
                } else if (o instanceof String) {
                    message = (String) o;
                    chatPrintln(message);
                }
            } catch (ClassNotFoundException ex) {
            }
        } while (!message.equals("Client: END"));
    }

    public void writeToChat(String str) throws IOException {
        jTextArea1.append("Server: " + str + "\n");
        out.writeObject("Server: " + str);
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        jLabel1.setText("Chat");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);
        jTextArea1.setEditable(false);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(94, 94, 94))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 549, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(47, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

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
    // End of variables declaration//GEN-END:variables
}
