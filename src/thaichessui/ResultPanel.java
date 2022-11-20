/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thaichessui;

/**
 *
 * @author butus
 */
public class ResultPanel extends javax.swing.JPanel {
        private String res;
        private String msg;
        /**
         * Creates new form MenuPanel
         */
        public ResultPanel(String res, String msg) {
                this.res = res;
                this.msg = msg;
                initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HostButton = new javax.swing.JButton();
        JoinButton = new javax.swing.JButton();
        QuitButton = new javax.swing.JButton();
        AboutButton = new javax.swing.JButton();
        NameField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        result = new javax.swing.JLabel();
        message = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245, 245, 252));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        HostButton.setFont(new java.awt.Font("Silom", 0, 18)); // NOI18N
        HostButton.setForeground(new java.awt.Color(255, 153, 51));
        HostButton.setText("Host");
        HostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HostButtonActionPerformed(evt);
            }
        });

        JoinButton.setFont(new java.awt.Font("Silom", 0, 18)); // NOI18N
        JoinButton.setForeground(new java.awt.Color(255, 153, 51));
        JoinButton.setText("Join");
        JoinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoinButtonActionPerformed(evt);
            }
        });

        QuitButton.setFont(new java.awt.Font("Silom", 0, 18)); // NOI18N
        QuitButton.setForeground(new java.awt.Color(255, 0, 0));
        QuitButton.setText("Quit");
        QuitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButtonActionPerformed(evt);
            }
        });

        AboutButton.setFont(new java.awt.Font("Silom", 0, 18)); // NOI18N
        AboutButton.setForeground(new java.awt.Color(255, 153, 51));
        AboutButton.setText("About");
        AboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutButtonActionPerformed(evt);
            }
        });

        NameField.setText("Name");
        NameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameFieldActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        jLabel2.setFont(new java.awt.Font("PT Sans", 3, 30)); // NOI18N
        jLabel2.setText("Makruk Thai");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thaichessui/images/bigwhiteknight.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HostButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(JoinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AboutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(QuitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(245, 245, 252));

        result.setFont(new java.awt.Font("Silom", 0, 48)); // NOI18N
        result.setForeground(new java.awt.Color(255, 153, 51));
        result.setText(res);

        message.setFont(new java.awt.Font("Silom", 0, 20)); // NOI18N
        message.setForeground(new java.awt.Color(51, 51, 51));
        message.setText(msg);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(result)
                .addGap(43, 43, 43)
                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

        private void AboutButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_AboutButtonActionPerformed
                AboutPanel aboutpanel = new AboutPanel();
                this.setLayout(new java.awt.BorderLayout());
                this.removeAll();
                this.add(aboutpanel);
                this.revalidate();
                // TODO CHANGE THIS -> USED FOR DEBUGGING BOARD
        }// GEN-LAST:event_AboutButtonActionPerformed

        private void HostButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_HostButtonActionPerformed
                HostPanel hostPanel = new HostPanel();
                this.setLayout(new java.awt.BorderLayout());
                this.removeAll();
                this.add(hostPanel);
                this.revalidate();
                // TODO Open host page
        }// GEN-LAST:event_HostButtonActionPerformed

        private void NameFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_NameFieldActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_NameFieldActionPerformed

        private void JoinButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_JoinButtonActionPerformed
                GamePanelClient b = new GamePanelClient();
                this.setLayout(new java.awt.BorderLayout());
                this.removeAll();
                this.add(b);
                this.revalidate();

                Thread clientThread = new Thread(new Runnable() {
                        public void run() {
                                b.run("127.0.0.1", 3000);
                        }
                });

                clientThread.start();
                // TODO Open Join Page
        }// GEN-LAST:event_JoinButtonActionPerformed

        private void QuitButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_QuitButtonActionPerformed
                System.exit(0);

        }// GEN-LAST:event_QuitButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AboutButton;
    private javax.swing.JButton HostButton;
    private javax.swing.JButton JoinButton;
    private javax.swing.JTextField NameField;
    private javax.swing.JButton QuitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel message;
    private javax.swing.JLabel result;
    // End of variables declaration//GEN-END:variables
}
