/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.semi.view;

import com.semi.pet.model.PetDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PetDelete extends javax.swing.JFrame implements ActionListener{
    private MemberInfo memberInfo;
   
    public PetDelete() {
        initComponents();
        
        init();
        addEvent();
    }
    
    public PetDelete(MemberInfo memberInfo) {
        this();
        this.memberInfo = memberInfo;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfPetno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        btCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 0, 24)); // NOI18N
        jLabel1.setText("삭제하려는 펫 번호를 입력하세요");

        tfPetno.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        jLabel2.setText("번호");

        btDelete.setText("삭제");

        btCancle.setText("취소");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPetno, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btDelete)
                        .addGap(36, 36, 36)
                        .addComponent(btCancle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPetno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete)
                    .addComponent(btCancle))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PetDelete().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfPetno;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addEvent() {
        btDelete.addActionListener(this);
        btCancle.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btCancle) {
            this.dispose();
        }else if(e.getSource()==btDelete){
            deletePet();
            memberInfo.setPetValue();
            this.dispose();
            
        }
    }

    private void deletePet() {
        PetDAO dao = new PetDAO();
                
        int no = Integer.parseInt(tfPetno.getText());
        
        try {
            int cnt = dao.deletePet(no);
            if(cnt>0) {
            JOptionPane.showMessageDialog(this, "펫 정보가 삭제되었습니다.");
            this.dispose();
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setPetValue();
        }else {
            JOptionPane.showMessageDialog(this, "펫 정보 삭제 실패");
        }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }

}
