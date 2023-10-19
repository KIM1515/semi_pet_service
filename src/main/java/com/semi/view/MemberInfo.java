/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/
package com.semi.view;

import com.semi.pay.model.PayDAO;
import com.semi.pay.model.PayDTO;
import com.semi.person.model.PersonDAO;
import com.semi.person.model.PersonDTO;
import com.semi.person.model.PersonService;
import com.semi.pet.model.PetService;
import com.semi.pet_animaltype_view.model.Pet_animaltype_ViewDAO;
import com.semi.pet_animaltype_view.model.Pet_animaltype_ViewDTO;
import com.semi.zipcode.model.ZipcodeDAO;
import com.semi.zipcode.model.ZipcodeDTO;
import com.semi.zipcode.model.ZipcodeService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MemberInfo extends javax.swing.JFrame implements ActionListener{
    private String[] email2List={"naver.com","daum.net","nate.com","gamil.com","직접입력"};
    private PersonDAO dao;
    private Pet_animaltype_ViewDAO pADao;
    private boolean dupChecked = true;
    private ZipcodeService zipcodeService;
    
    public MemberInfo() {
        initComponents();
        
        init();
        addEvent();
    }
    
    public boolean isDupChecked() {
        return dupChecked;
    }
    
    public void setDupChecked(boolean dupChecked) {
        this.dupChecked = dupChecked;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        cbhp1 = new javax.swing.JComboBox<>();
        tfhp3 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfhp2 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        cbPsYear = new javax.swing.JComboBox<>();
        cbPsMonth = new javax.swing.JComboBox<>();
        cbPsDate = new javax.swing.JComboBox<>();
        tfNickname = new javax.swing.JTextField();
        btNickCheck = new javax.swing.JButton();
        btZipcode = new javax.swing.JButton();
        tfZipcode = new javax.swing.JTextField();
        tfAddress = new javax.swing.JTextField();
        tfDetailAddress = new javax.swing.JTextField();
        tfPwd = new javax.swing.JPasswordField();
        tfPwd2 = new javax.swing.JPasswordField();
        jLabel27 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cbEmail2 = new javax.swing.JComboBox<>();
        tfEmail1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfEmail3 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btEdit = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        btSave = new javax.swing.JButton();
        tfZipno = new javax.swing.JTextField();
        tfbunji = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPet = new javax.swing.JTable();
        btPetAdd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        btPetDelete = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPay = new javax.swing.JTable();
        btPayDelete = new javax.swing.JButton();
        btPayAdd = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("아이디");

        jLabel2.setText("이름");

        jLabel3.setText("비밀번호");

        jLabel4.setText("전화번호");

        jLabel5.setText("생년월일");

        jLabel6.setText("닉네임");

        jLabel7.setText("우편번호");

        jLabel8.setText("주소");

        jLabel9.setText("상세주소");

        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });

        cbhp1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel24.setText("-");

        jLabel23.setText("-");

        cbPsYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPsMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPsDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbPsDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPsDateActionPerformed(evt);
            }
        });

        btNickCheck.setText("중복확인");

        btZipcode.setText("우편번호 찾기");

        tfPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPwdActionPerformed(evt);
            }
        });

        jLabel27.setText("비밀번호 재확인");

        jLabel11.setText("이메일");

        cbEmail2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("@");

        tfEmail3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmail3ActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        btEdit.setText("수정하기");

        btCancel.setText("취소");

        btSave.setText("저장하기");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSave)
                .addGap(29, 29, 29)
                .addComponent(btEdit)
                .addGap(32, 32, 32)
                .addComponent(btCancel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btCancel)
                        .addComponent(btEdit)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btNickCheck))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfDetailAddress)
                                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfPwd2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbPsYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cbPsMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbPsDate, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btZipcode)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfZipno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbhp1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel23)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfhp2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel24)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfhp3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addComponent(tfbunji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPwd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEmail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tfEmail3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbhp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfhp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfhp3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPsYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPsMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPsDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNickCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btZipcode)
                    .addComponent(tfZipno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfbunji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDetailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        tabbedPane.addTab("회원정보", jPanel1);

        tbPet.setEditingColumn(0);
        tbPet.setEditingRow(0);
        jScrollPane2.setViewportView(tbPet);

        btPetAdd.setText("펫정보 추가");
        btPetAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPetAddActionPerformed(evt);
            }
        });

        jLabel13.setText("* 반려동물을 선택하면 상세정보를 확인 할 수 있습니다.");

        btPetDelete.setText("펫정보 삭제");
        btPetDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPetDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btPetAdd)
                .addGap(65, 65, 65)
                .addComponent(btPetDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPetAdd)
                    .addComponent(btPetDelete))
                .addGap(43, 43, 43))
        );

        tabbedPane.addTab("반려동물정보", jPanel5);

        tbPay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbPay);

        btPayDelete.setText("카드 삭제");

        btPayAdd.setText("카드 등록");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btPayAdd)
                        .addGap(43, 43, 43)
                        .addComponent(btPayDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPayDelete)
                    .addComponent(btPayAdd))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        tabbedPane.addTab("결제정보", jPanel2);

        jLabel26.setFont(new java.awt.Font("돋움", 1, 18)); // NOI18N
        jLabel26.setText("내 정보");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jLabel10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(390, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(503, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdActionPerformed
    
    private void btPetAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPetAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPetAddActionPerformed
    
    private void tfPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPwdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPwdActionPerformed
    
    private void tfEmail3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmail3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmail3ActionPerformed
    
    private void cbPsDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPsDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPsDateActionPerformed
    
    private void btPetDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPetDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPetDeleteActionPerformed
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btNickCheck;
    private javax.swing.JButton btPayAdd;
    private javax.swing.JButton btPayDelete;
    private javax.swing.JButton btPetAdd;
    private javax.swing.JButton btPetDelete;
    private javax.swing.JButton btSave;
    private javax.swing.JButton btZipcode;
    private javax.swing.JComboBox<String> cbEmail2;
    private javax.swing.JComboBox<String> cbPsDate;
    private javax.swing.JComboBox<String> cbPsMonth;
    private javax.swing.JComboBox<String> cbPsYear;
    private javax.swing.JComboBox<String> cbhp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tbPay;
    public javax.swing.JTable tbPet;
    public javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfDetailAddress;
    private javax.swing.JTextField tfEmail1;
    private javax.swing.JTextField tfEmail3;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfName;
    public javax.swing.JTextField tfNickname;
    private javax.swing.JPasswordField tfPwd;
    private javax.swing.JPasswordField tfPwd2;
    public javax.swing.JTextField tfZipcode;
    public javax.swing.JTextField tfZipno;
    public javax.swing.JTextField tfbunji;
    private javax.swing.JTextField tfhp2;
    private javax.swing.JTextField tfhp3;
    // End of variables declaration//GEN-END:variables
    
    private void init() {
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tbPet.getTableHeader().setReorderingAllowed(false);
        tbPay.getTableHeader().setReorderingAllowed(false);
        
        //번호 앞자리 콤보박스
        String[] hp1List={"010","011","016","017", "019"};
        DefaultComboBoxModel<String> cmodel = new DefaultComboBoxModel<>(hp1List);
        cbhp1.setModel(cmodel);
        
        //이메일 두번째자리 콤보박스
        DefaultComboBoxModel<String> cmodel2 = new DefaultComboBoxModel<>(email2List);
        cbEmail2.setModel(cmodel2);
        
        //생년월일 콤보박스
        //년
        String[] yearList = new String[101];
        for(int i=0; i<=100; i++) {
            yearList[i] = 2023-i+"";
        }
        DefaultComboBoxModel<String> cmodel3 = new DefaultComboBoxModel<>(yearList);
        cbPsYear.setModel(cmodel3);
        //월
        String[] monthList = new String[12];
        for(int i=0; i<monthList.length; i++) {
            if(i<9) {
                monthList[i] = "0"+(i+1);
            }else {
                monthList[i] = i+1+"";
            }
        }
        DefaultComboBoxModel<String> cmodel4 = new DefaultComboBoxModel<>(monthList);
        cbPsMonth.setModel(cmodel4);
        //일
        String[] dayList = new String[31];
        for(int i=0; i<dayList.length; i++) {
            if(i<9) {
                dayList[i] = "0"+(i+1);
            }else{
                dayList[i] = i+1+"";
            }
        }
        DefaultComboBoxModel<String> cmodel8 = new DefaultComboBoxModel<>(dayList);
        cbPsDate.setModel(cmodel8);
        tfZipno.setVisible(false);
        tfbunji.setVisible(false);
        setPersonValue();
        setPetValue();
        setbutton();
        setPayValue();
        
        
        
    }
    private void addEvent() {
        cbPsMonth.addItemListener(new EventHandler());
        btEdit.addActionListener(this);
        btPetAdd.addActionListener(this);
        btPayAdd.addActionListener(this);
        tbPet.addMouseListener(new EventHandler());
        btCancel.addActionListener(this);
        cbEmail2.addItemListener(new EventHandler());
        btPetDelete.addActionListener(this);
        btPayDelete.addActionListener(this);
        btNickCheck.addActionListener(this);
        btZipcode.addActionListener(this);
        btSave.addActionListener(this);
        tfNickname.addKeyListener(new EventHandler());
    }
    //기존 회원정보 세팅
    private void setPersonValue() {
        dao = new PersonDAO();
        String id = PersonService.getId();
        
        try {
            PersonDTO dto = dao.selectById(id);
            tfId.setText(dto.getId());
            tfName.setText(dto.getName());
            tfPwd.setText(dto.getPwd());
            tfPwd2.setText(dto.getPwd());
            String hp = dto.getHp();
            if(hp != null && !hp.isEmpty()) {
                String[] hpArr = hp.split("-");
                String hp1 = hpArr[0];
                String hp2 = hpArr[1];
                String hp3 = hpArr[2];
                cbhp1.setSelectedItem(hp1);
                tfhp2.setText(hp2);
                tfhp3.setText(hp3);
            }else{
                cbhp1.setSelectedIndex(0);
            }
            String email = dto.getEmail();
            if(email!= null && !email.isEmpty()) {
                String[] emailArr = email.split("@");
                String email1 = emailArr[0];
                String email2 = emailArr[1];
                tfEmail1.setText(email1);
                boolean bool = false;
                for(int i=0; i<email2List.length; i++) {
                    if(email2.equals(email2List[i])) {
                        bool = true;
                        break;
                    }
                }
                if(bool) {
                    cbEmail2.setSelectedItem(email2);
                }else{
                    cbEmail2.setSelectedItem("직접입력");
                    tfEmail3.setText(email2);
                }
            }else{
                cbEmail2.setSelectedIndex(0);
            }
            String birth = dto.getBirth();
            String birth1 = birth.substring(0,4);
            String birth2 = birth.substring(4,6);
            String birth3 = birth.substring(6);
            cbPsYear.setSelectedItem(birth1);
            cbPsMonth.setSelectedItem(birth2);
            cbPsDate.setSelectedItem(birth3);
            tfNickname.setText(dto.getNickname());
            PersonService.setNickname(dto.getNickname());
            ZipcodeDAO zipDao = new ZipcodeDAO();
            ZipcodeDTO zipDto = zipDao.selectByZipno(dto.getPersonno());
            tfZipcode.setText(zipDto.getZipcodeno());
            tfAddress.setText(zipDto.getSido() + " " + zipDto.getGugun() + " " + zipDto.getDong());
            tfDetailAddress.setText(dto.getDetailaddress());
            tfZipno.setText(zipDto.getZipno()+"");
            tfbunji.setText(zipDto.getStartbunji());
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void setbutton() {
        tfId.setEditable(false);
        tfName.setEditable(false);
        tfPwd.setEditable(false);
        tfPwd2.setEditable(false);
        tfEmail1.setEditable(false);
        tfEmail3.setEditable(false);
        cbEmail2.setEditable(false);
        cbEmail2.setEnabled(false);
        cbhp1.setEditable(false);
        cbhp1.setEnabled(false);
        tfhp2.setEditable(false);
        tfhp3.setEditable(false);
        cbPsYear.setEditable(false);
        cbPsYear.setEnabled(false);
        cbPsMonth.setEditable(false);
        cbPsMonth.setEnabled(false);
        cbPsDate.setEditable(false);
        cbPsDate.setEnabled(false);
        tfNickname.setEditable(false);
        tfZipcode.setEditable(false);
        tfAddress.setEditable(false);
        tfDetailAddress.setEditable(false);
        btNickCheck.setVisible(false);
        btZipcode.setVisible(false);
        btSave.setVisible(false);
        btCancel.setVisible(false);
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btEdit) {
            tfPwd.setEditable(true);
            tfPwd2.setEditable(true);
            tfEmail1.setEditable(true);
            tfhp2.setEditable(true);
            tfhp3.setEditable(true);
            tfNickname.setEditable(true);
            tfDetailAddress.setEditable(true);
            btNickCheck.setVisible(true);
            btZipcode.setVisible(true);
            btSave.setVisible(true);
            btCancel.setVisible(true);
            btEdit.setVisible(false);
            cbPsDate.setEnabled(true);
            cbPsYear.setEnabled(true);
            cbPsMonth.setEnabled(true);
            cbhp1.setEnabled(true);
            cbEmail2.setEnabled(true);
        }else if(e.getSource()==btPetAdd){
            PetInfo f = new PetInfo(1, this);
            f.setVisible(true);
        }else if(e.getSource()==btPayAdd){
            Pay f = new Pay(this);
            f.setVisible(true);
        }else if(e.getSource()==btCancel) {
            setbutton();
            setPersonValue();
            btEdit.setVisible(true);
        }else if(e.getSource()==btPetDelete) {
            PetDelete f = new PetDelete(this);
            f.setVisible(true);
        }else if(e.getSource()==btPayDelete) {
            deletePay();
            setPayValue();
        }else if(e.getSource()==btNickCheck) {
            duplicate();
        }else if(e.getSource()==btZipcode) {
            ZipcodeGUI f = new ZipcodeGUI(this);
            f.setVisible(true);
        }else if(e.getSource()==btSave) {
            try {
                editPerson();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void setPetValue() {
        dao = new PersonDAO();
        pADao = new Pet_animaltype_ViewDAO();
        String id = PersonService.getId();
        String[] list = {"반려동물번호","구분","묘/견종","성별","반려동물이름"};
        
        try {
            PersonDTO dto = dao.selectById(id);
            
            List<Pet_animaltype_ViewDTO> pAList = pADao.selectByPersonNo(dto.getPersonno());
            String[][] data = new String[pAList.size()][5];
            String kinds = "";
            String gender = "";
            for(int i=0; i<pAList.size(); i++) {
                Pet_animaltype_ViewDTO pADto =pAList.get(i);
                
                data[i][0] = pADto.getPetno()+"";
                if(pADto.getAnitype().equalsIgnoreCase("c")) {
                    kinds = "고양이";
                }else{
                    kinds = "강아지";
                }
                data[i][1] = kinds;
                data[i][2] = pADto.getAnikinds();
                if(pADto.getGender().equals("M")){
                    gender = "남아";
                }else{
                    gender = "여아";
                }
                data[i][3] = gender;
                data[i][4] = pADto.getPetname();
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.setDataVector(data, list);
            tbPet.setModel(model);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void setPayValue() {
        dao = new PersonDAO();
        PayDAO payDao = new PayDAO();
        String id = PersonService.getId();
        String[] list = {"번호","카드사","카드번호","만료일"};
        
        try {
            PersonDTO dto = dao.selectById(id);
            
            List<PayDTO> payList = payDao.selectByPersonno(dto.getPersonno());
            String[][] data = new String[payList.size()][4];
            for(int i=0; i<payList.size(); i++) {
                PayDTO payDto =payList.get(i);
                
                data[i][0] = payDto.getRownum()+"";
                data[i][1] = payDto.getCardcom();
                data[i][2] = payDto.getCardno();
                String expiration = payDto.getExpiration();
                String exM = expiration.substring(0,2);
                String exY = expiration.substring(2);
                data[i][3] = (exY + "년 " + exM + "월");
            }
            
            DefaultTableModel model = new DefaultTableModel();
            model.setDataVector(data, list);
            tbPay.setModel(model);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private void deletePay() {
        int result = JOptionPane.showConfirmDialog(this, "해당 카드정보를 삭제하시겠습니까?","", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if(result == JOptionPane.YES_OPTION){
            PayDAO payDao = new PayDAO();
            int row = tbPay.getSelectedRow();
            String cardno = (String)tbPay.getValueAt(row,2);
            
            try {
                int cnt = payDao.deletePay(cardno);
                if(cnt>0){
                    JOptionPane.showMessageDialog(this, "해당 카드가 삭제되었습니다.");
                }else{
                    JOptionPane.showMessageDialog(this, "카드 삭제 실패");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }
    
    private void duplicate() {
        String Nickname = tfNickname.getText();
        if(Nickname == null || Nickname.isEmpty()){
            JOptionPane.showMessageDialog(this, "닉네임을 입력하세요");
            tfNickname.requestFocus();
            return;
        }
        
        PersonDAO personDao=new PersonDAO();
        try {
            
            int result = personDao.checkNickname(Nickname);
            
            if(result==personDao.USABLE_NICKNAME){
                int type=JOptionPane.showConfirmDialog(this, "사용가능한 닉네임입니다."+
                        "사용하시겠습니까","", JOptionPane.YES_NO_OPTION);
                if(type==JOptionPane.YES_OPTION){
                    setDupChecked(true);
                }else if(type==JOptionPane.NO_OPTION){
                    tfName.setText(PersonService.getNickname());
                }
            }else if(result==personDao.UNUSABLE_NICKNAME){ //사용불가
                JOptionPane.showMessageDialog(this, "해당 닉네임이 이미 존재합니다."
                        + "다른 닉네임을 입력하세요");
                tfName.setText(PersonService.getNickname());
            }else{
                JOptionPane.showMessageDialog(this, "닉네임 중복확인 실패!");
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void editPerson() throws SQLException {
        
        PersonDTO personDto = new PersonDTO();
        PersonDAO personDao = new PersonDAO();
        ZipcodeDAO zipcodeDao = new ZipcodeDAO();
        
        String passward = tfPwd.getText();
        String email1 = tfEmail1.getText();
        String emaildomain = (String)cbEmail2.getSelectedItem();
        String email2 = "";
        if(emaildomain.equals("직접입력")){
            email2 = tfEmail3.getText();
        }else{
            email2 = (String)cbEmail2.getSelectedItem();
        }
        String email = email1 + "@" + email2;
        String hp = (String)cbhp1.getSelectedItem()+"-"+tfhp2.getText()+"-"+tfhp3.getText();
        String birth = (String)cbPsYear.getSelectedItem()+(String)cbPsMonth.getSelectedItem()+(String)cbPsDate.getSelectedItem();
        String nickname = tfNickname.getText();
        String[] address = tfAddress.getText().split(" ", 3);
        String add1 = address[1].trim();
        String add2 = address[2].trim();
        String bunji = tfbunji.getText();
        ZipcodeDTO zipcodeDto = new ZipcodeDTO();
        zipcodeDto = zipcodeDao.findZipno(add1, add2, bunji);
        tfZipno.setText(zipcodeDto.getZipno()+"");
        int zipno = Integer.parseInt(tfZipno.getText());
        String detailaddress = tfDetailAddress.getText();
        personDto = personDao.selectById(PersonService.getId());
        
        int personno = personDto.getPersonno();
        
        if(passward == null || passward.isEmpty()) {
            JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
            tfPwd.requestFocus();
            return;
        }else if(email1 == null || email1.isEmpty()){
            JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
            tfEmail1.requestFocus();
            return;
        }else if(emaildomain.equals("직접입력") && (email2 == null || email2.isEmpty())){
            JOptionPane.showMessageDialog(this, "이메일을 입력하세요.");
            tfEmail3.requestFocus();
            return;
        }
        else if(tfhp2.getText() == null || tfhp2.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "전화번호를 입력하세요");
            tfhp2.requestFocus();
            return;
        }else if(tfhp2.getText().length()!=4){
            JOptionPane.showMessageDialog(this, "전화번호 한칸당 네자리 숫자만 입력하세요");
            tfhp2.requestFocus();
            return;
        }else if(tfhp3.getText() == null || tfhp3.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "전화번호를 입력하세요");
            tfhp3.requestFocus();
            return;
        }else if(tfhp3.getText().length()!=4){
            JOptionPane.showMessageDialog(this, "전화번호 한칸당 네자리 숫자만 입력하세요");
            tfhp3.requestFocus();
            return;
        }else if(nickname == null && nickname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "닉네임을 입력하세요");
            tfNickname.requestFocus();
            return;
        }else if(detailaddress == null || detailaddress.isEmpty()) {
            JOptionPane.showMessageDialog(this, "상세주소를 입력하세요");
            tfDetailAddress.requestFocus();
            return;
        }
        for(int i=0; i<tfhp2.getText().length(); i++) {
            if(tfhp2.getText().charAt(i) < '0' || tfhp2.getText().charAt(i) > '9') {
                JOptionPane.showMessageDialog(this, "전화번호는 숫자만 입력해야합니다.");
                tfhp2.requestFocus();
                return;
            }else if(tfhp3.getText().charAt(i) < '0' || tfhp3.getText().charAt(i) > '9'){
                JOptionPane.showMessageDialog(this, "전화번호는 숫자만 입력해야합니다.");
                tfhp3.requestFocus();
                return;
            }
        }
        
        personDto.setPwd(passward);
        personDto.setEmail(email);
        personDto.setHp(hp);
        personDto.setBirth(birth);
        personDto.setNickname(nickname);
        personDto.setZipno(zipno);
        personDto.setDetailaddress(detailaddress);
        personDto.setPersonno(personno);
        
        if(dupChecked == false) {
            JOptionPane.showMessageDialog(this, "닉네임 중복을 확인하세요.");
            return;
        }
        
        int cnt = personDao.updatePerson(personDto);
        if(cnt>0) {
            JOptionPane.showMessageDialog(this, "회원정보 수정이 완료되었습니다.");
            setbutton();
            btEdit.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(this, "회원정보 수정 실패");
            return;
        }
    }
    
    class EventHandler extends MouseAdapter implements ItemListener, KeyListener{
        
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource()==cbPsMonth) {
                setDay();//일
            }else if(e.getSource() ==cbEmail2) {
                if(cbEmail2.getSelectedItem().equals("직접입력")) {
                    tfEmail3.setEditable(true);
                }else{
                    tfEmail3.setEditable(false);
                }
            }
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==tbPet) {
                setPetInfo();
            }
        }
        
        @Override
        public void keyTyped(KeyEvent e) {
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getSource()==tfNickname){
                dupChecked = false;
            }
        }
        
        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
    
    private void setPetInfo() {
        PetInfo petinfo = new PetInfo(2);
        petinfo.setVisible(true);
        int row=tbPet.getSelectedRow();
        int no = Integer.parseInt((String)tbPet.getValueAt(row,0));
        
        PetService petService = new PetService();
        petService.setPetno(no);
        
        petinfo.selectByTable(no);
    }
    
    private void setDay() {
        String month = (String)cbPsMonth.getSelectedItem();
        if(month.equals("01") || month.equals("03") || month.equals("05") || month.equals("07") ||
                month.equals("08") || month.equals("10") || month.equals("12")){
            String[] day1List = new String[31];
            for(int i=0; i<day1List.length; i++) {
                if(i<9) {
                    day1List[i] = "0"+(i+1);
                }else{
                    day1List[i] = i+1+"";
                }
            }
            DefaultComboBoxModel<String> cmodel5 = new DefaultComboBoxModel<>(day1List);
            cbPsDate.setModel(cmodel5);
        }else if(month.equals("04") || month.equals("06") || month.equals("09") || month.equals("11")) {
            String[] day2List = new String[30];
            for(int i=0; i<day2List.length; i++) {
                if(i<9) {
                    day2List[i] = "0"+(i+1);
                }else{
                    day2List[i] = i+1+"";
                }
            }
            DefaultComboBoxModel<String> cmodel6 = new DefaultComboBoxModel<>(day2List);
            cbPsDate.setModel(cmodel6);
        }else{
            String[] day3List = new String[29];
            for(int i=0; i<day3List.length; i++) {
                if(i<9) {
                    day3List[i] = "0"+(i+1);
                }else{
                    day3List[i] = i+1+"";
                }
            }
            DefaultComboBoxModel<String> cmodel7 = new DefaultComboBoxModel<>(day3List);
            cbPsDate.setModel(cmodel7);
        }
    }
    
    
}
