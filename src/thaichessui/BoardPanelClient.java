/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package thaichessui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

/**
 *
 * @author kaikaew
 */
public class BoardPanelClient extends javax.swing.JPanel {

    private Socket socket = null;
    private ObjectInputStream in = null;
    private ObjectOutputStream out = null;

    /**
     * Creates new form BoardPanel
     */
    public BoardPanelClient() {
        initComponents();
    }

    public void run(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        } catch (UnknownHostException u) {
            System.out.println(u);
        } catch (IOException i) {
            JOptionPane.showMessageDialog(null, "There is no host right now!", "Sad", JOptionPane.WARNING_MESSAGE);

            HostPanel hostPanel = new HostPanel();

            this.setLayout(new java.awt.BorderLayout());
            this.removeAll();
            this.add(hostPanel);
            this.revalidate();
            return;
        }

        try {
            whileChatting();
        } catch (IOException i) {
            System.out.println(i);
        }

        try {
            in.close();
            out.close();
            socket.close();
            socket = null;
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public void whileChatting() throws IOException {
        String message = "";
        do {
            try {
                message = (String) in.readObject();
                jTextArea1.append(message + "\n");
            } catch (ClassNotFoundException classNotFoundException) {
            }
        } while (!message.equals("Client - END"));
    }

    public void writeToChat(String str) throws IOException {
        jTextArea1.append("Client: " + str + "\n");
        out.writeObject("Client: " + str);
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
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

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
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(257, 257, 257)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(101, 101, 101)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jScrollPane2,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 391,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jTextField1))))
                                .addContainerGap(246, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
        try {
            if (socket == null) {
                jTextArea1.append("Host has disconnected!\n");
            } else {
                writeToChat(jTextField1.getText());
            }
        } catch (IOException i) {
            System.out.println(i);
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
