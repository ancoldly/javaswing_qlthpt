package Controller;
import Connection.Connections;
import Model.LoginUser;
import Model.ThiSinh;
import View.DoiMatKhau;
import View.Login;
import View.ViewForm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static View.Login.*;

public class Enterlogin extends JFrame {
    public static void Enterlogin() {
        Login login = new Login();
        DoiMatKhau doiMatKhau = new DoiMatKhau();
        ViewForm viewForm = new ViewForm();
        login.setVisible(true);
        Connections.getColection();
        Actions.Actions();
        LoginUser s = new LoginUser();
        Login.xacnhapdangnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                s.setUser(nhaptendangnhap.getText());
                String cauLenhSQL = "Select * from DangNhap where Tendangnhap = '"+nhaptendangnhap.getText()+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                try {
                    while (rs.next()) {
                        s.setUser(rs.getString(1));
                        s.setPassWord(rs.getString(2));
                    }
                    if((Login.nhaptendangnhap.getText().equals(s.getUser()))&&(Login.nhapmatkhau.getText().equals(s.getPassWord()))) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Bạn đã thành công đăng nhập vào hệ thống...");
                        if(nhaptendangnhap.getText().equals("admin")) {
                            viewForm.setVisible(true);
                            login.dispose();
                            ViewForm.HienThi();
                            ViewForm.dm.setRowCount(0);
                            ViewForm.lichthi.setRowCount(0);
                            ViewForm.nguyenvong.setRowCount(0);

                            ViewForm.nhapcccd.setEditable(true);
                            ViewForm.nhapcccd.setText(null);
                            ViewForm.nhaphovaten.setText(null);
                            ViewForm.nhapngaysinh.setSelectedItem("01");
                            ViewForm.nhapthangsinh.setSelectedItem("01");
                            ViewForm.nhapnamsinh.setSelectedItem("1950");
                            ViewForm.gioitinhnam.setSelected(false);
                            ViewForm.gioitinhnu.setSelected(false);
                            ViewForm.nhapdienuutien.setSelectedItem("");
                            ViewForm.nhapkhuvuc.setSelectedItem("");
                            ViewForm.nhapdiachi.setText(null);
                            ViewForm.nhapthpt.setText(null);

                            ViewForm.nhapthutunguyenvong.setText(null);
                            ViewForm.nhaptruongdaihoc.setText(null);
                            ViewForm.nhapmatruongdaihoc.setText(null);
                            ViewForm.nhapnganh.setText(null);
                            ViewForm.nhapmanganh.setText(null);
                            ViewForm.nhapphuongthucxettuyen.setSelectedItem("");
                            ViewForm.nhaptohopmon.setSelectedItem("");
                            ViewForm.nhapthutunguyenvong.setEditable(true);
                            ViewForm.XinChao.setText("XIN CHÀO:  "+s.getUser());
                        } else {
                            viewForm.setVisible(true);
                            login.dispose();
                            ViewForm.An();
                            ThiSinh s = new ThiSinh();
                            s.setCccd(Login.nhaptendangnhap.getText());
                            String cauLenhSQL10 = "Select * from ThongTin where Cccd = '"+s.getCccd()+"'";
                            ResultSet rs10 = Connections.ThucThiLenhSelect(cauLenhSQL10);
                            try {
                                while (rs10.next()) {
                                    s.setCheckCccd(rs10.getString(1));
                                }
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                            if(s.getCccd().equals(s.getCheckCccd())) {
                                s.setCccd(Login.nhaptendangnhap.getText());
                                ViewForm.dm.setRowCount(0);
                                ViewForm.lichthi.setRowCount(0);
                                ViewForm.nguyenvong.setRowCount(0);
                                ViewForm.nhapthutunguyenvong.setText(null);
                                ViewForm.nhaptruongdaihoc.setText(null);
                                ViewForm.nhapmatruongdaihoc.setText(null);
                                ViewForm.nhapnganh.setText(null);
                                ViewForm.nhapmanganh.setText(null);
                                ViewForm.nhapphuongthucxettuyen.setSelectedItem("");
                                ViewForm.nhaptohopmon.setSelectedItem("");
                                ViewForm.nhapthutunguyenvong.setEditable(true);
                                Connections.getColection();
                                String Cccd = Login.nhaptendangnhap.getText();
                                String cauLenhSQLThongTin = "Select * from ThongTin where Cccd = "+Cccd;
                                String cauLenhSQLLichThi = "Select * from LichThi where Cccd = "+Cccd;
                                String cauLenhSQLNguyenVong = "Select * from NguyenVong where Cccd = "+Cccd;

                                ResultSet rs1 = Connections.ThucThiLenhSelect(cauLenhSQLThongTin);
                                ResultSet rs2 = Connections.ThucThiLenhSelect(cauLenhSQLLichThi);
                                ResultSet rs3 = Connections.ThucThiLenhSelect(cauLenhSQLNguyenVong);
                                DefaultTableModel model1 = (DefaultTableModel) ViewForm.tb1.getModel();

                                DefaultTableModel model2 = (DefaultTableModel) ViewForm.tblichthi.getModel();
                                DefaultTableModel model3 = (DefaultTableModel) ViewForm.tbnguyenvong.getModel();
                                Object objListThiSinhTimKiem [] = new Object[15];
                                Object objListLichThiTimKiem [] = new Object[15];
                                Object objListNguyenVongTimKiem [] = new Object[15];
                                try {
                                    while (rs1.next()) {
                                        objListThiSinhTimKiem [0] = rs1.getString(1);
                                        objListThiSinhTimKiem [1] = rs1.getString(2);
                                        objListThiSinhTimKiem [2] = rs1.getString(3);
                                        objListThiSinhTimKiem [3] = rs1.getString(4);
                                        objListThiSinhTimKiem [4] = rs1.getString(5);
                                        objListThiSinhTimKiem [5] = rs1.getString(6);
                                        objListThiSinhTimKiem [6] = rs1.getString(7);
                                        objListThiSinhTimKiem [7] = rs1.getString(8);
                                        model1.addRow(objListThiSinhTimKiem);
                                    }
                                    while (rs2.next()) {
                                        objListLichThiTimKiem [0] = rs2.getString(1);
                                        objListLichThiTimKiem [1] = rs2.getString(2);
                                        objListLichThiTimKiem [2] = rs2.getString(3);
                                        objListLichThiTimKiem [3] = rs2.getString(4);
                                        model2.addRow(objListLichThiTimKiem);
                                    }
                                    while (rs3.next()) {
                                        objListNguyenVongTimKiem [0] = rs3.getString(1);
                                        objListNguyenVongTimKiem [1] = rs3.getString(2);
                                        objListNguyenVongTimKiem [2] = rs3.getString(3);
                                        objListNguyenVongTimKiem [3] = rs3.getString(4);
                                        objListNguyenVongTimKiem [4] = rs3.getString(5);
                                        objListNguyenVongTimKiem [5] = rs3.getString(6);
                                        objListNguyenVongTimKiem [6] = rs3.getString(7);
                                        objListNguyenVongTimKiem [7] = rs3.getString(8);
                                        model3.addRow(objListNguyenVongTimKiem);
                                    }
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                                if(String.valueOf(objListThiSinhTimKiem [3]).equals("Nam")) {
                                    ViewForm.gioitinhnam.setSelected(true);
                                } else if(String.valueOf(objListThiSinhTimKiem [3]).equals("Nữ")) {
                                    ViewForm.gioitinhnu.setSelected(true);
                                }
                                ViewForm.nhapcccd.setText(String.valueOf(objListThiSinhTimKiem [0]));
                                ViewForm.nhapcccd.setEditable(false);
                                ViewForm.nhaphovaten.setText(String.valueOf(objListThiSinhTimKiem [1]));
                                ViewForm.nhapdienuutien.setSelectedItem(String.valueOf(objListThiSinhTimKiem [4]));
                                ViewForm.nhapkhuvuc.setSelectedItem(String.valueOf(objListThiSinhTimKiem [5]));
                                ViewForm.nhapdiachi.setText(String.valueOf(objListThiSinhTimKiem [6]));
                                ViewForm.nhapthpt.setText(String.valueOf(objListThiSinhTimKiem [7]));
                                String Sinhnhat = String.valueOf(objListThiSinhTimKiem [2]);

                                int namsinh1 = Sinhnhat.charAt(0);
                                int namsinh2 = Sinhnhat.charAt(1);
                                int namsinh3 = Sinhnhat.charAt(2);
                                int namsinh4 = Sinhnhat.charAt(3);
                                int thangsinh1 = Sinhnhat.charAt(5);
                                int thangsinh2 = Sinhnhat.charAt(6);
                                int ngaysinh1 = Sinhnhat.charAt(8);
                                int ngaysinh2 = Sinhnhat.charAt(9);
                                String ngay1 = String.valueOf((char) ngaysinh1);
                                String ngay2 = String.valueOf((char) ngaysinh2);
                                String thang1 = String.valueOf((char) thangsinh1);
                                String thang2 = String.valueOf((char) thangsinh2);
                                String nam1 = String.valueOf((char) namsinh1);
                                String nam2 = String.valueOf((char) namsinh2);
                                String nam3 = String.valueOf((char) namsinh3);
                                String nam4 = String.valueOf((char) namsinh4);
                                ViewForm.nhapngaysinh.setSelectedItem(ngay1+ngay2);
                                ViewForm.nhapthangsinh.setSelectedItem(thang1+thang2);
                                ViewForm.nhapnamsinh.setSelectedItem(nam1+nam2+nam3+nam4);
                                ViewForm.XinChao.setText("XIN CHÀO CCCD:  "+s.getCccd());
                                ViewForm.XacNhan.setEnabled(false);
                                ViewForm.NhapLai.setEnabled(false);
                            } else {
                                ViewForm.nhapcccd.setEditable(true);
                                ViewForm.nhapcccd.setText(null);
                                ViewForm.nhaphovaten.setText(null);
                                ViewForm.nhapngaysinh.setSelectedItem("01");
                                ViewForm.nhapthangsinh.setSelectedItem("01");
                                ViewForm.nhapnamsinh.setSelectedItem("1950");
                                ViewForm.gioitinhnam.setSelected(false);
                                ViewForm.gioitinhnu.setSelected(false);
                                ViewForm.nhapdienuutien.setSelectedItem("");
                                ViewForm.nhapkhuvuc.setSelectedItem("");
                                ViewForm.nhapdiachi.setText(null);
                                ViewForm.nhapthpt.setText(null);

                                ViewForm.nhapthutunguyenvong.setText(null);
                                ViewForm.nhaptruongdaihoc.setText(null);
                                ViewForm.nhapmatruongdaihoc.setText(null);
                                ViewForm.nhapnganh.setText(null);
                                ViewForm.nhapmanganh.setText(null);
                                ViewForm.nhapphuongthucxettuyen.setSelectedItem("");
                                ViewForm.nhaptohopmon.setSelectedItem("");
                                ViewForm.nhapthutunguyenvong.setEditable(true);
                                ViewForm.XacNhan.setEnabled(true);
                                ViewForm.NhapLai.setEnabled(true);

                                ViewForm.dm.setRowCount(0);
                                ViewForm.lichthi.setRowCount(0);
                                ViewForm.nguyenvong.setRowCount(0);
                                ViewForm.XinChao.setText("XIN CHÀO CCCD:  "+s.getCccd());
                                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống, vui lòng đăng kí thông tin...");
                            }
                        }
                    } else {
                        if((Login.nhaptendangnhap.getText().equals(""))||(Login.nhapmatkhau.getText().equals(""))) {
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập thông tin đăng nhập...");
                        } else {
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tên đăng nhập hoặc mật khẩu sai, vui lòng thử lại...");
                        }
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        //nhập lại đăng nhập
        Login.nhaplaitaikhoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.nhaptendangnhap.setText(null);
                Login.nhapmatkhau.setText(null);
            }
        });
        //Chuyển form đăng kí
        Login.dangki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout dangkicenter =(CardLayout) cardlayoutcenter.getLayout();
                dangkicenter.show(cardlayoutcenter, "center1");

                CardLayout dangkisouth =(CardLayout)cardlayoutsouth.getLayout();
                dangkisouth.show(cardlayoutsouth, "south1");

                login.setTitle("ĐĂNG KÍ TÀI KHOẢN THÍ SINH");
                tieude.setText("REGISTER ACCOUNT");
            }
        });
        //chuyển form đăng nhập
        Login.dangnhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout dangkicenter =(CardLayout) cardlayoutcenter.getLayout();
                dangkicenter.show(cardlayoutcenter, "center2");

                CardLayout dangkisouth =(CardLayout)cardlayoutsouth.getLayout();
                dangkisouth.show(cardlayoutsouth, "south2");

                login.setTitle("ĐĂNG NHẬP HỆ THỐNG QUẢN LÍ");
                tieude.setText("ACCOUNT LOGIN");
            }
        });
        //đăng kí tài khoản
        Login.xacnhandangki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connections.getColection();
                LoginUser s = new LoginUser();
                s.setCreateUser(nhaptaotendangnhap.getText());
                s.setCreatePassWord(nhaptaomatkhau.getText());
                String undoPass = nhaplaitaomatkhau.getText();
                String cauLenhSQLKiemTra = "Select * from DangNhap where Tendangnhap = '"+s.getCreateUser()+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQLKiemTra);
                try {
                    while (rs.next()) {
                        s.setCheckPassWord(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(s.getCreateUser().equals(s.getCheckPassWord())) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tên đăng nhập đã tồn tại, vui lòng thử tên đăng nhập khác...");
                } else {
                    if(s.getCreateUser().equals("")||s.getCreatePassWord().equals("")) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập thông tin cần đăng kí...");
                    } else {
                        if(undoPass.equals(s.getCreatePassWord())) {
                            String cauLenhSQL = "INSERT INTO DangNhap(Tendangnhap,Matkhau)"+
                                    "VALUES"+
                                    "('"+ s.getCreateUser() + "'"+
                                    ",'"+ s.getCreatePassWord() + "')";
                            Connections.ThucThi3Lenh(cauLenhSQL);
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Bạn đã đăng kí thành công tài khoản," +
                                    "hãy đăng nhập để sử dụng hệ thống...");
                        } else {
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Mật khẩu không trùng nhau, vui lòng nhập đúng mật khẩu đã đặt...");
                        }
                    }
                }
            }
        });
        //nhập lại đăng kí
        Login.nhaplaidangki.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login.nhaptaotendangnhap.setText(null);
                Login.nhaptaomatkhau.setText(null);
                Login.nhaplaitaomatkhau.setText(null);
            }
        });
        //hiển thị mật khẩu form đăng nhập
        hienthimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == hienthimatkhau) {
                    if(hienthimatkhau.isSelected()) {
                        nhapmatkhau.setEchoChar((char)0);
                    } else {
                        nhapmatkhau.setEchoChar('•');
                    }
                }
            }
        });
        ViewForm.DangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int re = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất tài khoản không?", "ĐĂNG XUẤT", JOptionPane.YES_NO_OPTION); 
                if(re == JOptionPane.YES_OPTION) {
                    viewForm.dispose();
                    login.setVisible(true);
                    nhaptendangnhap.setText("");
                    nhapmatkhau.setText("");
                }
            }
        });
        ViewForm.DoiMatKhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doiMatKhau.setVisible(true);
            }
        });
        DoiMatKhau.xacnhandoimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Model.DoiMatKhau s = new Model.DoiMatKhau();
                LoginUser loginUser = new LoginUser();
                loginUser.setUser(Login.nhaptendangnhap.getText());
                s.setMatKhauCu(DoiMatKhau.nhapmatkhaucu.getText());
                s.setMatKhauMoi(DoiMatKhau.nhapmatkhaumoi.getText());
                s.setNhapLaiMatKhauMoi(DoiMatKhau.nhaplaimatkhaumoi.getText());
                String user = Login.nhaptendangnhap.getText();
                String cauLenhSQL = "Select * from DangNhap where Tendangnhap = '" + user + "'";
                ResultSet rs10 = Connections.ThucThiLenhSelect(cauLenhSQL);
                try {
                    while (rs10.next()) {
                        s.setCheckMatKhauCu(rs10.getString(2));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(s.getMatKhauCu().equals(s.getCheckMatKhauCu())) {
                    if(s.getMatKhauCu().equals("")||s.getMatKhauMoi().equals("")) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Hãy nhập thông tin mật khẩu cần đổi...");     
                    } else {
                        if(s.getMatKhauMoi().equals(s.getNhapLaiMatKhauMoi())) {
                            String cauLenhSQL1 = "Update DangNhap set Matkhau = '"+s.getMatKhauMoi()+"' where Tendangnhap = '"+loginUser.getUser()+"'";
                            Connections.ThucThi3Lenh(cauLenhSQL1);
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Đã đổi mật khẩu thành công!");
                            DoiMatKhau.nhapmatkhaucu.setText(null);
                            DoiMatKhau.nhapmatkhaumoi.setText(null);
                            DoiMatKhau.nhaplaimatkhaumoi.setText(null);
                            doiMatKhau.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Mật khẩu mới không trùng nhau,kiểm tra lại...");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Mật khẩu cũ không đúng, kiểm tra lại...");
                }
            }
        });
        DoiMatKhau.nhaplaidoimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoiMatKhau.nhapmatkhaucu.setText(null);
                DoiMatKhau.nhapmatkhaumoi.setText(null);
                DoiMatKhau.nhaplaimatkhaumoi.setText(null);
            }
        });
        DoiMatKhau.thoatdoimatkhau.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DoiMatKhau.nhapmatkhaucu.setText(null);
                DoiMatKhau.nhapmatkhaumoi.setText(null);
                DoiMatKhau.nhaplaimatkhaumoi.setText(null);
                doiMatKhau.dispose();

            }
        });
    }
    public static void main(String[] args) {
        Enterlogin.Enterlogin();
    }
}
