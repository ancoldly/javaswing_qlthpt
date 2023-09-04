package Controller;

import Connection.Connections;
import Model.*;
import View.ViewForm;
import View.Login;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.PropertyPermission;

public class Actions extends JFrame {
    public static void Actions() {
        Connections.getColection();
        //Xác nhận thông tin thí sinh
        ViewForm.XacNhan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connections.getColection();
                ThiSinh s = new ThiSinh();
                String ngay = String.valueOf(ViewForm.nhapngaysinh.getSelectedItem());
                String thang = String.valueOf(ViewForm.nhapthangsinh.getSelectedItem());
                String nam = String.valueOf(ViewForm.nhapnamsinh.getSelectedItem());
                String nhapgioitinh = "";
                if(ViewForm.gioitinhnam.isSelected()) {
                    nhapgioitinh+="Nam";
                }
                if(ViewForm.gioitinhnu.isSelected()) {
                    nhapgioitinh+="Nữ";
                }
                s.setCccd(ViewForm.nhapcccd.getText());
                s.setHoVaTen(ViewForm.nhaphovaten.getText());
                s.setSinhNhat(nam+"/"+thang+"/"+ngay);
                s.setGioiTinh(nhapgioitinh);
                s.setDienUuTien(String.valueOf(ViewForm.nhapdienuutien.getSelectedItem()));
                s.setKhuVuc(String.valueOf(ViewForm.nhapkhuvuc.getSelectedItem()));
                s.setDiaChi(ViewForm.nhapdiachi.getText());
                s.setThpt(ViewForm.nhapthpt.getText());
                String cauLenhSQLKiemTra = "Select * from ThongTin where Cccd = '"+s.getCccd()+"'";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQLKiemTra);
                try {
                    while (rs.next()) {
                        s.setCheckCccd(rs.getString(1));
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                if(s.getCccd().equals(s.getCheckCccd())) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD đã tồn tại trong hệ thống, vui lòng kiểm tra lại thông tin...");
                } else {
                    if(s.getCccd().equals("")||s.getSinhNhat().equals("")||s.getHoVaTen().equals("")||s.getGioiTinh().equals("")||s.getDienUuTien().equals("")||s.getKhuVuc().equals("")||
                    s.getDiaChi().equals("")||s.getThpt().equals("")) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin không được để trống, vui lòng nhập đầy đủ thông tin...");
                    } else {
                        String cauLenhSQL = "INSERT INTO ThongTin(Cccd,Hovaten,Sinhnhat,Gioitinh,Dienuutien,Khuvuc,Diachi,Thpt)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'"+
                                ",N'"+ s.getHoVaTen() + "'"+
                                ",'"+ s.getSinhNhat() + "'"+
                                ",N'"+ s.getGioiTinh() + "'"+
                                ",N'"+ s.getDienUuTien() + "'"+
                                ",N'"+ s.getKhuVuc() + "'"+
                                ",N'"+ s.getDiaChi() + "'"+
                                ",N'"+ s.getThpt() + "')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.dm.addRow(new String [] {s.getCccd(),s.getHoVaTen(),s.getSinhNhat(),s.getGioiTinh(),
                                s.getDienUuTien(),s.getKhuVuc(),s.getDiaChi(),s.getThpt()});
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin của CCCD: "+s.getCccd()+" đã được thêm thành công...");
                    }
                }
            }
        });
        //Nhập lại thông tin thí sinh
        ViewForm.NhapLai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                ViewForm.nhapthongtinthisinh.setText(null);
            }
        });
        //Xóa tất cả thông tin thí sinh
        ViewForm.XoaTatCa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.dm.setRowCount(0);
                String cauLenhSQL = "Delete from ThongTin";
                Connections.ThucThi3Lenh(cauLenhSQL);
                ViewForm.lichthi.setRowCount(0);
                String cauLenhSQL1 = "Delete from LichThi";
                Connections.ThucThi3Lenh(cauLenhSQL1);
                ViewForm.nguyenvong.setRowCount(0);
                String cauLenhSQL2 = "Delete from NguyenVong";
                Connections.ThucThi3Lenh(cauLenhSQL2);
                ViewForm.diemthi.setRowCount(0);
                String cauLenhSQL3 = "Delete from DiemThi";
                Connections.ThucThi3Lenh(cauLenhSQL3);
                ViewForm.diemhb.setRowCount(0);
                String cauLenhSQL4 = "Delete from HocBa";
                Connections.ThucThi3Lenh(cauLenhSQL4);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin đã được xóa...");
            }
        });
        //xóa thông tin thí sinh đã chọn
        ViewForm.Xoa1ThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = ViewForm.tb1.getSelectedRow();
                int DSViTriXoaThongTin [] = ViewForm.tb1.getSelectedRows();
                if(removeIndex == -1 ) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn thông tin thí sinh cần xóa!");
                } else {
                    for(int i=DSViTriXoaThongTin.length -1;i >=0; i--) {
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tb1.getModel();
                        String CccdThiSinh = ViewForm.tb1.getValueAt(DSViTriXoaThongTin[i],0).toString();
                        String cauLenhSQL = "Delete from ThongTin where Cccd = "+"'"+CccdThiSinh+"'";
                        String cauLenhSQL1 = "Delete from LichThi where Cccd = "+"'"+CccdThiSinh+"'";
                        String cauLenhSQL2 = "Delete from DiemThi where Cccd = "+"'"+CccdThiSinh+"'";
                        String cauLenhSQL3 = "Delete from HocBa where Cccd = "+"'"+CccdThiSinh+"'";
                        String cauLenhSQL4 = "Delete from NguyenVong where Cccd = "+"'"+CccdThiSinh+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        Connections.ThucThi3Lenh(cauLenhSQL1);
                        Connections.ThucThi3Lenh(cauLenhSQL2);
                        Connections.ThucThi3Lenh(cauLenhSQL3);
                        Connections.ThucThi3Lenh(cauLenhSQL4);
                    }
                    ViewForm.dm.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Đã xóa thông tin bạn chọn...");
                }
            }
        });
        //cập nhật danh sách thông tin thí sinh từ SQL
        ViewForm.CapNhatThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.dm.setRowCount(0);
                Connections.getColection();
                String cauLenhSQL = "Select * from ThongTin";
                ResultSet rs =  Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) ViewForm.tb1.getModel();
                Object objListThongTin [] = new Object[10];
                try {
                    while (rs.next()) {
                        objListThongTin [0] = rs.getString(1);
                        objListThongTin [1] = rs.getString(2);
                        objListThongTin [2] = rs.getString(3);
                        objListThongTin [3] = rs.getString(4);
                        objListThongTin [4] = rs.getString(5);
                        objListThongTin [5] = rs.getString(6);
                        objListThongTin [6] = rs.getString(7);
                        objListThongTin [7] = rs.getString(8);
                        model.addRow(objListThongTin); //thêm thông tin từ table sql sever vào table thông tinh java
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin đã được hiển thị lên table....");
            }
        });
        //tìm kiếm thông tin thí sinh theo CCCD
        ViewForm.TimKimThongTinThiSinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapthongtinthisinh.getText());
                if(ViewForm.nhapthongtinthisinh.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập vào số CCCD cần tìm kiếm thông tin...");
                } else {
                    String cauLenhSQL10 = "Select * from ThongTin where Cccd = '"+s.getCccd()+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL10);
                    try {
                        while (rs.next()) {
                            s.setCheckCccd(rs.getString(1));
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(s.getCccd().equals(s.getCheckCccd())) {
                        ViewForm.dm.setRowCount(0);
                        ViewForm.lichthi.setRowCount(0);
                        ViewForm.nguyenvong.setRowCount(0);
                        ViewForm.diemthi.setRowCount(0);
                        ViewForm.diemhb.setRowCount(0);
                        Connections.getColection();
                        String Cccd = ViewForm.nhapthongtinthisinh.getText();
                        String cauLenhSQLThongTin = "Select * from ThongTin where Cccd = "+Cccd;
                        String cauLenhSQLLichThi = "Select * from LichThi where Cccd = "+Cccd;
                        String cauLenhSQLNguyenVong = "Select * from NguyenVong where Cccd = "+Cccd;
                        String cauLenhSQLDiemThi = "Select * from DiemThi where Cccd = "+Cccd;
                        String caulenhSQLDiemHB = "Select * from HocBa where Cccd = "+Cccd;
                        ResultSet rs1 = Connections.ThucThiLenhSelect(cauLenhSQLThongTin);
                        ResultSet rs2 = Connections.ThucThiLenhSelect(cauLenhSQLLichThi);
                        ResultSet rs3 = Connections.ThucThiLenhSelect(cauLenhSQLNguyenVong);
                        ResultSet rs4 = Connections.ThucThiLenhSelect(cauLenhSQLDiemThi);
                        ResultSet rs5 = Connections.ThucThiLenhSelect(caulenhSQLDiemHB);
                        DefaultTableModel model1 = (DefaultTableModel) ViewForm.tb1.getModel();
                        DefaultTableModel model2 = (DefaultTableModel) ViewForm.tblichthi.getModel();
                        DefaultTableModel model3 = (DefaultTableModel) ViewForm.tbnguyenvong.getModel();
                        DefaultTableModel model4 = (DefaultTableModel) ViewForm.tbdiemthi.getModel();
                        DefaultTableModel model5 = (DefaultTableModel) ViewForm.tbdiemhb.getModel();
                        Object objListThiSinhTimKiem [] = new Object[15];
                        Object objListLichThiTimKiem [] = new Object[15];
                        Object objListNguyenVongTimKiem [] = new Object[15];
                        Object objListTimKiemDiemThi [] = new Object[15];
                        Object objListHocBaTimKiem [] = new Object[15];
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
                            while (rs4.next()) {
                                objListTimKiemDiemThi [0] = rs4.getString(1);
                                objListTimKiemDiemThi [1] = rs4.getString(2);
                                objListTimKiemDiemThi [2] = rs4.getString(3);
                                objListTimKiemDiemThi [3] = rs4.getString(4);
                                objListTimKiemDiemThi [4] = rs4.getString(5);
                                objListTimKiemDiemThi [5] = rs4.getString(6);
                                objListTimKiemDiemThi [6] = rs4.getString(7);
                                objListTimKiemDiemThi [7] = rs4.getString(8);
                                objListTimKiemDiemThi [8] = rs4.getString(9);
                                objListTimKiemDiemThi [9] = rs4.getString(10);
                                model4.addRow(objListTimKiemDiemThi);
                            }
                            while (rs5.next()) {
                                objListHocBaTimKiem [0] = rs5.getString(1);
                                objListHocBaTimKiem [1] = rs5.getString(2);
                                objListHocBaTimKiem [2] = rs5.getString(3);
                                objListHocBaTimKiem [3] = rs5.getString(4);
                                objListHocBaTimKiem [4] = rs5.getString(5);
                                objListHocBaTimKiem [5] = rs5.getString(6);
                                objListHocBaTimKiem [6] = rs5.getString(7);
                                objListHocBaTimKiem [7] = rs5.getString(8);
                                objListHocBaTimKiem [8] = rs5.getString(9);
                                objListHocBaTimKiem [9] = rs5.getString(10);
                                objListHocBaTimKiem [10] = rs5.getString(11);
                                objListHocBaTimKiem [11] = rs5.getString(12);
                                model5.addRow(objListHocBaTimKiem);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin của CCCD: "+Cccd+" đã được hiển thị lên table.\n" +
                                "Bao gồm thông tin thí sinh,lịch thi,nguyện vọng,điểm thi và học bạ...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống, vui lòng kiểm tra lại...");
                    }

                }
            }
        });
        //sửa thông tin thí sinh
        ViewForm.SuaThongTinThiSinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ngay = String.valueOf(ViewForm.nhapngaysinh.getSelectedItem());
                String thang = String.valueOf(ViewForm.nhapthangsinh.getSelectedItem());
                String nam = String.valueOf(ViewForm.nhapnamsinh.getSelectedItem());
                String nhapgioitinh = "";
                if(ViewForm.gioitinhnam.isSelected()) {
                    nhapgioitinh+="Nam";
                }
                if(ViewForm.gioitinhnu.isSelected()) {
                    nhapgioitinh+="Nữ";
                }

                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapcccd.getText());
                s.setHoVaTen(ViewForm.nhaphovaten.getText());
                s.setSinhNhat(nam+"/"+thang+"/"+ngay);
                s.setGioiTinh(nhapgioitinh);
                s.setDienUuTien(String.valueOf(ViewForm.nhapdienuutien.getSelectedItem()));
                s.setKhuVuc(String.valueOf(ViewForm.nhapkhuvuc.getSelectedItem()));
                s.setDiaChi(ViewForm.nhapdiachi.getText());
                s.setThpt(ViewForm.nhapthpt.getText());
                //
                int removeIndex = ViewForm.tb1.getSelectedRow();
                String cauLenhSQL = "Update ThongTin" +
                        " set Hovaten = N'"+ s.getHoVaTen() + "'"+
                        ", Sinhnhat = '"+ s.getSinhNhat()+ "'" +
                        ", Gioitinh = N'"+ s.getGioiTinh()+ "'" +
                        ", Dienuutien = N'"+s.getDienUuTien()+ "'" +
                        ", Khuvuc = N'"+ s.getKhuVuc()+ "'" +
                        ", Diachi = N'"+ s.getDiaChi()+ "'" +
                        ", Thpt = N'"+ s.getThpt()+ "'" +
                        " Where Cccd = "+ViewForm.nhapcccd.getText();
                Connections.ThucThi3Lenh(cauLenhSQL);
                String cauLenhSQLHB = "Update HocBa"+
                        " set Hovaten = N'"+s.getHoVaTen()+"'"+
                        " where Cccd = "+ViewForm.nhapcccd.getText();
                Connections.ThucThi3Lenh(cauLenhSQLHB);
                ViewForm.dm.removeRow(removeIndex);
                ViewForm.dm.addRow(new String [] {s.getCccd(),s.getHoVaTen(),s.getSinhNhat(),
                        s.getGioiTinh(),s.getDienUuTien(),s.getKhuVuc(),s.getDiaChi(),s.getThpt()});
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sửa thông tin thành công...");
            }
        });
        //xác nhận tạo lịch thi
        ViewForm.XacNhanLichThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connections.getColection();
                MonThi s = new MonThi();
                s.setCccd(ViewForm.nhapcccd.getText());
                if(s.getCccd().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Hãy kiểm tra lại thông tin thí sinh cần tạo lịch thi...");
                } else {
                    if(ViewForm.CheckBox1.isSelected()) {
                        s.setVan(ViewForm.monvan.getText());
                        s.setNgayThi(ViewForm.ngaythivan.getText());
                        s.setGioThi(ViewForm.giothivan.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getVan() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getVan(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox2.isSelected()) {
                        s.setToan(ViewForm.montoan.getText());
                        s.setNgayThi(ViewForm.ngaythitoan.getText());
                        s.setGioThi(ViewForm.giothitoan.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getToan() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getToan(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox3.isSelected()) {
                        s.setLy(ViewForm.monly.getText());
                        s.setNgayThi(ViewForm.ngaythily.getText());
                        s.setGioThi(ViewForm.giothily.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getLy() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getLy(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox4.isSelected()) {
                        s.setHoa(ViewForm.monhoa.getText());
                        s.setNgayThi(ViewForm.ngaythihoa.getText());
                        s.setGioThi(ViewForm.giothihoa.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getHoa() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getHoa(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox5.isSelected()) {
                        s.setSinh(ViewForm.monsinh.getText());
                        s.setNgayThi(ViewForm.ngaythisinh.getText());
                        s.setGioThi(ViewForm.giothisinh.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getSinh() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getSinh(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox6.isSelected()) {
                        s.setSu(ViewForm.monsu.getText());
                        s.setNgayThi(ViewForm.ngaythisu.getText());
                        s.setGioThi(ViewForm.giothisu.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getSu() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getSu(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox7.isSelected()) {
                        s.setDia(ViewForm.mondia.getText());
                        s.setNgayThi(ViewForm.ngaythidia.getText());
                        s.setGioThi(ViewForm.giothidia.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getDia() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getDia(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox8.isSelected()) {
                        s.setGdcd(ViewForm.moncongdan.getText());
                        s.setNgayThi(ViewForm.ngaythicongdan.getText());
                        s.setGioThi(ViewForm.giothicongdan.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'" +
                                ",N'"+ s.getGdcd() +"'" +
                                ",'"+ s.getNgayThi() +"'" +
                                ",'"+ s.getGioThi() +"')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String [] {s.getCccd(),s.getGdcd(),s.getNgayThi(),s.getGioThi()});
                    }
                    if(ViewForm.CheckBox9.isSelected()) {
                        s.setAnh(ViewForm.monanh.getText());
                        s.setNgayThi(ViewForm.ngaythianh.getText());
                        s.setGioThi(ViewForm.giothianh.getText());
                        String cauLenhSQL = "INSERT INTO LichThi(Cccd,Monthi,Ngaythi,Giothi)" +
                                "VALUES" +
                                "('" + s.getCccd() + "'" +
                                ",N'" + s.getAnh() + "'" +
                                ",'" + s.getNgayThi() + "'" +
                                ",'" + s.getGioThi() + "')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.lichthi.addRow(new String[]{s.getCccd(), s.getAnh(), s.getNgayThi(), s.getGioThi()});
                    }
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Đã tạo lịch thi thành công...");
                }
            }
        });
        //nhập lại thông tin môn thi
        ViewForm.NhapLaiLichThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.CheckBox1.setSelected(false);
                ViewForm.CheckBox2.setSelected(false);
                ViewForm.CheckBox3.setSelected(false);
                ViewForm.CheckBox4.setSelected(false);
                ViewForm.CheckBox5.setSelected(false);
                ViewForm.CheckBox6.setSelected(false);
                ViewForm.CheckBox7.setSelected(false);
                ViewForm.CheckBox8.setSelected(false);
                ViewForm.CheckBox9.setSelected(false);
            }
        });
        //Xóa môn thi đã chọn
        ViewForm.Xoa1LichThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int DSViTriXoaMonThi [] = ViewForm.tblichthi.getSelectedRows();
                int removeIndex = ViewForm.tblichthi.getSelectedRow();
                if(removeIndex == -1 ) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn môn thi cần xóa!");
                } else {
                    for(int i=DSViTriXoaMonThi.length-1;i>=0;i--) {
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tblichthi.getModel();
                        String CccdLichThi = ViewForm.tblichthi.getValueAt(DSViTriXoaMonThi[i],0).toString();
                        String MonLichThi = ViewForm.tblichthi.getValueAt(DSViTriXoaMonThi[i],1).toString();
                        String cauLenhSQL = "Delete from LichThi where Monthi = N'"+MonLichThi+"' and Cccd = '"+CccdLichThi+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                    }
                    ViewForm.lichthi.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Môn thi bạn chọn đã được xóa...");
                }
            }
        });
        //xóa tất cả lịch thi
        ViewForm.XoaTatCaLichThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.lichthi.setRowCount(0);
                String cauLenhSQL = "Delete from LichThi";
                Connections.ThucThi3Lenh(cauLenhSQL);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả lịch thi đã được xóa...");
            }
        });
        //cập nhật danh sách lịch thi
        ViewForm.CapNhatLichThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.lichthi.setRowCount(0);
                Connections.getColection();
                String cauLenhSQL = "Select * from LichThi";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) ViewForm.tblichthi.getModel();
                Object objListLichThi [] = new Object[10];
                try{
                    while(rs.next()) {
                        objListLichThi [0] = rs.getString(1);
                        objListLichThi [1] = rs.getString(2);
                        objListLichThi [2] = rs.getString(3);
                        objListLichThi [3] = rs.getString(4);
                        model.addRow(objListLichThi);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả lịch thi đã được hiển thị lên table.");
            }
        });
        //Tìm kiếm lịch thi
        ViewForm.TimKiemLichThiTheoCCCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapthongtinlichthi.getText());
                if(ViewForm.nhapthongtinlichthi.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập số CCCD cần tìm kiếm lịch thi...");
                } else {
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
                        ViewForm.lichthi.setRowCount(0);
                        Connections.getColection();
                        String Cccd = ViewForm.nhapthongtinlichthi.getText();
                        String cauLenhSQL = "Select * from LichThi where Cccd = "+Cccd;
                        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tblichthi.getModel();
                        Object objListLichThiTimKiem [] = new Object[10];
                        try {
                            while(rs.next()) {
                                objListLichThiTimKiem [0] = rs.getString(1);
                                objListLichThiTimKiem [1] = rs.getString(2);
                                objListLichThiTimKiem [2] = rs.getString(3);
                                objListLichThiTimKiem [3] = rs.getString(4);
                                model.addRow(objListLichThiTimKiem);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin lịch thi của CCCD: "+Cccd+" đã được hiển thị lên table...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống...");
                    }
                }
            }
        });
        //xác nhận đăng kí nguyện vọng
        ViewForm.xacnhandangkinv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connections.getColection();
                NguyenVong s = new NguyenVong();
                s.setCccd(ViewForm.nhapcccd.getText());
                if(s.getCccd().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng kiểm tra lại thông tin thí sinh cần đăng kí nguyện vọng...");
                } else {
                    s.setThuTuNguyenVong(ViewForm.nhapthutunguyenvong.getText());
                    s.setTruongDaiHoc(ViewForm.nhaptruongdaihoc.getText());
                    s.setMaTruongDaiHoc(ViewForm.nhapmatruongdaihoc.getText());
                    s.setNganh(ViewForm.nhapnganh.getText());
                    s.setMaNganh(ViewForm.nhapmanganh.getText());
                    s.setPhuongThucXetTuyen(String.valueOf(ViewForm.nhapphuongthucxettuyen.getSelectedItem()));
                    s.setToHopMon(String.valueOf(ViewForm.nhaptohopmon.getSelectedItem()));
                    String cauLenhSQL = "INSERT INTO NguyenVong(Cccd,Thutunguyenvong,Truongdaihoc,Matruong,Nganh,Manganh,Phuongthuc,Tohopmon)"+
                            "VALUES"+
                            "('"+ s.getCccd() + "'"+
                            ",'"+ s.getThuTuNguyenVong() + "'"+
                            ",N'"+ s.getTruongDaiHoc() + "'"+
                            ",'"+ s.getMaTruongDaiHoc()+ "'"+
                            ",N'"+ s.getNganh() + "'"+
                            ",'"+ s.getMaNganh() + "'"+
                            ",N'"+ s.getPhuongThucXetTuyen() + "'"+
                            ",N'"+ s.getToHopMon() + "')";
                    Connections.ThucThi3Lenh(cauLenhSQL);
                    ViewForm.nguyenvong.addRow(new String [] {s.getCccd() ,s.getThuTuNguyenVong(),s.getTruongDaiHoc(),s.getMaTruongDaiHoc(),s.getNganh(),s.getMaNganh(),s.getPhuongThucXetTuyen(),s.getToHopMon()});
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin nguyện vọng đã được thêm thành công...");
                }
            }
        });
        //nhập lại thông tin nguyện vọng
        ViewForm.nhaplaithongtinnv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.nhapthutunguyenvong.setText(null);
                ViewForm.nhaptruongdaihoc.setText(null);
                ViewForm.nhapmatruongdaihoc.setText(null);
                ViewForm.nhapnganh.setText(null);
                ViewForm.nhapmanganh.setText(null);
                ViewForm.nhapphuongthucxettuyen.setSelectedItem("");
                ViewForm.nhaptohopmon.setSelectedItem("");
                ViewForm.nhapthutunguyenvong.setEditable(true);
            }
        });
        //Xóa nguyện vọng đã chọn
        ViewForm.xoanguyenvong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = ViewForm.tbnguyenvong.getSelectedRow();
                int DSViTriXoaNguyenVong [] = ViewForm.tbnguyenvong.getSelectedRows();
                if(removeIndex == -1) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn nguyện vọng cần xóa!");
                } else {
                    for(int i=DSViTriXoaNguyenVong.length -1;i>=0;i--) {
                        String CccdNguyenVong = ViewForm.tbnguyenvong.getValueAt(DSViTriXoaNguyenVong[i],0).toString();
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tbnguyenvong.getModel();
                        String Thutunv = ViewForm.tbnguyenvong.getValueAt(DSViTriXoaNguyenVong[i],1).toString();
                        String cauLenhSQL = "Delete from NguyenVong where Thutunguyenvong = '"+Thutunv+"' and Cccd = '"+CccdNguyenVong+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                    }
                    ViewForm.nguyenvong.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Nguyện vọng bạn chọn đã được xóa...");
                }
            }
        });
        //xóa tất cả nguyện vọng
        ViewForm.xoatatcanv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.nguyenvong.setRowCount(0);
                String cauLenhSQL = "Delete from NguyenVong";
                Connections.ThucThi3Lenh(cauLenhSQL);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin nguyện vọng đã được xóa...");
            }
        });
        //cập nhật danh sách nguyện vọng
        ViewForm.capnhatnguyenvong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.nguyenvong.setRowCount(0);
                Connections.getColection();
                String cauLenhSQL = "Select * from NguyenVong";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) ViewForm.tbnguyenvong.getModel();
                Object objListNguyenVong [] = new Object[10];
                try {
                    while (rs.next()) {
                        objListNguyenVong [0] = rs.getString(1);
                        objListNguyenVong [1] = rs.getString(2);
                        objListNguyenVong [2] = rs.getString(3);
                        objListNguyenVong [3] = rs.getString(4);
                        objListNguyenVong [4] = rs.getString(5);
                        objListNguyenVong [5] = rs.getString(6);
                        objListNguyenVong [6] = rs.getString(7);
                        objListNguyenVong [7] = rs.getString(8);
                        model.addRow(objListNguyenVong);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin nguyện vọng đã được hiển thị lên table...");
            }
        });
        //tìm kiếm thông tin nguyện vọng
        ViewForm.timkiemthongtinnv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapthongtinnv.getText());
                if(ViewForm.nhapthongtinnv.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập số CCCD cần tìm kiếm thông tin nguyện vọng...");
                } else {
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
                        ViewForm.nguyenvong.setRowCount(0);
                        Connections.getColection();
                        String Cccd = ViewForm.nhapthongtinnv.getText();
                        String cauLenhSQL = "Select * from NguyenVong where Cccd = "+Cccd;
                        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tbnguyenvong.getModel();
                        Object objListNguyenVongTimKiem [] = new Object [10];
                        try {
                            while (rs.next()) {
                                objListNguyenVongTimKiem [0] = rs.getString(1);
                                objListNguyenVongTimKiem [1] = rs.getString(2);
                                objListNguyenVongTimKiem [2] = rs.getString(3);
                                objListNguyenVongTimKiem [3] = rs.getString(4);
                                objListNguyenVongTimKiem [4] = rs.getString(5);
                                objListNguyenVongTimKiem [5] = rs.getString(6);
                                objListNguyenVongTimKiem [6] = rs.getString(7);
                                objListNguyenVongTimKiem [7] = rs.getString(8);
                                model.addRow(objListNguyenVongTimKiem);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin nguyện vọng của CCCD: "+Cccd+" đã được hiển thị lên table...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống...");
                    }
                }
            }
        });
        //sửa thông tin nguyện vọng
        ViewForm.suathongtinnv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NguyenVong s = new NguyenVong();
                s.setCccd(ViewForm.nhapcccd.getText());
                s.setThuTuNguyenVong(ViewForm.nhapthutunguyenvong.getText());
                s.setTruongDaiHoc(ViewForm.nhaptruongdaihoc.getText());
                s.setMaTruongDaiHoc(ViewForm.nhapmatruongdaihoc.getText());
                s.setNganh(ViewForm.nhapnganh.getText());
                s.setMaNganh(ViewForm.nhapmanganh.getText());
                s.setPhuongThucXetTuyen(String.valueOf(ViewForm.nhapphuongthucxettuyen.getSelectedItem()));
                s.setToHopMon(String.valueOf(ViewForm.nhaptohopmon.getSelectedItem()));
                int removeIndex = ViewForm.tbnguyenvong.getSelectedRow();
                String cauLenhSQL = "Update NguyenVong" +
                        " set Truongdaihoc = N'"+ s.getTruongDaiHoc()+ "'" +
                        ", Matruong = '"+ s.getMaTruongDaiHoc()+ "'" +
                        ", Nganh = N'"+ s.getNganh()+ "'" +
                        ", Manganh = '"+ s.getMaNganh()+ "'" +
                        ", Phuongthuc = N'"+ s.getPhuongThucXetTuyen()+ "'" +
                        ", Tohopmon = N'"+ s.getToHopMon()+ "'" +
                        " Where Cccd = '"+ViewForm.nhapcccd.getText()+"' and Thutunguyenvong = '"+ViewForm.nhapthutunguyenvong.getText()+"'";
                ViewForm.nguyenvong.removeRow(removeIndex);
                ViewForm.nguyenvong.addRow(new String [] {s.getCccd() ,s.getThuTuNguyenVong(),s.getTruongDaiHoc(),s.getMaTruongDaiHoc(),s.getNganh(),s.getMaNganh(),s.getPhuongThucXetTuyen(),s.getToHopMon()});
                Connections.ThucThi3Lenh(cauLenhSQL);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sửa nguyện vọng thành công...");
            }
        });
        //xác nhận nhập điểm thi
        ViewForm.XacNhanNhapDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connections.getColection();
                DiemThi s = new DiemThi();
                ThiSinh thiSinh = new ThiSinh();
                s.setCccd(ViewForm.nhapcccd.getText());
                if(s.getCccd().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng kiểm tra lại thông tin thí sinh cần nhập điểm thi...");
                } else {
                    s.setDiemToan(ViewForm.nhapdiemtoan.getText());
                    s.setDiemVan(ViewForm.nhapdiemvan.getText());
                    s.setDiemAnh(ViewForm.nhapdiemanh.getText());
                    s.setDiemLy(ViewForm.nhapdiemly.getText());
                    s.setDiemHoa(ViewForm.nhapdiemhoa.getText());
                    s.setDiemSinh(ViewForm.nhapdiemsinh.getText());
                    s.setDiemSu(ViewForm.nhapdiemsu.getText());
                    s.setDiemDia(ViewForm.nhapdiemdia.getText());
                    s.setDiemGdcd(ViewForm.nhapdiemgdcd.getText());
                    s.setDiemAnh(ViewForm.nhapdiemanh.getText());
                    String cauLenhSQLKiemTra = "Select * from DiemThi where Cccd = '"+s.getCccd()+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQLKiemTra);
                    try {
                        while (rs.next()) {
                            thiSinh.setCheckCccd(rs.getString(1));
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(s.getCccd().equals(thiSinh.getCheckCccd())) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Điểm thi của thi sinh đã tồn tại trong hệ thống, vui lòng kiểm tra lại...");
                    } else {
                        String cauLenhSQL = "INSERT INTO DiemThi(Cccd,Diemtoan,Diemvan,Diemanh,Diemly,Diemhoa,Diemsinh,Diemsu,Diemdia,Diemgdcd)"+
                                "VALUES"+
                                "('"+ s.getCccd() + "'"+
                                ",'"+ s.getDiemToan() + "'"+
                                ",'"+ s.getDiemVan() + "'"+
                                ",'"+ s.getDiemAnh() + "'"+
                                ",'"+ s.getDiemLy() + "'"+
                                ",'"+ s.getDiemHoa() + "'"+
                                ",'"+ s.getDiemSinh() + "'"+
                                ",'"+ s.getDiemSu() + "'"+
                                ",'"+ s.getDiemDia() + "'"+
                                ",'"+ s.getDiemGdcd() + "')";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                        ViewForm.diemthi.addRow(new String [] {s.getCccd(), String.valueOf(s.getDiemToan()),String.valueOf(s.getDiemVan()),String.valueOf(s.getDiemAnh()),String.valueOf(s.getDiemLy()),
                                String.valueOf(s.getDiemHoa()),String.valueOf(s.getDiemSinh()),String.valueOf(s.getDiemSu()),String.valueOf(s.getDiemDia()),String.valueOf(s.getDiemGdcd())});
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Điêm thi của bạn đã được thêm thành công...");
                    }
                }
            }
        });
        //nhập lại thông tin điểm thi
        ViewForm.NhapLaiDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.nhapdiemtoan.setText(null);
                ViewForm.nhapdiemvan.setText(null);
                ViewForm.nhapdiemly.setText(null);
                ViewForm.nhapdiemhoa.setText(null);
                ViewForm.nhapdiemsinh.setText(null);
                ViewForm.nhapdiemanh.setText(null);
                ViewForm.nhapdiemsu.setText(null);
                ViewForm.nhapdiemdia.setText(null);
                ViewForm.nhapdiemgdcd.setText(null);
            }
        });
        //xóa điểm thi đã chọn
        ViewForm.XoaDiemDaChon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = ViewForm.tbdiemthi.getSelectedRow();
                int DSViTriXoaDiem [] = ViewForm.tbdiemthi.getSelectedRows();
                if(removeIndex == -1 ) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn thông tin điểm cần xóa!");
                } else {
                    for(int i=DSViTriXoaDiem.length-1;i>=0;i--) {
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tbdiemthi.getModel();
                        String CccdDiem = ViewForm.tbdiemthi.getValueAt(DSViTriXoaDiem[i],0).toString();
                        String cauLenhSQL = "Delete from DiemThi where Cccd= "+"'"+CccdDiem+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                    }
                    ViewForm.diemthi.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin điểm thi bạn chọn đã được xóa...");
                }
            }
        });
        //xóa tất cả điểm thi
        ViewForm.XoaTaCaDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.diemthi.setRowCount(0);
                String cauLenhSQL = "Delete from DiemThi";
                Connections.ThucThi3Lenh(cauLenhSQL);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin điểm thi đã được xóa...");
            }
        });
        //Cập nhật danh sách điểm thi
        ViewForm.CapNhatDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.diemthi.setRowCount(0);
                Connections.getColection();
                String cauLenhSQL = "Select * from DiemThi";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) ViewForm.tbdiemthi.getModel();
                Object objListDiem [] = new Object[10];
                try{
                    while (rs.next()) {
                        objListDiem [0] = rs.getString(1);
                        objListDiem [1] = rs.getString(2);
                        objListDiem [2] = rs.getString(3);
                        objListDiem [3] = rs.getString(4);
                        objListDiem [4] = rs.getString(5);
                        objListDiem [5] = rs.getString(6);
                        objListDiem [6] = rs.getString(7);
                        objListDiem [7] = rs.getString(8);
                        objListDiem [8] = rs.getString(9);
                        objListDiem [9] = rs.getString(10);
                        model.addRow(objListDiem);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin điểm thi đã được hiển thị lên table...");
            }
        });
        //tìm kiếm điểm thí sinh
        ViewForm.TimKiemDiemTheoCccd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapthongtindiem.getText());
                if(ViewForm.nhapthongtindiem.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập số CCCD cần tìm kiếm thông tin điểm thi...");
                } else {
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
                        ViewForm.diemthi.setRowCount(0);
                        Connections.getColection();
                        String Cccd = ViewForm.nhapthongtindiem.getText();
                        String cauLenhSQL = "Select * from DiemThi where Cccd = "+Cccd;
                        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tbdiemthi.getModel();
                        Object objListTimKiemDiem [] = new Object[10];
                        try{
                            while (rs.next()) {
                                objListTimKiemDiem [0] = rs.getString(1);
                                objListTimKiemDiem [1] = rs.getString(2);
                                objListTimKiemDiem [2] = rs.getString(3);
                                objListTimKiemDiem [3] = rs.getString(4);
                                objListTimKiemDiem [4] = rs.getString(5);
                                objListTimKiemDiem [5] = rs.getString(6);
                                objListTimKiemDiem [6] = rs.getString(7);
                                objListTimKiemDiem [7] = rs.getString(8);
                                objListTimKiemDiem [8] = rs.getString(9);
                                objListTimKiemDiem [9] = rs.getString(10);
                                model.addRow(objListTimKiemDiem);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin điểm thi của CCCD: "+Cccd+" đã được hiển thị lên table...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống...");
                    }
                }
            }
        });
        //sửa điểm thi
        ViewForm.SuaDiemThiSinh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiemThi s = new DiemThi();
                s.setCccd(ViewForm.nhapcccd.getText());
                s.setDiemToan(ViewForm.nhapdiemtoan.getText());
                s.setDiemVan(ViewForm.nhapdiemvan.getText());
                s.setDiemLy(ViewForm.nhapdiemly.getText());
                s.setDiemHoa(ViewForm.nhapdiemhoa.getText());
                s.setDiemSinh(ViewForm.nhapdiemsinh.getText());
                s.setDiemSu(ViewForm.nhapdiemsu.getText());
                s.setDiemDia(ViewForm.nhapdiemdia.getText());
                s.setDiemGdcd(ViewForm.nhapdiemgdcd.getText());
                s.setDiemAnh(ViewForm.nhapdiemanh.getText());
                int removeIndex = ViewForm.tbdiemthi.getSelectedRow();
                String cauLenhSQL = "Update DiemThi" +
                        " set Diemtoan = '"+ s.getDiemToan() +"'"+
                        ", Diemvan = '"+ s.getDiemVan()+ "'" +
                        ", Diemanh = '"+ s.getDiemAnh()+ "'" +
                        ", Diemly   = '"+ s.getDiemLy()+ "'" +
                        ", Diemhoa = '"+ s.getDiemHoa()+ "'" +
                        ", Diemsinh = '"+ s.getDiemSinh()+ "'" +
                        ", Diemsu = '"+ s.getDiemSu()+ "'" +
                        ", Diemdia = '"+ s.getDiemDia()+ "'" +
                        ", Diemgdcd = '"+ s.getDiemGdcd()+ "'" +
                        " Where Cccd = "+ViewForm.nhapcccd.getText();
                Connections.ThucThi3Lenh(cauLenhSQL);
                ViewForm.diemthi.removeRow(removeIndex);
                ViewForm.diemthi.addRow(new String [] {s.getCccd(), String.valueOf(s.getDiemToan()),String.valueOf(s.getDiemVan()),String.valueOf(s.getDiemAnh()),String.valueOf(s.getDiemLy()),
                        String.valueOf(s.getDiemHoa()),String.valueOf(s.getDiemSinh()),String.valueOf(s.getDiemSu()),String.valueOf(s.getDiemDia()),String.valueOf(s.getDiemGdcd())});
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sửa điểm thi thành công...");
            }
        });
        //Xác nhận điểm học bạ
        ViewForm.XacNhanNhapDiemHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connections.getColection();
                DiemHocBa s = new DiemHocBa();
                s.setCccd(ViewForm.nhapcccd.getText());
                if(s.getCccd().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng kiểm tra lại thông tin thí sinh cần nhập học ba...");
                } else {
                    s.setHoVaTen(ViewForm.nhaphovaten.getText());
                    s.setMonHoc(String.valueOf(ViewForm.nhapmonhocba.getSelectedItem()));
                    s.setTbhk1lop10(Float.parseFloat(ViewForm.nhaphocky1lop10.getText()));
                    s.setTbhk2lop10(Float.parseFloat(ViewForm.nhaphocky2lop10.getText()));
                    s.setTbhk1lop11(Float.parseFloat(ViewForm.nhaphocky1lop11.getText()));
                    s.setTbhk2lop11(Float.parseFloat(ViewForm.nhaphocky2lop11.getText()));
                    s.setTbhk1lop12(Float.parseFloat(ViewForm.nhaphocky1lop12.getText()));
                    s.setTbhk2lop12(Float.parseFloat(ViewForm.nhaphocky2lop12.getText()));
                    s.setTbcanam12((s.getTbhk1lop12()*2+s.getTbhk2lop12())/3);
                    s.setTb6ky((s.getTbhk1lop10()+s.getTbhk2lop10()+s.getTbhk1lop11()+s.getTbhk2lop11()+s.getTbhk1lop12()+s.getTbhk2lop12())/6);
                    s.setTb5ky((s.getTbhk1lop10()+s.getTbhk2lop10()+s.getTbhk1lop11()+s.getTbhk2lop11()+s.getTbhk1lop12())/5);
                    String cauLenhSQLHB = "INSERT INTO HocBa(Cccd,Hovaten,Monhoc,Tbhk1lop10,Tbhk2lop10,Tbhk1lop11,Tbhk2lop11,Tbhk1lop12,Tbhk2lop12,Tbcanam12,Tb6ky,Tb5ky)"+
                            "VALUES"+
                            "('"+ s.getCccd() + "'"+
                            ",N'"+ s.getHoVaTen() + "'"+
                            ",N'"+ s.getMonHoc() + "'"+
                            ",'"+ s.getTbhk1lop10() + "'"+
                            ",'"+ s.getTbhk2lop10() + "'"+
                            ",'"+ s.getTbhk1lop11() + "'"+
                            ",'"+ s.getTbhk2lop11() + "'"+
                            ",'"+ s.getTbhk1lop12() + "'"+
                            ",'"+ s.getTbhk2lop12() + "'"+
                            ",'"+ s.getTbcanam12() + "'"+
                            ",'"+ s.getTb6ky() + "'"+
                            ",'"+ s.getTb5ky() + "')";
                    Connections.ThucThi3Lenh(cauLenhSQLHB);
                    ViewForm.diemhb.addRow(new String [] {s.getCccd(),s.getHoVaTen(),s.getMonHoc(), String.valueOf(s.getTbhk1lop10()),String.valueOf(s.getTbhk2lop10()),
                            String.valueOf(s.getTbhk1lop11()),String.valueOf(s.getTbhk2lop11()),String.valueOf(s.getTbhk1lop12()),String.valueOf(s.getTbhk2lop12()),String.valueOf(s.getTbcanam12())
                            ,String.valueOf(s.getTb6ky()),String.valueOf(s.getTb5ky())});
                    ViewForm.nhaptrungbinh6ky.setText(String.valueOf(s.getTb6ky()));
                    ViewForm.nhaptrungbinh5ky.setText(String.valueOf(s.getTb5ky()));
                    ViewForm.nhaptrungbinhcanam12.setText(String.valueOf(s.getTbcanam12()));
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin điểm học bạ đã được thêm thành công...");
                }
            }
        });
        //nhập lại điểm học bạ
        ViewForm.NhapLaiDiemHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.nhapmonhocba.setSelectedItem("");
                ViewForm.nhaphocky1lop10.setText(null);
                ViewForm.nhaphocky2lop10.setText(null);
                ViewForm.nhaphocky1lop11.setText(null);
                ViewForm.nhaphocky2lop11.setText(null);
                ViewForm.nhaphocky1lop12.setText(null);
                ViewForm.nhaphocky2lop12.setText(null);
                ViewForm.nhaptrungbinhcanam12.setText(null);
                ViewForm.nhaptrungbinh6ky.setText(null);
                ViewForm.nhaptrungbinh5ky.setText(null);
                ViewForm.nhapmonhocba.setEnabled(true);
            }
        });
        //xóa tất cả điểm học bạ
        ViewForm.XoaTatCaDiemHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.diemhb.setRowCount(0);
                String cauLenhSQL = "Delete from HocBa";
                Connections.ThucThi3Lenh(cauLenhSQL);
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin điểm học bạ đã được xóa...");
            }
        });
        //xóa điểm học bạ đã chọn
        ViewForm.XoaDiemDaChonHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int removeIndex = ViewForm.tbdiemhb.getSelectedRow();
                int DSViTriXoaHocBa [] = ViewForm.tbdiemhb.getSelectedRows();
                if(removeIndex == -1) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Hãy chọn thông tin điểm học bạ cần xóa!");
                } else {
                    for(int i=DSViTriXoaHocBa.length-1;i>=0;i--) {
                        String CccdHocBa = ViewForm.tbdiemhb.getValueAt(DSViTriXoaHocBa [i],0).toString();
                        String MonHocBa = ViewForm.tbdiemhb.getValueAt(DSViTriXoaHocBa [i],2).toString();
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tbdiemhb.getModel();
                        String cauLenhSQL = "Delete from HocBa where Monhoc = N'"+MonHocBa+"' and Cccd = '"+CccdHocBa+"'";
                        Connections.ThucThi3Lenh(cauLenhSQL);
                    }
                    ViewForm.diemhb.removeRow(removeIndex);
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin học bạ bạn chọn đã được xóa...");
                }
            }
        });
        //Cập nhật danh sách điểm học bạ
        ViewForm.CapNhatDiemHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.diemhb.setRowCount(0);
                Connections.getColection();
                String cauLenhSQL = "Select * from HocBa";
                ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                DefaultTableModel model = (DefaultTableModel) ViewForm.tbdiemhb.getModel();
                Object objListHocBa [] = new Object[15];
                try {
                    while(rs.next()) {
                        objListHocBa [0] = rs.getString(1);
                        objListHocBa [1] = rs.getString(2);
                        objListHocBa [2] = rs.getString(3);
                        objListHocBa [3] = rs.getString(4);
                        objListHocBa [4] = rs.getString(5);
                        objListHocBa [5] = rs.getString(6);
                        objListHocBa [6] = rs.getString(7);
                        objListHocBa [7] = rs.getString(8);
                        objListHocBa [8] = rs.getString(9);
                        objListHocBa [9] = rs.getString(10);
                        objListHocBa [10] = rs.getString(11);
                        objListHocBa [11] = rs.getString(12);
                        model.addRow(objListHocBa);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin hoc bạ đã được hiển thị lên table...");
            }
        });
        //tìm kiếm điểm học ba
        ViewForm.TimKiemDiemTheoCccdHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapthongtindiemhb.getText());
                if(ViewForm.nhapthongtindiemhb.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập số CCCD cần tìm kiếm thông tin học bạ...");
                } else {
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
                        ViewForm.diemhb.setRowCount(0);
                        Connections.getColection();
                        String Cccd = ViewForm.nhapthongtindiemhb.getText();
                        String cauLenhSQL = "Select * from HocBa where Cccd = "+Cccd;
                        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                        DefaultTableModel model = (DefaultTableModel) ViewForm.tbdiemhb.getModel();
                        Object objListHocBaTimKiem [] = new Object[15];
                        try {
                            while (rs.next()) {
                                objListHocBaTimKiem [0] = rs.getString(1);
                                objListHocBaTimKiem [1] = rs.getString(2);
                                objListHocBaTimKiem [2] = rs.getString(3);
                                objListHocBaTimKiem [3] = rs.getString(4);
                                objListHocBaTimKiem [4] = rs.getString(5);
                                objListHocBaTimKiem [5] = rs.getString(6);
                                objListHocBaTimKiem [6] = rs.getString(7);
                                objListHocBaTimKiem [7] = rs.getString(8);
                                objListHocBaTimKiem [8] = rs.getString(9);
                                objListHocBaTimKiem [9] = rs.getString(10);
                                objListHocBaTimKiem [10] = rs.getString(11);
                                objListHocBaTimKiem [11] = rs.getString(12);
                                model.addRow(objListHocBaTimKiem);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Thông tin học bạ của CCCD: "+Cccd+" đã được hiển thị lên table...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống...");
                    }
                }
            }
        });
        //sửa điểm học bạ
        ViewForm.SuaDiemThiSinhHB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiemHocBa s = new DiemHocBa();
                s.setCccd(ViewForm.nhapcccd.getText());
                s.setHoVaTen(ViewForm.nhaphovaten.getText());
                s.setMonHoc(String.valueOf(ViewForm.nhapmonhocba.getSelectedItem()));
                s.setTbhk1lop10(Float.parseFloat(ViewForm.nhaphocky1lop10.getText()));
                s.setTbhk2lop10(Float.parseFloat(ViewForm.nhaphocky2lop10.getText()));
                s.setTbhk1lop11(Float.parseFloat(ViewForm.nhaphocky1lop11.getText()));
                s.setTbhk2lop11(Float.parseFloat(ViewForm.nhaphocky2lop11.getText()));
                s.setTbhk1lop12(Float.parseFloat(ViewForm.nhaphocky1lop12.getText()));
                s.setTbhk2lop12(Float.parseFloat(ViewForm.nhaphocky2lop12.getText()));
                s.setTbcanam12((s.getTbhk1lop12()*2+s.getTbhk2lop12())/3);
                s.setTb6ky((s.getTbhk1lop10()+s.getTbhk2lop10()+s.getTbhk1lop11()+s.getTbhk2lop11()+s.getTbhk1lop12()+s.getTbhk2lop12())/6);
                s.setTb5ky((s.getTbhk1lop10()+s.getTbhk2lop10()+s.getTbhk1lop11()+s.getTbhk2lop11()+s.getTbhk1lop12())/5);
                int removeIndex = ViewForm.tbdiemhb.getSelectedRow();
                String cauLenhSQL = "Update HocBa" +
                        " set Cccd = '"+ s.getCccd() +"'"+
                        ", Hovaten = N'"+ ViewForm.nhaphovaten.getText()+ "'" +
                        ", Monhoc = N'"+ s.getMonHoc()+ "'" +
                        ", Tbhk1lop10 = '"+ s.getTbhk1lop10()+ "'" +
                        ", Tbhk2lop10 = '"+ s.getTbhk2lop10()+ "'" +
                        ", Tbhk1lop11 = '"+ s.getTbhk1lop11()+ "'" +
                        ", Tbhk2lop11 = '"+ s.getTbhk2lop11()+ "'" +
                        ", Tbhk1lop12 = '"+ s.getTbhk1lop12()+ "'" +
                        ", Tbhk2lop12 = '"+ s.getTbhk2lop12()+ "'" +
                        ", Tbcanam12 = '"+ s.getTbcanam12()+ "'" +
                        ", Tb6ky = '"+ s.getTb6ky()+ "'" +
                        ", Tb5ky = '"+ s.getTb5ky()+ "'" +
                        " Where Monhoc = N'"+ViewForm.nhapmonhocba.getSelectedItem()+"' and Cccd = '"+ViewForm.nhapcccd.getText()+"'";
                Connections.ThucThi3Lenh(cauLenhSQL);
                ViewForm.diemhb.removeRow(removeIndex);
                ViewForm.diemhb.addRow(new String [] {s.getCccd(),s.getHoVaTen(),s.getMonHoc(), String.valueOf(s.getTbhk1lop10()),String.valueOf(s.getTbhk2lop10()),
                        String.valueOf(s.getTbhk1lop11()),String.valueOf(s.getTbhk2lop11()),String.valueOf(s.getTbhk1lop12()),String.valueOf(s.getTbhk2lop12()),String.valueOf(s.getTbcanam12())
                        ,String.valueOf(s.getTb6ky()),String.valueOf(s.getTb5ky())});
                ViewForm.nhaptrungbinh6ky.setText(String.valueOf(s.getTb6ky()));
                ViewForm.nhaptrungbinh5ky.setText(String.valueOf(s.getTb5ky()));
                ViewForm.nhaptrungbinhcanam12.setText(String.valueOf(s.getTbcanam12()));
                JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Sửa điểm học bạ thành công...");
            }
        });
        //hiển thị thông tin nguyện vọng
        ViewForm.tbnguyenvong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ViewForm.tbnguyenvong.getSelectedRow();
                    String Cccd = ViewForm.tbnguyenvong.getValueAt(row,0).toString();
                    String Thutunv = ViewForm.tbnguyenvong.getValueAt(row,1).toString();
                    String Truongdaihoc = ViewForm.tbnguyenvong.getValueAt(row,2).toString();
                    String Matruongdaihoc = ViewForm.tbnguyenvong.getValueAt(row,3).toString();
                    String Nganh = ViewForm.tbnguyenvong.getValueAt(row,4).toString();
                    String Manganh = ViewForm.tbnguyenvong.getValueAt(row,5).toString();
                    String Phuongthucxettuyen = ViewForm.tbnguyenvong.getValueAt(row,6).toString();
                    String Tohopmon = ViewForm.tbnguyenvong.getValueAt(row,7).toString();
                    //set gia tri len text
                    ViewForm.nhapthutunguyenvong.setText(Thutunv);
                    ViewForm.nhaptruongdaihoc.setText(Truongdaihoc);
                    ViewForm.nhapmatruongdaihoc.setText(Matruongdaihoc);
                    ViewForm.nhapnganh.setText(Nganh);
                    ViewForm.nhapmanganh.setText(Manganh);
                    ViewForm.nhapphuongthucxettuyen.setSelectedItem(Phuongthucxettuyen);
                    ViewForm.nhaptohopmon.setSelectedItem(Tohopmon);
                    ViewForm.nhapthutunguyenvong.setEditable(false);
            }
        });
        //hiển thị thông tin thí sinh
        ViewForm.tb1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ViewForm.tb1.getSelectedRow();
                    String Cccd = ViewForm.tb1.getValueAt(row,0).toString();
                    String Hovaten = ViewForm.tb1.getValueAt(row,1).toString();
                    String Sinhnhat = ViewForm.tb1.getValueAt(row,2).toString();
                    String Gioitinh = ViewForm.tb1.getValueAt(row,3).toString();
                    String Dienuutien = ViewForm.tb1.getValueAt(row,4).toString();
                    String Khuvuc = ViewForm.tb1.getValueAt(row,5).toString();
                    String Diachi = ViewForm.tb1.getValueAt(row,6).toString();
                    String Thpt = ViewForm.tb1.getValueAt(row,7).toString();
                    if(Gioitinh.equals("Nam")) {
                        ViewForm.gioitinhnam.setSelected(true);
                    } else if(Gioitinh.equals("Nữ")) {
                        ViewForm.gioitinhnu.setSelected(true);
                    }
                    ViewForm.nhapcccd.setEditable(false);
                    ViewForm.nhapcccd.setText(Cccd);
                    ViewForm.nhaphovaten.setText(Hovaten);
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
                    ViewForm.nhapdienuutien.setSelectedItem(Dienuutien);
                    ViewForm.nhapkhuvuc.setSelectedItem(Khuvuc);
                    ViewForm.nhapdiachi.setText(Diachi);
                    ViewForm.nhapthpt.setText(Thpt);
            }
        });
        //hiển thị điểm thi
        ViewForm.tbdiemthi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ViewForm.tbdiemthi.getSelectedRow();
                    String Cccd = ViewForm.tbdiemthi.getValueAt(row,0).toString();
                    String Diemtoan = ViewForm.tbdiemthi.getValueAt(row,1).toString();
                    String Diemvan = ViewForm.tbdiemthi.getValueAt(row,2).toString();
                    String Diemanh = ViewForm.tbdiemthi.getValueAt(row,3).toString();
                    String Diemly = ViewForm.tbdiemthi.getValueAt(row,4).toString();
                    String Diemhoa = ViewForm.tbdiemthi.getValueAt(row,5).toString();
                    String Diemsinh = ViewForm.tbdiemthi.getValueAt(row,6).toString();
                    String Diemsu = ViewForm.tbdiemthi.getValueAt(row,7).toString();
                    String Diemdia = ViewForm.tbdiemthi.getValueAt(row,8).toString();
                    String Diemgdcd = ViewForm.tbdiemthi.getValueAt(row,9).toString();
                    ViewForm.nhapdiemtoan.setText(Diemtoan);
                    ViewForm.nhapdiemvan.setText(Diemvan);
                    ViewForm.nhapdiemly.setText(Diemly);
                    ViewForm.nhapdiemhoa.setText(Diemhoa);
                    ViewForm.nhapdiemsinh.setText(Diemsinh);
                    ViewForm.nhapdiemsu.setText(Diemsu);
                    ViewForm.nhapdiemdia.setText(Diemdia);
                    ViewForm.nhapdiemgdcd.setText(Diemgdcd);
                    ViewForm.nhapdiemanh.setText(Diemanh);
            }
        });
        //hiển thị điểm học bạ
        ViewForm.tbdiemhb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = ViewForm.tbdiemhb.getSelectedRow();
                String Monhoc = ViewForm.tbdiemhb.getValueAt(row,2).toString();
                String Tbhk1lop10 = ViewForm.tbdiemhb.getValueAt(row,3).toString();
                String Tbhk2lop10 = ViewForm.tbdiemhb.getValueAt(row,4).toString();
                String Tbhk1lop11 = ViewForm.tbdiemhb.getValueAt(row,5).toString();
                String Tbhk2lop11 = ViewForm.tbdiemhb.getValueAt(row,6).toString();
                String Tbhk1lop12 = ViewForm.tbdiemhb.getValueAt(row,7).toString();
                String Tbhk2lop12 = ViewForm.tbdiemhb.getValueAt(row,8).toString();
                String Tbcanam12 = ViewForm.tbdiemhb.getValueAt(row,9).toString();
                String Tb6ky = ViewForm.tbdiemhb.getValueAt(row,10).toString();
                String Tb5ky = ViewForm.tbdiemhb.getValueAt(row,11).toString();
                ViewForm.nhapmonhocba.setSelectedItem(Monhoc);
                ViewForm.nhaphocky1lop10.setText(Tbhk1lop10);
                ViewForm.nhaphocky2lop10.setText(Tbhk2lop10);
                ViewForm.nhaphocky1lop11.setText(Tbhk1lop11);
                ViewForm.nhaphocky2lop11.setText(Tbhk2lop11);
                ViewForm.nhaphocky1lop12.setText(Tbhk1lop12);
                ViewForm.nhaphocky2lop12.setText(Tbhk2lop12);
                ViewForm.nhaptrungbinhcanam12.setText(Tbcanam12);
                ViewForm.nhaptrungbinh6ky.setText(Tb6ky);
                ViewForm.nhaptrungbinh5ky.setText(Tb5ky);
                ViewForm.nhapmonhocba.setEnabled(false);
            }
        });
        //xác nhận tính điểm TNPT
        ViewForm.xacnhantinhdiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TinhDiemTNPT s = new TinhDiemTNPT();
                s.setCccd(ViewForm.nhapcccdtinhdiemtnpt.getText());
                s.setDiemToan(Float.parseFloat(ViewForm.nhapdiemmontoan.getText()));
                s.setDiemVan(Float.parseFloat(ViewForm.nhapdiemmonvan.getText()));
                s.setDiemAnh(Float.parseFloat(ViewForm.nhapdiemmonanh.getText()));
                s.setDiemLy_Su(Float.parseFloat(ViewForm.nhapdiemmonly_su.getText()));
                s.setDiemHoa_Dia(Float.parseFloat(ViewForm.nhapdiemmonhoa_dia.getText()));
                s.setDiemSinh_Gdcd(Float.parseFloat(ViewForm.nhapdiemmonsinh_gdcd.getText()));
                s.setDiemTb12(Float.parseFloat(ViewForm.nhapdiemtb12.getText()));
                s.setDiemKhuyenKhich(Float.parseFloat(ViewForm.nhapdiemkhuyenkhich.getText()));
                s.setDiemUuTien(Float.parseFloat(ViewForm.nhapdiemuutien.getText()));
                s.setDoiTuongHs(String.valueOf(ViewForm.nhapdoituonghs.getSelectedItem()));
                if(ViewForm.nhapdoituonghs.getSelectedItem().equals("Hệ THPT")) {
                    s.setDiemxettotnghiep((((s.getDiemToan()+s.getDiemVan()+s.getDiemAnh()+(s.getDiemLy_Su()+s.getDiemHoa_Dia()+s.getDiemSinh_Gdcd())/3+s.getDiemKhuyenKhich())/4)*7+s.getDiemTb12()*3)/10+s.getDiemUuTien());
                    ViewForm.hienthidiemxettotnghiep.setText(String.valueOf(s.getDiemxettotnghiep()));
                    if(s.getDiemxettotnghiep()>=5) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Điểm xét tốt nghiệp của bạn là: "+s.getDiemxettotnghiep()+"\nBạn đã đủ điều kiện đậu tốt nghiệp THPT...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Điểm xét tốt nghiệp của bạn là: "+s.getDiemxettotnghiep()+"\nBạn không đủ điều kiện đậu tốt nghiệp THPT...");
                    }
                } else if(ViewForm.nhapdoituonghs.getSelectedItem().equals("Hệ GDTX")){
                    s.setDiemxettotnghiep((((s.getDiemToan()+s.getDiemVan()+(s.getDiemLy_Su()+s.getDiemHoa_Dia()+s.getDiemSinh_Gdcd())/3)/3+s.getDiemKhuyenKhich()/4)*7+s.getDiemTb12()*3)/10+s.getDiemUuTien());
                    ViewForm.hienthidiemxettotnghiep.setText(String.valueOf(s.getDiemxettotnghiep()));
                    if(s.getDiemxettotnghiep()>=5) {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Điểm xét tốt nghiệp của bạn là: "+s.getDiemxettotnghiep()+"\nBạn đã đủ điều kiện đậu tốt nghiệp THPT...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Điểm xét tốt nghiệp của bạn là: "+s.getDiemxettotnghiep()+"\nBạn không đủ điều kiện đậu tốt nghiệp THPT...");
                    }
                } else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng chọn đối tượng học sinh cần tính điểm...");
                }
            }
        });
        //nhập lại tính điểm tnpt
        ViewForm.nhaplaithongtintinhdiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.nhapcccdtinhdiemtnpt.setText(null);
                ViewForm.nhapdiemmontoan.setText(null);
                ViewForm.nhapdiemmonvan.setText(null);
                ViewForm.nhapdiemmonanh.setText(null);
                ViewForm.nhapdiemmonly_su.setText(null);
                ViewForm.nhapdiemmonhoa_dia.setText(null);
                ViewForm.nhapdiemmonsinh_gdcd.setText(null);
                ViewForm.nhapdiemuutien.setText(String.valueOf(0));
                ViewForm.nhapdiemkhuyenkhich.setText(String.valueOf(0));
                ViewForm.nhapdiemtb12.setText(null);
                ViewForm.nhapdoituonghs.setSelectedItem("");
                ViewForm.hienthidiemxettotnghiep.setText("0.0");
                ViewForm.hienthicccdxettotnghiep.setText("");
            }
        });
        //cập nhật thông tin cần tính điêểm
        ViewForm.capnhatthongtintinhdiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewForm.tinhdiemtnpt.setRowCount(0);
                Connections.getColection();
                TinhDiemTNPT s = new TinhDiemTNPT();
                s.setCccd(ViewForm.nhapcccdtinhdiemtnpt.getText());
                ViewForm.hienthicccdxettotnghiep.setText(s.getCccd());
                if(s.getCccd().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Hãy nhập vào CCCD cần lấy thông tin điểm, nếu CCCD đã tồn tại thông tin trong hệ thống...");
                } else {
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
                        String cauLenhSQL = "Select * from DiemThi where Cccd = '" + s.getCccd() + "'";
                        String cauLenhSQL1 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Toán'";
                        String cauLenhSQL2 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Ngữ Văn'";
                        String cauLenhSQL3 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Tiếng Anh'";
                        String cauLenhSQL4 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Vật Lý'";
                        String cauLenhSQL5 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Hóa Học'";
                        String cauLenhSQL6 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Sinh Học'";
                        String cauLenhSQL7 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Lịch Sử'";
                        String cauLenhSQL8 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Địa Lí'";
                        String cauLenhSQL9 = "Select * from HocBa Where Cccd = '"+s.getCccd()+"' and Monhoc = N'Giáo Dục Công Dân'";

                        ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL);
                        ResultSet rs1 = Connections.ThucThiLenhSelect(cauLenhSQL1);
                        ResultSet rs2 = Connections.ThucThiLenhSelect(cauLenhSQL2);
                        ResultSet rs3 = Connections.ThucThiLenhSelect(cauLenhSQL3);
                        ResultSet rs4 = Connections.ThucThiLenhSelect(cauLenhSQL4);
                        ResultSet rs5 = Connections.ThucThiLenhSelect(cauLenhSQL5);
                        ResultSet rs6 = Connections.ThucThiLenhSelect(cauLenhSQL6);
                        ResultSet rs7 = Connections.ThucThiLenhSelect(cauLenhSQL7);
                        ResultSet rs8 = Connections.ThucThiLenhSelect(cauLenhSQL8);
                        ResultSet rs9 = Connections.ThucThiLenhSelect(cauLenhSQL9);
                        try {
                            while (rs.next()&&rs1.next()&&rs2.next()&&rs3.next()&&rs4.next()&&rs5.next()&&rs6.next()&&rs7.next()&&rs8.next()&&rs9.next()) {
                                String cccd = rs.getString(1);
                                String toan = rs.getString(2);
                                String van = rs.getString(3);
                                String anh = rs.getString(4);
                                String ly = rs.getString(5);
                                String hoa = rs.getString(6);
                                String sinh = rs.getString(7);
                                String su = rs.getString(8);
                                String dia = rs.getString(9);
                                String gdcd = rs.getString(10);
                                float canamtoan = rs1.getFloat(10);
                                float canamvan = rs2.getFloat(10);
                                float canamanh = rs3.getFloat(10);
                                float canamly = rs4.getFloat(10);
                                float canamhoa = rs5.getFloat(10);
                                float canamsinh = rs6.getFloat(10);
                                float canamsu = rs7.getFloat(10);
                                float canamdia = rs8.getFloat(10);
                                float canamgdcd = rs9.getFloat(10);
                                String tbcanam12 = String.valueOf((canamtoan+canamvan+canamanh+canamly+canamhoa+canamsinh+canamsu+canamdia+canamgdcd)/9);
                                if(ly.equals("     ")&&hoa.equals("     ")&&sinh.equals("     ")) {
                                    ViewForm.tinhdiemtnpt.addRow(new String [] {cccd,toan,van,anh,su,dia,gdcd,tbcanam12});
                                    ViewForm.nhapdiemmontoan.setText(toan);
                                    ViewForm.nhapdiemmonvan.setText(van);
                                    ViewForm.nhapdiemmonanh.setText(anh);
                                    ViewForm.nhapdiemmonly_su.setText(su);
                                    ViewForm.nhapdiemmonhoa_dia.setText(dia);
                                    ViewForm.nhapdiemmonsinh_gdcd.setText(gdcd);
                                    ViewForm.nhapdiemtb12.setText(tbcanam12);
                                } else if(su.equals("     ")&&dia.equals("     ")&&gdcd.equals("     ")) {
                                    ViewForm.tinhdiemtnpt.addRow(new String [] {cccd,toan,van,anh,ly,hoa,sinh,tbcanam12});
                                    ViewForm.nhapdiemmontoan.setText(toan);
                                    ViewForm.nhapdiemmonvan.setText(van);
                                    ViewForm.nhapdiemmonanh.setText(anh);
                                    ViewForm.nhapdiemmonly_su.setText(ly);
                                    ViewForm.nhapdiemmonhoa_dia.setText(hoa);
                                    ViewForm.nhapdiemmonsinh_gdcd.setText(sinh);
                                    ViewForm.nhapdiemtb12.setText(tbcanam12);
                                }
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Đã cập nhật điểm của thí sinh, nếu bạn cần tính điểm tốt nghiệp thì hãy nhập các thông tin lưu ý còn lại...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống...");
                    }

                }
            }
        });
        //////Tìm kiếm tổng thông tin thí sinh
        ViewForm.buttontimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThiSinh s = new ThiSinh();
                s.setCccd(ViewForm.nhapsocccdtimkiem.getText());
                if(ViewForm.nhapsocccdtimkiem.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Vui lòng nhập vào số CCCD cần tìm kiếm thông tin...");
                } else {
                    String cauLenhSQL10 = "Select * from ThongTin where Cccd = '"+s.getCccd()+"'";
                    ResultSet rs = Connections.ThucThiLenhSelect(cauLenhSQL10);
                    try {
                        while (rs.next()) {
                            s.setCheckCccd(rs.getString(1));
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    if(s.getCccd().equals(s.getCheckCccd())) {
                        ViewForm.thongtinlichthi.setRowCount(0);
                        ViewForm.thongtinnguyenvong.setRowCount(0);
                        ViewForm.thongtindiemhocba.setRowCount(0);
                        Connections.getColection();
                        String Cccd = ViewForm.nhapsocccdtimkiem.getText();
                        String cauLenhSQLThongTin = "Select * from ThongTin where Cccd = "+Cccd;
                        String cauLenhSQLLichThi = "Select * from LichThi where Cccd = "+Cccd;
                        String cauLenhSQLNguyenVong = "Select * from NguyenVong where Cccd = "+Cccd;
                        String cauLenhSQLDiemThi = "Select * from DiemThi where Cccd = "+Cccd;
                        String caulenhSQLDiemHB = "Select * from HocBa where Cccd = "+Cccd;
                        ResultSet rs1 = Connections.ThucThiLenhSelect(cauLenhSQLThongTin);
                        ResultSet rs2 = Connections.ThucThiLenhSelect(cauLenhSQLLichThi);
                        ResultSet rs3 = Connections.ThucThiLenhSelect(cauLenhSQLNguyenVong);
                        ResultSet rs4 = Connections.ThucThiLenhSelect(cauLenhSQLDiemThi);
                        ResultSet rs5 = Connections.ThucThiLenhSelect(caulenhSQLDiemHB);
                        DefaultTableModel model2 = (DefaultTableModel) ViewForm.tbthongtinlichthi.getModel();
                        DefaultTableModel model3 = (DefaultTableModel) ViewForm.tbthongtinnguyenvong.getModel();
                        DefaultTableModel model5 = (DefaultTableModel) ViewForm.tbthongtindiemhocba.getModel();
                        Object objListThiSinhTimKiem [] = new Object[15];
                        Object objListLichThiTimKiem [] = new Object[15];
                        Object objListNguyenVongTimKiem [] = new Object[15];
                        Object objListTimKiemDiemThi [] = new Object[15];
                        Object objListHocBaTimKiem [] = new Object[15];
                        try {
                            while (rs1.next()) {
                                objListThiSinhTimKiem[1] = rs1.getString(2);
                                objListThiSinhTimKiem[2] = rs1.getString(3);
                                objListThiSinhTimKiem[3] = rs1.getString(4);
                                objListThiSinhTimKiem[4] = rs1.getString(5);
                                objListThiSinhTimKiem[5] = rs1.getString(6);
                                objListThiSinhTimKiem[6] = rs1.getString(7);
                                objListThiSinhTimKiem[7] = rs1.getString(8);
                                ViewForm.hienthihovaten.setText(String.valueOf(objListThiSinhTimKiem[1]));
                                ViewForm.hienthisinhnhat.setText(String.valueOf(objListThiSinhTimKiem[2]));
                                ViewForm.hienthigioitinh.setText(String.valueOf(objListThiSinhTimKiem[3]));
                                ViewForm.hienthidienuutien.setText(String.valueOf(objListThiSinhTimKiem[4]));
                                ViewForm.hienthikhuvuc.setText(String.valueOf(objListThiSinhTimKiem[5]));
                                ViewForm.hienthidiachi.setText(String.valueOf(objListThiSinhTimKiem[6]));
                                ViewForm.hienthithpt.setText(String.valueOf(objListThiSinhTimKiem[7]));
                            }
                                while (rs2.next()) {
                                    objListLichThiTimKiem [0] = rs2.getString(2);
                                    objListLichThiTimKiem [1] = rs2.getString(3);
                                    objListLichThiTimKiem [2] = rs2.getString(4);
                                    model2.addRow(objListLichThiTimKiem);
                                }
                                while (rs3.next()) {
                                    objListNguyenVongTimKiem [0] = rs3.getString(2);
                                    objListNguyenVongTimKiem [1] = rs3.getString(3);
                                    objListNguyenVongTimKiem [2] = rs3.getString(4);
                                    objListNguyenVongTimKiem [3] = rs3.getString(5);
                                    objListNguyenVongTimKiem [4] = rs3.getString(6);
                                    objListNguyenVongTimKiem [5] = rs3.getString(7);
                                    objListNguyenVongTimKiem [6] = rs3.getString(8);
                                    model3.addRow(objListNguyenVongTimKiem);
                                }
                                while (rs4.next()) {
                                    objListTimKiemDiemThi [0] = rs4.getString(2);
                                    objListTimKiemDiemThi [1] = rs4.getString(3);
                                    objListTimKiemDiemThi [2] = rs4.getString(4);
                                    objListTimKiemDiemThi [3] = rs4.getString(5);
                                    objListTimKiemDiemThi [4] = rs4.getString(6);
                                    objListTimKiemDiemThi [5] = rs4.getString(7);
                                    objListTimKiemDiemThi [6] = rs4.getString(8);
                                    objListTimKiemDiemThi [7] = rs4.getString(9);
                                    objListTimKiemDiemThi [8] = rs4.getString(10);

                                    if(rs4.getString(5).equals("     ")&&rs4.getString(6).equals("     ")&&rs4.getString(7).equals("     ")) {
                                        ViewForm.hienthidiemtoan.setText(String.valueOf(objListTimKiemDiemThi [0]));
                                        ViewForm.hienthidiemvan.setText(String.valueOf(objListTimKiemDiemThi [1]));
                                        ViewForm.hienthidiemanh.setText(String.valueOf(objListTimKiemDiemThi [2]));
                                        ViewForm.hienthidiemly.setText("Không thi");
                                        ViewForm.hienthidiemhoa.setText("Không thi");
                                        ViewForm.hienthidiemsinh.setText("Không thi");
                                        ViewForm.hienthidiemsu.setText(String.valueOf(objListTimKiemDiemThi [6]));
                                        ViewForm.hienthidiemdia.setText(String.valueOf(objListTimKiemDiemThi [7]));
                                        ViewForm.hienthidiemgdcd.setText(String.valueOf(objListTimKiemDiemThi [8]));
                                    } else if(rs4.getString(8).equals("     ")&&rs4.getString(9).equals("     ")&&rs4.getString(10).equals("     ")) {
                                        ViewForm.hienthidiemtoan.setText(String.valueOf(objListTimKiemDiemThi [0]));
                                        ViewForm.hienthidiemvan.setText(String.valueOf(objListTimKiemDiemThi [1]));
                                        ViewForm.hienthidiemanh.setText(String.valueOf(objListTimKiemDiemThi [2]));
                                        ViewForm.hienthidiemsu.setText("Không thi");
                                        ViewForm.hienthidiemdia.setText("Không thi");
                                        ViewForm.hienthidiemgdcd.setText("Không thi");
                                        ViewForm.hienthidiemly.setText(String.valueOf(objListTimKiemDiemThi [3]));
                                        ViewForm.hienthidiemhoa.setText(String.valueOf(objListTimKiemDiemThi [4]));
                                        ViewForm.hienthidiemsinh.setText(String.valueOf(objListTimKiemDiemThi [5]));
                                    }
                                }
                                while (rs5.next()) {
                                    objListHocBaTimKiem [0] = rs5.getString(3);
                                    objListHocBaTimKiem [1] = rs5.getString(4);
                                    objListHocBaTimKiem [2] = rs5.getString(5);
                                    objListHocBaTimKiem [3] = rs5.getString(6);
                                    objListHocBaTimKiem [4] = rs5.getString(7);
                                    objListHocBaTimKiem [5] = rs5.getString(8);
                                    objListHocBaTimKiem [6] = rs5.getString(9);
                                    objListHocBaTimKiem [7] = rs5.getString(10);
                                    model5.addRow(objListHocBaTimKiem);
                                }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Tất cả thông tin của số CCCD: "+s.getCccd()+" đã được hiển thị lên màn hình...");
                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),"Số CCCD: "+s.getCccd()+" không tồn tại thông tin trong hệ thống, vui lòng kiểm tra lại...");
                    }
                }
            }
        });
        ///chon phuong thuc xet tuyen
        ViewForm.nhapphuongthucxettuyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== ViewForm.nhapphuongthucxettuyen) {
                    if(ViewForm.nhapphuongthucxettuyen.getSelectedItem().equals("Tuyển thẳng, ƯTXT theo qui định của Bộ GD&ĐT và của Trường") || ViewForm.nhapphuongthucxettuyen.getSelectedItem().equals("Xét theo kết quả đánh giá năng lực do ĐHQGHN tổ chức năm 2023")) {
                        ViewForm.nhaptohopmon.setEnabled(false);
                        ViewForm.nhaptohopmon.setSelectedItem("");
                    } else {
                        ViewForm.nhaptohopmon.setEnabled(true);
                    }
                }
            }
        });
    }
}
