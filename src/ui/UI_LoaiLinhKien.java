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

import dao.DanhSachKhachHang;
import dao.DanhSachLinhKien;
import dao.DanhSachLoaiLinhKien;
import entity.LoaiLinhKien;
import xuly.Database;

import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class UI_LoaiLinhKien extends JDialog implements MouseListener, ActionListener{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private Box bTong,bThongTin,bGiua,bTable,bChucNang,bTimKiem,bTren,bDuoi;
	
	private JLabel lblMaLoai,lblTenLoai;
	private JTextField txtMaLoai,txtTenLoai;
	
	private JButton btnThem, btnSua,btnLuu,btnXoaRong,btnHuy;
	private JLabel lblThongBao;
	private JTextField txtThongBao;
	
	public JComboBox<String> cboMoTa3,cboMoTa4;
	private JTextField txtTenTK;
	private JButton btnTimKiem;
	
	private DefaultTableModel dataModel;
	private JTable table;
	private Component horizontalStrut;
	private Component horizontalStrut_1;
	private Component horizontalStrut_2;


	public String maLoai,maNCC;
	public int hanhdong;

	

	private DanhSachLoaiLinhKien dsllk=new DanhSachLoaiLinhKien();
	
	private JLabel lblTnKH;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component horizontalStrut_5;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private Component verticalStrut_4;
	
	public UI_LoaiLinhKien() {
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
		bTong.add(bGiua=Box.createHorizontalBox());
		bTong.add(bDuoi=Box.createVerticalBox());

		
		//thong tin linh kien
		bThongTin=Box.createVerticalBox();
		bThongTin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		bTren.add(bThongTin);
		bThongTin.setBackground(Color.WHITE);
		bThongTin.setBorder(new TitledBorder(null, "Thông tin loại linh kiện", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		//label and text field
		lblMaLoai=new JLabel("Mã Loại: ");
		lblMaLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblTenLoai=new JLabel(" Tên Loại:  ");
		lblTenLoai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenLoai.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtMaLoai=new JTextField();
		txtMaLoai.setColumns(7);
		txtMaLoai.setBackground(Color.WHITE);
		txtMaLoai.setEditable(false);
		txtMaLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtTenLoai=new JTextField();
		txtTenLoai.setColumns(7);
		txtTenLoai.setBackground(Color.WHITE);
		txtTenLoai.setEditable(false);
		txtTenLoai.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		//add vao
		Box b01,b02;
		b01=Box.createHorizontalBox();
		b02=Box.createHorizontalBox();
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		bThongTin.add(verticalStrut_3);
		bThongTin.add(b01);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		bThongTin.add(verticalStrut_2);
		
		

		bThongTin.add(b02);
		
		b01.add(lblMaLoai);
		b01.add(txtMaLoai);
		b01.add(lblTenLoai);
		b01.add(txtTenLoai);
		// hinh an linh kien
	
		//chuc nang - button
		bChucNang=Box.createHorizontalBox();
		bGiua.add(bChucNang);
		btnThem=new JButton("Thêm loại linh kiện mới");
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
		Box b11;
		
	

		b11=Box.createHorizontalBox();
		
		btk.add(b11);
		
		txtTenTK=new JTextField();
		txtTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		btnTimKiem=new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		lblTnKH = new JLabel("Tên Loại:   ");
		lblTnKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		
		
		b11.add(lblTnKH);
		b11.add(txtTenTK);
		
		horizontalStrut_5 = Box.createHorizontalStrut(10);
		b11.add(horizontalStrut_5);
		b11.add(btnTimKiem);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		btk.add(verticalStrut_1);
		
	
		btk.setMaximumSize(new Dimension(1600, 100));
		bThongTin.setMaximumSize(new Dimension(1600, 600));
		bGiua.setMaximumSize(new Dimension(1600, 600));
		//table
		Box bds=Box.createVerticalBox();
		bDuoi.add(bds);
		bds.setBorder(new TitledBorder("Danh sách loại linh kiện"));
		String[] headers= {"Mã loại","Tên loại"};
		dataModel=new DefaultTableModel(headers,0);	
		JScrollPane scroll;
		bds.add(scroll=new JScrollPane(table=new JTable(dataModel)));
	
		dataModel.setRowCount(0);
		table.setModel(dsllk.docTableQLLLK());
		table.setRowHeight(50);
		table.addMouseListener(this);
		table.setDefaultEditor(Object.class, null);
		Database.getInstance().connect();
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTimKiem.addActionListener(this);
		setTrangThai("Xem thông tin loại linh kiện");
	
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
			String[] ttam=dsllk.docTextFieldQLLLK(ma);
			txtMaLoai.setText(ttam[0]);
			txtTenLoai.setText(ttam[1]);
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
			
			table.setEnabled(false);
			table.clearSelection();
			xoaRongTextField();
			editTextField();
			hanhdong=1;
			setTrangThai("Thêm loại linh kiện mới, nhập thông tin trên các ô trống và bấm lưu.");
		}else
		if (o.equals(btnSua)) {
			btnThem.setEnabled(false);
			btnSua.setEnabled(false);
			btnHuy.setEnabled(true);
			btnLuu.setEnabled(true);
			
			table.setEnabled(false);
			table.clearSelection();
			editTextField();
			
			hanhdong=2;
			setTrangThai("Thay đổi thông tin loại linh kiện, sửa đổi thông tin cần thiết và bấm lưu.");
		}else
		if (o.equals(btnHuy)) {
			btnThem.setEnabled(true);
			btnSua.setEnabled(true);
			btnHuy.setEnabled(false);
			btnLuu.setEnabled(false);
			table.setEnabled(true);
			xoaRongTextField();
			falseEditTextField();
			hanhdong=0;
			setTrangThai("Xem thông tin loại linh kiện");
		}else
		
		if (o.equals(btnLuu)) {
			
			if (hanhdong==1) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn thêm loại linh kiện này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
				if(dialogResult == JOptionPane.YES_OPTION){
					if (dsllk.themllk(txtTenLoai.getText())) {
						btnThem.setEnabled(true);
						btnSua.setEnabled(true);
						btnHuy.setEnabled(false);
						btnLuu.setEnabled(false);
						table.setEnabled(true);
						table.clearSelection();
						xoaRongTextField();
						falseEditTextField();
						table.setEnabled(true);

						dataModel.setRowCount(0);
						table.setModel(dsllk.docTableQLLLK());
						table.setRowHeight(50);
						hanhdong=0;
					}
						
			
				}
				}
			else
				if (hanhdong==2) {
					int dialogResult2 = JOptionPane.showConfirmDialog (null, "Bạn có muốn thay đổi thông tin loại linh kiện này không?","Cảnh báo",JOptionPane.YES_NO_OPTION);
					if(dialogResult2 == JOptionPane.YES_OPTION){
						if (dsllk.suaLoai(txtTenLoai.getText(), txtMaLoai.getText())) {
							btnThem.setEnabled(true);
							btnSua.setEnabled(true);
							btnHuy.setEnabled(false);
							btnLuu.setEnabled(false);
							table.setEnabled(true);
							table.clearSelection();
							xoaRongTextField();
							falseEditTextField();
							table.setEnabled(true);

							dataModel.setRowCount(0);
							table.setModel(dsllk.docTableQLLLK());
							table.setRowHeight(50);
							hanhdong=0;
						}
						
				}
			}
			setTrangThai("Xem thông tin loại linh kiện");
			
		}else
		
		if (o.equals(btnTimKiem)) {
			locTK();
		}
	}
	
	
		

	private void locTK() {
		// TODO Auto-generated method stub
		table.setRowHeight(15);
		dataModel.setRowCount(0);
		String ten=txtTenTK.getText();
	
		table.setModel(dsllk.locLLK(ten));
		table.setRowHeight(50);
	}

	public void editTextField() {
		txtTenLoai.setEditable(true);
	
		
	}
	public void falseEditTextField() {
		txtTenLoai.setEditable(false);

		
	}
	public void xoaRongTextField() {
		txtMaLoai.setText("");
		txtTenLoai.setText("");
	
		
	}
	


}
