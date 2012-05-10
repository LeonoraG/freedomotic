/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CustomizeEvent.java
 *
 * Created on 4-set-2010, 9.57.19
 */
package it.freedomotic.plugins.gui;

import it.freedomotic.app.Freedomotic;
import it.freedomotic.reactions.Payload;
import it.freedomotic.persistence.TriggerPersistence;
import it.freedomotic.reactions.Statement;
import it.freedomotic.reactions.Trigger;
import it.freedomotic.util.PropertiesPanel;
import it.freedomotic.util.PropertiesPanel_1;
import java.util.Iterator;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author enrico
 */
public class CustomizeTrigger extends javax.swing.JFrame {

    ReactionList main;
    Trigger original;
    PropertiesPanel_1 panel;

    /**
     * Creates new form CustomizeEvent
     */
    public CustomizeTrigger(ReactionList main, Trigger t) {
        initComponents();
        this.main = main;
        original = t;
        this.setTitle(t.getName() + " Trigger Editor");
        txtName.setText(t.getName());
        txtDescription.setText(t.getDescription());
        lblExplanation.setText("Fire this trigger if parameters are:");

        if (t.isHardwareLevel() || !t.isToPersist()) {
            btnEdit.setEnabled(false);
        }
        lblTemplateWarning.setVisible(!t.isToPersist());

        panel = new PropertiesPanel_1(t.getPayload().size(), 4);
        pnlParam.add(panel);
        Iterator it = t.getPayload().iterator();
        int row = 0;
        while (it.hasNext()) {
            Statement statement = (Statement) it.next();
            panel.addElement(new JTextField(statement.getLogical()), row, 0);
            panel.addElement(new JTextField(statement.getAttribute()), row, 1);
            panel.addElement(new JTextField(statement.getOperand()), row, 2);
            panel.addElement(new JTextField(statement.getValue()), row, 3);
            row++;
        }
        panel.layoutPanel();
    }

    private void addEmptyRow() {
        int rows = panel.addRow();
        panel.addElement(new JTextField(""), rows, 0);
        panel.addElement(new JTextField(""), rows, 1);
        panel.addElement(new JTextField(""), rows, 2);
        panel.addElement(new JTextField(""), rows, 3);
        panel.layoutPanel();
        this.validate();
    }

    private void save(Trigger t) {
        synchronized (t) {
            Payload payload = new Payload();
            for (int row = 0; row < panel.getRows(); row++) {
//                for (int col = 0; col < panel.getColumns(); col++) {

                    String logical = panel.getComponent(row, 0);
                    String attribute = panel.getComponent(row, 1);
                    String operand = panel.getComponent(row, 2);
                    String value = panel.getComponent(row, 3);
                    payload.addStatement(
                            logical,
                            attribute,
                            operand,
                            value);
//                }
            }
            t.setName(txtName.getText());
            t.setDescription(txtDescription.getName());
            t.setChannel(original.getChannel());
            t.setDescription(txtDescription.getText());
            t.setPersistence(true);
            t.setPayload(payload);
            System.out.println(t.getPayload().toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        lblExplanation = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlParam = new javax.swing.JPanel();
        btnAddRow = new javax.swing.JButton();
        lblTemplateWarning = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSave.setText("Save as New Trigger");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Description:");

        lblExplanation.setText("Fire the event if this parameters are consistent with the received event:");

        btnEdit.setText("Save Changes");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete Trigger");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlParam.setLayout(new java.awt.BorderLayout());
        jScrollPane1.setViewportView(pnlParam);

        btnAddRow.setText("Add Statement");
        btnAddRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddRowActionPerformed(evt);
            }
        });

        lblTemplateWarning.setText("This trigger is a template so you cannot change it. Save it as new trigger.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDescription)
                                    .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblExplanation)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddRow)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTemplateWarning, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExplanation)
                    .addComponent(btnAddRow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTemplateWarning)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnSave)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Trigger t = new Trigger();
        save(t); //saves as new trigger
        int preSize = TriggerPersistence.size();
        TriggerPersistence.addAndRegister(t);
        int postSize = TriggerPersistence.size();
        if (preSize < postSize) {
            System.out.println("Trigger addedd correctly [" + postSize + " triggers]");
        } else {
            System.err.println("Error while addind a trigger in trigger editor");
        }
        main.setTargetTrigger(t);
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        save(original); //save changes over original trigger
        main.setTargetTrigger(original);
        this.dispose();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        System.out.println("Trying to remove a trigger from the list");
        TriggerPersistence.remove(original);
        main.updateData();
        this.dispose();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddRowActionPerformed
        addEmptyRow();
    }//GEN-LAST:event_btnAddRowActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddRow;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblExplanation;
    private javax.swing.JLabel lblTemplateWarning;
    private javax.swing.JPanel pnlParam;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private int getOperatorIndex(String operand) {
        if (operand.equalsIgnoreCase("EQUALS")) {
            return 0;
        }
        if (operand.equalsIgnoreCase("GREATER_THEN")) {
            return 1;
        }
        if (operand.equalsIgnoreCase("LESS_THEN")) {
            return 2;
        }
        if (operand.equalsIgnoreCase("REGEX")) {
            return 3;
        }
        return -1;
    }

    private String getOperatorName(int index) {
        if (index == 0) {
            return "EQUALS";
        }
        if (index == 1) {
            return "GREATER_THEN";

        }
        if (index == 2) {
            return "LESS_THEN";

        }
        if (index == 3) {
            return "REGEX";
        }
        return "";
    }
}
