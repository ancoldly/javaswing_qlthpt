package View;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;
public class ViewForm extends JFrame {
    public static JButton XacNhan,NhapLai,XoaTatCa,Xoa1ThongTin,CapNhatThongTin,TimKimThongTinThiSinh,SuaThongTinThiSinh;
    public static JButton XacNhanLichThi,NhapLaiLichThi,Xoa1LichThi,XoaTatCaLichThi,CapNhatLichThi,TimKiemLichThiTheoCCCD;
    public static JButton xacnhandangkinv,nhaplaithongtinnv,xoanguyenvong,xoatatcanv,capnhatnguyenvong,timkiemthongtinnv,suathongtinnv;
    public static JButton XacNhanNhapDiem,NhapLaiDiem,XoaDiemDaChon,XoaTaCaDiem,CapNhatDiem,TimKiemDiemTheoCccd,SuaDiemThiSinh;
    public static JButton XacNhanNhapDiemHB,NhapLaiDiemHB,XoaDiemDaChonHB,XoaTatCaDiemHB,CapNhatDiemHB,TimKiemDiemTheoCccdHB,SuaDiemThiSinhHB;
    public static JButton capnhatthongtintinhdiem,xacnhantinhdiem,nhaplaithongtintinhdiem;
    public static JButton buttontimkiem;
    public static JRadioButton gioitinhnam,gioitinhnu;
    public static JComboBox nhapmonhocba,nhapdienuutien,nhapkhuvuc,nhapnamsinh,nhapthangsinh,nhapngaysinh,nhapphuongthucxettuyen,nhaptohopmon,nhapdoituonghs;
    public static JTextField nhapcccd,nhaphovaten,nhapdiachi,nhapthpt,nhapthongtinthisinh,nhapthongtinlichthi,nhapthutunguyenvong,nhaptruongdaihoc,nhapmatruongdaihoc,nhapnganh,nhapmanganh,nhapthongtinnv,nhapdiemtoan,nhapdiemvan,nhapdiemly,nhapdiemhoa,nhapdiemsinh,nhapdiemanh,nhapdiemsu,nhapdiemdia,nhapdiemgdcd,nhapthongtindiem,
    nhaphocky1lop10,nhaphocky2lop10,nhaphocky1lop11,nhaphocky2lop11,nhaphocky1lop12,nhaphocky2lop12,nhaptrungbinh6ky,nhaptrungbinh5ky,nhapthongtindiemhb,nhapcccdtinhdiemtnpt,nhapdiemmontoan,nhapdiemmonvan,nhapdiemmonanh,nhapdiemmonly_su,nhapdiemmonhoa_dia,nhapdiemmonsinh_gdcd,
            nhapdiemtb12,nhapdiemkhuyenkhich,nhapdiemuutien,nhaptrungbinhcanam12,nhapsocccdtimkiem;
    public static JCheckBox CheckBox1,CheckBox2,CheckBox3,CheckBox4,CheckBox5,CheckBox6,CheckBox7,CheckBox8,CheckBox9;
    public static DefaultTableModel dm,lichthi,nguyenvong,diemthi,diemhb,tinhdiemtnpt,thongtinlichthi,thongtindiemhocba,thongtinnguyenvong;
    public static JTable tb1,tblichthi,tbnguyenvong,tbdiemthi,tbdiemhb,tbtinhdiemtnpt,tbthongtinlichthi,tbthongtindiemhocba,tbthongtinnguyenvong;
    public static JMenuItem NhapDiemTN,NhapHocBa;
    public static JLabel tieude,montoan,monvan,monly,monhoa,monsinh,monsu,mondia,moncongdan,monanh,ngaythitoan,ngaythivan,ngaythily,ngaythihoa,ngaythisinh,ngaythisu,ngaythidia,
    ngaythicongdan,ngaythianh,giothitoan,giothivan,giothily,giothihoa,giothisinh,giothisu,giothidia,giothicongdan,giothianh,hienthidiemxettotnghiep,hienthicccdxettotnghiep;
    public static JLabel hienthihovaten,hienthisinhnhat,hienthigioitinh,hienthidienuutien,hienthikhuvuc,hienthidiachi,hienthithpt,hienthidiemtoan,hienthidiemvan,hienthidiemanh,hienthidiemly,hienthidiemhoa,hienthidiemsinh,hienthidiemsu,hienthidiemdia,hienthidiemgdcd;
    public static JMenuItem DangXuat,DoiMatKhau;
    public static JMenu XinChao;
    public ViewForm() {
        super("QUẢN LÍ THI TỐT NGHIỆP THPT QUỐC GIA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1120,900);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/graduated.png"))).getImage());

        Container container = getContentPane();
        //Title north
        tieude = new JLabel("QUẢN LÍ THÔNG TIN THÍ SINH THAM GIA THI THPT QUỐC GIA");
        tieude.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/graduated.png"))));
    
        JPanel tieudenorth = new JPanel();
        tieudenorth.setBackground(new Color(224,255,255));
        tieudenorth.setBorder(new LineBorder(Color.BLACK,1));
        tieudenorth.setLayout(new FlowLayout(1,1,5));
        tieudenorth.add(tieude);
        container.add(tieudenorth,BorderLayout.NORTH);
        //Jlabelthông tin thí sinh
        JLabel cccd = new JLabel("Số CCCD ");
        JLabel hovaten = new JLabel("Họ và tên ");
        JLabel ngaysinh = new JLabel("Ngày sinh ");
        JLabel gioitinh = new JLabel("Giới tính ");
        JLabel dienuutien = new JLabel("Diện ưu tiên ");
        JLabel khuvuc = new JLabel("Khu vực ");
        JLabel diachi = new JLabel("Địa chỉ ");
        JLabel thpt = new JLabel("Trường THPT");
        //Jlabel sinh nhật thí sinh
        JLabel ngay = new JLabel("Ngày");
        JLabel thang = new JLabel("Tháng");
        JLabel nam = new JLabel("Năm");
        //Jlabel and textfield and Jpanel tìm kiếm thí sinh
        JLabel timthongtinthisinh = new JLabel("CCCD cần tìm");
        nhapthongtinthisinh = new JTextField(15);
        nhapthongtinthisinh.setBorder(new LineBorder(Color.RED,3));
        JPanel timkiemthisinh = new JPanel();
        timkiemthisinh.setBackground(new Color(230,230,250));
        timkiemthisinh.setLayout(new FlowLayout(5,8,1));
        timkiemthisinh.add(timthongtinthisinh);
        timkiemthisinh.add(nhapthongtinthisinh);
        //Jlabel and textfield and Jpanel tìm kiếm lịch thi
        JLabel timthongtinlichthi = new JLabel("CCCD cần tìm");
        nhapthongtinlichthi = new JTextField(15);
        nhapthongtinlichthi.setBorder(new LineBorder(Color.MAGENTA,3));
        JPanel timkiemlichthi = new JPanel();
        timkiemlichthi.setBackground(new Color(250,250,210));
        timkiemlichthi.setLayout(new FlowLayout(5,8,1));
        timkiemlichthi.add(timthongtinlichthi);
        timkiemlichthi.add(nhapthongtinlichthi);
        //Jlabel and textfield and Jpanel tìm kiếm nguyen vong
        JLabel timthongtinnguyenvong = new JLabel("CCCD cần tìm");
        nhapthongtinnv = new JTextField(15);
        nhapthongtinnv.setBorder(new LineBorder(Color.cyan, 3));
        JPanel timkiemnguyenvong = new JPanel();
        timkiemnguyenvong.setBackground(new Color(144,238,144));
        timkiemnguyenvong.setLayout(new FlowLayout(5,8,1));
        timkiemnguyenvong.add(timthongtinnguyenvong);
        timkiemnguyenvong.add(nhapthongtinnv);
        //textfield thông tin
        nhapcccd = new JTextField(10);
        nhapcccd.setBorder(new LineBorder(Color.BLACK,2));
        nhaphovaten = new JTextField(10);
        nhaphovaten.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiachi = new JTextField(10);
        nhapdiachi.setBorder(new LineBorder(Color.BLACK,2));
        nhapthpt = new JTextField(10);
        nhapthpt.setBorder(new LineBorder(Color.BLACK,2));
        //jcombobox sinh nhat
        String ngaysinhnhat [] = {"01","02","03","04","05","06","07","08","09","10",
                "11","12","13","14","15","16","17","18","19","20",
                "21","22","23","24","25","26","27","28","29","30","31",};
        nhapngaysinh = new JComboBox(ngaysinhnhat);
        nhapngaysinh.setBorder(new LineBorder(Color.BLACK,2));
        String thangsinhnhat [] = {"01","02","03","04","05","06","07","08","09","10","11","12",};
        nhapthangsinh = new JComboBox(thangsinhnhat);
        nhapthangsinh.setBorder(new LineBorder(Color.BLACK,2));
        String namsinhnhat [] = {"1950","1951","1952","1953","1954","1955","1956","1957","1958","1959","1960","1961","1962","1963","1964",
                "1965","1966","1967","1968","1969","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981",
                "1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999",
                "2000","2001","2002","2003","2004","2005"};
        nhapnamsinh = new JComboBox(namsinhnhat);
        nhapnamsinh.setBorder(new LineBorder(Color.BLACK,2));
        //jpanel sinhn nhat
        JPanel nhapsinhnhat = new JPanel();
        nhapsinhnhat.setLayout(new FlowLayout(6,4,1));
        nhapsinhnhat.setBackground(new Color(224,255,255));
        nhapsinhnhat.add(ngay);
        nhapsinhnhat.add(nhapngaysinh);
        nhapsinhnhat.add(thang);
        nhapsinhnhat.add(nhapthangsinh);
        nhapsinhnhat.add(nam);
        nhapsinhnhat.add(nhapnamsinh);
        //jcombobox diện ưu tiên
        String cacdienuutien [] = {"","Không","Đối tượng 1","Đối tượng 2","Đối tượng 3","Đối tượng 4",
                "Đối tượng 5", "Đối tượng 6","Đối tượng 7",};
        nhapdienuutien = new JComboBox(cacdienuutien);
        nhapdienuutien.setBorder(new LineBorder(Color.BLACK,2));
        nhapdienuutien.setBackground(new Color(238,130,238));
        nhapdienuutien.setForeground(Color.WHITE);
        //jcombobox khu vực ưu tiên
        String khuvucuutien [] = {"","Khu vực 1","Khu vực 2-NT","Khu vực 2","Khu vực 3"};
        nhapkhuvuc = new JComboBox(khuvucuutien);
        nhapkhuvuc.setBorder(new LineBorder(Color.BLACK,2));
        nhapkhuvuc.setBackground(new Color(238,130,238));
        nhapkhuvuc.setForeground(Color.WHITE);
        //radiobutton giới tính
        gioitinhnam = new JRadioButton("Nam");
        gioitinhnam.setBackground(new Color(224,255,255));
        gioitinhnu = new JRadioButton("Nữ");
        gioitinhnu.setBackground(new Color(224,255,255));
        //button gr giới tính
        ButtonGroup buttonGroupgioitinh = new ButtonGroup();
        buttonGroupgioitinh.add(gioitinhnam);
        buttonGroupgioitinh.add(gioitinhnu);
        //Jpanel giới tính
        JPanel nhapgioitinh = new JPanel();
        nhapgioitinh.setBackground(new Color(224,255,255));
        nhapgioitinh.setLayout(new FlowLayout(5));
        nhapgioitinh.add(gioitinhnam);
        nhapgioitinh.add(gioitinhnu);
        // ĐĂNG KÍ MÔN -----------------------------------------
        //check box môn
        CheckBox1 = new JCheckBox("Chọn");
        CheckBox1.setBackground(new Color(224,255,255));
        CheckBox2 = new JCheckBox("Chọn");
        CheckBox2.setBackground(new Color(224,255,255));
        CheckBox3 = new JCheckBox("Chọn");
        CheckBox3.setBackground(new Color(224,255,255));
        CheckBox4 = new JCheckBox("Chọn");
        CheckBox4.setBackground(new Color(224,255,255));
        CheckBox5 = new JCheckBox("Chọn");
        CheckBox5.setBackground(new Color(224,255,255));
        CheckBox6 = new JCheckBox("Chọn");
        CheckBox6.setBackground(new Color(224,255,255));
        CheckBox7 = new JCheckBox("Chọn");
        CheckBox7.setBackground(new Color(224,255,255));
        CheckBox8 = new JCheckBox("Chọn");
        CheckBox8.setBackground(new Color(224,255,255));
        CheckBox9 = new JCheckBox("Chọn");
        CheckBox9.setBackground(new Color(224,255,255));
        //thông tin đăng kí
        JLabel tenmon = new JLabel("Tên môn");
        JLabel dangki = new JLabel("Đăng kí");
        JLabel ngaythi = new JLabel("Ngày thi");
        JLabel giothi = new JLabel("Giờ thi");
        //môn thi
        montoan = new JLabel("Toán");
        montoan.setForeground(new Color(255,20,147));
        monly = new JLabel("Vật lý");
        monly.setForeground(new Color(255,20,147));
        monhoa = new JLabel("Hóa học");
        monhoa.setForeground(new Color(255,20,147));
        monanh = new JLabel("Ngoại ngữ");
        monanh.setForeground(new Color(255,20,147));
        monvan = new JLabel("Ngữ văn");
        monvan.setForeground(new Color(255,20,147));
        monsu = new JLabel("Lịch sử");
        monsu.setForeground(new Color(255,20,147));
        mondia = new JLabel("Địa lý");
        mondia.setForeground(new Color(255,20,147));
        moncongdan = new JLabel("Công dân");
        moncongdan.setForeground(new Color(255,20,147));
        monsinh = new JLabel("Sinh học");
        monsinh.setForeground(new Color(255,20,147));
        // ngày thi
        ngaythitoan = new JLabel("2023/07/07");
        ngaythitoan.setForeground(new Color(255,20,147));
        ngaythivan = new JLabel("2023/07/07");
        ngaythivan.setForeground(new Color(255,20,147));
        ngaythily = new JLabel("2023/07/08");
        ngaythily.setForeground(new Color(255,20,147));
        ngaythihoa = new JLabel("2023/07/08");
        ngaythihoa.setForeground(new Color(255,20,147));
        ngaythisinh = new JLabel("2023/07/08");
        ngaythisinh.setForeground(new Color(255,20,147));
        ngaythisu = new JLabel("2023/07/08");
        ngaythisu.setForeground(new Color(255,20,147));
        ngaythidia = new JLabel("2023/07/08");
        ngaythidia.setForeground(new Color(255,20,147));
        ngaythicongdan = new JLabel("2023/07/08");
        ngaythicongdan.setForeground(new Color(255,20,147));
        ngaythianh = new JLabel("2023/07/08");
        ngaythianh.setForeground(new Color(255,20,147));
        // giờ thi
        giothitoan = new JLabel("7h35p");
        giothitoan.setForeground(new Color(255,20,147));
        giothivan = new JLabel("14h30p");
        giothivan.setForeground(new Color(255,20,147));
        giothily = new JLabel("7h35p");
        giothily.setForeground(new Color(255,20,147));
        giothihoa = new JLabel("8h35p");
        giothihoa.setForeground(new Color(255,20,147));
        giothisinh = new JLabel("9h35p");
        giothisinh.setForeground(new Color(255,20,147));
        giothisu = new JLabel("7h35p");
        giothisu.setForeground(new Color(255,20,147));
        giothidia = new JLabel("8h35p");
        giothidia.setForeground(new Color(255,20,147));
        giothicongdan = new JLabel("9h30p");
        giothicongdan.setForeground(new Color(255,20,147));
        giothianh = new JLabel("14h30p");
        giothianh.setForeground(new Color(255,20,147));
        //Jpanel môn thi
        JPanel girdmonthi = new JPanel();
        girdmonthi.setBackground(new Color(224,255,255));
        girdmonthi.setLayout(new GridLayout(10,1, 1,18));
        girdmonthi.add(tenmon);
        girdmonthi.add(monvan);
        girdmonthi.add(montoan);
        girdmonthi.add(monly);
        girdmonthi.add(monhoa);
        girdmonthi.add(monsinh);
        girdmonthi.add(monsu);
        girdmonthi.add(mondia);
        girdmonthi.add(moncongdan);
        girdmonthi.add(monanh);
        //Panel đăng kí
        JPanel girddangki = new JPanel();
        girddangki.setBackground(new Color(224,255,255));
        girddangki.setLayout(new GridLayout(10,1, 1,10));
        girddangki.add(dangki);
        girddangki.add(CheckBox1);
        girddangki.add(CheckBox2);
        girddangki.add(CheckBox3);
        girddangki.add(CheckBox4);
        girddangki.add(CheckBox5);
        girddangki.add(CheckBox6);
        girddangki.add(CheckBox7);
        girddangki.add(CheckBox8);
        girddangki.add(CheckBox9);
        //panel ngày thi
        JPanel girdngaythi = new JPanel();
        girdngaythi.setBackground(new Color(224,255,255));
        girdngaythi.setLayout(new GridLayout(10,1, 1,18));
        girdngaythi.add(ngaythi);
        girdngaythi.add(ngaythivan);
        girdngaythi.add(ngaythitoan);
        girdngaythi.add(ngaythily);
        girdngaythi.add(ngaythihoa);
        girdngaythi.add(ngaythisinh);
        girdngaythi.add(ngaythisu);
        girdngaythi.add(ngaythidia);
        girdngaythi.add(ngaythicongdan);
        girdngaythi.add(ngaythianh);
        //Panel giờ thi
        JPanel girdgiothi = new JPanel();
        girdgiothi.setBackground(new Color(224,255,255));
        girdgiothi.setLayout(new GridLayout(10,1, 1,18));
        girdgiothi.add(giothi);
        girdgiothi.add(giothivan);
        girdgiothi.add(giothitoan);
        girdgiothi.add(giothily);
        girdgiothi.add(giothihoa);
        girdgiothi.add(giothisinh);
        girdgiothi.add(giothisu);
        girdgiothi.add(giothidia);
        girdgiothi.add(giothicongdan);
        girdgiothi.add(giothianh);

        // table hien thị thí sinh
        dm  = new DefaultTableModel();
        dm.addColumn("CCCD");
        dm.addColumn("Họ và tên");
        dm.addColumn("Ngày sinh");
        dm.addColumn("Giới tính");
        dm.addColumn("Diện ưu tiên");
        dm.addColumn("Khu vực");
        dm.addColumn("Địa chỉ");
        dm.addColumn("Trường THPT");

        tb1 = new JTable(dm);
        TableColumnModel columnModel = tb1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(70);
        columnModel.getColumn(1).setPreferredWidth(130);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(40);
        columnModel.getColumn(4).setPreferredWidth(60);
        columnModel.getColumn(5).setPreferredWidth(60);
        columnModel.getColumn(6).setPreferredWidth(190);
        columnModel.getColumn(7).setPreferredWidth(160);
        JScrollPane sc = new JScrollPane(tb1);
        sc.setBorder(new LineBorder(new Color(238,130,238),3));
        sc.setPreferredSize(new Dimension(1060,210));
        // title south
        JPanel bodertitlesouththongtin = new JPanel();
        Border borderthongtin = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitlethongtin = BorderFactory.createTitledBorder(borderthongtin, " THÍ SINH   ");
        bodertitlesouththongtin.setBorder(bordertitlethongtin);
        bodertitlesouththongtin.setBackground(new Color(220,220,220));
        bodertitlesouththongtin.add(sc);
        //table lịch thi
        lichthi  = new DefaultTableModel();
        lichthi.addColumn("Số CCCD");
        lichthi.addColumn("Môn thi");
        lichthi.addColumn("Ngày thi");
        lichthi.addColumn("Giờ thi");

        tblichthi = new JTable(lichthi);
        TableColumnModel columnModellichthi = tblichthi.getColumnModel();
        columnModellichthi.getColumn(0).setPreferredWidth(110);
        columnModellichthi.getColumn(1).setPreferredWidth(110);
        columnModellichthi.getColumn(2).setPreferredWidth(110);
        columnModellichthi.getColumn(3).setPreferredWidth(110);

        JScrollPane sclichthi = new JScrollPane(tblichthi);
        sclichthi.setBorder(new LineBorder(new Color(0,191,255),3));
        sclichthi.setPreferredSize(new Dimension(1060,210));

        JPanel bodertitlesouthlichthi = new JPanel();
        Border borderlichthi = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitlichthi = BorderFactory.createTitledBorder(borderlichthi, " LỊCH THI   ");
        bodertitlesouthlichthi.setBorder(bordertitlichthi);
        bodertitlesouthlichthi.setBackground(new Color(173,216,230));
        bodertitlesouthlichthi.add(sclichthi);
        //Jpanel Girdlayout các Jlabel thông tin
        JPanel thongtin = new JPanel();
        thongtin.setBackground(new Color(224,255,255));
        thongtin.setLayout(new GridLayout(8,0,1,29));
        thongtin.add(cccd);
        thongtin.add(hovaten);
        thongtin.add(ngaysinh);
        thongtin.add(gioitinh);
        thongtin.add(dienuutien);
        thongtin.add(khuvuc);
        thongtin.add(diachi);
        thongtin.add(thpt);
        //Jpanel Girdlayout các trường nhập thông tin
        JPanel nhapthongtin = new JPanel();
        nhapthongtin.setBackground(new Color(224,255,255));
        nhapthongtin.setLayout(new GridLayout(8,0,1,10));
        nhapthongtin.add(nhapcccd);
        nhapthongtin.add(nhaphovaten);
        nhapthongtin.add(nhapsinhnhat);
        nhapthongtin.add(nhapgioitinh);
        nhapthongtin.add(nhapdienuutien);
        nhapthongtin.add(nhapkhuvuc);
        nhapthongtin.add(nhapdiachi);
        nhapthongtin.add(nhapthpt);
        //Đăng kí nguyện vọng//
        //Jlabel
        JLabel thutunguyenvong = new JLabel("Thứ tự nguyện vọng");
        JLabel truongdaihoc = new JLabel("Trường");
        JLabel matruongdaihoc = new JLabel("Mã trường");
        JLabel nganh = new JLabel("Ngành");
        JLabel manganh = new JLabel("Mã ngành");
        JLabel phuongthucxettuyen = new JLabel("Phương thức xét tuyển");
        JLabel tohopmon = new JLabel("Tổ hợp môn");
        //Jtextfield
        nhapthutunguyenvong = new JTextField(5);
        nhapthutunguyenvong.setBorder(new LineBorder(Color.BLACK,2));
        nhaptruongdaihoc = new JTextField(10);
        nhaptruongdaihoc.setBorder(new LineBorder(Color.BLACK,2));
        nhapmatruongdaihoc = new JTextField(10);
        nhapmatruongdaihoc.setBorder(new LineBorder(Color.BLACK,2));
        nhapnganh = new JTextField(10);
        nhapnganh.setBorder(new LineBorder(Color.BLACK,2));
        nhapmanganh = new JTextField(10);
        nhapmanganh.setBorder(new LineBorder(Color.BLACK,2));
        // combobox
        String cacphuongthucxettuyen [] = {"","Tuyển thẳng, ƯTXT theo qui định của Bộ GD&ĐT và của Trường","Xét theo kết quả thi tốt THPT","Xét theo kết quả học tập bậc THPT",
                "Xét theo kết quả đánh giá năng lực do ĐHQGHN tổ chức năm 2023","Xét kết hợp CCQT với kết quả thi tốt nghiệp THPT","Xét kết hợp CCQT với kết quả học tập bậc THPT"
                ,"Xét kết hợp giải HSG với kết quả thi tốt nghiệp THPT"};
        nhapphuongthucxettuyen = new JComboBox(cacphuongthucxettuyen);
        nhapphuongthucxettuyen.setBorder(new LineBorder(Color.BLACK,2));
        String[] cactohopmon = {"","A00\tToán, Vật lý, Hóa học","A01\tToán, Vật lý, Tiếng Anh","A02\tToán, Vật lý, Sinh học","A03\tToán, Vật lý, Lịch sử",
                "A04\tToán, Vật lý, Địa lý","A05\tToán, Hóa học, Lịch sử","A06\tToán, Hóa học, Địa lý","A07\tToán, Lịch sử, Địa lý","A08\tToán, Lịch sử, Giáo dục công dân",
                "A09\tToán, Địa lý, Giáo dục công dân","A10\tToán, Vật lý, Giáo dục công dân","B00\tToán, Hóa học, Sinh học","B01\tToán, Sinh học, Lịch sử","B02\tToán, Sinh học, Địa lý",
                "B03\tToán, Sinh học, Ngữ văn","B04\tToán, Sinh học, Giáo dục công dân","B05\tToán, Sinh học, Khoa học xã hội","B08\tToán, Sinh học, Tiếng Anh","C00\tNgữ văn, Lịch sử, Địa lý","" +
                "C01\tNgữ văn, Toán học, Vật lý","C02\tNgữ văn, Toán học, Hóa học","C03\tNgữ văn, Toán học, Lịch sử","C04\tNgữ văn, Toán học, Địa lý","C05\tNgữ văn, Vật lý, Hóa học",
                "C06\tNgữ văn, Vật lý, Sinh học","C07\tNgữ văn, Vật lý, Lịch sử","C08\tNgữ văn, Hóa học, Sinh học","C09\tNgữ văn, Vật lý, Địa lý","C10\tNgữ văn, Hóa học, Lịch sử",
                "D01\tNgữ văn, Toán học, Tiếng Anh","D02\tNgữ văn, Toán học, Tiếng Nga","D03\tNgữ văn, Toán học, Tiếng Pháp","D04\tNgữ văn, Toán học, Tiếng Trung","D05\tNgữ văn, Toán học, Tiếng Đức","D06\tNgữ văn, Toán học, Tiếng Nhật",
                "D07\tToán học, Hóa học, Tiếng Anh","D08\tToán học, Sinh học, Tiếng Anh","D09\tToán học, Lịch sử, Tiếng Anh","D10\tToán học, Địa lý, Tiếng Anh"};
        nhaptohopmon = new JComboBox(cactohopmon);
        nhaptohopmon.setBorder(new LineBorder(Color.BLACK,2));
        //table nguyện vọng
        nguyenvong  = new DefaultTableModel();
        nguyenvong.addColumn("Số CCCD");
        nguyenvong.addColumn("STT NV");
        nguyenvong.addColumn("Trường");
        nguyenvong.addColumn("Mã trường");
        nguyenvong.addColumn("Ngành");
        nguyenvong.addColumn("Mã ngành");
        nguyenvong.addColumn("Phương thức xét tuyển");
        nguyenvong.addColumn("Tổ hợp môn");

        tbnguyenvong = new JTable(nguyenvong);
        TableColumnModel columnModelnguyenvong = tbnguyenvong.getColumnModel();
        columnModelnguyenvong.getColumn(0).setPreferredWidth(50);
        columnModelnguyenvong.getColumn(1).setPreferredWidth(30);
        columnModelnguyenvong.getColumn(2).setPreferredWidth(150);
        columnModelnguyenvong.getColumn(3).setPreferredWidth(45);
        columnModelnguyenvong.getColumn(4).setPreferredWidth(130);
        columnModelnguyenvong.getColumn(5).setPreferredWidth(45);
        columnModelnguyenvong.getColumn(6).setPreferredWidth(130);
        columnModelnguyenvong.getColumn(7).setPreferredWidth(110);

        JScrollPane scnguyenvong = new JScrollPane(tbnguyenvong);
        scnguyenvong.setBorder(new LineBorder(new Color(255,20,147),3));
        scnguyenvong.setPreferredSize(new Dimension(1060,210));

        JPanel bodertitlesouthnguyenvong = new JPanel();
        Border bordernguyenvong = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitnguyenvong = BorderFactory.createTitledBorder(bordernguyenvong, " NGUYỆN VỌNG   ");
        bodertitlesouthnguyenvong.setBorder(bordertitnguyenvong);
        bodertitlesouthnguyenvong.setBackground(new Color(230,230,250));
        bodertitlesouthnguyenvong.add(scnguyenvong);
        //Jbutton
        xacnhandangkinv = new JButton("  Xác nhận đăng kí nguyện vọng ");
        xacnhandangkinv.setHorizontalAlignment(JButton.LEADING);
        xacnhandangkinv.setBorderPainted(false);
        xacnhandangkinv.setContentAreaFilled(false);
        xacnhandangkinv.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-mark.png"))));

        nhaplaithongtinnv = new JButton("  Nhập lại thông tin nguyện vọng  ");
        nhaplaithongtinnv.setHorizontalAlignment(JButton.LEADING);
        nhaplaithongtinnv.setBorderPainted(false);
        nhaplaithongtinnv.setContentAreaFilled(false);
        nhaplaithongtinnv.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/reset.png"))));
       
        xoanguyenvong = new JButton("  Xóa nguyện vọng đã chọn  ");
        xoanguyenvong.setHorizontalAlignment(JButton.LEADING);
        xoanguyenvong.setBorderPainted(false);
        xoanguyenvong.setContentAreaFilled(false);
        xoanguyenvong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/eraser.png"))));

        xoatatcanv = new JButton("  Xóa tất cả nguyện vọng  ");
        xoatatcanv.setHorizontalAlignment(JButton.LEADING);
        xoatatcanv.setBorderPainted(false);
        xoatatcanv.setContentAreaFilled(false);
        xoatatcanv.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/delete (1).png"))));
        
        capnhatnguyenvong = new JButton("  Cập nhật thông tin nguyện vọng  ");
        capnhatnguyenvong.setHorizontalAlignment(JButton.LEADING);
        capnhatnguyenvong.setBorderPainted(false);
        capnhatnguyenvong.setContentAreaFilled(false);
        capnhatnguyenvong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/implement.png"))));
        
        timkiemthongtinnv = new JButton("  Tìm kiếm thông tin nguyện vọng  ");
        timkiemthongtinnv.setHorizontalAlignment(JButton.LEADING);
        timkiemthongtinnv.setBorderPainted(false);
        timkiemthongtinnv.setContentAreaFilled(false);
        timkiemthongtinnv.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/loupe.png"))));
        
        suathongtinnv = new JButton("  Sửa thông tin nguyện vọng  ");
        suathongtinnv.setHorizontalAlignment(JButton.LEADING);
        suathongtinnv.setBorderPainted(false);
        suathongtinnv.setContentAreaFilled(false);
        suathongtinnv.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/note.png"))));
        
        //Jpanel label đk nguyện vọng
        JPanel girdthongtinnv = new JPanel();
        girdthongtinnv.setBackground(new Color(255,240,245));
        girdthongtinnv.setLayout(new GridLayout(7,1,1,36));
        girdthongtinnv.add(thutunguyenvong);
        girdthongtinnv.add(truongdaihoc);
        girdthongtinnv.add(matruongdaihoc);
        girdthongtinnv.add(nganh);
        girdthongtinnv.add(manganh);
        girdthongtinnv.add(phuongthucxettuyen);
        girdthongtinnv.add(tohopmon);
        //Jpanel trường nhập thông tin nguyện vọng
        JPanel girdnhapthongtinnv = new JPanel();
        girdnhapthongtinnv.setBackground(new Color(255,240,245));
        girdnhapthongtinnv.setLayout(new GridLayout(7,1,1,23));
        girdnhapthongtinnv.add(nhapthutunguyenvong);
        girdnhapthongtinnv.add(nhaptruongdaihoc);
        girdnhapthongtinnv.add(nhapmatruongdaihoc);
        girdnhapthongtinnv.add(nhapnganh);
        girdnhapthongtinnv.add(nhapmanganh);
        girdnhapthongtinnv.add(nhapphuongthucxettuyen);
        girdnhapthongtinnv.add(nhaptohopmon);
        //Jpanel button đăng kí nguyện vọng
        JPanel grbuttonnv = new JPanel();
        grbuttonnv.setBackground(new Color(144,238,144));
        grbuttonnv.setLayout(new GridLayout(8,0,0,10));
        grbuttonnv.add(xacnhandangkinv);
        grbuttonnv.add(nhaplaithongtinnv);
        grbuttonnv.add(xoanguyenvong);
        grbuttonnv.add(xoatatcanv);
        grbuttonnv.add(capnhatnguyenvong);
        grbuttonnv.add(timkiemnguyenvong);
        grbuttonnv.add(timkiemthongtinnv);
        grbuttonnv.add(suathongtinnv);
        //Jpanel tổng cho các layout
        JPanel centernguyenvong = new JPanel();
        centernguyenvong.setBackground(new Color(255,240,245));
        centernguyenvong.setLayout(new FlowLayout(1,25,25));
        centernguyenvong.add(girdthongtinnv);
        centernguyenvong.add(girdnhapthongtinnv);

        //Jbutton thông tin
        XacNhan = new JButton("  Xác nhận thông tin thí sinh ");
        XacNhan.setHorizontalAlignment(JButton.LEADING);
        XacNhan.setBorderPainted(false);
        XacNhan.setContentAreaFilled(false);
        XacNhan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-mark.png"))));

        NhapLai = new JButton("  Nhập lại thông tin thí sinh  ");
        NhapLai.setHorizontalAlignment(JButton.LEADING);
        NhapLai.setBorderPainted(false);
        NhapLai.setContentAreaFilled(false);
        NhapLai.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/reset.png"))));

        XoaTatCa = new JButton("  Xóa tất cả thông tin  ");
        XoaTatCa.setHorizontalAlignment(JButton.LEADING);
        XoaTatCa.setBorderPainted(false);
        XoaTatCa.setContentAreaFilled(false);
        XoaTatCa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/delete (1).png"))));
        
        Xoa1ThongTin = new JButton("  Xóa thông tin đã chọn  ");
        Xoa1ThongTin.setHorizontalAlignment(JButton.LEADING);
        Xoa1ThongTin.setBorderPainted(false);
        Xoa1ThongTin.setContentAreaFilled(false);
        Xoa1ThongTin.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/user.png"))));

        CapNhatThongTin = new JButton("  Cập nhật thông tin thí sinh  ");
        CapNhatThongTin.setHorizontalAlignment(JButton.LEADING);
        CapNhatThongTin.setBorderPainted(false);
        CapNhatThongTin.setContentAreaFilled(false);
        CapNhatThongTin.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/implement.png"))));
        
        TimKimThongTinThiSinh = new JButton("  Tìm kiếm thông tin thí sinh  ");
        TimKimThongTinThiSinh.setHorizontalAlignment(JButton.LEADING);
        TimKimThongTinThiSinh.setBorderPainted(false);
        TimKimThongTinThiSinh.setContentAreaFilled(false);
        TimKimThongTinThiSinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/loupe.png"))));
        
        SuaThongTinThiSinh = new JButton("  Sửa thông tin thí sinh  ");
        SuaThongTinThiSinh.setHorizontalAlignment(JButton.LEADING);
        SuaThongTinThiSinh.setBorderPainted(false);
        SuaThongTinThiSinh.setContentAreaFilled(false);
        SuaThongTinThiSinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/note.png"))));
        
        //Jbutton lịch thi
        XacNhanLichThi = new JButton("  Xác nhận lịch thi ");
        XacNhanLichThi.setHorizontalAlignment(JButton.LEADING);
        XacNhanLichThi.setBorderPainted(false);
        XacNhanLichThi.setContentAreaFilled(false);
        XacNhanLichThi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-mark.png"))));
        
        NhapLaiLichThi = new JButton("  Nhập lại thông tin môn thi ");
        NhapLaiLichThi.setHorizontalAlignment(JButton.LEADING);
        NhapLaiLichThi.setBorderPainted(false);
        NhapLaiLichThi.setContentAreaFilled(false);
        NhapLaiLichThi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/reset.png"))));
        
        Xoa1LichThi = new JButton("  Xóa môn thi đã chọn  ");
        Xoa1LichThi.setHorizontalAlignment(JButton.LEADING);
        Xoa1LichThi.setBorderPainted(false);
        Xoa1LichThi.setContentAreaFilled(false);
        Xoa1LichThi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/eraser.png"))));
        
        XoaTatCaLichThi  = new JButton("  Xóa tất cả lịch thi  ");
        XoaTatCaLichThi.setHorizontalAlignment(JButton.LEADING);
        XoaTatCaLichThi.setBorderPainted(false);
        XoaTatCaLichThi.setContentAreaFilled(false);
        XoaTatCaLichThi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/delete (1).png"))));
        
        CapNhatLichThi = new JButton("  Cập nhật lịch thi  ");
        CapNhatLichThi.setHorizontalAlignment(JButton.LEADING);
        CapNhatLichThi.setBorderPainted(false);
        CapNhatLichThi.setContentAreaFilled(false);
        CapNhatLichThi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/implement.png"))));
        
        TimKiemLichThiTheoCCCD = new JButton("  Tìm kiếm lịch thi  ");
        TimKiemLichThiTheoCCCD.setHorizontalAlignment(JButton.LEADING);
        TimKiemLichThiTheoCCCD.setBorderPainted(false);
        TimKiemLichThiTheoCCCD.setContentAreaFilled(false);
        TimKiemLichThiTheoCCCD.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/loupe.png"))));
        
        //thông tin nhập điểm thí sinh
        //Jlabel
        JLabel diemtoan = new JLabel("Điểm môn Toán");
        JLabel diemvan = new JLabel("Điểm môn Ngữ văn");
        JLabel diemly = new JLabel("Điểm môn Vật lý");
        JLabel diemhoa = new JLabel("Điểm môn Hóa học");
        JLabel diemsinh  = new JLabel("Điểm môn Sinh học");
        JLabel diemsu = new JLabel("Điểm môn Lịch sử");
        JLabel diemdia = new JLabel("Điểm môn Địa lí");
        JLabel diemgdcd = new JLabel("Điêm môn GDCD");
        JLabel diemanh = new JLabel("Điểm môn Tiếng anh");
        //Jtextfield các trường nhập điểm
        nhapdiemtoan = new JTextField(30);
        nhapdiemtoan.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemvan = new JTextField(30);
        nhapdiemvan.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemly = new JTextField(30);
        nhapdiemly.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemhoa = new JTextField(30);
        nhapdiemhoa.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemsinh = new JTextField(30);
        nhapdiemsinh.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemsu = new JTextField(30);
        nhapdiemsu.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemdia = new JTextField(30);
        nhapdiemdia.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemgdcd = new JTextField(30);
        nhapdiemgdcd.setBorder(new LineBorder(Color.BLACK,2));
        nhapdiemanh = new JTextField(30);
        nhapdiemanh.setBorder(new LineBorder(Color.BLACK,2));
        //Jlabel + textfield tìm kiếm thí sinh
        JLabel timkiemdiemthisinh = new JLabel("CCCD cần tìm");
        nhapthongtindiem = new JTextField(15);
        nhapthongtindiem.setBorder(new LineBorder(Color.BLUE,3));
        JPanel timkiemdiem = new JPanel();
        timkiemdiem.setBackground(new Color(255,228,225));
        timkiemdiem.setLayout(new FlowLayout(5,8,1));
        timkiemdiem.add(timkiemdiemthisinh);
        timkiemdiem.add(nhapthongtindiem);
        //Jtable thông tin điểm
        diemthi  = new DefaultTableModel();
        diemthi.addColumn("Số CCCD");
        diemthi.addColumn("Điểm Toán");
        diemthi.addColumn("Điểm Ngữ văn");
        diemthi.addColumn("Điểm Tiếng Anh");
        diemthi.addColumn("Điểm Vật lý");
        diemthi.addColumn("Điểm Hóa học");
        diemthi.addColumn("Điểm Sinh học");
        diemthi.addColumn("Điểm Lịch sử");
        diemthi.addColumn("Điểm Địa lí");
        diemthi.addColumn("Điểm GDCD");

        tbdiemthi = new JTable(diemthi);
        TableColumnModel columnModeldiemtn = tbdiemthi.getColumnModel();
        columnModeldiemtn.getColumn(0).setPreferredWidth(100);
        columnModeldiemtn.getColumn(1).setPreferredWidth(100);
        columnModeldiemtn.getColumn(2).setPreferredWidth(100);
        columnModeldiemtn.getColumn(3).setPreferredWidth(100);
        columnModeldiemtn.getColumn(4).setPreferredWidth(100);
        columnModeldiemtn.getColumn(5).setPreferredWidth(100);
        columnModeldiemtn.getColumn(6).setPreferredWidth(100);
        columnModeldiemtn.getColumn(7).setPreferredWidth(100);
        columnModeldiemtn.getColumn(8).setPreferredWidth(100);
        columnModeldiemtn.getColumn(9).setPreferredWidth(100);
        JScrollPane scdiemthi = new JScrollPane(tbdiemthi);
        scdiemthi.setBorder(new LineBorder(new Color(0,250,154),3));
        scdiemthi.setPreferredSize(new Dimension(1060,210));

        JPanel bodertitlesouthdiem = new JPanel();
        Border borderdiem = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitdiem = BorderFactory.createTitledBorder(borderdiem, " DANH SÁCH ĐIỂM THI   ");
        bodertitlesouthdiem.setBorder(bordertitdiem);
        bodertitlesouthdiem.setBackground(new Color(143,188,143));
        bodertitlesouthdiem.add(scdiemthi);
        //Jbutton thông tin điểm
        XacNhanNhapDiem = new JButton("  Xác nhận nhập điểm  ");
        XacNhanNhapDiem.setHorizontalAlignment(JButton.LEADING);
        XacNhanNhapDiem.setBorderPainted(false);
        XacNhanNhapDiem.setContentAreaFilled(false);
        XacNhanNhapDiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-mark.png"))));
        
        NhapLaiDiem = new JButton("  Nhập lại thông tin điểm  ");
        NhapLaiDiem.setHorizontalAlignment(JButton.LEADING);
        NhapLaiDiem.setBorderPainted(false);
        NhapLaiDiem.setContentAreaFilled(false);
        NhapLaiDiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/reset.png"))));

        XoaDiemDaChon = new JButton("  Xóa điểm thí sinh đã chọn  ");
        XoaDiemDaChon.setHorizontalAlignment(JButton.LEADING);
        XoaDiemDaChon.setBorderPainted(false);
        XoaDiemDaChon.setContentAreaFilled(false);
        XoaDiemDaChon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/eraser.png"))));

        XoaTaCaDiem = new JButton("  Xóa tất cả điểm thi  ");
        XoaTaCaDiem.setHorizontalAlignment(JButton.LEADING);
        XoaTaCaDiem.setBorderPainted(false);
        XoaTaCaDiem.setContentAreaFilled(false);
        XoaTaCaDiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/delete (1).png"))));

        CapNhatDiem = new JButton("  Cập nhật thông tin điểm  ");
        CapNhatDiem.setHorizontalAlignment(JButton.LEADING);
        CapNhatDiem.setBorderPainted(false);
        CapNhatDiem.setContentAreaFilled(false);
        CapNhatDiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/implement.png"))));

        TimKiemDiemTheoCccd = new JButton("  Tìm kiếm điểm của thí sinh  ");
        TimKiemDiemTheoCccd.setHorizontalAlignment(JButton.LEADING);
        TimKiemDiemTheoCccd.setBorderPainted(false);
        TimKiemDiemTheoCccd.setContentAreaFilled(false);
        TimKiemDiemTheoCccd.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/loupe.png"))));

        SuaDiemThiSinh = new JButton("  Sửa điểm của thí sinh");
        SuaDiemThiSinh.setHorizontalAlignment(JButton.LEADING);
        SuaDiemThiSinh.setBorderPainted(false);
        SuaDiemThiSinh.setContentAreaFilled(false);
        SuaDiemThiSinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/note.png"))));
        
        //Grbutton phần điểm thí sinh
        JPanel grbuttondiem = new JPanel();
        grbuttondiem.setLayout(new GridLayout(8,0,0,10));
        grbuttondiem.setBackground(new Color(255,228,225));
        grbuttondiem.add(XacNhanNhapDiem);
        grbuttondiem.add(NhapLaiDiem);
        grbuttondiem.add(XoaDiemDaChon);
        grbuttondiem.add(XoaTaCaDiem);
        grbuttondiem.add(CapNhatDiem);
        grbuttondiem.add(timkiemdiem);
        grbuttondiem.add(TimKiemDiemTheoCccd);
        grbuttondiem.add(SuaDiemThiSinh);
        //panel set layout phần thông tin điểm
        JPanel diemthisinh = new JPanel();
        diemthisinh.setLayout(new GridLayout(9,1,1,25));
        diemthisinh.setBackground(new Color(173,216,230));
        diemthisinh.add(diemtoan);
        diemthisinh.add(diemvan);
        diemthisinh.add(diemanh);
        diemthisinh.add(diemly);
        diemthisinh.add(diemhoa);
        diemthisinh.add(diemsinh);
        diemthisinh.add(diemsu);
        diemthisinh.add(diemdia);
        diemthisinh.add(diemgdcd);
        //panel set layout trường thông tin nhập điểm
        JPanel nhapdiem = new JPanel();
        nhapdiem.setBackground(new Color(173,216,230));
        nhapdiem.setLayout(new GridLayout(9,1,1,21));
        nhapdiem.add(nhapdiemtoan);
        nhapdiem.add(nhapdiemvan);
        nhapdiem.add(nhapdiemanh);
        nhapdiem.add(nhapdiemly);
        nhapdiem.add(nhapdiemhoa);
        nhapdiem.add(nhapdiemsinh);
        nhapdiem.add(nhapdiemsu);
        nhapdiem.add(nhapdiemdia);
        nhapdiem.add(nhapdiemgdcd);
        //panel center nhập điểm
        JPanel centerdiem = new JPanel();
        centerdiem.setLayout(new FlowLayout(1,25,25));
        centerdiem.setBackground(new Color(173,216,230));
        centerdiem.add(diemthisinh);
        centerdiem.add(nhapdiem);

        //hoc baaaaaaa
        JLabel monhocba = new JLabel("Môn học");
        JLabel hocky1lop10 = new JLabel("Trung bình HKI lớp 10");
        JLabel hocky2lop10 = new JLabel("Trung bình HKII lớp 10");
        JLabel hocky1lop11 = new JLabel("Trung bình HKI lớp 11");
        JLabel hocky2lop11 = new JLabel("Trung bình HKII lớp 11");
        JLabel hocky1lop12 = new JLabel("Trung bình HKI lớp 12");
        JLabel hocky2lop12 = new JLabel("Trung bình HKII lớp 12");
        JLabel trungbinhcanam12 = new JLabel("Trung bình cả năm lớp 12");
        JLabel trungbinh6ky = new JLabel("Trung bình 6 kỳ học");
        JLabel trungbinh5ky = new JLabel("Trung bình 5 kỳ học");
        //Jpanel tìm kiếm điểm học bạ
        JLabel timkiemdiemthisinhhb = new JLabel("CCCD cần tìm");
        nhapthongtindiemhb = new JTextField(15);
        nhapthongtindiemhb.setBorder(new LineBorder(Color.BLUE,3));
        JPanel timkiemdiemHB = new JPanel();
        timkiemdiemHB.setBackground(new Color(224,255,255));
        timkiemdiemHB.setLayout(new FlowLayout(5,8,1));
        timkiemdiemHB.add(timkiemdiemthisinhhb);
        timkiemdiemHB.add(nhapthongtindiemhb);
        //Jpanel Jlabel điểm học bạ
        JPanel diemhocba = new JPanel();
        diemhocba.setLayout(new GridLayout(10,1,1,23));
        diemhocba.setBackground(new Color(255,235,205));
        diemhocba.add(monhocba);
        diemhocba.add(hocky1lop10);
        diemhocba.add(hocky2lop10);
        diemhocba.add(hocky1lop11);
        diemhocba.add(hocky2lop11);
        diemhocba.add(hocky1lop12);
        diemhocba.add(hocky2lop12);
        diemhocba.add(trungbinhcanam12);
        diemhocba.add(trungbinh6ky);
        diemhocba.add(trungbinh5ky);
        //Jtextfield nhập điểm học bạ
        String cacmonhocba [] = {"","Toán","Ngữ Văn","Tiếng Anh","Vật Lý","Hóa Học","Sinh Học","Lịch Sử","Địa Lí","Giáo Dục Công Dân"};
        nhapmonhocba = new JComboBox(cacmonhocba);
        nhapmonhocba.setBorder(new LineBorder(Color.BLACK,2));
        nhaphocky1lop10 = new JTextField(30);
        nhaphocky1lop10.setBorder(new LineBorder(Color.BLACK,2));
        nhaphocky2lop10 = new JTextField(30);
        nhaphocky2lop10.setBorder(new LineBorder(Color.BLACK,2));
        nhaphocky1lop11 = new JTextField(30);
        nhaphocky1lop11.setBorder(new LineBorder(Color.BLACK,2));
        nhaphocky2lop11 = new JTextField(30);
        nhaphocky2lop11.setBorder(new LineBorder(Color.BLACK,2));
        nhaphocky1lop12 = new JTextField(30);
        nhaphocky1lop12.setBorder(new LineBorder(Color.BLACK,2));
        nhaphocky2lop12 = new JTextField(30);
        nhaphocky2lop12.setBorder(new LineBorder(Color.BLACK,2));
        nhaptrungbinhcanam12 = new JTextField(30);
        nhaptrungbinhcanam12.setBorder(new LineBorder(Color.BLACK,2));
        nhaptrungbinhcanam12.setEditable(false);
        nhaptrungbinh6ky = new JTextField(30);
        nhaptrungbinh6ky.setBorder(new LineBorder(Color.BLACK,2));
        nhaptrungbinh6ky.setEditable(false);
        nhaptrungbinh5ky = new JTextField(30);
        nhaptrungbinh5ky.setBorder(new LineBorder(Color.BLACK,2));
        nhaptrungbinh5ky.setEditable(false);
        //Jpanel jtextfield nhập điểm học bạ
        JPanel nhapdiemhocba = new JPanel();
        nhapdiemhocba.setLayout(new GridLayout(10,1,1,10));
        nhapdiemhocba.setBackground(new Color(255,235,205));
        nhapdiemhocba.add(nhapmonhocba);
        nhapdiemhocba.add(nhaphocky1lop10);
        nhapdiemhocba.add(nhaphocky2lop10);
        nhapdiemhocba.add(nhaphocky1lop11);
        nhapdiemhocba.add(nhaphocky2lop11);
        nhapdiemhocba.add(nhaphocky1lop12);
        nhapdiemhocba.add(nhaphocky2lop12);
        nhapdiemhocba.add(nhaptrungbinhcanam12);
        nhapdiemhocba.add(nhaptrungbinh6ky);
        nhapdiemhocba.add(nhaptrungbinh5ky);
        //Tabel điểm học bạ của thí sinh
        diemhb  = new DefaultTableModel();
        diemhb.addColumn("Số CCCD");
        diemhb.addColumn("Họ và tên");
        diemhb.addColumn("Môn học");
        diemhb.addColumn("TB HKI-10");
        diemhb.addColumn("TB HKII-10");
        diemhb.addColumn("TB HKI-11");
        diemhb.addColumn("TB HKII-11");
        diemhb.addColumn("TB HKI-12");
        diemhb.addColumn("TB HKII-12");
        diemhb.addColumn("TBCN-12");
        diemhb.addColumn("TB 6 HK");
        diemhb.addColumn("TB 5 HK");

        tbdiemhb = new JTable(diemhb);
        TableColumnModel columnModeldiemhb = tbdiemhb.getColumnModel();
        columnModeldiemhb.getColumn(0).setPreferredWidth(95);
        columnModeldiemhb.getColumn(1).setPreferredWidth(150);
        columnModeldiemhb.getColumn(2).setPreferredWidth(110);
        columnModeldiemhb.getColumn(3).setPreferredWidth(95);
        columnModeldiemhb.getColumn(4).setPreferredWidth(95);
        columnModeldiemhb.getColumn(5).setPreferredWidth(95);
        columnModeldiemhb.getColumn(6).setPreferredWidth(95);
        columnModeldiemhb.getColumn(7).setPreferredWidth(95);
        columnModeldiemhb.getColumn(8).setPreferredWidth(95);
        columnModeldiemhb.getColumn(9).setPreferredWidth(95);
        columnModeldiemhb.getColumn(10).setPreferredWidth(95);
        columnModeldiemhb.getColumn(11).setPreferredWidth(95);
        JScrollPane scdiemhb = new JScrollPane(tbdiemhb);
        scdiemhb.setBorder(new LineBorder(new Color(0,206,209),3));
        scdiemhb.setPreferredSize(new Dimension(1060,210));

        JPanel bodertitlesouthdiemhb = new JPanel();
        Border borderdiemhb = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitdiemhb = BorderFactory.createTitledBorder(borderdiemhb, " ĐIỂM HỌC BẠ  ");
        bodertitlesouthdiemhb.setBorder(bordertitdiemhb);
        bodertitlesouthdiemhb.setBackground(new Color(152,251,152));
        bodertitlesouthdiemhb.add(scdiemhb);
        //Jbutton điểm học bạ
        XacNhanNhapDiemHB = new JButton("  Xác nhận nhập điểm học bạ  ");
        XacNhanNhapDiemHB.setHorizontalAlignment(JButton.LEADING);
        XacNhanNhapDiemHB.setBorderPainted(false);
        XacNhanNhapDiemHB.setContentAreaFilled(false);
        XacNhanNhapDiemHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-mark.png"))));
    
        NhapLaiDiemHB = new JButton("  Nhập lại điểm học bạ ");
        NhapLaiDiemHB.setHorizontalAlignment(JButton.LEADING);
        NhapLaiDiemHB.setBorderPainted(false);
        NhapLaiDiemHB.setContentAreaFilled(false);
        NhapLaiDiemHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/reset.png"))));

        XoaTatCaDiemHB = new JButton("  Xóa tất cả điểm học bạ  ");
        XoaTatCaDiemHB.setHorizontalAlignment(JButton.LEADING);
        XoaTatCaDiemHB.setBorderPainted(false);
        XoaTatCaDiemHB.setContentAreaFilled(false);
        XoaTatCaDiemHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/delete (1).png"))));

        XoaDiemDaChonHB = new JButton("  Xóa điểm học bạ môn đã chọn  ");
        XoaDiemDaChonHB.setHorizontalAlignment(JButton.LEADING);
        XoaDiemDaChonHB.setBorderPainted(false);
        XoaDiemDaChonHB.setContentAreaFilled(false);
        XoaDiemDaChonHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/eraser.png"))));

        CapNhatDiemHB = new JButton("  Cập nhật thông tin điểm học bạ  ");
        CapNhatDiemHB.setHorizontalAlignment(JButton.LEADING);
        CapNhatDiemHB.setBorderPainted(false);
        CapNhatDiemHB.setContentAreaFilled(false);
        CapNhatDiemHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/implement.png"))));

        TimKiemDiemTheoCccdHB = new JButton("  Tìm kiếm điểm học bạ của thí sinh  ");
        TimKiemDiemTheoCccdHB.setHorizontalAlignment(JButton.LEADING);
        TimKiemDiemTheoCccdHB.setBorderPainted(false);
        TimKiemDiemTheoCccdHB.setContentAreaFilled(false);
        TimKiemDiemTheoCccdHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/loupe.png"))));

        SuaDiemThiSinhHB = new JButton("  Sửa điểm học bạ của thí sinh");
        SuaDiemThiSinhHB.setHorizontalAlignment(JButton.LEADING);
        SuaDiemThiSinhHB.setBorderPainted(false);
        SuaDiemThiSinhHB.setContentAreaFilled(false);
        SuaDiemThiSinhHB.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/note.png"))));

        //Jpanel center điểm học bạ
        JPanel ThongTinDiemHocBa = new JPanel();
        ThongTinDiemHocBa.setLayout(new FlowLayout(1,70,20));
        ThongTinDiemHocBa.setBackground(new Color(255,235,205));
        ThongTinDiemHocBa.add(diemhocba);
        ThongTinDiemHocBa.add(nhapdiemhocba);
        //Jpanel East button điểm học bạ
        JPanel grbuttondiemhb = new JPanel();
        grbuttondiemhb.setLayout(new GridLayout(8,0,0,10));
        grbuttondiemhb.setBackground(new Color(224,255,255));
        grbuttondiemhb.add(XacNhanNhapDiemHB);
        grbuttondiemhb.add(NhapLaiDiemHB);
        grbuttondiemhb.add(XoaDiemDaChonHB);
        grbuttondiemhb.add(XoaTatCaDiemHB);
        grbuttondiemhb.add(CapNhatDiemHB);
        grbuttondiemhb.add(timkiemdiemHB);
        grbuttondiemhb.add(TimKiemDiemTheoCccdHB);
        grbuttondiemhb.add(SuaDiemThiSinhHB);
        //Công cụ tính điểm TNPT
        JLabel cccdtinhdiemtnpt = new JLabel("Nhập vào số CCCD(nếu thông tin đã có trong hệ thống)");
        JLabel diemmontoan = new JLabel("Nhập điểm môn Toán");
        JLabel diemmonvan = new JLabel("Nhập điểm môn Ngữ văn");
        JLabel diemmonanh = new JLabel("Nhập điểm môn Ngoại ngữ");
        JLabel diemmonly_su = new JLabel("Nhập điểm môn Vật lý(hoặc Lịch sử)");
        JLabel diemmonhoa_dia = new JLabel("Nhập điểm môn Hóa học(hoặc Địa lí)");
        JLabel diemmonsinh_gdcd = new JLabel("Nhập điểm môn Sinh học(hoặc GDCD)");
        JLabel diemtb12 = new JLabel("Nhập điểm trung bình cả năm lớp 12");
        JLabel diemkhuyenkhich = new JLabel("Nhập điểm khuyến khích(nếu có)");
        JLabel diemuutien = new JLabel("Nhập điểm ưu tiên(nếu có)");
        JLabel doituonghs = new JLabel("Đối tượng học sinh");
        JLabel diemxettotnghiep = new JLabel("Điểm xét tốt nghiệp: ");
        JLabel cccdxettotnghiep = new JLabel("CCCD cần xét điểm TNPT: ");
        hienthidiemxettotnghiep = new JLabel("0.0");
        hienthidiemxettotnghiep.setForeground(Color.RED);
        hienthicccdxettotnghiep = new JLabel("");
        hienthicccdxettotnghiep.setForeground(Color.RED);
        JLabel trongtren = new JLabel();
        JLabel trongduoi = new JLabel();
        JLabel tronggiua = new JLabel();
        JPanel jpaneldiemxettotnghiep = new JPanel();
        jpaneldiemxettotnghiep.setLayout(new FlowLayout(5,1,5));
        jpaneldiemxettotnghiep.add(diemxettotnghiep);
        jpaneldiemxettotnghiep.add(hienthidiemxettotnghiep);

        JPanel jpanelcccdxettotnghiep = new JPanel();
        jpanelcccdxettotnghiep.setLayout(new FlowLayout(5,1,5));
        jpanelcccdxettotnghiep.add(cccdxettotnghiep);
        jpanelcccdxettotnghiep.add(hienthicccdxettotnghiep);

        JPanel thongtintinhdiem = new JPanel();
        thongtintinhdiem.setLayout(new GridLayout(11,1,1,20));
        thongtintinhdiem.add(cccdtinhdiemtnpt);
        thongtintinhdiem.add(diemmontoan);
        thongtintinhdiem.add(diemmonvan);
        thongtintinhdiem.add(diemmonanh);
        thongtintinhdiem.add(diemmonly_su);
        thongtintinhdiem.add(diemmonhoa_dia);
        thongtintinhdiem.add(diemmonsinh_gdcd);
        thongtintinhdiem.add(diemtb12);
        thongtintinhdiem.add(diemkhuyenkhich);
        thongtintinhdiem.add(diemuutien);
        thongtintinhdiem.add(doituonghs);
        //Jtextfield nhập công cụ tính điểm xét tốt nghiệp
        nhapcccdtinhdiemtnpt = new JTextField(25);
        nhapcccdtinhdiemtnpt.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemmontoan = new JTextField(25);
        nhapdiemmontoan.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemmonvan = new JTextField(25);
        nhapdiemmonvan.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemmonanh = new JTextField(25);
        nhapdiemmonanh.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemmonly_su = new JTextField(25);
        nhapdiemmonly_su.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemmonhoa_dia = new JTextField(25);
        nhapdiemmonhoa_dia.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemmonsinh_gdcd = new JTextField(25);
        nhapdiemmonsinh_gdcd.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemtb12 = new JTextField(25);
        nhapdiemtb12.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemkhuyenkhich = new JTextField(25);
        nhapdiemkhuyenkhich.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemkhuyenkhich.setText(String.valueOf(0));
        nhapdiemuutien = new JTextField(25);
        nhapdiemuutien.setBorder(new LineBorder(new Color(175,238,238),2));
        nhapdiemuutien.setText(String.valueOf(0));
        String cacdoituonghs [] = {"","Hệ THPT","Hệ GDTX"};
        nhapdoituonghs = new JComboBox(cacdoituonghs);
        nhapdoituonghs.setBackground(new Color(238,130,238));
        nhapdoituonghs.setForeground(Color.WHITE);
        JPanel nhapthongtintinhdiem = new JPanel();
        nhapthongtintinhdiem.setLayout(new GridLayout(11,1,1,11));
        nhapthongtintinhdiem.add(nhapcccdtinhdiemtnpt);
        nhapthongtintinhdiem.add(nhapdiemmontoan);
        nhapthongtintinhdiem.add(nhapdiemmonvan);
        nhapthongtintinhdiem.add(nhapdiemmonanh);
        nhapthongtintinhdiem.add(nhapdiemmonly_su);
        nhapthongtintinhdiem.add(nhapdiemmonhoa_dia);
        nhapthongtintinhdiem.add(nhapdiemmonsinh_gdcd);
        nhapthongtintinhdiem.add(nhapdiemtb12);
        nhapthongtintinhdiem.add(nhapdiemkhuyenkhich);
        nhapthongtintinhdiem.add(nhapdiemuutien);
        nhapthongtintinhdiem.add(nhapdoituonghs);
        //Table công cụ tính điểm TNPT
        tinhdiemtnpt = new DefaultTableModel();
        tinhdiemtnpt.addColumn("CCCD");
        tinhdiemtnpt.addColumn("Điểm Toán");
        tinhdiemtnpt.addColumn("Điểm Văn");
        tinhdiemtnpt.addColumn("Điểm Anh");
        tinhdiemtnpt.addColumn("Điểm Lý-Sử");
        tinhdiemtnpt.addColumn("Điểm Hóa-Địa");
        tinhdiemtnpt.addColumn("Điểm Sinh-GDCD");
        tinhdiemtnpt.addColumn("Điểm TBCN-12");

        tbtinhdiemtnpt = new JTable(tinhdiemtnpt);
        TableColumnModel columnModeltinhdiem = tbtinhdiemtnpt.getColumnModel();
        columnModeltinhdiem.getColumn(0).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(1).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(2).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(3).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(4).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(5).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(6).setPreferredWidth(110);
        columnModeltinhdiem.getColumn(7).setPreferredWidth(110);

        JScrollPane sctinhdiem = new JScrollPane(tbtinhdiemtnpt);
        sctinhdiem.setBorder(new LineBorder(new Color(240,128,128),3));
        sctinhdiem.setPreferredSize(new Dimension(1060,210));

        JPanel bodertitlesouthtinhdiem = new JPanel();
        Border bordertinhdiem = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertittinhdiem = BorderFactory.createTitledBorder(bordertinhdiem, " THÔNG TIN ĐIỂM   ");
        bodertitlesouthtinhdiem.setBorder(bordertittinhdiem);
        bodertitlesouthtinhdiem.setBackground(new Color(173,216,230));
        bodertitlesouthtinhdiem.add(sctinhdiem);

        //Jbutton xác nhận tính điểm
        xacnhantinhdiem = new JButton("   Tính điểm xét tốt nghiệp   ");
        xacnhantinhdiem.setForeground(Color.WHITE);
        xacnhantinhdiem.setBorder(new LineBorder(new Color(76,175,80)));
        xacnhantinhdiem.setBackground(new Color(76,175,80));

        nhaplaithongtintinhdiem = new JButton("   Nhập lại thông tin điểm   ");
        nhaplaithongtintinhdiem.setForeground(Color.WHITE);
        nhaplaithongtintinhdiem.setBorder(new LineBorder(new Color(76,175,80)));
        nhaplaithongtintinhdiem.setBackground(new Color(76,175,80));

        capnhatthongtintinhdiem = new JButton("  Cập nhật thông tin cần tính điểm ");
        capnhatthongtintinhdiem.setForeground(Color.WHITE);
        capnhatthongtintinhdiem.setBorder(new LineBorder(new Color(76,175,80)));
        capnhatthongtintinhdiem.setBackground(new Color(76,175,80));

        //Jpanel thông tin tính điểm tnpt
        JPanel grthongtintinhdiem = new JPanel();
        grthongtintinhdiem.setLayout(new FlowLayout(1,30,20));
        grthongtintinhdiem.add(thongtintinhdiem);
        grthongtintinhdiem.add(nhapthongtintinhdiem);
        //jpanel button tính điểm
        JPanel buttonlayouteast = new JPanel();
        buttonlayouteast.setLayout(new GridLayout(8,1,1,0));
        buttonlayouteast.add(trongtren);
        buttonlayouteast.add(jpanelcccdxettotnghiep);
        buttonlayouteast.add(capnhatthongtintinhdiem);
        buttonlayouteast.add(jpaneldiemxettotnghiep);
        buttonlayouteast.add(xacnhantinhdiem);
        buttonlayouteast.add(tronggiua);
        buttonlayouteast.add(nhaplaithongtintinhdiem);
        buttonlayouteast.add(trongduoi);

        JPanel flowbuttoneast = new JPanel();
        flowbuttoneast.setLayout(new FlowLayout(1,5,1));
        flowbuttoneast.add(buttonlayouteast);
        //Trang chủ/////
        JLabel centertieude = new JLabel();
        centertieude.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/thithpt (2).png"))));
        JLabel easttieude = new JLabel();
        easttieude.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/thpt (2).png"))));

        JPanel tieudecenter = new JPanel();
        tieudecenter.setBackground(new Color(230,230,250));
        tieudecenter.setBorder(new LineBorder(Color.BLACK,1));
        tieudecenter.setLayout(new FlowLayout(1,1,35));
        tieudecenter.add(centertieude);

        JPanel tieudeeast = new JPanel();
        tieudeeast.setBackground(new Color(255,228,225));
        tieudeeast.setBorder(new LineBorder(Color.BLACK,1));
        tieudeeast.setLayout(new FlowLayout(1,1,50));
        tieudeeast.add(easttieude);

        JLabel loichuc1 = new JLabel("              Hôm nay tôi có lời chúc gửi đến cho các bạn sắp phải bước vào kỳ thi trung học phổ thông quốc gia!");
        JLabel loichuc2 = new JLabel("Tôi mong các bạn hãy luôn tự tin vào bản thân mình và chứng minh cho cả thế giới biết rằng là 12 năm đèn sách của bạn không vô nghĩa.");
        JLabel loichuc3 = new JLabel("Tuy tôi biết rằng: Có rất nhiều con đường để đi đến sự thành công, nhưng con đường học vấn vẫn là con đường ngắn nhất và an toàn nhất.");
        JLabel loichuc4 = new JLabel("Chúc các bạn thi thật tốt, hãy làm hết mình nhé. Vì chúng ta chính là chiến binh và kỳ thi này chính là trận chiến mang tính chất quyết định 70% cuộc đời của bạn sau này...");
        loichuc4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/four-leaf.png"))));
        JLabel loichuc5 = new JLabel("                                                                            #anwriter");

        JPanel loichuc = new JPanel();
        loichuc.setLayout(new GridLayout(5,1,1,1));
        loichuc.setBackground(new Color(224,255,255));
        loichuc.add(loichuc1);
        loichuc.add(loichuc2);
        loichuc.add(loichuc3);
        loichuc.add(loichuc4);
        loichuc.add(loichuc5);

        JPanel southloichuc = new JPanel();
        southloichuc.setLayout(new FlowLayout(1,20,30));
        southloichuc.setBackground(new Color(224,255,255));
        southloichuc.add(loichuc);
        /////////////////////////////////////////////////////
        //Jpanel button thongtin
        JPanel grbutton = new JPanel();
        grbutton.setBackground(new Color(230,230,250));
        grbutton.setLayout(new GridLayout(8,0,0,10));
        grbutton.add(XacNhan);
        grbutton.add(NhapLai);
        grbutton.add(XoaTatCa);
        grbutton.add(Xoa1ThongTin);
        grbutton.add(CapNhatThongTin);
        grbutton.add(timkiemthisinh);
        grbutton.add(TimKimThongTinThiSinh);
        grbutton.add(SuaThongTinThiSinh);
        //Jpanel button Lịch thi
        JPanel grbuttonLichThi = new JPanel();
        grbuttonLichThi.setBackground(new Color(250,250,210));
        grbuttonLichThi.setLayout(new GridLayout(7,0,0,17));
        grbuttonLichThi.add(XacNhanLichThi);
        grbuttonLichThi.add(NhapLaiLichThi);
        grbuttonLichThi.add(Xoa1LichThi);
        grbuttonLichThi.add(XoaTatCaLichThi);
        grbuttonLichThi.add(CapNhatLichThi);
        grbuttonLichThi.add(timkiemlichthi);
        grbuttonLichThi.add(TimKiemLichThiTheoCCCD);
        //Jpanel thông tin thí sinh
        final JPanel ThongTinThiSinh = new JPanel();
        ThongTinThiSinh.setBackground(new Color(224,255,255));
        ThongTinThiSinh.setLayout(new FlowLayout(5,40,20));
        ThongTinThiSinh.add(thongtin);
        ThongTinThiSinh.add(nhapthongtin);
        ThongTinThiSinh.add(girdmonthi);
        ThongTinThiSinh.add(girddangki);
        ThongTinThiSinh.add(girdngaythi);
        ThongTinThiSinh.add(girdgiothi);
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////tìm kiếm tổng thông tin thí sinh///////
        //Tìm kiếm tổng
        JLabel socccdtimkiem = new JLabel("Số CCCD: ");
        socccdtimkiem.setForeground(Color.red);
        nhapsocccdtimkiem = new JTextField(10);
        nhapsocccdtimkiem.setBorder(new LineBorder(new Color(64,224,208),3));
        nhapsocccdtimkiem.setForeground(Color.RED);
        buttontimkiem = new JButton("Tìm kiếm");
        buttontimkiem.setBackground(new Color(50,205,50));
        buttontimkiem.setForeground(Color.WHITE);

        JPanel thanhtimkiem = new JPanel();
        thanhtimkiem.setLayout(new FlowLayout(1,10,10));
        thanhtimkiem.setBackground(new Color(230,230,250));
        thanhtimkiem.add(socccdtimkiem);
        thanhtimkiem.add(nhapsocccdtimkiem);
        thanhtimkiem.add(buttontimkiem);

        JLabel trongeasttimkiem = new JLabel();
        trongeasttimkiem.setBorder(new LineBorder(new Color(127,255,0),3));
        trongeasttimkiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/timkiem (1).png"))));

        JPanel anheast = new JPanel();
        anheast.setLayout(new FlowLayout(1,5,10));
        anheast.setBackground(new Color(230,230,250));
        anheast.add(trongeasttimkiem);

        JPanel buttontimkiemeast = new JPanel();
        buttontimkiemeast.setLayout(new GridLayout(2,1,1,5));
        buttontimkiemeast.setBackground(new Color(230,230,250));
        buttontimkiemeast.add(thanhtimkiem);
        buttontimkiemeast.add(anheast);

        //thông tin tìm kiếm thí sinh
        JLabel hovatentimkiem = new JLabel("Họ và tên:");
        JLabel sinhnhattimkiem = new JLabel("Ngày sinh:");
        JLabel gioitinhtimkiem = new JLabel("Giới tính:");
        JLabel dienuutientimkiem = new JLabel("Diện ưu tiên:");
        JLabel khuvuctimkiem = new JLabel("Khu vực:");
        JLabel diachitimkiem = new JLabel("Địa chỉ:");
        JLabel thpttimkiem = new JLabel("Trường THPT:");

        JPanel thongtintimkiem = new JPanel();
        thongtintimkiem.setLayout(new GridLayout(7,1,1,13));
        thongtintimkiem.add(hovatentimkiem);
        thongtintimkiem.add(sinhnhattimkiem);
        thongtintimkiem.add(gioitinhtimkiem);
        thongtintimkiem.add(dienuutientimkiem);
        thongtintimkiem.add(khuvuctimkiem);
        thongtintimkiem.add(diachitimkiem);
        thongtintimkiem.add(thpttimkiem);
        thongtintimkiem.setBackground(new Color(230,230,250));
        //hiển thị thông tin thí sinh
        hienthihovaten = new JLabel("...............................");
        hienthisinhnhat = new JLabel("...............................");
        hienthigioitinh = new JLabel("...............................");
        hienthidienuutien = new JLabel("...............................");
        hienthikhuvuc = new JLabel("...............................");
        hienthidiachi = new JLabel("...............................");
        hienthithpt = new JLabel("...............................");
        JPanel hienthithongtin = new JPanel();
        hienthithongtin.setLayout(new GridLayout(7,1,1,13));
        hienthithongtin.add(hienthihovaten);
        hienthithongtin.add(hienthisinhnhat);
        hienthithongtin.add(hienthigioitinh);
        hienthithongtin.add(hienthidienuutien);
        hienthithongtin.add(hienthikhuvuc);
        hienthithongtin.add(hienthidiachi);
        hienthithongtin.add(hienthithpt);
        hienthithongtin.setBackground(new Color(230,230,250));
        //Jpanel thoong tin thí sinh
        JPanel thongtinthisinh = new JPanel();
        thongtinthisinh.setLayout(new FlowLayout(1,30,5));
        thongtinthisinh.setBackground(new Color(230,230,250));
        thongtinthisinh.add(thongtintimkiem);
        thongtinthisinh.add(hienthithongtin);

        JPanel bodertitlesouththongtinthisinh = new JPanel();
        Border borderthongtinthisinh = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitthongtinthisinh = BorderFactory.createTitledBorder(borderthongtinthisinh, " THÔNG TIN   ");
        bodertitlesouththongtinthisinh.setBackground(new Color(230,230,250));
        bodertitlesouththongtinthisinh.setBorder(bordertitthongtinthisinh);
        bodertitlesouththongtinthisinh.add(thongtinthisinh);
        //Tabel lịch thi
        thongtinlichthi = new DefaultTableModel();
        thongtinlichthi.addColumn("Môn thi");
        thongtinlichthi.addColumn("Ngày thi");
        thongtinlichthi.addColumn("Giờ thi");

        tbthongtinlichthi = new JTable(thongtinlichthi);
        TableColumnModel colthongtinlichthi = tbthongtinlichthi.getColumnModel();
        colthongtinlichthi.getColumn(0).setPreferredWidth(90);
        colthongtinlichthi.getColumn(1).setPreferredWidth(140);
        colthongtinlichthi.getColumn(2).setPreferredWidth(120);
        tbthongtinlichthi.setEnabled(false);

        JScrollPane scthongtinlichthi = new JScrollPane(tbthongtinlichthi);
        scthongtinlichthi.setBorder(new LineBorder(new Color(0,206,209),3));
        scthongtinlichthi.setPreferredSize(new Dimension(350,200));

        JPanel bodertitlesouththongtinlichthi = new JPanel();
        Border borderthongtinlichthi = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitthongtinlichthi = BorderFactory.createTitledBorder(borderthongtinlichthi, " LỊCH THI   ");
        bodertitlesouththongtinlichthi.setBackground(new Color(230,230,250));
        bodertitlesouththongtinlichthi.setBorder(bordertitthongtinlichthi);
        bodertitlesouththongtinlichthi.add(scthongtinlichthi);

        ///Điểm thi
        JLabel diemthimontoan = new JLabel("Điểm Toán:");
        JLabel diemthimonvan = new JLabel("Điểm Ngữ văn:");
        JLabel diemthimonanh = new JLabel("Điểm Ngoại ngữ:");
        JLabel diemthimonly = new JLabel("Điểm Vật lý:");
        JLabel diemthimonhoa = new JLabel("Điểm Hóa học:");
        JLabel diemthimonsinh = new JLabel("Điểm Sinh học:");
        JLabel diemthimonsu = new JLabel("Điểm Lịch Sử:");
        JLabel diemthimondia = new JLabel("Điểm Địa lí:");
        JLabel diemthimongdcd = new JLabel("Điểm GDCD:");

        JPanel diemthithisinh = new JPanel();
        diemthithisinh.setLayout(new GridLayout(9,1,1,5));
        diemthithisinh.setBackground(new Color(230,230,250));
        diemthithisinh.add(diemthimontoan);
        diemthithisinh.add(diemthimonvan);
        diemthithisinh.add(diemthimonanh);
        diemthithisinh.add(diemthimonly);
        diemthithisinh.add(diemthimonhoa);
        diemthithisinh.add(diemthimonsinh);
        diemthithisinh.add(diemthimonsu);
        diemthithisinh.add(diemthimondia);
        diemthithisinh.add(diemthimongdcd);

        hienthidiemtoan = new JLabel("0.0");
        hienthidiemvan = new JLabel("0.0");
        hienthidiemanh = new JLabel("0.0");
        hienthidiemly = new JLabel("0.0");
        hienthidiemhoa = new JLabel("0.0");
        hienthidiemsinh = new JLabel("0.0");
        hienthidiemsu = new JLabel("0.0");
        hienthidiemdia = new JLabel("0.0");
        hienthidiemgdcd = new JLabel("0.0");

        JPanel hienthidiemthisinh = new JPanel();
        hienthidiemthisinh.setLayout(new GridLayout(9,1,1,5));
        hienthidiemthisinh.setBackground(new Color(230,230,250));
        hienthidiemthisinh.add(hienthidiemtoan);
        hienthidiemthisinh.add(hienthidiemvan);
        hienthidiemthisinh.add(hienthidiemanh);
        hienthidiemthisinh.add(hienthidiemly);
        hienthidiemthisinh.add(hienthidiemhoa);
        hienthidiemthisinh.add(hienthidiemsinh);
        hienthidiemthisinh.add(hienthidiemsu);
        hienthidiemthisinh.add(hienthidiemdia);
        hienthidiemthisinh.add(hienthidiemgdcd);

        JPanel thongtindiemthisinh = new JPanel();
        thongtindiemthisinh.setLayout(new FlowLayout(1,23,10));
        thongtindiemthisinh.setBackground(new Color(230,230,250));
        thongtindiemthisinh.add(diemthithisinh);
        thongtindiemthisinh.add(hienthidiemthisinh);

        JPanel bodertitlesouththongtindiem = new JPanel();
        Border borderthongtindiem = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitthongtindiem = BorderFactory.createTitledBorder(borderthongtindiem, " ĐIỂM THI   ");
        bodertitlesouththongtindiem.setBackground(new Color(230,230,250));
        bodertitlesouththongtindiem.setBorder(bordertitthongtindiem);
        bodertitlesouththongtindiem.add(thongtindiemthisinh);
        //Điểm học bạ
        thongtindiemhocba = new DefaultTableModel();
        thongtindiemhocba.addColumn("Môn học");
        thongtindiemhocba.addColumn("TB HKI-10");
        thongtindiemhocba.addColumn("TB HKII-10");
        thongtindiemhocba.addColumn("TB HKI-11");
        thongtindiemhocba.addColumn("TB HKII-11");
        thongtindiemhocba.addColumn("TB HKI-12");
        thongtindiemhocba.addColumn("TB HKII-12");
        thongtindiemhocba.addColumn("TBCN-12");

        tbthongtindiemhocba = new JTable(thongtindiemhocba);
        TableColumnModel colthongtindiemhocba = tbthongtindiemhocba.getColumnModel();
        colthongtindiemhocba.getColumn(0).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(1).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(2).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(3).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(4).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(5).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(6).setPreferredWidth(85);
        colthongtindiemhocba.getColumn(7).setPreferredWidth(85);
        tbthongtindiemhocba.setEnabled(false);

        JScrollPane scthongtindiemhocba = new JScrollPane(tbthongtindiemhocba);
        scthongtindiemhocba.setBorder(new LineBorder(new Color(0,206,209),3));
        scthongtindiemhocba.setPreferredSize(new Dimension(500,200));

        JPanel bodertitlesouththongtindiemhocba = new JPanel();
        Border borderthongtindiemhocba = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitthongtindiemhocba = BorderFactory.createTitledBorder(borderthongtindiemhocba, " ĐIỂM HỌC BẠ  ");
        bodertitlesouththongtindiemhocba.setBorder(bordertitthongtindiemhocba);
        bodertitlesouththongtindiemhocba.setBackground(new Color(230,230,250));
        bodertitlesouththongtindiemhocba.add(scthongtindiemhocba);

        //Nguyện vọng
        thongtinnguyenvong = new DefaultTableModel();
        thongtinnguyenvong.addColumn("STT NV");
        thongtinnguyenvong.addColumn("Trường");
        thongtinnguyenvong.addColumn("Mã trường");
        thongtinnguyenvong.addColumn("Ngành");
        thongtinnguyenvong.addColumn("Mã ngành");
        thongtinnguyenvong.addColumn("Phương thức xét tuyển");
        thongtinnguyenvong.addColumn("Tổ hợp môn");

        tbthongtinnguyenvong = new JTable(thongtinnguyenvong);
        TableColumnModel colthongtinnguyenvong = tbthongtinnguyenvong.getColumnModel();
        colthongtinnguyenvong.getColumn(0).setPreferredWidth(30);
        colthongtinnguyenvong.getColumn(1).setPreferredWidth(150);
        colthongtinnguyenvong.getColumn(2).setPreferredWidth(45);
        colthongtinnguyenvong.getColumn(3).setPreferredWidth(130);
        colthongtinnguyenvong.getColumn(4).setPreferredWidth(45);
        colthongtinnguyenvong.getColumn(5).setPreferredWidth(130);
        colthongtinnguyenvong.getColumn(6).setPreferredWidth(110);
        tbthongtinnguyenvong.setEnabled(false);

        JScrollPane scthongtinnguyenvong = new JScrollPane(tbthongtinnguyenvong);
        scthongtinnguyenvong.setBorder(new LineBorder(new Color(0,206,209),3));
        scthongtinnguyenvong.setPreferredSize(new Dimension(1060,200));

        JPanel bodertitlesouththongtinnguyenvong = new JPanel();
        Border borderthongtinnguyenvong = BorderFactory.createLineBorder(Color.BLACK,2);
        TitledBorder bordertitthongtinnguyenvong = BorderFactory.createTitledBorder(borderthongtinnguyenvong, " NGUYỆN VỌNG   ");
        bodertitlesouththongtinnguyenvong.setBorder(bordertitthongtinnguyenvong);
        bodertitlesouththongtinnguyenvong.setBackground(new Color(230,230,250));
        bodertitlesouththongtinnguyenvong.add(scthongtinnguyenvong);
        //Jpanel flow
        JPanel flowcenter = new JPanel();
        flowcenter.setLayout(new FlowLayout(1,5,5));
        flowcenter.add(bodertitlesouththongtinthisinh);
        flowcenter.add(bodertitlesouththongtinlichthi);
        flowcenter.setBackground(new Color(230,230,250));

        JPanel flowcenter1 = new JPanel();
        flowcenter1.setLayout(new FlowLayout(1,5,5));
        flowcenter1.setBackground(new Color(230,230,250));
        flowcenter1.add(bodertitlesouththongtindiemhocba);
        flowcenter1.add(bodertitlesouththongtindiem);
        //Jpanel tổng center
        JPanel tongcenter = new JPanel();
        tongcenter.setLayout(new GridLayout(2,1,1,1));
        tongcenter.setBackground(new Color(230,230,250));
        tongcenter.add(flowcenter);
        tongcenter.add(flowcenter1);

        final JPanel CardlayoutCenter = new JPanel();
        CardlayoutCenter.setLayout(new CardLayout());
        CardlayoutCenter.setBorder(new LineBorder(Color.BLACK,1));
        CardlayoutCenter.add(tieudecenter,"center");
        CardlayoutCenter.add(ThongTinThiSinh, "center1");
        CardlayoutCenter.add(centernguyenvong, "center2");
        CardlayoutCenter.add(centerdiem, "center3");
        CardlayoutCenter.add(ThongTinDiemHocBa,"center4");
        CardlayoutCenter.add(grthongtintinhdiem,"center5");
        CardlayoutCenter.add(tongcenter,"center6");
        container.add(CardlayoutCenter, BorderLayout.CENTER);

        // Jpanel Layoutt Table South
        final JPanel CardlayoutTableSouth= new JPanel();
        CardlayoutTableSouth.setLayout(new CardLayout());
        CardlayoutTableSouth.add(southloichuc,"sc");
        CardlayoutTableSouth.add(bodertitlesouththongtin, "sc1");
        CardlayoutTableSouth.add(bodertitlesouthlichthi, "sc2");
        CardlayoutTableSouth.add(bodertitlesouthnguyenvong,"sc3");
        CardlayoutTableSouth.add(bodertitlesouthdiem,"sc4");
        CardlayoutTableSouth.add(bodertitlesouthdiemhb, "sc5");
        CardlayoutTableSouth.add(bodertitlesouthtinhdiem,"sc6");
        CardlayoutTableSouth.add(bodertitlesouththongtinnguyenvong,"sc7");
        container.add(CardlayoutTableSouth, BorderLayout.SOUTH);
        //Jpanel Layout Button EAST
        final JPanel CardlayoutButtonEast = new JPanel();
        CardlayoutButtonEast.setLayout(new CardLayout());
        CardlayoutButtonEast.setBorder(new LineBorder(Color.BLACK,1));
        CardlayoutButtonEast.add(tieudeeast,"button");
        CardlayoutButtonEast.add(grbutton, "button1");
        CardlayoutButtonEast.add(grbuttonLichThi, "button2");
        CardlayoutButtonEast.add(grbuttonnv,"button3");
        CardlayoutButtonEast.add(grbuttondiem, "button4");
        CardlayoutButtonEast.add(grbuttondiemhb,"button5");
        CardlayoutButtonEast.add(flowbuttoneast,"button6");
        CardlayoutButtonEast.add(buttontimkiemeast,"button7");
        container.add(CardlayoutButtonEast, BorderLayout.EAST);
        //MenuBar
        JMenuBar MenuBar = new JMenuBar();
        MenuBar.setBorder(new LineBorder(Color.BLACK,1));
        MenuBar.setBackground(new Color(46,139,87));
        setJMenuBar(MenuBar);
        JMenu HeThong = new JMenu("Hệ thống");
        HeThong.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/content-management-system.png"))));
        HeThong.setForeground(Color.WHITE);
        JMenu ThiSinh = new JMenu("Thí sinh");
        ThiSinh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/man.png"))));
        ThiSinh.setForeground(Color.WHITE);
        JMenu TrangChu = new JMenu("Trang chủ");
        TrangChu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/home-page.png"))));
        TrangChu.setForeground(Color.WHITE);
        XinChao = new JMenu();
        XinChao.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/key.png"))));
        XinChao.setForeground(Color.WHITE);
        MenuBar.add(XinChao);
        MenuBar.add(TrangChu);
        MenuBar.add(HeThong);
        MenuBar.add(ThiSinh);
        JMenuItem DangNhap = new JMenuItem("  Thông tin thí sinh  ");
        DangNhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/new.png"))));
        DangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout thongtin =(CardLayout)CardlayoutTableSouth.getLayout();
                thongtin.show(CardlayoutTableSouth, "sc1");

                CardLayout buttonthongtin =(CardLayout)CardlayoutButtonEast.getLayout();
                buttonthongtin.show(CardlayoutButtonEast, "button1");

                CardLayout centerthongtin =(CardLayout)CardlayoutCenter.getLayout();
                centerthongtin.show(CardlayoutCenter, "center1");
            }
        });
        JMenuItem ThongTin = new JMenuItem("  Thông tin lịch thi  ");
        ThongTin.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/schedule.png"))));
        ThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout lichthi =(CardLayout)CardlayoutTableSouth.getLayout();
                lichthi.show(CardlayoutTableSouth, "sc2");

                CardLayout centerlichthi =(CardLayout)CardlayoutCenter.getLayout();
                centerlichthi.show(CardlayoutCenter, "center1");

                CardLayout buttonlichthi =(CardLayout)CardlayoutButtonEast.getLayout();
                buttonlichthi.show(CardlayoutButtonEast, "button2");
            }
        });
        JMenuItem DangKiMon = new JMenuItem("  Thông tin nguyện vọng thí sinh  ");
        DangKiMon.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/online-registration.png"))));
        DangKiMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout nguyenvong =(CardLayout)CardlayoutTableSouth.getLayout();
                nguyenvong.show(CardlayoutTableSouth, "sc3");

                CardLayout buttonnv =(CardLayout)CardlayoutButtonEast.getLayout();
                buttonnv.show(CardlayoutButtonEast, "button3");

                CardLayout dangkinguyenvong =(CardLayout)CardlayoutCenter.getLayout();
                dangkinguyenvong.show(CardlayoutCenter, "center2");

            }
        });
        JMenuItem GioiThieu = new JMenuItem("Màn hình chính");
        GioiThieu.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/background.png"))));
        GioiThieu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout trangchusouth =(CardLayout)CardlayoutTableSouth.getLayout();
                trangchusouth.show(CardlayoutTableSouth, "sc");

                CardLayout trangchueast =(CardLayout)CardlayoutButtonEast.getLayout();
                trangchueast.show(CardlayoutButtonEast, "button");

                CardLayout trangchucenter =(CardLayout)CardlayoutCenter.getLayout();
                trangchucenter.show(CardlayoutCenter, "center");
            }
        });
        DangXuat = new JMenuItem("  Đăng xuất  ");
        DangXuat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/log-out.png"))));

        NhapDiemTN = new JMenuItem("  Thông tin điểm thi thí sinh ");
        NhapDiemTN.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/to-do-list.png"))));
        NhapDiemTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout diemtn =(CardLayout)CardlayoutTableSouth.getLayout();
                diemtn.show(CardlayoutTableSouth, "sc4");

                CardLayout buttondiemtn =(CardLayout)CardlayoutButtonEast.getLayout();
                buttondiemtn.show(CardlayoutButtonEast, "button4");

                CardLayout nhapdiemtn =(CardLayout)CardlayoutCenter.getLayout();
                nhapdiemtn.show(CardlayoutCenter, "center3");
            }
        });
        NhapHocBa = new JMenuItem("  Thông tin điểm học bạ thí sinh  ");
        NhapHocBa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/diary.png"))));
        NhapHocBa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout diemhb =(CardLayout)CardlayoutTableSouth.getLayout();
                diemhb.show(CardlayoutTableSouth, "sc5");

                CardLayout buttondiemhb =(CardLayout)CardlayoutButtonEast.getLayout();
                buttondiemhb.show(CardlayoutButtonEast, "button5");

                CardLayout nhapdiemhb =(CardLayout)CardlayoutCenter.getLayout();
                nhapdiemhb.show(CardlayoutCenter, "center4");
            }
        });
        JMenuItem CongCuTinhDiemTNPT = new JMenuItem("  Công cụ tính điểm TNPT  ");
        CongCuTinhDiemTNPT.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/mathematics-tool.png"))));
        CongCuTinhDiemTNPT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout tinhdiem =(CardLayout)CardlayoutTableSouth.getLayout();
                tinhdiem.show(CardlayoutTableSouth, "sc6");

                CardLayout buttoncongcutinhdiem =(CardLayout)CardlayoutButtonEast.getLayout();
                buttoncongcutinhdiem.show(CardlayoutButtonEast, "button6");

                CardLayout nhaptinhdiem =(CardLayout)CardlayoutCenter.getLayout();
                nhaptinhdiem.show(CardlayoutCenter, "center5");
            }
        });
        JMenuItem TimKiemTongThongTin = new JMenuItem("Tra cứu thông tin thí sinh");
        TimKiemTongThongTin.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/view.png"))));
        TimKiemTongThongTin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout timkiem =(CardLayout)CardlayoutTableSouth.getLayout();
                timkiem.show(CardlayoutTableSouth, "sc7");

                CardLayout timkiembutton =(CardLayout)CardlayoutButtonEast.getLayout();
                timkiembutton.show(CardlayoutButtonEast, "button7");

                CardLayout timkiemcenter =(CardLayout)CardlayoutCenter.getLayout();
                timkiemcenter.show(CardlayoutCenter, "center6");
            }
        });
        JMenuItem Thoat = new JMenuItem("Thoát");
        Thoat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/exit.png"))));
        Thoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int re = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "THOÁT", JOptionPane.YES_NO_OPTION);
                if(re == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        DoiMatKhau = new JMenuItem("Đổi mật khẩu");
        DoiMatKhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/reset-password.png"))));
        XinChao.add(DoiMatKhau);
        TrangChu.add(GioiThieu);
        XinChao.add(DangXuat);
        TrangChu.add(Thoat);
        HeThong.add(DangNhap);
        HeThong.add(ThongTin);
        HeThong.add(CongCuTinhDiemTNPT);
        HeThong.add(TimKiemTongThongTin);
        ThiSinh.add(NhapDiemTN);
        ThiSinh.add(NhapHocBa);
        ThiSinh.add(DangKiMon);
        //Nhấp nháy bla bla
        Timer timer = new Timer(500, new ActionListener() {
            boolean flag = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thay đổi màu của JLabel
                if (flag) {
                    tieude.setForeground(new Color(255,0,255));
                    loichuc1.setForeground(new Color(255,20,147));
                    loichuc2.setForeground(new Color(255,20,147));
                    loichuc3.setForeground(new Color(255,20,147));
                    loichuc4.setForeground(new Color(255,20,147));
                    loichuc5.setForeground(new Color(255,20,147));
                    tieudenorth.setBorder(new LineBorder(new Color(255,99,71),2));
                    trongeasttimkiem.setBorder(new LineBorder(new Color(0,255,255),3));
                }
                else {
                    tieude.setForeground(new Color(0,191,255));
                    tieudenorth.setBorder(new LineBorder(new Color(124,252,0),2));
                    loichuc1.setForeground(new Color(50,205,50));
                    loichuc2.setForeground(new Color(50,205,50));
                    loichuc3.setForeground(new Color(50,205,50));
                    loichuc4.setForeground(new Color(50,205,50));
                    loichuc5.setForeground(new Color(50,205,50));
                    trongeasttimkiem.setBorder(new LineBorder(new Color(255,99,71),3));
                }
                flag = !flag;
            }
        });
        timer.start();
    }
    public static void An() {
        ViewForm.NhapDiemTN.setEnabled(false);
        ViewForm.NhapHocBa.setEnabled(false);
        ViewForm.CapNhatThongTin.setEnabled(false);
        ViewForm.CapNhatLichThi.setEnabled(false);
        ViewForm.capnhatnguyenvong.setEnabled(false);
        ViewForm.TimKimThongTinThiSinh.setEnabled(false);
        ViewForm.TimKiemLichThiTheoCCCD.setEnabled(false);
        ViewForm.timkiemthongtinnv.setEnabled(false);
        ViewForm.nhapthongtinthisinh.setEditable(false);
        ViewForm.nhapthongtinlichthi.setEditable(false);
        ViewForm.nhapthongtinnv.setEditable(false);
        ViewForm.Xoa1ThongTin.setEnabled(false);
        ViewForm.XoaTatCa.setEnabled(false);
        ViewForm.xoatatcanv.setEnabled(false);
        ViewForm.XoaTatCaLichThi.setEnabled(false);
    }
    public static void HienThi() {
        ViewForm.NhapDiemTN.setEnabled(true);
        ViewForm.NhapHocBa.setEnabled(true);
        ViewForm.CapNhatThongTin.setEnabled(true);
        ViewForm.CapNhatLichThi.setEnabled(true);
        ViewForm.capnhatnguyenvong.setEnabled(true);
        ViewForm.TimKimThongTinThiSinh.setEnabled(true);
        ViewForm.TimKiemLichThiTheoCCCD.setEnabled(true);
        ViewForm.timkiemthongtinnv.setEnabled(true);
        ViewForm.nhapthongtinthisinh.setEditable(true);
        ViewForm.nhapthongtinlichthi.setEditable(true);
        ViewForm.nhapthongtinnv.setEditable(true);
        ViewForm.Xoa1ThongTin.setEnabled(true);
        ViewForm.XoaTatCa.setEnabled(true);
        ViewForm.xoatatcanv.setEnabled(true);
        ViewForm.XoaTatCaLichThi.setEnabled(true);
    }
}
