/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package thaichessui;

/**
 *
 * @author ROG Zephyrus M
 */
public class HostPanel extends javax.swing.JPanel {

    /**
     * Creates new form HostPanel
     */
    public HostPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        TimeComboBox = new javax.swing.JComboBox<>();
        TimeLabel = new javax.swing.JLabel();
        PlayAsLabel = new javax.swing.JLabel();
        WhiteRadioButton = new javax.swing.JRadioButton();
        BlackRadioButton = new javax.swing.JRadioButton();
        StartButton = new javax.swing.JButton();
        TimeLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(242, 252, 242));
        setPreferredSize(new java.awt.Dimension(800, 600));

        TimeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "1 min", "3 min", "5 min", "10 min", "30 min", "1 hr", "2 hr", "Unlimited" }));
        TimeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeComboBoxActionPerformed(evt);
            }
        });

        TimeLabel.setForeground(new java.awt.Color(255, 153, 0));
        TimeLabel.setText("Time");

        PlayAsLabel.setForeground(new java.awt.Color(255, 153, 0));
        PlayAsLabel.setText("Play as");

        buttonGroup1.add(WhiteRadioButton);
        WhiteRadioButton.setText("White");
        WhiteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WhiteRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(BlackRadioButton);
        BlackRadioButton.setText("Black");
        BlackRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlackRadioButtonActionPerformed(evt);
            }
        });

        StartButton.setFont(new java.awt.Font("Silom", 0, 18)); // NOI18N
        StartButton.setForeground(new java.awt.Color(0, 153, 153));
        StartButton.setText("START ♖");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        TimeLabel1.setFont(new java.awt.Font("Silom", 0, 36)); // NOI18N
        TimeLabel1.setForeground(new java.awt.Color(255, 204, 51));
        TimeLabel1.setText("Configuration");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 261,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(203, 203, 203))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(StartButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 212,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(PlayAsLabel,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(98, 98, 98)
                                                                .addComponent(WhiteRadioButton,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(BlackRadioButton,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                                .addGap(238, 238, 238))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TimeLabel1)
                                .addGap(223, 223, 223)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(TimeLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 87,
                                                Short.MAX_VALUE)
                                        .addComponent(TimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(WhiteRadioButton)
                                        .addComponent(BlackRadioButton)
                                        .addComponent(PlayAsLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)));
    }// </editor-fold>//GEN-END:initComponents

    private void TimeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TimeComboBoxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TimeComboBoxActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_StartButtonActionPerformed
        // TODO add your handling code here:

        BoardPanel b = new BoardPanel();
        // BoardPanelServer b = new BoardPanelServer();
        this.setLayout(new java.awt.BorderLayout());
        this.removeAll();
        this.add(b);
        this.revalidate();

        // Thread serverThread = new Thread(new Runnable() {
        // public void run() {
        // b.run(3000);
        // }
        // });

        // serverThread.start();

    }// GEN-LAST:event_StartButtonActionPerformed

    private void BlackRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_BlackRadioButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_BlackRadioButtonActionPerformed

    private void WhiteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_WhiteRadioButtonActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_WhiteRadioButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BlackRadioButton;
    private javax.swing.JLabel PlayAsLabel;
    private javax.swing.JButton StartButton;
    private javax.swing.JComboBox<String> TimeComboBox;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JLabel TimeLabel1;
    private javax.swing.JRadioButton WhiteRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
