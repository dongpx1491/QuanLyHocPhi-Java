/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import database.Connect;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import controller.*;
import java.io.FileNotFoundException;

import java.util.Formatter;


public class NopHocPhiLayout extends javax.swing.JPanel {

    /**
     * Creates new form NopHocPhiLayout
     */
    Connect conn = new Connect();
    HoaDonController hdcon = new HoaDonController();

    public NopHocPhiLayout() {
        setSize(1000, 1000);
        initComponents();
        hdcon.hienThiHD(jTable1, "select * from hoadon");
    }

    String getDateNow() {
        Date today = new Date();
        DateFormat da = new SimpleDateFormat("dd/MM/yyyy");
        String dat = da.format(today);
        return dat;
    }

    String hoaDon() {
        String ans = "";
        ResultSet rs = conn.queryData("select * from sinhvien where masv = " + masv);
        String[] s = new String[10];
        try {
            rs.next();
            s[0] = "\tHOÁ ĐƠN THU TIỀN\n";
            s[1] = "Mã sinh viên : " + rs.getInt("masv") + "\n";
            s[2] = "Tên sinh viên : " + rs.getString("hoten") + "\n";
            s[3] = "Ngày sinh : " + rs.getString("ngaysinh") + "\n";
            s[4] = "Ngày nộp : " + getDateNow() + "\n";
            s[5] = "Số tiền nộp : " + sotien + "\n";
            s[6] = "\n  Người nộp \t \t Người thu";
            s[7] = "\n";
        } catch (SQLException ex) {
            Logger.getLogger(NopHocPhiLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i = 0; i <= 7; i++) {
            ans += s[i];
        }
        return ans;
    }

    void xuatHoaDon(String hd) {
        try {
            Formatter x = new Formatter("hoadon.txt");
            x.format(hoaDon());
            x.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(NopHocPhiLayout.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    String masv, sotien, hocky;

    void getTxt() {
        masv = txtMsv.getText();
        sotien = txtSoTien.getText();
        hocky = txtKiHoc.getText();
    }

    void clearTxt() {
        txtMsv.setText("");
        txtSoTien.setText("");
        txtKiHoc.setText("");
    }

    //return the new mahoadon to into datebase
    int createKeyMahd() {
        ResultSet rs = conn.queryData("select max(mahd) from hoadon");
        try {
            if (rs.next()) {
                int key = rs.getInt("max(mahd)");
                return key + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NopHocPhiLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNop = new javax.swing.JButton();
        txtMsv = new javax.swing.JTextField();
        txtSoTien = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtKiHoc = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        tbl_hoadon = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaHoaDon = new javax.swing.JTextArea();
        btnXuatHoaDon = new javax.swing.JButton();

        setBackground(new java.awt.Color(232, 240, 254));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã sinh viên : ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số tiền đóng : ");

        btnNop.setBackground(new java.awt.Color(76, 139, 245));
        btnNop.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNop.setForeground(new java.awt.Color(255, 255, 255));
        btnNop.setText("Nộp");
        btnNop.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNopActionPerformed(evt);
            }
        });

        txtMsv.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtSoTien.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Kì học :");

        txtKiHoc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtKiHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKiHocActionPerformed(evt);
            }
        });

        btn_timkiem.setBackground(new java.awt.Color(76, 139, 245));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_hoadon.setViewportView(jTable1);

        txtaHoaDon.setColumns(20);
        txtaHoaDon.setRows(5);
        jScrollPane1.setViewportView(txtaHoaDon);

        btnXuatHoaDon.setBackground(new java.awt.Color(76, 139, 245));
        btnXuatHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatHoaDon.setText("Xuất hoá đơn");
        btnXuatHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXuatHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtKiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMsv, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_timkiem)))
                            .addComponent(tbl_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNop, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXuatHoaDon)
                        .addGap(69, 69, 69)))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(txtMsv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtKiHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNop)
                            .addComponent(btn_timkiem))
                        .addGap(27, 27, 27)
                        .addComponent(tbl_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnXuatHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNopActionPerformed
        getTxt();
        ResultSet rs = conn.queryData("select * from sinhvien where masv = " + masv);
        if (masv.equals("") || sotien.equals("") || hocky.equals("")) {
            JOptionPane.showMessageDialog(txtSoTien, "Không được để trống");
        } else {
            try {
                if (!rs.next()) {
                    JOptionPane.showMessageDialog(txtSoTien, "Mã sinh viên không tồn t  ại");
                } else {
                    int maHD = createKeyMahd();
                    System.out.println(maHD + "----");
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String sql = "insert into hoadon values(" + maHD + "," + sotien + "," + hocky + ", '" + dateFormat.format(date) + "'," + masv + ")";
                    int check = conn.UpdateData(sql);
                    String sqlUpdateCongno = "UPDATE sinhvien SET congno = congno - " + sotien + " WHERE masv = " + masv;
                    int check1 = conn.UpdateData(sqlUpdateCongno);
                    if (check != 0 && check1 != 0) {
                        JOptionPane.showMessageDialog(txtSoTien, "Nộp tiền thành công!");
                    } else {
                        JOptionPane.showMessageDialog(txtSoTien, "Lỗi! kiểm tra lại ");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(NopHocPhiLayout.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hdcon.hienThiHD(jTable1, "select * from hoadon");
        txtaHoaDon.setText(hoaDon());
        clearTxt();
    }//GEN-LAST:event_btnNopActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        getTxt();
        if (masv.equals("")) {
            JOptionPane.showMessageDialog(txtSoTien, "Không được để trống !");
        }
        hdcon.hienThiHD(jTable1, "select * from hoadon where masv = " + masv);
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btnXuatHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatHoaDonActionPerformed
        xuatHoaDon(masv);
        JOptionPane.showMessageDialog(txtSoTien, "Xuất hoá đơn thành công");
    }//GEN-LAST:event_btnXuatHoaDonActionPerformed

    private void txtKiHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKiHocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKiHocActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNop;
    private javax.swing.JButton btnXuatHoaDon;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JScrollPane tbl_hoadon;
    private javax.swing.JTextField txtKiHoc;
    private javax.swing.JTextField txtMsv;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JTextArea txtaHoaDon;
    // End of variables declaration//GEN-END:variables
}
