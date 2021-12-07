package ui;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;


public class UI_TrangChu extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenu mnHeThong;
	private JMenu mnQuanLy;
	private JMenu mnThongKe;
	private JMenu mnHoTro;

	private JMenuItem itTrangChu;
	private JMenuItem itDangXuat;
	private JMenuItem itThoat;
	
	private JMenuItem itLinhKien;
	private JMenuItem itKhachHang;
	private JMenuItem itHoaDon;
	private JMenuItem itLoaiLinhKien;
	private JMenuItem itNhaCungCap;
	private JMenuItem itNhanVien;
	private JMenuItem itTaiKhoan;
	
	private JMenuItem itTKLK;
	private JMenuItem itTKHD;
	
	private JMenuItem itHuongDan;
	private JMenuItem itGioiThieu;
	
	public UI_TrangChu() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("REEBPC");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        Image icon = Toolkit.getDefaultToolkit().getImage("./icon/REEBPC.png");
        setIconImage(icon);
        buildUI();
	}
	private void buildUI() {
		setJMenuBar(taoMenu());
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setUndecorated(true);
		setVisible(true);
	}
	public JMenuBar taoMenu() {
		JMenuBar mb = new JMenuBar();
		mb.setBackground(Color.WHITE);
		mnHeThong = new JMenu("Hệ Thống");
		mnHeThong.setBackground(Color.WHITE);
		mnHeThong.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnQuanLy = new JMenu("Quản Lý");
		mnQuanLy.setBackground(Color.WHITE);
		mnQuanLy.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnThongKe = new JMenu("Thống Kê");
		mnThongKe.setBackground(Color.WHITE);
		mnThongKe.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		mnHoTro = new JMenu("Hỗ Trợ");
		mnHoTro.setBackground(Color.WHITE);
		mnHoTro.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itTrangChu =new JMenuItem("Trang Chủ");
		itTrangChu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itDangXuat =new JMenuItem("Đăng Xuất");
		itDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itThoat = new JMenuItem("Thoát");
		itThoat.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		itLinhKien=new JMenuItem("Linh Kiện");
		itLinhKien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itKhachHang=new JMenuItem("Khách Hàng");
		itKhachHang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itHoaDon=new JMenuItem("Hóa Đơn");
		itHoaDon.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itLoaiLinhKien=new JMenuItem("Loại Linh Kiện");
		itLoaiLinhKien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itNhaCungCap=new JMenuItem("Nhà Cung Cấp");
		itNhaCungCap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itNhanVien=new JMenuItem("Nhân Viên");
		itNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itTaiKhoan=new JMenuItem("Tài Khoản");
		itTaiKhoan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itTKLK=new JMenuItem("Thống Kê Linh Kiện");
		itTKLK.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itTKHD=new JMenuItem("Thống kê Hóa Đơn");
		itTKHD.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		itHuongDan=new JMenuItem("Hướng Dẫn");
		itHuongDan.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		itGioiThieu=new JMenuItem("Giới Thiệu");
		itGioiThieu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		mnHeThong.setIcon(new ImageIcon("./icon/home.png"));
		mnQuanLy.setIcon(new ImageIcon("./icon/quanly.png"));
		mnThongKe.setIcon(new ImageIcon("./icon/statistical.png"));
		mnHoTro.setIcon(new ImageIcon("./icon/huongdan.png"));
		
		itTrangChu.setIcon(new ImageIcon("./icon/dangxuat.png"));
		itDangXuat.setIcon(new ImageIcon("./icon/dangxuat.png"));
		itThoat.setIcon(new ImageIcon("./icon/thoat.png"));
		
		itLinhKien.setIcon(new ImageIcon("./icon/computer.png"));
		itKhachHang.setIcon(new ImageIcon("./icon/customer.png"));
		itHoaDon.setIcon(new ImageIcon("./icon/bill.png"));
		itLoaiLinhKien.setIcon(new ImageIcon("./icon/plus.png"));
		itNhaCungCap.setIcon(new ImageIcon("./icon/ncc.png"));
		itNhanVien.setIcon(new ImageIcon("./icon/staff.png"));
		itTaiKhoan.setIcon(new ImageIcon("./icon/maintenance.png"));
		
		itTKLK.setIcon(new ImageIcon("./icon/maintenance.png"));
		itTKHD.setIcon(new ImageIcon("./icon/maintenance.png"));
		
		itHuongDan.setIcon(new ImageIcon("./icon/huongdan.png"));
		itGioiThieu.setIcon(new ImageIcon("./icon/about.png"));
		
		mb.add(mnHeThong);
		mb.add(mnQuanLy);
		mb.add(mnThongKe);
		mb.add(mnHoTro);
		
		mnHeThong.add(itDangXuat);
		mnHeThong.add(itThoat);
		
		mnQuanLy.add(itLinhKien);
		mnQuanLy.add(itKhachHang);
		mnQuanLy.add(itHoaDon);
		mnQuanLy.add(itLoaiLinhKien);
		mnQuanLy.add(itNhaCungCap);
		mnQuanLy.add(itNhanVien);
		mnQuanLy.add(itTaiKhoan);
		
		mnThongKe.add(itTKLK);
		mnThongKe.add(itTKHD);
		
		mnHoTro.add(itHuongDan);
		mnHoTro.add(itGioiThieu);
		
		itLinhKien.addActionListener(this);
		itKhachHang.addActionListener(this);
		itLoaiLinhKien.addActionListener(this);
		itNhaCungCap.addActionListener(this);
		itThoat.addActionListener(this);
		return mb;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if (o.equals(itLinhKien)) {
			UI_LinhKien frm=new UI_LinhKien();
			frm.setVisible(true);
		}else
		if (o.equals(itKhachHang)) {
			UI_KhachHang frm=new UI_KhachHang();
			frm.setVisible(true);
		}else
		if (o.equals(itLoaiLinhKien)) {
				UI_LoaiLinhKien frm=new UI_LoaiLinhKien();
				frm.setVisible(true);
		}
		else
		if (o.equals(itNhaCungCap)) {
					UI_NhaCungCap frm=new UI_NhaCungCap();
					frm.setVisible(true);
		}
		else
		if (o.equals(itThoat)) {
			  System.exit(0);
		}
	}
}
