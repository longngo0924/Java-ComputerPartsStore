package ui;

import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.DanhSachLinhKien;
import dao.DanhSachLoaiLinhKien;
import entity.LoaiLinhKien;
import xuly.Database;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_LinhKien extends JDialog implements MouseListener, ActionListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bTable,bChucNang,bTimKiem,bTren,bDuoi,bHinhAnh;
	private JPanel pnlAnhSanPham;
	private JLabel lblMaLinhKien,lblTenLinhKien,lblSoLuong,lblDonGiaGoc,lblDonGiaBan,lblNhaCungCap,lblThoiHanBaoHanh,lblLoai,lblAnh,lblMoTa1,lblMoTa2,lblMoTa3,lblMoTa4;
	private JTextField txtMaLinhKien,txtTenLinhKien,txtSoLuong,txtDonGiaGoc,txtDonGiaBan,txtNhaCungCap,txtThoiHanBaoHanh,txtLoai,txtAnh,txtMoTa1,txtMoTa2,txtMoTa3,txtMoTa4;
	private JLabel lblTieuDe;
	private JButton btnThem, btnSua,btnLuu,btnXoaRong,btnHuy;
	private JLabel lblThongBao;
	private JTextField txtThongBao;
	
	private JLabel lblLoaiTK,lblMoTa1TK,lblMoTa2TK,lblMoTa3TK,lblMoTa4TK;
	public JComboBox<String> cboLoaiLK;
	public JComboBox<String> cboMoTa1,cboMoTa2,cboMoTa3,cboMoTa4;
	private JTextField txtTimKiem;
	private JButton btnTimKiem;
	
	private DefaultTableModel dataModel;
	private JTable table;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;
	private DanhSachLinhKien dslk=new DanhSachLinhKien();
	private JLabel lblAnhSP;
	
	private JButton btnChonLoai;
	private JButton btnChonNCC;
	private JButton btnChonAnh;
	private JButton btnXacNhanLoai,btnXacNhanNCC;
	private JFrame diaLoai;
	private JTable tableLoai,tableCC;
	public String maLoai,maNCC;
	public int hanhdong;
	private ImageIcon imiAnh;
	
	private JFrame frmChonMaNCC;
	private DanhSachLoaiLinhKien dsllk=new DanhSachLoaiLinhKien();
	private ArrayList<LoaiLinhKien> ds_lk;
	private JLabel lblTnLinhKin;
	
	public UI_LinhKien() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Quản lý linh kiện");
		setSize(1600, 830);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo ( null );
        maLoai=null;
        maNCC=null;
        hanhdong=0;
        buildUI();
        
	}

	private void buildUI() {
		// TODO Auto-generated method stub
		
		getContentPane().add(bTong=Box.createVerticalBox());
		
		bTong.add(Box.createVerticalStrut(10));
		bTong.add(bTren=Box.createHorizontalBox());
		bTong.add(Box.createVerticalStrut(20));
		bTong.add(bGiua=Box.createHorizontalBox());
		bTong.add(Box.createVerticalStrut(20));
		bTong.add(bDuoi=Box.createVerticalBox());

		
		//thong tin linh kien
		bThongTin=Box.createVerticalBox();
		bThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bTren.add(bThongTin);
		bThongTin.setBackground(Color.WHITE);
		bThongTin.setBorder(new TitledBorder(null, "Thông tin linh kiện", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaLinhKien=new JLabel("Mã linh kiện: ");
		lblMaLinhKien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenLinhKien=new JLabel("Tên linh kiện: ");
		lblTenLinhKien.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblSoLuong=new JLabel("Số lượng: ");
		lblSoLuong.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDonGiaGoc=new JLabel("Đơn giá gốc: ");
		lblDonGiaGoc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonGiaGoc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDonGiaBan=new JLabel("Đơn giá bán: ");
		lblDonGiaBan.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDonGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNhaCungCap=new JLabel("Nhà cung cấp: ");
		lblNhaCungCap.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThoiHanBaoHanh=new JLabel("Thời hạn bảo hành: ");
		lblThoiHanBaoHanh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThoiHanBaoHanh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLoai=new JLabel("Loại: ");
		lblLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAnh=new JLabel("Ảnh: ");
		lblAnh.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa1=new JLabel("Mô tả 1: ");
		lblMoTa1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa2=new JLabel("Mô tả 2: ");
		lblMoTa2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa3=new JLabel("Mô tả 3: ");
		lblMoTa3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMoTa4=new JLabel("Mô tả 4: ");
		lblMoTa4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		lblMaLinhKien.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblSoLuong.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblDonGiaGoc.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblAnh.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblMoTa1.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblMoTa3.setPreferredSize(lblNhaCungCap.getPreferredSize());
		lblLoai.setPreferredSize(lblNhaCungCap.getPreferredSize());
		
		lblTenLinhKien.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
	
		lblDonGiaBan.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
		lblMoTa2.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
		lblMoTa4.setPreferredSize(lblThoiHanBaoHanh.getPreferredSize());
		
		
		txtMaLinhKien=new JTextField();
		txtMaLinhKien.setColumns(7);
		txtMaLinhKien.setBackground(Color.WHITE);
		txtMaLinhKien.setEditable(false);
		txtMaLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenLinhKien=new JTextField();
		txtTenLinhKien.setColumns(7);
		txtTenLinhKien.setBackground(Color.WHITE);
		txtTenLinhKien.setEditable(false);
		txtTenLinhKien.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtSoLuong=new JTextField();
		txtSoLuong.setColumns(7);
		txtSoLuong.setBackground(Color.WHITE);
		txtSoLuong.setEditable(false);
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGiaGoc=new JTextField();
		txtDonGiaGoc.setColumns(7);
		txtDonGiaGoc.setBackground(Color.WHITE);
		txtDonGiaGoc.setEditable(false);
		txtDonGiaGoc.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtDonGiaBan=new JTextField();
		txtDonGiaBan.setColumns(7);
		txtDonGiaBan.setBackground(Color.WHITE);
		txtDonGiaBan.setEditable(false);
		txtDonGiaBan.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNhaCungCap=new JTextField();
		txtNhaCungCap.setColumns(8);
		txtNhaCungCap.setBackground(Color.WHITE);
		txtNhaCungCap.setEditable(false);
		txtNhaCungCap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtThoiHanBaoHanh=new JTextField();
		txtThoiHanBaoHanh.setColumns(7);
		txtThoiHanBaoHanh.setBackground(Color.WHITE);
		txtThoiHanBaoHanh.setEditable(false);
		txtThoiHanBaoHanh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtLoai=new JTextField();
		txtLoai.setColumns(8);
		txtLoai.setBackground(Color.WHITE);
		txtLoai.setEditable(false);
		txtLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtAnh=new JTextField();
		txtAnh.setBackground(Color.WHITE);
		txtAnh.setEditable(false);
		txtAnh.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa1=new JTextField();
		txtMoTa1.setColumns(7);
		txtMoTa1.setBackground(Color.WHITE);
		txtMoTa1.setEditable(false);
		txtMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa2=new JTextField();
		txtMoTa2.setColumns(7);
		txtMoTa2.setBackground(Color.WHITE);
		txtMoTa2.setEditable(false);
		txtMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa3=new JTextField();
		txtMoTa3.setColumns(7);
		txtMoTa3.setBackground(Color.WHITE);
		txtMoTa3.setEditable(false);
		txtMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtMoTa4=new JTextField();
		txtMoTa4.setColumns(7);
		txtMoTa4.setBackground(Color.WHITE);
		txtMoTa4.setEditable(false);
		txtMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtNhaCungCap.setPreferredSize(txtMaLinhKien.getPreferredSize());
		btnChonLoai=new JButton("Chọn Loại Linh Kiện");
		btnChonLoai.setEnabled(false);
		btnChonNCC=new JButton("Chọn Nhà Cung Cấp");
		btnChonNCC.setEnabled(false);
		btnChonAnh=new JButton("Chọn Ảnh");
		btnChonAnh.setEnabled(false);

		//add vao
		Box b01,b02,b03,b04,b05,b06,b07,b08;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		b03=Box.createHorizontalBox();
		b04=Box.createHorizontalBox();
		b05=Box.createHorizontalBox();
		b06=Box.createHorizontalBox();
		b07=Box.createHorizontalBox();
		b08=Box.createHorizontalBox();
		bThongTin.add(b01);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b02);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b03);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b04);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b05);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b06);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b07);
		bThongTin.add(Box.createVerticalStrut(5));
		bThongTin.add(b08);
		
		b01.add(lblMaLinhKien);
		b01.add(txtMaLinhKien);
		b01.add(lblTenLinhKien);
		b01.add(txtTenLinhKien);
	
		b02.add(lblSoLuong);
		b02.add(txtSoLuong);
		b02.add(lblThoiHanBaoHanh);
		b02.add(txtThoiHanBaoHanh);
		b03.add(lblDonGiaGoc);
		b03.add(txtDonGiaGoc);
		b03.add(lblDonGiaBan);
		b03.add(txtDonGiaBan);
		b04.add(lblNhaCungCap);
		b04.add(txtNhaCungCap);
		b04.add(btnChonNCC);
		
		b05.add(lblLoai);
		b05.add(txtLoai);
		b05.add(btnChonLoai);
		b06.add(lblMoTa1);
		b06.add(txtMoTa1);
		b06.add(lblMoTa2);
		b06.add(txtMoTa2);
		b07.add(lblMoTa3);
		b07.add(txtMoTa3);
		b07.add(lblMoTa4);
		b07.add(txtMoTa4);
		b08.add(lblAnh);
		b08.add(txtAnh);
		b08.add(btnChonAnh);
		// hinh an linh kien
		bHinhAnh=Box.createVerticalBox();
		bTren.add(bHinhAnh);
		bHinhAnh.setBackground(Color.WHITE);
		bHinhAnh.setBorder(new TitledBorder(null, "Hình ảnh minh họa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlAnhSanPham = new JPanel();
		pnlAnhSanPham.setPreferredSize(new Dimension(450, 300));	
		pnlAnhSanPham.setBackground(Color.WHITE);
		bHinhAnh.add(pnlAnhSanPham);
		pnlAnhSanPham.add(lblAnhSP=new JLabel(new ImageIcon("./anh/0.jpg")));
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Thêm Linh Kiện");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSua=new JButton("Thay đổi thông tin");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLuu=new JButton("Lưu");
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnHuy=new JButton("Hủy");
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblThongBao=new JLabel("Trạng Thái:        ");
		lblThongBao.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtThongBao=new JTextField(){
		    @Override public void setBorder(Border border) {
		        // No!
		    }
		};
		txtThongBao.setHorizontalAlignment(SwingConstants.LEFT);
		txtThongBao.setFont(new Font("Times New Roman", Font.ITALIC, 15));;
		txtThongBao.setBackground(Color.WHITE);
		txtThongBao.setForeground(Color.BLACK);
		txtThongBao.setEditable(false);
		bChucNang.add(btnThem);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(btnSua);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(btnLuu);
		bChucNang.add(Box.createHorizontalStrut(10));
		bChucNang.add(btnHuy);
		bChucNang.add(Box.createHorizontalStrut(120));
		bChucNang.add(lblThongBao);
		bChucNang.add(txtThongBao);
		//bduoi
		//tim kiem
		Box btk=Box.createVerticalBox();
		bDuoi.add(btk);
		btk.setBorder(new TitledBorder("Tìm Kiếm"));
		Box b11,b12;
		b11=Box.createHorizontalBox();
		b12=Box.createHorizontalBox();
		btk.add(b11);
		btk.add(Box.createVerticalStrut(10));
		btk.add(b12);
		lblLoaiTK=new JLabel("Loại:      ");
		lblLoaiTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
	    ds_lk=dsllk.docTuBang();
		cboLoaiLK=new JComboBox(ds_lk.toArray());
		cboLoaiLK.addItem("Tất cả");
		cboLoaiLK.setSelectedIndex(cboLoaiLK.getItemCount()-1);
		cboLoaiLK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboLoaiLK.setBackground(new Color(240, 255, 240));
		cboLoaiLK.setForeground(Color.BLACK);
		txtTimKiem=new JTextField();
		txtTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTimKiem.setPreferredSize(txtMaLinhKien.getPreferredSize());
		btnTimKiem=new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblMoTa1TK=new JLabel("Mô tả 1: ");
		lblMoTa1TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		String mota1[]= {"Tất cả"};
		cboMoTa1=new JComboBox(mota1);
		cboMoTa1.setEnabled(false);
		cboMoTa1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa1.setBackground(new Color(240, 255, 240));
		lblMoTa2TK=new JLabel("Mô tả 2: ");
		lblMoTa2TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cboMoTa2=new JComboBox(mota1);
		cboMoTa2.setEnabled(false);
		cboMoTa2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa2.setBackground(new Color(240, 255, 240));
		lblMoTa3TK=new JLabel("Mô tả 3: ");
		lblMoTa3TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cboMoTa3=new JComboBox(mota1);
		cboMoTa3.setEnabled(false);
		cboMoTa3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa3.setBackground(new Color(240, 255, 240));
		lblMoTa4TK=new JLabel("Mô tả 4: ");
		lblMoTa4TK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cboMoTa4=new JComboBox(mota1);
		cboMoTa4.setEnabled(false);
		cboMoTa4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cboMoTa4.setBackground(new Color(240, 255, 240));
		b11.add(lblLoaiTK);
		b11.add(cboLoaiLK);
		b11.add(Box.createHorizontalStrut(20));
		
		lblTnLinhKin = new JLabel("Tên Linh Kiện:    ");
		lblTnLinhKin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		b11.add(lblTnLinhKin);
		b11.add(txtTimKiem);
		b11.add(btnTimKiem);
		b12.add(lblMoTa1TK);
		b12.add(cboMoTa1);
		
		horizontalStrut = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut);
		b12.add(lblMoTa2TK);
		b12.add(cboMoTa2);
		
		horizontalStrut_1 = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut_1);
		b12.add(lblMoTa3TK);
		b12.add(cboMoTa3);
		
		horizontalStrut_2 = Box.createHorizontalStrut(10);
		b12.add(horizontalStrut_2);
		b12.add(lblMoTa4TK);
		b12.add(cboMoTa4);
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh sách linh kiện"));
		String[] headers= {"Mã linh kiện","Tên linh kiện","Số lượng","Loại","Đơn giá gốc","Đơn giá bán","Nhà cung cấp","Thời hạn bảo hành"};
		dataModel=new DefaultTableModel(headers,0);	
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dslk.docTableQLLK());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnChonLoai.addActionListener(this);
		btnChonNCC.addActionListener(this);
		btnChonAnh.addActionListener(this);
		lblAnhSP.setIcon(new ImageIcon("./anh/0.jpg"));
		cboLoaiLK.addActionListener(this);
	//	btnXacNhanLoai.addActionListener(this);
		cboMoTa1.setEnabled(false);
		cboMoTa2.setEnabled(false);
		cboMoTa3.setEnabled(false);
		cboMoTa4.setEnabled(false);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem thông tin linh kiện");
	
	}

	private void setTrangThai(String string) {
		// TODO Auto-generated method stub
		txtThongBao.setText(string);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		if (row>-1) {
			String ma=table.getValueAt(row, 0).toString();
			String[] ttam=dslk.docTextFieldQLLK(ma);
			txtMaLinhKien.setText(ttam[0]);
			txtTenLinhKien.setText(ttam[1]);
			txtSoLuong.setText(ttam[2]);
			txtLoai.setText(ttam[3]);
			txtDonGiaGoc.setText(ttam[4]);
			txtDonGiaBan.setText(ttam[5]);
			txtNhaCungCap.setText(ttam[6]);
			
			txtThoiHanBaoHanh.setText(ttam[7]);
			txtAnh.setText(ttam[8]);
			txtMoTa1.setText(ttam[9]);
			txtMoTa2.setText(ttam[10]);
			txtMoTa3.setText(ttam[11]);
			txtMoTa4.setText(ttam[12]);
			lblAnhSP.setIcon(new ImageIcon("./anh/"+ttam[8]+".jpg"));
			maNCC=ttam[13];
			maLoai=ttam[14];
		}
	
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if (o.equals(btnThem)) {
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			btnChonLoai.setEnabled(true);
			btnChonNCC.setEnabled(true);
			btnChonAnh.setEnabled(true);
			table.setEnabled(false);
			table.clearSelection();
			xoaRongTextField();
			editTextField();
			hanhdong=1;
			setTrangThai("Thêm Linh Kiện, nhập thông tin trên các ô trống và bấm lưu.");
		}else
		if (o.equals(btnSua)) {
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			btnChonLoai.setEnabled(true);
			btnChonNCC.setEnabled(true);
			btnChonAnh.setEnabled(true);
			table.setEnabled(false);
			table.clearSelection();
			editTextField();
			suaTextField();
			hanhdong=2;
			setTrangThai("Thay đổi thông tin linh kiện, sửa đổi thông tin cần thiết và bấm lưu.");
		}else
		if (o.equals(btnHuy)) {
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			btnHuy.setEnabled(false);
			btnLuu.setEnabled(false);
			btnChonLoai.setEnabled(false);
			btnChonNCC.setEnabled(false);
			btnChonAnh.setEnabled(false);
			table.setEnabled(true);
			xoaRongTextField();
			falseEditTextField();
			hanhdong=0;
			setTrangThai("Xem thông tin linh kiện");
		}else
		if (o.equals(btnXacNhanLoai)) {
			int row=tableLoai.getSelectedRow();
			if (row>=0) {
				String ma=tableLoai.getValueAt(row, 0).toString();
				String ten=tableLoai.getValueAt(row, 1).toString();
				txtLoai.setText(ten);
				maLoai=ma;
				diaLoai.dispose();
			}
		}else
		if (o.equals(btnChonLoai)) {
			chonLoai();
		}else
		if (o.equals(btnXacNhanNCC)) {
			int row=tableCC.getSelectedRow();
			if (row>=0) {
				String ma=tableCC.getValueAt(row, 0).toString();
				String ten=tableCC.getValueAt(row, 1).toString();
				txtNhaCungCap.setText(ten);
				maNCC=ma;
				frmChonMaNCC.dispose();
			}
		}else
		if (o.equals(btnChonNCC)) {
			chonNCC();
		}else
			if (o.equals(btnChonAnh)) {
				String a="";
				a=chonHinhAnh();
				imiAnh=new ImageIcon(a); 
				lblAnhSP.setIcon(imiAnh);
		}else
		if (o.equals(btnLuu)) {
			setTrangThai("Xem thông tin linh kiện");
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn thêm Linh Kiện này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					try {
						
						themLinhKien();
						btnThem.setEnabled(true);
						btnSua.setEnabled(true);
						btnHuy.setEnabled(false);
						btnLuu.setEnabled(false);
						btnChonLoai.setEnabled(false);
						btnChonNCC.setEnabled(false);
						btnChonAnh.setEnabled(false);
						table.setEnabled(true);
						table.clearSelection();
						xoaRongTextField();
						falseEditTextField();
						table.setEnabled(true);
						hanhdong=0;
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "Bạn có muốn thay đổi thông tin Linh Kiện này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						try {
							suaLinhKien();
							btnThem.setEnabled(true);
							btnSua.setEnabled(true);
							btnHuy.setEnabled(false);
							btnLuu.setEnabled(false);
							btnChonLoai.setEnabled(false);
							btnChonNCC.setEnabled(false);
							btnChonAnh.setEnabled(false);
							table.setEnabled(true);
							table.clearSelection();
							xoaRongTextField();
							falseEditTextField();
							table.setEnabled(true);
							hanhdong=0;
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					
				}
			}
			
		}else
		if (o.equals(cboLoaiLK)) {
			if ((cboLoaiLK.getSelectedIndex())==(cboLoaiLK.getItemCount()-1)) {
				cboMoTa1.setEnabled(false);
				cboMoTa2.setEnabled(false);
				cboMoTa3.setEnabled(false);
				cboMoTa4.setEnabled(false);
			}else {
				cboMoTa1.setEnabled(true);
				cboMoTa2.setEnabled(true);
				cboMoTa3.setEnabled(true);
				cboMoTa4.setEnabled(true);
				
				ArrayList<String> ds_mt1=dslk.docMoTa1(cboLoaiLK.getSelectedItem().toString());
				cboMoTa1.setModel(new DefaultComboBoxModel(ds_mt1.toArray()));
				cboMoTa1.addItem("Tất cả");
				cboMoTa1.setSelectedIndex(cboMoTa1.getItemCount()-1);
				
				ArrayList<String> ds_mt2=dslk.docMoTa2(cboLoaiLK.getSelectedItem().toString());
				cboMoTa2.setModel(new DefaultComboBoxModel(ds_mt2.toArray()));
				cboMoTa2.addItem("Tất cả");
				cboMoTa2.setSelectedIndex(cboMoTa2.getItemCount()-1);
				
				ArrayList<String> ds_mt3=dslk.docMoTa3(cboLoaiLK.getSelectedItem().toString());
				cboMoTa3.setModel(new DefaultComboBoxModel(ds_mt3.toArray()));
				cboMoTa3.addItem("Tất cả");
				cboMoTa3.setSelectedIndex(cboMoTa3.getItemCount()-1);

				ArrayList<String> ds_mt4=dslk.docMoTa4(cboLoaiLK.getSelectedItem().toString());
				cboMoTa4.setModel(new DefaultComboBoxModel(ds_mt4.toArray()));
				cboMoTa4.addItem("Tất cả");
				cboMoTa4.setSelectedIndex(cboMoTa4.getItemCount()-1);
		
				
			}
		}else
		if (o.equals(btnTimKiem)) {
			locComboBox();
		}
	}
	private void themLinhKien() throws IOException {
		
		Image img = imiAnh.getImage();
		BufferedImage bi = new BufferedImage(250,250,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();
		g2.drawImage(img, 0, 0, null);
		g2.dispose();
		ImageIO.write(bi, "jpg",new File("./anh/"+txtAnh.getText()+".jpg"));
		if(dslk.themLinhKien(txtTenLinhKien.getText(), txtSoLuong.getText(), txtDonGiaGoc.getText(), txtDonGiaBan.getText(), maNCC,txtThoiHanBaoHanh.getText(), maLoai, txtAnh.getText(),txtMoTa1.getText(),txtMoTa2.getText(),txtMoTa3.getText(),txtMoTa4.getText())) {
			dataModel.setRowCount(0);
			table.setModel(dslk.docTableQLLK());
			JOptionPane.showMessageDialog(null, "Đã thêm Linh Kiện thành công.");
			xoaRongTextField();
		}
	}
	private void suaLinhKien() throws IOException {
		if (imiAnh==null) imiAnh=new ImageIcon("./anh/"+txtAnh.getText()+".jpg");
		Image img = imiAnh.getImage();
		BufferedImage bi = new BufferedImage(250,250,BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = bi.createGraphics();
		g2.drawImage(img, 0, 0, null);
		g2.dispose();
		ImageIO.write(bi, "jpg",new File("./anh/"+txtAnh.getText()+".jpg"));
		
		if(dslk.suaLinhKien(txtTenLinhKien.getText(), txtSoLuong.getText(), txtDonGiaGoc.getText(), txtDonGiaBan.getText(), maNCC,txtThoiHanBaoHanh.getText(), maLoai, txtAnh.getText(),txtMaLinhKien.getText(),txtMoTa1.getText(),txtMoTa2.getText(),txtMoTa3.getText(),txtMoTa4.getText())) {
			dataModel.setRowCount(0);
			table.setModel(dslk.docTableQLLK());
			JOptionPane.showMessageDialog(null, "Đã thay đổi thành công thông tin linh kiện.");
			xoaRongTextField();
		}
	}
		
	public void suaTextField() {
		String goc,ban,bh;
		goc=txtDonGiaGoc.getText();
		goc = goc.replace(",", "");
		goc = goc.replaceAll(" VND", "");
		txtDonGiaGoc.setText(goc);
		ban=txtDonGiaBan.getText();
		ban = ban.replace(",", "");
		ban = ban.replaceAll(" VND", "");
		txtDonGiaBan.setText(ban);
		txtThoiHanBaoHanh.setText(txtThoiHanBaoHanh.getText().replaceAll(" Tháng", ""));
	}
		

	public void editTextField() {
		txtTenLinhKien.setEditable(true);
		txtSoLuong.setEditable(true);
		txtDonGiaGoc.setEditable(true);
		txtDonGiaBan.setEditable(true);
		txtThoiHanBaoHanh.setEditable(true);
		txtMoTa1.setEditable(true);
		txtMoTa2.setEditable(true);
		txtMoTa3.setEditable(true);
		txtMoTa4.setEditable(true);
	}
	public void falseEditTextField() {
		txtTenLinhKien.setEditable(false);
		txtSoLuong.setEditable(false);
		txtDonGiaGoc.setEditable(false);
		txtDonGiaBan.setEditable(false);
		txtThoiHanBaoHanh.setEditable(false);
		txtMoTa1.setEditable(false);
		txtMoTa2.setEditable(false);
		txtMoTa3.setEditable(false);
		txtMoTa4.setEditable(false);
	}
	public void xoaRongTextField() {
		txtMaLinhKien.setText("");
		txtTenLinhKien.setText("");
		txtSoLuong.setText("");
		txtLoai.setText("");
		txtDonGiaGoc.setText("");
		txtDonGiaBan.setText("");
		txtNhaCungCap.setText("");
		txtThoiHanBaoHanh.setText("");
		txtAnh.setText("");
		txtMoTa1.setText("");
		txtMoTa2.setText("");
		txtMoTa3.setText("");
		txtMoTa4.setText("");
		lblAnhSP.setIcon(new ImageIcon("./anh/0.jpg"));
	}
	private String chonHinhAnh() {
		// TODO Auto-generated method stub
		 String l="";
		 JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
         j.setAcceptAllFileFilterUsed(false); 
         j.setDialogTitle("Select a .jpg file"); 
         FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .jpg files", "jpg"); 
         j.addChoosableFileFilter(restrict); 
         int r = j.showOpenDialog(null); 
           if (r == JFileChooser.APPROVE_OPTION) { 
              l=j.getSelectedFile().getAbsolutePath(); 
              txtAnh.setText(j.getSelectedFile().getName());
              txtAnh.setText(txtAnh.getText().replaceAll(".jpg", ""));
           } 
           else {
              l="./anh/0.jpg";
           	 txtAnh.setText("0.jpg");
           	}
		return l;
	}
	private void chonNCC() {
		// TODO Auto-generated method stub
		frmChonMaNCC=new JFrame();
		frmChonMaNCC.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frmChonMaNCC.setAlwaysOnTop(true);
		JPanel pnlNCC=new JPanel();
		JPanel pnlBTN=new JPanel();
		frmChonMaNCC.setTitle("Chọn Nhà Cung Cấp");
		frmChonMaNCC.setSize(500, 450);
		frmChonMaNCC.setLocationRelativeTo(null);
		frmChonMaNCC.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("./icon/REEBPC.png");
		frmChonMaNCC.setIconImage(icon);
		frmChonMaNCC.setVisible(true);
		Box bTong=Box.createVerticalBox();
		bTong.add(pnlNCC);
		bTong.add(pnlBTN);
		frmChonMaNCC.getContentPane().add(bTong);	
		DefaultTableModel tableModelCC;
		tableCC = null;
		
		String [] header = {"Mã NCC","Tên NCC","Địa chỉ","SĐT","E-mail"};
		tableModelCC = new DefaultTableModel(header, 0);
		tableCC = new JTable(tableModelCC) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		JScrollPane scroll;
		pnlNCC.add(scroll = new JScrollPane(tableCC));
		tableModelCC.setRowCount(0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhacungcap";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String dc=rs.getString(3);
				String sdt=rs.getString(4);
				String email=rs.getString(5);
				String[] rowData= {ma,ten,dc,sdt,email};
				tableModelCC.addRow(rowData);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		tableCC.setModel(tableModelCC);
		pnlBTN.add(btnXacNhanNCC=new JButton("Xác Nhận"));
		btnXacNhanNCC.addActionListener(this);
		
	}

	private void chonLoai() {
		// TODO Auto-generated method stub
		
		diaLoai=new JFrame();
		diaLoai.setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		JPanel pnlNCC=new JPanel();
		JPanel pnlBTN=new JPanel();
		diaLoai.setTitle("Chọn Loại Linh Kiện");
		diaLoai.setSize(500, 450);
		diaLoai.setLocationRelativeTo(null);
		diaLoai.setResizable(false);
		diaLoai.setAlwaysOnTop(true);
		Image icon = Toolkit.getDefaultToolkit().getImage("./icon/REEBPC.png");
		diaLoai.setIconImage(icon);
		diaLoai.setVisible(true);
		Box bTong=Box.createVerticalBox();
		bTong.add(pnlNCC);
		bTong.add(pnlBTN);
		diaLoai.getContentPane().add(bTong);	
		DefaultTableModel tableModelCC;
		tableLoai = null;
		JScrollPane scrollCC;
		String [] header = {"Mã loại","Tên Loại"};
		tableModelCC = new DefaultTableModel(header, 0);
		tableLoai = new JTable(tableModelCC) {
			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JScrollPane scroll;
		pnlNCC.add(scroll = new JScrollPane(tableLoai));
		int st=0;
		tableModelCC.setRowCount(0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String[] rowData= {ma,ten};
				tableModelCC.addRow(rowData);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		tableLoai.setModel(tableModelCC);
		pnlBTN.add(btnXacNhanLoai=new JButton("Xác Nhận"));
		btnXacNhanLoai.addActionListener(this);
	}
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}
	private void locComboBox() {
		table.setRowHeight(15);
		dataModel.setRowCount(0);
		String l=cboLoaiLK.getSelectedItem().toString();
		String m1=cboMoTa1.getSelectedItem().toString();
		String m2=cboMoTa2.getSelectedItem().toString();
		String m3=cboMoTa3.getSelectedItem().toString();
		String m4=cboMoTa4.getSelectedItem().toString();
		table.setModel(dslk.locTableQLLK(l,m1,m2,m3,m4,txtTimKiem.getText()));
		table.setRowHeight(50);
	}
}
