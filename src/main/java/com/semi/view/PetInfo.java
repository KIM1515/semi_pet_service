/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/
package com.semi.view;

import com.semi.animaltype.model.AnimalTypeDAO;
import com.semi.animaltype.model.AnimalTypeDTO;
import com.semi.person.model.PersonDAO;
import com.semi.person.model.PersonDTO;
import com.semi.person.model.PersonService;
import com.semi.pet.model.PetDAO;
import com.semi.pet.model.PetDTO;
import com.semi.pet.model.PetService;
import com.semi.pet_animaltype_view.model.Pet_animaltype_ViewDAO;
import com.semi.pet_animaltype_view.model.Pet_animaltype_ViewDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PetInfo extends javax.swing.JFrame implements ActionListener{
    public static final int PET_REGISTER=1;
    public static final int PET_EDIT=2; //회원정보수정
    private  int petFlag;
    
    private MemberInfo memberInfo;
    private Pet_animaltype_ViewDAO pADao;
    private PersonService personService;
    
    public PetInfo() {
        initComponents();
        
        init();
        addEvent();
    }
    
    public PetInfo(int flag, MemberInfo memberInfo){
        this();
        this.petFlag = flag;
        this.memberInfo = memberInfo;
        petProc();
    }
    
    public PetInfo(int flag){
        this();
        this.petFlag=flag;
        petProc();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        petInfolabel = new javax.swing.JLabel();
        aaa = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbAniType = new javax.swing.JComboBox<>();
        cbAniKinds = new javax.swing.JComboBox<>();
        tfPetName = new javax.swing.JTextField();
        cbPetGender = new javax.swing.JComboBox<>();
        cbPetYear = new javax.swing.JComboBox<>();
        cbPetMonth = new javax.swing.JComboBox<>();
        cbPetDate = new javax.swing.JComboBox<>();
        tfPetWeight = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        cbNeut = new javax.swing.JComboBox<>();
        tfFeed = new javax.swing.JTextField();
        tfAllergy = new javax.swing.JTextField();
        btEdit = new javax.swing.JButton();
        btCancle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        petInfolabel.setFont(new java.awt.Font("돋움", 1, 18)); // NOI18N
        petInfolabel.setText("펫 정보 수정");

        jLabel11.setText("묘/견");

        jLabel12.setText("이름");

        jLabel13.setText("성별");

        jLabel14.setText("생일");

        jLabel15.setText("몸무게");

        jLabel16.setText("중성화여부");

        jLabel17.setText("먹는 사료");

        jLabel20.setText("알러지");

        cbAniType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbAniKinds.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPetGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPetYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPetMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        cbPetDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jLabel22.setText("Kg");

        cbNeut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btEdit.setText("수정");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btCancle.setText("취소");

        javax.swing.GroupLayout aaaLayout = new javax.swing.GroupLayout(aaa);
        aaa.setLayout(aaaLayout);
        aaaLayout.setHorizontalGroup(
            aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aaaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(aaaLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfPetName))
                    .addGroup(aaaLayout.createSequentialGroup()
                        .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbNeut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFeed)))
                    .addGroup(aaaLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfAllergy))
                    .addGroup(aaaLayout.createSequentialGroup()
                        .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(aaaLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbPetGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aaaLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbAniType, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAniKinds, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(aaaLayout.createSequentialGroup()
                                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(aaaLayout.createSequentialGroup()
                                        .addComponent(tfPetWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22))
                                    .addGroup(aaaLayout.createSequentialGroup()
                                        .addComponent(cbPetYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbPetMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbPetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 164, Short.MAX_VALUE)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aaaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btEdit)
                .addGap(55, 55, 55)
                .addComponent(btCancle)
                .addGap(155, 155, 155))
        );
        aaaLayout.setVerticalGroup(
            aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aaaLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAniType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbAniKinds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPetName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPetGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPetYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPetMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPetDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPetWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNeut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFeed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfAllergy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(aaaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEdit)
                    .addComponent(btCancle))
                .addGap(15, 15, 15))
        );

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
                        .addComponent(aaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(petInfolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(381, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(aaa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(petInfolabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(392, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditActionPerformed
    
    
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MemberFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aaa;
    private javax.swing.JButton btCancle;
    private javax.swing.JButton btEdit;
    private javax.swing.JComboBox<String> cbAniKinds;
    private javax.swing.JComboBox<String> cbAniType;
    private javax.swing.JComboBox<String> cbNeut;
    private javax.swing.JComboBox<String> cbPetDate;
    private javax.swing.JComboBox<String> cbPetGender;
    private javax.swing.JComboBox<String> cbPetMonth;
    private javax.swing.JComboBox<String> cbPetYear;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel petInfolabel;
    private javax.swing.JTextField tfAllergy;
    private javax.swing.JTextField tfFeed;
    private javax.swing.JTextField tfPetName;
    private javax.swing.JTextField tfPetWeight;
    // End of variables declaration//GEN-END:variables
    
    private void init() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //견/묘 콤보박스
        String[] CDList = {"고양이", "강아지"};
        DefaultComboBoxModel<String> cmodel = new DefaultComboBoxModel<>(CDList);
        cbAniType.setModel(cmodel);
        
        //종 콤보박스
        setAnikinds();
        
        //성별
        String[] genderList = {"남아","여아"};
        DefaultComboBoxModel<String> cmodel2 = new DefaultComboBoxModel<>(genderList);
        cbPetGender.setModel(cmodel2);
     
        //생년월일 콤보박스
        //년
        String[] yearList = new String[101];
        for(int i=0; i<=100; i++) {
            yearList[i] = 2023-i+"";
        }
        DefaultComboBoxModel<String> cmodel3 = new DefaultComboBoxModel<>(yearList);
        cbPetYear.setModel(cmodel3);
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
        cbPetMonth.setModel(cmodel4);
        //일
        String[] dayList = new String[31];
        for(int i=0; i<dayList.length; i++) {
            if(i<9) {
                dayList[i] = "0"+(i+1);
            }else{
                dayList[i] = i+1+"";
            }
        }
        setday();
        
        //중성화
        String[] neutList = {"","Y","N"};
        DefaultComboBoxModel<String> cmodel6 = new DefaultComboBoxModel<>(neutList);
        cbNeut.setModel(cmodel6);
        
    }
    private void addEvent() {
        btEdit.addActionListener(this);
        btCancle.addActionListener(this);
        cbAniType.addItemListener(new EventHandler());
    }

    private void setday() {
         String month = (String)cbPetMonth.getSelectedItem();
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
            cbPetDate.setModel(cmodel5);
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
            cbPetDate.setModel(cmodel6);
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
            cbPetDate.setModel(cmodel7);
        }
    }
    
    class EventHandler implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getSource()==cbAniType) {
                setAnikinds();
            }
        }
        
    }
    //테이블에서 선택된 팻 정보 출력
    void selectByTable(int no) {
        Pet_animaltype_ViewDTO pADto = new Pet_animaltype_ViewDTO();
        Pet_animaltype_ViewDAO pADao = new Pet_animaltype_ViewDAO();
        try {
            pADto = pADao.selectByPetNo(no);
            String CD = "";
            if(pADto.getAnitype().equals("C")) {
                CD = "고양이";
            }else{
                CD = "강아지";
            }
            cbAniType.setSelectedItem(CD);
            cbAniKinds.setSelectedItem(pADto.getAnikinds());
            tfPetName.setText(pADto.getPetname());
            String gender = "";
            if(pADto.getGender().equals("M")) {
                gender = "남아";
            }else if(pADto.getGender().equals("W")) {
                gender = "여아";
            }
            cbPetGender.setSelectedItem(gender);
            String year = pADto.getPetbirth().substring(0, 4);
            String month = pADto.getPetbirth().substring(4, 6);
            String date = pADto.getPetbirth().substring(6);
            cbPetYear.setSelectedItem(year);
            cbPetMonth.setSelectedItem(month);
            cbPetDate.setSelectedItem(date);
            tfPetWeight.setText(pADto.getWeight()+"");
            cbNeut.setSelectedItem(pADto.getNeut());
            tfFeed.setText(pADto.getFeed());
            tfAllergy.setText(pADto.getAllergy());
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void petProc() {
        if(petFlag==PET_REGISTER) {
            petInfolabel.setText("펫 정보 등록");
            btEdit.setText("등록");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btEdit){
            try {
                if(petFlag==PET_REGISTER) {
                    petAdd();
                }else if(petFlag==PET_EDIT)
                    petEdit();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource()==btCancle) {
            this.dispose();
        }
    }
    
    private void petAdd() throws SQLException {
        int anino = getAnino();
        String petname = tfPetName.getText();
        String pety = (String)cbPetYear.getSelectedItem();
        String petm = (String)cbPetMonth.getSelectedItem();
        String petd = (String)cbPetDate.getSelectedItem();
        String petbirth = pety+petm+petd;
        String gender = "";
        String gen = (String)cbPetGender.getSelectedItem();
        if(gen.equals("남아")) {
            gender = "M";
        }else{
            gender = "W";
        }
        String weight = tfPetWeight.getText();
        String neut = (String)cbNeut.getSelectedItem();
        String feed = tfFeed.getText();
        String allergy = tfAllergy.getText();
        PersonDTO personDto = new PersonDTO();
        PersonDAO personDao = new PersonDAO();
        personDto = personDao.selectById(personService.getId());
        int personno = personDto.getPersonno();
        
        if(petname == null || petname.isEmpty()) {
            JOptionPane.showMessageDialog(this, "이름을 입력하세요");
            tfPetName.requestFocus();
            return;
        }else if((weight) == null || (weight).isEmpty()) {
            JOptionPane.showMessageDialog(this, "몸무게를 입력하세요");
            tfPetWeight.requestFocus();
            return;
        }
        PetDAO petDao = new PetDAO();
        PetDTO petDto = new PetDTO();
        petDto.setPetname(petname);
        petDto.setPetbirth(petbirth);
        petDto.setGender(gender);
        petDto.setWeight(Double.parseDouble(weight));
        petDto.setNeut(neut);
        petDto.setFeed(feed);
        petDto.setAllergy(allergy);
        petDto.setAnino(anino);
        petDto.setPersonno(personno);
        
        int cnt = petDao.insertPet(petDto);
        if(cnt>0) {
            JOptionPane.showMessageDialog(this, "펫 정보가 등록되었습니다.");
            memberInfo.setPetValue();
            this.dispose();
            
            
        }else {
            JOptionPane.showMessageDialog(this, "펫 정보 등록 실패");
        }
        
    }
    
    private void petEdit() throws SQLException {
       PetDTO petDto = new PetDTO();
       PetDAO petDao = new PetDAO();
       PetService petServie = new PetService();
       AnimalTypeDTO animalTypeDto = new AnimalTypeDTO();
       AnimalTypeDAO animalTypeDao = new AnimalTypeDAO();
       petDto = petDao.selectByPetno(petServie.getPetno());
       
       String anikind = (String)cbAniKinds.getSelectedItem();
       animalTypeDto = animalTypeDao.selectByAniKinds(anikind);
       int anino = animalTypeDto.getAnino();
       String petname = tfPetName.getText();
       String petbirth = (String)(cbPetYear.getSelectedItem()) + (String)(cbPetMonth.getSelectedItem()) + (String)(cbPetDate.getSelectedItem());
       String gen = "";
       String selectedGen = (String)cbPetGender.getSelectedItem();
       if(selectedGen.equals("남아")){
           gen = "M";
       }else{
           gen = "W";
       }
       String gender = gen;
       double weight = Double.parseDouble(tfPetWeight.getText());
       String neut = (String)cbNeut.getSelectedItem();
       String feed = tfFeed.getText();
       String allergy = tfAllergy.getText();
       int petno = petServie.getPetno();
       
       petDto.setAnino(anino);
       petDto.setPetname(petname);
       petDto.setPetbirth(petbirth);
       petDto.setGender(gender);
       petDto.setWeight(weight);
       petDto.setNeut(neut);
       petDto.setFeed(feed);
       petDto.setAllergy(allergy);
       petDto.setPetno(petno);
       
       int cnt = petDao.updatePet(petDto);
        if(cnt>0) {
            JOptionPane.showMessageDialog(this, "펫 정보 수정이 완료되었습니다.");
            memberInfo.setPetValue();
            this.dispose();
            
        }else {
            JOptionPane.showMessageDialog(this, "펫 정보 수정 실패");
            return;
        }
    }
    
    private int getAnino() {
        AnimalTypeDTO animalTypeDto = new AnimalTypeDTO();
        AnimalTypeDAO animalTypeDao = new AnimalTypeDAO();
        
        String aniKinds = (String)cbAniKinds.getSelectedItem();
        int anino = 0;
        try {
            animalTypeDto = animalTypeDao.selectByAniKinds(aniKinds);
            anino = animalTypeDto.getAnino();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return anino;
    }

    private void setAnikinds() {
        AnimalTypeDAO animalTypeDao = new AnimalTypeDAO();
        try {
            String type = "";
            String str = (String)cbAniType.getSelectedItem();
            if(str.equals("고양이")) {
                type = "C";
            }else if(str.equals("강아지")){
                type = "D";
            }
            String[] animalKindsList = animalTypeDao.getAnimalTypeList(type);
            DefaultComboBoxModel<String> cmodel = new DefaultComboBoxModel<>(animalKindsList);
            cbAniKinds.setModel(cmodel);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
}
