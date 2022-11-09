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

        TimeComboBox = new javax.swing.JComboBox<>();
        TimeLabel = new javax.swing.JLabel();
        PlayAsLabel = new javax.swing.JLabel();
        WhiteRadioButton = new javax.swing.JRadioButton();
        BlackRadioButton = new javax.swing.JRadioButton();
        StartButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(800, 600));

        TimeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(
                new String[] { "1 min", "3 min", "5 min", "10 min", "30 min", "1 hr", "2 hr", " " }));
        TimeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeComboBoxActionPerformed(evt);
            }
        });

        TimeLabel.setText("Time");

        PlayAsLabel.setText("Play as");

        WhiteRadioButton.setText("White");

        BlackRadioButton.setText("Black");

        StartButton.setText("Start");
        StartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(PlayAsLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(137, 137, 137)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(TimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(WhiteRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        277, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BlackRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(262, 262, 262))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(293, 293, 293)
                                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(TimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 87,
                                                Short.MAX_VALUE)
                                        .addComponent(TimeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PlayAsLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(WhiteRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(BlackRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(136, 136, 136)
                                .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131)));
    }// </editor-fold>//GEN-END:initComponents

    private void TimeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_TimeComboBoxActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_TimeComboBoxActionPerformed

    private void StartButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_StartButtonActionPerformed
        // TODO add your handling code here:

        // BoardPanel b = new BoardPanel();
        // this.setLayout(new java.awt.BorderLayout());
        // this.removeAll();
        // this.add(b);
        // this.revalidate();

        HostPanel hostPanel = this;
        BoardPanel b = new BoardPanel();
        hostPanel.setLayout(new java.awt.BorderLayout());
        hostPanel.removeAll();
        hostPanel.add(b);
        hostPanel.revalidate();

        Thread serverThread = new Thread(new Runnable() {

            public void run() {

                Server server = new Server(3000);
            }
        });

        serverThread.start();

    }// GEN-LAST:event_StartButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BlackRadioButton;
    private javax.swing.JLabel PlayAsLabel;
    private javax.swing.JButton StartButton;
    private javax.swing.JComboBox<String> TimeComboBox;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JRadioButton WhiteRadioButton;
    // End of variables declaration//GEN-END:variables
}
