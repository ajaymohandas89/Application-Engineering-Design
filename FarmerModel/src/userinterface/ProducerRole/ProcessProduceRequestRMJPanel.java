
package userinterface.ProducerRole;


import userinterface.ManufacturerWarehouseRole.*;
import userinterface.WarehouseManagerRole.*;
import Business.WorkQueue.ProduceRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Ajay Mohandas
 */
public class ProcessProduceRequestRMJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    ProduceRequest request;
    /**
     * Creates new form ProcessProduceRequestRMJPanel
     */
    public ProcessProduceRequestRMJPanel(JPanel userProcessContainer, ProduceRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        resultJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        submitJButton.setText("Submit Result");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 424, 200, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Raw Material Result");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 358, -1, -1));

        resultJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(resultJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 355, 200, -1));

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back-icon (2).png"))); // NOI18N
        backJButton.setText("Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 728, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Plants-Hand-Planting-icon.png"))); // NOI18N
        jLabel2.setText("Raw Material Result");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 53, 335, 73));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManufacturerProducerJPanel wwjp = (ManufacturerProducerJPanel) component;
        wwjp.populateSuppRequestTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        if (resultJTextField.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Please enter a response before submitting");
        }
        else
        {
        request.setTestResult(resultJTextField.getText());
        request.setStatus("Completed");
        }
        resultJTextField.setText("");
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField resultJTextField;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
