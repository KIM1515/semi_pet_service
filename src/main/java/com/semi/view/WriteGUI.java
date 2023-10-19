/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
*/

package com.semi.view;

import com.semi.board.model.BoardDAO;
import com.semi.board.model.BoardDTO;
import com.semi.board.model.BoardService;
import com.semi.person.model.PersonService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author yes03
 */
public class WriteGUI extends javax.swing.JFrame implements ItemListener{
    private String selectedCate1;
    private String selectedCate2;
    private String selectedCate3;
    
    public static final int BOARD_REGISTER=1; //게시글 등록
    public static final int BOARD_EDIT=2; //게시글 수정
    
    private BoarderGUI boarderGui;
    //게시글 등록/게시글 수정구분 플래그
    private int boardFlag;

    public WriteGUI() {
        initComponents();
        
        init();
        addEvent();
    }
     //게시글 수정
    public WriteGUI(int boardFlag){
        this();
        this.boardFlag=boardFlag;
        boardProc();
    }
    
    //게시글 등록
    public WriteGUI(int boardFlag, BoarderGUI boarderGui){
        this(boardFlag);
        this.boarderGui=boarderGui;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cbCategory1 = new javax.swing.JComboBox<>();
        rbDog = new javax.swing.JRadioButton();
        rbCat = new javax.swing.JRadioButton();
        cbCategory2 = new javax.swing.JComboBox<>();
        tfTitle = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taBody = new javax.swing.JTextArea();
        btWriting = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbCategory1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "육아톡톡", "수다방" }));

        buttonGroup1.add(rbDog);
        rbDog.setText("강아지");

        buttonGroup1.add(rbCat);
        rbCat.setText("고양이");

        cbCategory2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QnA", "사료", "영양제", "간식", "외출/산책", "의료/치료", "행동/교정", "정보공유(용품)", "실종/목격" }));

        taBody.setColumns(20);
        taBody.setRows(5);
        jScrollPane2.setViewportView(taBody);

        btWriting.setText("등록");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btWriting, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rbDog, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                                    .addComponent(rbCat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbCategory2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(rbDog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCat))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCategory1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCategory2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btWriting, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
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
            java.util.logging.Logger.getLogger(WriteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WriteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WriteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WriteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WriteGUI().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btWriting;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCategory1;
    private javax.swing.JComboBox<String> cbCategory2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton rbCat;
    private javax.swing.JRadioButton rbDog;
    private javax.swing.JTextArea taBody;
    private javax.swing.JTextField tfTitle;
    // End of variables declaration//GEN-END:variables
    private void init() {
        selectedCate1="육아톡톡";
        if(selectedCate1.equals("육아톡톡")){
        selectedCate2="QnA";
        }else if(selectedCate1.equals("수다방")){
        selectedCate2="";    
        }
        selectedCate3="강아지";
        taBody.setLineWrap(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    private void addEvent() {
        rbDog.addItemListener(this);
        rbCat.addItemListener(this);
        cbCategory1.addItemListener(this);
        cbCategory2.addItemListener(this);
        
        //btInsertImg.addActionListener(new EventHandler());
        btWriting.addActionListener(new EventHandler());
        
    }
    //카테고리1 : 육아톡톡 / 수다방
    //카테고리2 : 육아톡톡 하위 카테고리
    //카테고리3 : 강아지 / 고양이
    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==rbDog){
            selectedCate3="강아지";
        }else if(e.getSource()==rbCat){
            selectedCate3="고양이";
        }else if(e.getSource()==cbCategory1){
            int index = cbCategory1.getSelectedIndex();
            if(index==0){  //육아톡톡
                selectedCate1="육아톡톡";
                cbCategory2.setVisible(true);
            }else if(index==1){ //수다방
                selectedCate1="수다방";
                cbCategory2.setVisible(false);
            }
        }else if(e.getSource()==cbCategory2){
            int index = cbCategory2.getSelectedIndex();
            if(index==0){ 
                selectedCate2="QnA";
            }else if(index==1){ 
                selectedCate2="사료";
            }else if(index==2){ 
                selectedCate2="영양제";
            }else if(index==3){ 
                selectedCate2="간식";
            }else if(index==4){ 
                selectedCate2="외출/산책";
            }else if(index==5){ 
                selectedCate2="의료/치료";
            }else if(index==6){ 
                selectedCate2="행동/교정";
            }else if(index==7){ 
                selectedCate2="정보공유(용품)";
            }else if(index==8){ 
                selectedCate2="실종/목격";
            }
        }
    }

    private void boardProc() {
         if(boardFlag==BOARD_REGISTER){
            setTitle("게시글 등록");
            btWriting.setText("등록");
            rbDog.setSelected(true);
        }else if(boardFlag==BOARD_EDIT){
            setTitle("게시글 수정");
            btWriting.setText("수정");
             try {
                showPreWriting();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }

    private void showPreWriting() throws SQLException {
        int bno=BoardService.getBno();
        BoardDAO boardDao=new BoardDAO();
        BoardDTO dto=boardDao.readBoard(bno);
        
      
        if (dto.getBcategory3().trim().equals("강아지")) {  
            rbDog.setSelected(true);
         }else if(dto.getBcategory3().trim().equals("고양이")){
            rbCat.setSelected(true);
         }   

        cbCategory1.setSelectedItem(dto.getBcategory1());
        cbCategory2.setSelectedItem(dto.getBcategory2());
        tfTitle.setText(dto.getBtitle());
        taBody.setText(dto.getBbody());
       
    }

    class EventHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==btWriting){ //게시글 등록, 수정
                try {
                    if(boardFlag==BOARD_REGISTER){
                        addBoard();             
                    }else if(boardFlag==BOARD_EDIT){
                        editBoard();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
            }
        }
    }
        private void addBoard() throws SQLException {
            String category1=selectedCate1;
            String category2=selectedCate2;
            String category3=selectedCate3;
            String btitle=tfTitle.getText();
            String bbody=taBody.getText();
            int personno=PersonService.getPersonno();
            
            if(btitle==null||btitle.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "제목을 입력해 주세요.");
                tfTitle.requestFocus();
                return;
            }else if(bbody==null||bbody.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "내용을 입력해 주세요.");
                taBody.requestFocus();
                return;
            }
            BoardDTO dto=new BoardDTO();
            dto.setBcategory1(category1);
            dto.setBcategory2(category2);
            dto.setBcategory3(category3);
            dto.setBtitle(btitle);
            dto.setBbody(bbody);
            dto.setPersonno(personno);
            
            BoardDAO boardDao=new BoardDAO();
            int cnt=boardDao.insertBoard(dto);
            
            if(cnt>0) {
                JOptionPane.showMessageDialog(rootPane, "게시글 등록에 성공했습니다.");
                BoarderGUI boarderGui=new BoarderGUI();
                if(category1.equals("육아톡톡")){
                     boarderGui.getjTabbedPane1().setSelectedIndex(0);
                }else if(category1.equals("수다방")){
                     boarderGui.getjTabbedPane1().setSelectedIndex(1);
                }
                     boarderGui.setVisible(true);
                     dispose();
            }
           
        }

        private void editBoard() throws SQLException {
            String category1=(String)cbCategory1.getSelectedItem();
            String category2="";
            if(category1.equals("육아톡톡")){
               category2=(String)cbCategory2.getSelectedItem();
            }else if(category1.equals("수다방")){
               category2="";
            }    
            String category3=selectedCate3;
            String btitle=tfTitle.getText();
            String bbody=taBody.getText();
            
            if(btitle==null || btitle.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "제목을 입력해야 합니다.");
            }else if(bbody==null || bbody.isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "내용을 입력해야 합니다.");
            }
            
            BoardDTO dto=new BoardDTO();
            dto.setBcategory1(category1);
            dto.setBcategory2(category2);
            dto.setBcategory3(category3);
            dto.setBtitle(btitle);
            dto.setBbody(bbody);

            BoardDAO boardDao=new BoardDAO();
            int cnt=boardDao.UpdateBoard(dto);
            if(cnt>0) {
                JOptionPane.showMessageDialog(rootPane, "게시글 수정에 성공했습니다.");
                     dispose();
                     ReadBoardGUI readboardGui=new ReadBoardGUI();
                     readboardGui.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(rootPane, "게시글 수정에 실패했습니다.");
            }
            
        }
    
    }

    

