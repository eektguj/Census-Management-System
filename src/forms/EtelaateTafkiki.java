/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.File;
import javax.swing.JOptionPane;
import model.Country;
import model.ModelMgr;
import model.PredictPopulation;

/**
 *
 * @author amir
 */
public class EtelaateTafkiki extends javax.swing.JPanel {

    /**
     * Creates new form EtelaateTafkiki
     */
    public EtelaateTafkiki() {
        initComponents();
        ModelMgr.getInstance().etelaateTafkiki = this;
        init();
    }
    
    private void init(){
        disableEditArea();
        disableEditButton();
        disableEditCountryArea();
        disableEditCountryButton();
        combo_information_country.setModel(ModelMgr.getInstance().getCuntriesComboModel());        
        combo_information_year.setModel(ModelMgr.getInstance().getYearsComboModelForPupulation());
        combo_information_year.setSelectedIndex(-1);
        combo_information_country.setSelectedIndex(-1);
        lbl_information_men.setText("");
        lbl_information_women.setText("");
        lbl_information_all.setText("");
        try{
        ModelMgr.getInstance().exportData.init();
        ModelMgr.getInstance().countriesTable.init();
        }
        catch(Exception e){
            
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

        combo_information_country = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_information_year = new javax.swing.JComboBox();
        pane_information_edit = new javax.swing.JPanel();
        lbl_edit_men = new javax.swing.JLabel();
        lbl_edit_women = new javax.swing.JLabel();
        txt_information_men = new javax.swing.JTextField();
        txt_information_women = new javax.swing.JTextField();
        button_edit_done = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbl_information_men = new javax.swing.JLabel();
        lbl_information_women = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_information_all = new javax.swing.JLabel();
        button_information_startEditCountry = new javax.swing.JButton();
        panel_editCountry = new javax.swing.JPanel();
        txt_editCountry = new javax.swing.JTextField();
        lbl_editcountry = new javax.swing.JLabel();
        button_editCountry_done = new javax.swing.JButton();
        button_information_startEdit = new javax.swing.JButton();

        combo_information_country.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        combo_information_country.setName("combo_country"); // NOI18N
        combo_information_country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_information_countryActionPerformed(evt);
            }
        });
        combo_information_country.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                combo_information_countryVetoableChange(evt);
            }
        });

        jLabel1.setText("Country:");

        jLabel2.setText("Year:");

        combo_information_year.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        combo_information_year.setName("combo_year"); // NOI18N
        combo_information_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_information_yearActionPerformed(evt);
            }
        });
        combo_information_year.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                combo_information_yearVetoableChange(evt);
            }
        });

        pane_information_edit.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Population"));
        pane_information_edit.setToolTipText("Edit");
        pane_information_edit.setName("panel_edit"); // NOI18N

        lbl_edit_men.setText("Men:");

        lbl_edit_women.setText("Women:");

        button_edit_done.setText("Done");
        button_edit_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_edit_doneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pane_information_editLayout = new javax.swing.GroupLayout(pane_information_edit);
        pane_information_edit.setLayout(pane_information_editLayout);
        pane_information_editLayout.setHorizontalGroup(
            pane_information_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_information_editLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_information_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_edit_men)
                    .addGroup(pane_information_editLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txt_information_men, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_edit_women)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_information_women, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pane_information_editLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(button_edit_done, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pane_information_editLayout.setVerticalGroup(
            pane_information_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_information_editLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_information_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pane_information_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_information_women, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_edit_women, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pane_information_editLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_edit_men)
                        .addComponent(txt_information_men, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pane_information_editLayout.createSequentialGroup()
                        .addGap(0, 38, Short.MAX_VALUE)
                        .addComponent(button_edit_done))))
        );

        jLabel3.setText("Men:");

        lbl_information_men.setText("                                   ");
        lbl_information_men.setName("label_menPopulation"); // NOI18N

        lbl_information_women.setText("                                   ");
        lbl_information_women.setName("label_womenPopulation"); // NOI18N

        jLabel6.setText("Women:");

        jLabel7.setText("All:");

        lbl_information_all.setText("                                   ");
        lbl_information_all.setName("label_allPopulation"); // NOI18N

        button_information_startEditCountry.setText("Edit Country");
        button_information_startEditCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_information_startEditCountryActionPerformed(evt);
            }
        });

        panel_editCountry.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Country"));

        lbl_editcountry.setText("Country:");

        button_editCountry_done.setText("Done");
        button_editCountry_done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editCountry_doneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_editCountryLayout = new javax.swing.GroupLayout(panel_editCountry);
        panel_editCountry.setLayout(panel_editCountryLayout);
        panel_editCountryLayout.setHorizontalGroup(
            panel_editCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_editCountryLayout.createSequentialGroup()
                .addGroup(panel_editCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_editCountryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_editcountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_editCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_editCountryLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(button_editCountry_done, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_editCountryLayout.setVerticalGroup(
            panel_editCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_editCountryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel_editCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_editcountry)
                    .addComponent(txt_editCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(button_editCountry_done)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button_information_startEdit.setText("Edit Population");
        button_information_startEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_information_startEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_information_all, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_information_startEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_information_country, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_information_men, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(120, 120, 120)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(combo_information_year, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbl_information_women, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(button_information_startEditCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_editCountry, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pane_information_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_information_country, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(combo_information_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(lbl_information_men)
                    .addComponent(lbl_information_women))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lbl_information_all)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_information_startEditCountry)
                            .addComponent(button_information_startEdit))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pane_information_edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel_editCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pane_information_edit.getAccessibleContext().setAccessibleName("panel_edit");
    }// </editor-fold>//GEN-END:initComponents

    private void combo_information_yearVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_combo_information_yearVetoableChange
        // TODO add your handling code here:
        ChangeViewData();
    }//GEN-LAST:event_combo_information_yearVetoableChange

    private void combo_information_countryVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_combo_information_countryVetoableChange
        // TODO add your handling code here:
        ChangeViewData();
    }//GEN-LAST:event_combo_information_countryVetoableChange

    private void combo_information_countryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_information_countryActionPerformed
        // TODO add your handling code here:
        ChangeViewData();
    }//GEN-LAST:event_combo_information_countryActionPerformed

    private void combo_information_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_information_yearActionPerformed
        // TODO add your handling code here:
        ChangeViewData();
    }//GEN-LAST:event_combo_information_yearActionPerformed

    private void button_information_startEditCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_information_startEditCountryActionPerformed
        // TODO add your handling code here:
        if(combo_information_country.getSelectedIndex() == -1)
            return;
        enableEditCountryArea();
    }//GEN-LAST:event_button_information_startEditCountryActionPerformed

    private void button_edit_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_edit_doneActionPerformed
        // TODO add your handling code here:
        Country country = ModelMgr.getInstance().getCountry(combo_information_country.getSelectedItem().toString());
        String yy = combo_information_year.getSelectedItem().toString();
        int year = Integer.parseInt(yy);
        PredictPopulation menPopulation = country.getPredictByYear(ModelMgr.ESTIMATES, year, 0);
        PredictPopulation womenPopulation = country.getPredictByYear(ModelMgr.ESTIMATES, year, 1);
        menPopulation.populationNumber = Integer.parseInt(txt_information_men.getText());
        womenPopulation.populationNumber = Integer.parseInt(txt_information_women.getText());
        ModelMgr.getInstance().saveDataFile();
        init();
        ChangeViewData();
    }//GEN-LAST:event_button_edit_doneActionPerformed

    private void button_editCountry_doneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editCountry_doneActionPerformed
        // TODO add your handling code here:
        Country country = ModelMgr.getInstance().getCountry(combo_information_country.getSelectedItem().toString());
        country.countryName = txt_editCountry.getText();
        ModelMgr.getInstance().saveDataFile();
        init();
        ChangeViewData();
    }//GEN-LAST:event_button_editCountry_doneActionPerformed

    private void button_information_startEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_information_startEditActionPerformed
        // TODO add your handling code here:
        if(combo_information_country.getSelectedIndex() == -1 || combo_information_year.getSelectedIndex() == -1)
            return;
        enableEditArea();
    }//GEN-LAST:event_button_information_startEditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_editCountry_done;
    private javax.swing.JButton button_edit_done;
    private javax.swing.JButton button_information_startEdit;
    private javax.swing.JButton button_information_startEditCountry;
    private javax.swing.JComboBox combo_information_country;
    private javax.swing.JComboBox combo_information_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbl_edit_men;
    private javax.swing.JLabel lbl_edit_women;
    private javax.swing.JLabel lbl_editcountry;
    private javax.swing.JLabel lbl_information_all;
    private javax.swing.JLabel lbl_information_men;
    private javax.swing.JLabel lbl_information_women;
    private javax.swing.JPanel pane_information_edit;
    private javax.swing.JPanel panel_editCountry;
    private javax.swing.JTextField txt_editCountry;
    private javax.swing.JTextField txt_information_men;
    private javax.swing.JTextField txt_information_women;
    // End of variables declaration//GEN-END:variables

    private void ChangeViewData() {
        disableEditArea();
        disableEditButton();
        disableEditCountryButton();
        disableEditCountryArea();
        
        if(combo_information_country.getSelectedIndex() != -1){
            enableEditCountryButton();
            Country country = ModelMgr.getInstance().getCountry(combo_information_country.getSelectedItem().toString());
            if(combo_information_year.getSelectedIndex() != -1){
                enableEditButton();
                String yy = combo_information_year.getSelectedItem().toString();
                int year = Integer.parseInt(yy);
                PredictPopulation menPopulation = country.getPredictByYear(ModelMgr.ESTIMATES, year, 0);
                PredictPopulation womenPopulation = country.getPredictByYear(ModelMgr.ESTIMATES, year, 1);
                lbl_information_men.setText(menPopulation.populationNumber + "");
                lbl_information_women.setText(womenPopulation.populationNumber + "");
                lbl_information_all.setText((menPopulation.populationNumber + womenPopulation.populationNumber) + "");
            }
            return;
        }
    }
    
    private void disableEditArea(){
        lbl_edit_men.setEnabled(false);
        lbl_edit_women.setEnabled(false);
        txt_information_men.setEnabled(false);
        txt_information_women.setEnabled(false);
        
        pane_information_edit.setEnabled(false);
        button_edit_done.setEnabled(false);
        txt_information_women.setText("");
        txt_information_men.setText("");
        
    }
    
    private void disableEditCountryArea(){
        lbl_editcountry.setEnabled(false);
        txt_editCountry.setEditable(false);
        txt_editCountry.setText("");
        panel_editCountry.setEnabled(false);
    }
    
    private void enableEditCountryArea(){
        lbl_editcountry.setEnabled(true);
        txt_editCountry.setEditable(true);
        txt_editCountry.setText(combo_information_country.getSelectedItem().toString());
        panel_editCountry.setEnabled(true);
    }
    
    private void enableEditArea(){
        lbl_edit_men.setEnabled(true);
        lbl_edit_women.setEnabled(true);
        txt_information_men.setEnabled(true);
        txt_information_women.setEnabled(true);
        pane_information_edit.setEnabled(true);
        button_edit_done.setEnabled(true);
        txt_information_women.setText(lbl_information_women.getText());
        txt_information_men.setText(lbl_information_men.getText());
    }
    
    private void disableEditButton(){
        button_information_startEdit.setEnabled(false);
    }
    
    private void enableEditButton(){
        button_information_startEdit.setEnabled(true);
    }
    
    private void disableEditCountryButton(){
        button_information_startEditCountry.setEnabled(false);
    }
    
    private void enableEditCountryButton(){
        button_information_startEditCountry.setEnabled(true);
    }
}
