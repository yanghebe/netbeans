/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.apisupport.project.ui.customizer;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.apisupport.project.api.UIUtil;
import org.netbeans.modules.apisupport.project.spi.BrandingModel;
import org.netbeans.spi.project.ui.support.ProjectCustomizer;
import static org.netbeans.modules.apisupport.project.ui.customizer.Bundle.*;
import org.openide.util.NbBundle.Messages;

/**
 * Represents <em>Application</em> panel in Suite customizer.
 *
 * @author Radek Matous
 */
final class SuiteCustomizerBasicBranding extends NbPropertyPanel.Suite  {
    
    private BasicCustomizer.SubCategoryProvider prov;
    /**
     * Creates new form SuiteCustomizerLibraries
     */
    public SuiteCustomizerBasicBranding(final SuiteProperties suiteProps, ProjectCustomizer.Category cat, 
            BasicCustomizer.SubCategoryProvider prov) {
        super(suiteProps, SuiteCustomizerBasicBranding.class, cat);
        initComponents();        
        this.prov = prov;
        refresh(); 
        checkValidity();
        DocumentListener textFieldChangeListener = new UIUtil.DocumentAdapter() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                checkValidity();
            }
        };
        nameValue.getDocument().addDocumentListener(textFieldChangeListener);
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        if (prov != null) {
            showSubCategory(prov);
            // do preselect just once..
            prov = null;
        }
    }
    
    
    @Messages({
        "ERR_EmptyName=Application name cannot be empty",
        "ERR_InvalidName=Application name is not valid"
    })
    protected void checkValidity() {
        boolean panelValid = true;
        
        if (panelValid && nameValue.getText().trim().length() == 0) {
            category.setErrorMessage(ERR_EmptyName());//NOI18N
            panelValid = false;
        }

        if (panelValid && !nameValue.getText().trim().matches("[a-z][a-z0-9]*(_[a-z][a-z0-9]*)*")) {//NOI18N
            category.setErrorMessage(ERR_InvalidName());//NOI18N
            panelValid = false;
        }
        
        if (panelValid) {        
            category.setErrorMessage(null);
        }
        category.setValid(panelValid);
    }
    
    @Override
    protected void refresh() {
        getBrandingModel().brandingEnabledRefresh();        
        getBrandingModel().initName(true);
        getBrandingModel().initTitle(true);
        standaloneApp.setSelected(getBrandingModel().isBrandingEnabled());
        addOn.setSelected(!getBrandingModel().isBrandingEnabled());
        nameValue.setText(getBrandingModel().getName());
        
        enableOrDisableComponents();
        
    }
    
    public @Override void store() {
        //getBrandingModel().setBrandingEnabled(buildWithBranding.isSelected());        
        getBrandingModel().setName(nameValue.getText());
    }
    
    private void enableOrDisableComponents() {
        nameValue.setEnabled(standaloneApp.isSelected());
        name.setEnabled(standaloneApp.isSelected());        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        name = new javax.swing.JLabel();
        nameValue = new javax.swing.JTextField();
        addOn = new javax.swing.JRadioButton();
        standaloneApp = new javax.swing.JRadioButton();
        lblSpacer = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        name.setLabelFor(nameValue);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/netbeans/modules/apisupport/project/ui/customizer/Bundle"); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(name, bundle.getString("LBL_AppName")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        add(name, gridBagConstraints);
        name.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_Name")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 0, 0);
        add(nameValue, gridBagConstraints);

        buttonGroup1.add(addOn);
        org.openide.awt.Mnemonics.setLocalizedText(addOn, bundle.getString("LBL_AppAddOn")); // NOI18N
        addOn.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        addOn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        addOn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(addOn, gridBagConstraints);
        addOn.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_AddOn")); // NOI18N

        buttonGroup1.add(standaloneApp);
        org.openide.awt.Mnemonics.setLocalizedText(standaloneApp, bundle.getString("LBL_AppStandAlone")); // NOI18N
        standaloneApp.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        standaloneApp.setMargin(new java.awt.Insets(0, 0, 0, 0));
        standaloneApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standaloneAppActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        add(standaloneApp, gridBagConstraints);
        standaloneApp.getAccessibleContext().setAccessibleDescription(bundle.getString("ACS_StandAloneApp")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(lblSpacer, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void standaloneAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standaloneAppActionPerformed
        //TODO: Exclude IDE Modules must be done
        enableOrDisableComponents();
        getBrandingModel().setBrandingEnabled(standaloneApp.isSelected());                
    }//GEN-LAST:event_standaloneAppActionPerformed

    private void addOnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addOnActionPerformed
        enableOrDisableComponents();
        getBrandingModel().setBrandingEnabled(standaloneApp.isSelected());                
    }//GEN-LAST:event_addOnActionPerformed
            
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton addOn;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lblSpacer;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameValue;
    private javax.swing.JRadioButton standaloneApp;
    // End of variables declaration//GEN-END:variables
    
    private BrandingModel getBrandingModel() {
        return getProperties().getBrandingModel();
    }
    
    private void showSubCategory(BasicCustomizer.SubCategoryProvider prov) {
        if (SuiteCustomizer.APPLICATION.equals(prov.getCategory()) &&
            SuiteCustomizer.APPLICATION_CREATE_STANDALONE_APPLICATION.equals(prov.getSubcategory())) {
            standaloneApp.requestFocus();
        }
    }
    
}