package View;

import Controller.Enterlogin;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame {
    public static JButton xacnhapdangnhap,nhaplaitaikhoan,dangki,dangnhap,xacnhandangki,nhaplaidangki;
    public static JTextField nhaptendangnhap,nhaptaotendangnhap,nhaptaomatkhau,nhaplaitaomatkhau;
    public static JPasswordField nhapmatkhau;
    public static JLabel tieude;
    public static Border raised = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
    public static JPanel cardlayoutcenter,cardlayoutsouth;
    public static JCheckBox hienthimatkhau;
    public Login() {
        super("ĐĂNG NHẬP HỆ THỐNG QUẢN LÍ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(410,300);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/img/graduated.png"))).getImage());

        Container container = getContentPane();

        //Tittle
        tieude = new JLabel("  ACCOUNT LOGIN  ");
        tieude.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/hacker.png"))));

        JPanel tieudenorth = new JPanel();
        tieudenorth.setBackground(new Color(102,205,170));
        tieudenorth.setLayout(new FlowLayout(1,1,5));
        tieudenorth.add(tieude);
        container.add(tieudenorth, BorderLayout.NORTH);
        //Jlabel đăng kí
        JLabel taotendangnhap = new JLabel("  NUMBER CCCD");
        taotendangnhap.setForeground(new Color(255,20,147));
        taotendangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/login.png"))));
        JLabel taomatkhau = new JLabel("  PASSWORD");
        taomatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/password.png"))));
        taomatkhau.setForeground(new Color(255,20,147));
        JLabel taolaimatkhau = new JLabel(" CONFIRM");
        taolaimatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/approved.png"))));
        taolaimatkhau.setForeground(new Color(255,20,147));

        JPanel taotaikhoan = new JPanel();
        taotaikhoan.setBackground(new Color(102,205,170));
        taotaikhoan.setLayout(new GridLayout(3,1,1,15));
        taotaikhoan.add(taotendangnhap);
        taotaikhoan.add(taomatkhau);
        taotaikhoan.add(taolaimatkhau);
        //Jtextfield đăng kí
        nhaptaotendangnhap = new JTextField(20);
        nhaptaotendangnhap.setBorder(new LineBorder(new Color(100,149,237),2));

        nhaptaomatkhau = new JPasswordField(20);
        nhaptaomatkhau.setBorder(new LineBorder(new Color(100,149,237),2));

        nhaplaitaomatkhau = new JPasswordField(20);
        nhaplaitaomatkhau.setBorder(new LineBorder(new Color(100,149,237),2));


        JPanel nhaptaotaikhoan = new JPanel();
        nhaptaotaikhoan.setBackground(new Color(102,205,170));
        nhaptaotaikhoan.setLayout(new GridLayout(3,1,1,15));
        nhaptaotaikhoan.add(nhaptaotendangnhap);
        nhaptaotaikhoan.add(nhaptaomatkhau);
        nhaptaotaikhoan.add(nhaplaitaomatkhau);
        //Jpanel đăng kí
        JPanel dangkitaikhoan = new JPanel();
        dangkitaikhoan.setBackground(new Color(102,205,170));
        dangkitaikhoan.setLayout(new FlowLayout(1,25,10));
        dangkitaikhoan.add(taotaikhoan);
        dangkitaikhoan.add(nhaptaotaikhoan);

        //Jbutton đăng kí tài khoản
        dangnhap = new JButton(" LOGIN  ");
        dangnhap.setForeground(Color.WHITE);
        dangnhap.setBorder(raised);
        dangnhap.setBackground(new Color(176,196,222));
        dangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/login-button.png"))));

        xacnhandangki = new JButton(" REGISTER  ");
        xacnhandangki.setForeground(Color.WHITE);
        xacnhandangki.setBorder(raised);
        xacnhandangki.setBackground(new Color(176,196,222));
        xacnhandangki.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-user.png"))));

        nhaplaidangki = new JButton(" RESET  ");
        nhaplaidangki.setForeground(Color.WHITE);
        nhaplaidangki.setBorder(raised);
        nhaplaidangki.setBackground(new Color(176,196,222));
        nhaplaidangki.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/undo.png"))));

        JPanel buttondangki = new JPanel();
        buttondangki.setBackground(new Color(102,205,170));
        buttondangki.setLayout(new FlowLayout(1,40,20));
        buttondangki.add(dangnhap);
        buttondangki.add(xacnhandangki);
        buttondangki.add(nhaplaidangki);
        //Jlabel đăng nhập
        JLabel tendangnhap = new JLabel("  NUMBER CCCD");
        tendangnhap.setForeground(new Color(255,20,147));
        tendangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/login.png"))));
        JLabel matkhau = new JLabel("  PASSWORD");
        matkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/password.png"))));
        matkhau.setForeground(new Color(255,20,147));
        hienthimatkhau = new JCheckBox("Hiển thị mật khẩu?");
        hienthimatkhau.setBackground(new Color(102,205,170));
        hienthimatkhau.setForeground(new Color(255,0,255));
        JLabel trong = new JLabel();

        JPanel dangnhaptaikhoan = new JPanel();
        dangnhaptaikhoan.setBackground(new Color(102,205,170));
        dangnhaptaikhoan.setLayout(new GridLayout(3,1,1,18));
        dangnhaptaikhoan.add(tendangnhap);
        dangnhaptaikhoan.add(matkhau);
        dangnhaptaikhoan.add(hienthimatkhau);

        //Jtextfield đăng nhập
        nhaptendangnhap = new JTextField(20);
        nhaptendangnhap.setBorder(new LineBorder(new Color(100,149,237),2));
        nhaptendangnhap.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(nhaptendangnhap.getText().equals(" Hãy nhập tên đăng nhập...")) {
                    nhaptendangnhap.setText("");
                    nhaptendangnhap.setForeground(new Color(255,69,0));
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if(nhaptendangnhap.getText().equals("")) {
                    nhaptendangnhap.setText(" Hãy nhập tên đăng nhập...");
                    nhaptendangnhap.setForeground(new Color(255,69,0));
                }
            }
        });
        nhapmatkhau = new JPasswordField(20);
        nhapmatkhau.setBorder(new LineBorder(new Color(100,149,237),2));

        JPanel nhapdangnhap = new JPanel();
        nhapdangnhap.setBackground(new Color(102,205,170));
        nhapdangnhap.setLayout(new GridLayout(3,1,1,22));
        nhapdangnhap.add(nhaptendangnhap);
        nhapdangnhap.add(nhapmatkhau);
        nhapdangnhap.add(trong);
        //Jpanel đăng nhập
        JPanel dangnhaptk = new JPanel();
        dangnhaptk.setBackground(new Color(102,205,170));
        dangnhaptk.setLayout(new FlowLayout(1,5,5));
        dangnhaptk.add(dangnhaptaikhoan);
        dangnhaptk.add(nhapdangnhap);
        //Jbutton đăng nhập tài khoản
        dangki = new JButton(" REGISTER  ");
        dangki.setForeground(Color.WHITE);
        dangki.setBorder(raised);
        dangki.setBackground(new Color(176,196,222));
        dangki.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/create-user.png"))));

        xacnhapdangnhap = new JButton(" LOGIN  ");
        xacnhapdangnhap.setForeground(Color.WHITE);
        xacnhapdangnhap.setBorder(raised);
        xacnhapdangnhap.setBackground(new Color(176,196,222));
        xacnhapdangnhap.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-user.png"))));

        nhaplaitaikhoan = new JButton(" RESET  ");
        nhaplaitaikhoan.setForeground(Color.WHITE);
        nhaplaitaikhoan.setBorder(raised);
        nhaplaitaikhoan.setBackground(new Color(176,196,222));
        nhaplaitaikhoan.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/undo.png"))));

        JPanel buttondangnhap = new JPanel();
        buttondangnhap.setBackground(new Color(102,205,170));
        buttondangnhap.setLayout(new FlowLayout(1,40,20));
        buttondangnhap.add(dangki);
        buttondangnhap.add(xacnhapdangnhap);
        buttondangnhap.add(nhaplaitaikhoan);
        //cardlayout center
        cardlayoutcenter = new JPanel();
        cardlayoutcenter.setLayout(new CardLayout());
        cardlayoutcenter.setBackground(new Color(102,205,170));
        cardlayoutcenter.add(dangnhaptk,"center2");
        cardlayoutcenter.add(dangkitaikhoan,"center1");
        container.add(cardlayoutcenter,BorderLayout.CENTER);
        //cardlayout south
        cardlayoutsouth = new JPanel();
        cardlayoutsouth.setLayout(new CardLayout());
        cardlayoutsouth.setBackground(new Color(102,205,170));
        cardlayoutsouth.add(buttondangnhap,"south2");
        cardlayoutsouth.add(buttondangki,"south1");
        container.add(cardlayoutsouth,BorderLayout.SOUTH);

        Timer timer = new Timer(500, new ActionListener() {
            boolean flag = true;
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thay đổi màu của JLabel
                if (flag) {
                    Login.tieude.setForeground(new Color(138,43,226));
                    Login.nhaptaotendangnhap.setBorder(new LineBorder(new Color(255,20,147),2));
                    Login.nhaptaomatkhau.setBorder(new LineBorder(new Color(255,20,147),2));
                    Login.nhaplaitaomatkhau.setBorder(new LineBorder(new Color(255,20,147),2));
                    Login.nhaptendangnhap.setBorder(new LineBorder(new Color(255,215,0),2));
                    Login.nhapmatkhau.setBorder(new LineBorder(new Color(255,215,0),2));
                }
                else {
                    Login.tieude.setForeground(new Color(30,144,255));
                    Login.nhaptaotendangnhap.setBorder(new LineBorder(new Color(255,0,255),2));
                    Login.nhaptaomatkhau.setBorder(new LineBorder(new Color(255,0,255),2));
                    Login.nhaplaitaomatkhau.setBorder(new LineBorder(new Color(255,0,255),2));
                    Login.nhaptendangnhap.setBorder(new LineBorder(new Color(0,0,205),2));
                    Login.nhapmatkhau.setBorder(new LineBorder(new Color(0,0,205),2));
                }
                flag = !flag;
            }
        });
        timer.start();
    }
}
