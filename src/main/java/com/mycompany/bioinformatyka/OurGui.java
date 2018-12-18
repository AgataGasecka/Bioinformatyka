/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bioinformatyka;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import org.biojava.nbio.core.exceptions.CompoundNotFoundException;
import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.compound.AmbiguityDNACompoundSet;

/**
 *
 * @author Agata
 */
public class OurGui extends javax.swing.JFrame {

    /**
     * Creates new form OurGui
     */
    public OurGui() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        seq1Label = new javax.swing.JLabel();
        seq2Label = new javax.swing.JLabel();
        seq1Input = new javax.swing.JTextField();
        seq2Input = new javax.swing.JTextField();
        seq1Button = new javax.swing.JButton();
        seq2Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTextArea = new javax.swing.JTextArea();
        globalRadio = new javax.swing.JRadioButton();
        localRadio = new javax.swing.JRadioButton();
        gopLabel = new javax.swing.JLabel();
        gopInput = new javax.swing.JTextField();
        gepLabel = new javax.swing.JLabel();
        gepInput = new javax.swing.JTextField();
        cleanButton = new javax.swing.JButton();
        makeResultButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        seq1Label.setText("Sekwencja 1");

        seq2Label.setText("Sekwencja 2");

        seq1Button.setText("Wgraj plik");
        seq1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFile1(evt);
            }
        });

        seq2Button.setText("Wgraj plik");
        seq2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseFile2(evt);
            }
        });

        resultTextArea.setColumns(20);
        resultTextArea.setRows(5);
        jScrollPane1.setViewportView(resultTextArea);

        buttonGroup1.add(globalRadio);
        globalRadio.setText("GLOBALNIE");

        buttonGroup1.add(localRadio);
        localRadio.setText("LOKALNIE");

        gopLabel.setText("GOP");

        gepLabel.setText("GEP");

        cleanButton.setText("Wyczyść");
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButtonActionPerformed(evt);
            }
        });

        makeResultButton.setText("Wykonaj");
        makeResultButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeResultButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(seq2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(seq1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(seq2Input, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(seq1Input))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(seq1Button)
                                    .addComponent(seq2Button)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(globalRadio)
                                .addGap(36, 36, 36)
                                .addComponent(localRadio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(gopLabel)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(gepLabel)
                                        .addGap(20, 20, 20)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(gepInput, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                                    .addComponent(gopInput)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(cleanButton)
                        .addGap(91, 91, 91)
                        .addComponent(makeResultButton)))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seq1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seq1Input, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seq1Button))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seq2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seq2Input, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seq2Button))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(globalRadio)
                    .addComponent(localRadio))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gopLabel)
                    .addComponent(gopInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gepLabel)
                    .addComponent(gepInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cleanButton)
                    .addComponent(makeResultButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChooseFile2(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFile2
        int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
          seq2Input.read( new FileReader( file.getAbsolutePath() ), null );
        } catch (IOException ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
    } else {
        System.out.println("File access cancelled by user.");
    }
    }//GEN-LAST:event_ChooseFile2

    private void ChooseFile1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseFile1
          int returnVal = fileChooser.showOpenDialog(this);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
        File file = fileChooser.getSelectedFile();
        try {
          seq1Input.read( new FileReader( file.getAbsolutePath() ), null );
        } catch (IOException ex) {
          System.out.println("problem accessing file"+file.getAbsolutePath());
        }
    } else {
        System.out.println("File access cancelled by user.");
    }
    }//GEN-LAST:event_ChooseFile1

    private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButtonActionPerformed
        seq1Input.setText("");
        seq2Input.setText("");
        gopInput.setText("");
        gepInput.setText("");
        resultTextArea.setText("");
        
    }//GEN-LAST:event_cleanButtonActionPerformed

    private void makeResultButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeResultButtonActionPerformed
        resultTextArea.setText("");
        BioBackend bioObject = new BioBackend();
        
        bioObject.gep = Integer.parseInt(gepInput.getText());
        bioObject.gop = Integer.parseInt(gopInput.getText());
        if(globalRadio.isSelected()){
        bioObject.type = bioObject.type.GLOBAL;
        }
        else if(localRadio.isSelected()){
            bioObject.type = bioObject.type.LOCAL;
        }
        
        if(seq1Input.getText().contains(">") || seq2Input.getText().contains(">")){
            try {
                bioObject.uniProtId1 = seq1Input.getText(1,6);
                bioObject.uniProtId2 = seq2Input.getText(1,6);
                bioObject.seq1 = bioObject.getFastaSequenceFromId(bioObject.uniProtId1);
                bioObject.seq2 = bioObject.getFastaSequenceFromId(bioObject.uniProtId2);
                String[] resultsToShow = bioObject.makeResultForProtein();
                resultTextArea.append(resultsToShow[0] + "\n" + resultsToShow[1] + "\n" + resultsToShow[2]);
            } catch (BadLocationException ex) {
                Logger.getLogger(OurGui.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(OurGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            
            try {
                bioObject.dna1 = seq1Input.getText();
                bioObject.dna2 = seq2Input.getText();
               String[] resultsToShow = bioObject.makeResultForDNA();
               resultTextArea.append(resultsToShow[0] + "\n" + resultsToShow[1] + "\n" + resultsToShow[2]);
            } catch (CompoundNotFoundException ex) {
                Logger.getLogger(OurGui.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
       
        
    }//GEN-LAST:event_makeResultButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OurGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OurGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OurGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OurGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OurGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cleanButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextField gepInput;
    private javax.swing.JLabel gepLabel;
    private javax.swing.JRadioButton globalRadio;
    private javax.swing.JTextField gopInput;
    private javax.swing.JLabel gopLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton localRadio;
    private javax.swing.JButton makeResultButton;
    private javax.swing.JTextArea resultTextArea;
    private javax.swing.JButton seq1Button;
    private javax.swing.JTextField seq1Input;
    private javax.swing.JLabel seq1Label;
    private javax.swing.JButton seq2Button;
    private javax.swing.JTextField seq2Input;
    private javax.swing.JLabel seq2Label;
    // End of variables declaration//GEN-END:variables
}
