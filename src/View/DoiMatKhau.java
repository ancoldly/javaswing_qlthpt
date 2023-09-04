package View;

import javax.swing.*;
import java.awt.*;

public class DoiMatKhau extends JFrame {
    public static JPasswordField nhapmatkhaucu,nhapmatkhaumoi,nhaplaimatkhaumoi;
    public static JButton xacnhandoimatkhau,nhaplaidoimatkhau,thoatdoimatkhau;
    public DoiMatKhau() {
        super("ĐĂNG NHẬP HỆ THỐNG QUẢN LÍ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(410,290);
        setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Login.class.getResource("/img/graduated.png"))).getImage());
        Container container = getContentPane();

        JLabel tieudematkhau = new JLabel(" THAY ĐỔI MẬT KHẨU  ");
        tieudematkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/encryption.png"))));

        JPanel tieudenorth = new JPanel();
        tieudenorth.setLayout(new FlowLayout(1,1,5));
        tieudenorth.add(tieudematkhau);
        container.add(tieudenorth, BorderLayout.NORTH);

        JLabel matkhaucu = new JLabel("Mật khẩu cũ");
        JLabel matkhaumoi = new JLabel("Mật khẩu mới");
        JLabel laimatkhaumoi = new JLabel("Xác nhận mật khẩu mới");

        nhapmatkhaucu = new JPasswordField(20);
        nhapmatkhaumoi = new JPasswordField(20);
        nhaplaimatkhaumoi = new JPasswordField(20);

        JPanel doimatkhau = new JPanel();
        doimatkhau.setLayout(new GridLayout(3,1,1,15));
        doimatkhau.add(matkhaucu);
        doimatkhau.add(matkhaumoi);
        doimatkhau.add(laimatkhaumoi);

        JPanel nhapdoimatkhau = new JPanel();
        nhapdoimatkhau.setLayout(new GridLayout(3,1,1,10));
        nhapdoimatkhau.add(nhapmatkhaucu);
        nhapdoimatkhau.add(nhapmatkhaumoi);
        nhapdoimatkhau.add(nhaplaimatkhaumoi);

        JPanel doimatkhautaikhoan = new JPanel();
        doimatkhautaikhoan.setLayout(new FlowLayout(1,25,10));
        doimatkhautaikhoan.add(doimatkhau);
        doimatkhautaikhoan.add(nhapdoimatkhau);
        container.add(doimatkhautaikhoan,BorderLayout.CENTER);

        xacnhandoimatkhau = new JButton("Xác nhận");
        xacnhandoimatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/check-user.png"))));
        xacnhandoimatkhau.setBackground(new Color(50,205,50));
        xacnhandoimatkhau.setForeground(Color.WHITE);
        nhaplaidoimatkhau = new JButton("Nhập lại");
        nhaplaidoimatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/undo.png"))));
        nhaplaidoimatkhau.setBackground(new Color(50,205,50));
        nhaplaidoimatkhau.setForeground(Color.WHITE);
        thoatdoimatkhau = new JButton("Thoát");
        thoatdoimatkhau.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewForm.class.getResource("/img/close.png"))));
        thoatdoimatkhau.setBackground(new Color(50,205,50));
        thoatdoimatkhau.setForeground(Color.WHITE);

        JPanel buttondoimatkhau = new JPanel();
        buttondoimatkhau.setLayout(new FlowLayout(1,25,20));
        buttondoimatkhau.add(xacnhandoimatkhau);
        buttondoimatkhau.add(nhaplaidoimatkhau);
        buttondoimatkhau.add(thoatdoimatkhau);
        container.add(buttondoimatkhau,BorderLayout.SOUTH);
    }
}
