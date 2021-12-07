package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.KhachHang;
import entity.LinhKien;
import ui.test;
import xuly.Database;

public class DanhSachKhachHang {
	ArrayList<KhachHang> ds;
	KhachHang kh;
	public DanhSachKhachHang() {
		ds=new ArrayList<KhachHang>();
		kh=new KhachHang();
	}
	
	public ArrayList<KhachHang> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from khachhang";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sdt=rs.getString(3);
				String dc=rs.getString(4);
				KhachHang s=new KhachHang(ma,ten,sdt,dc);
				ds.add(s);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean themKhachHang(String ten, String sdt, String diachi) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO KhachHang (hoten,sodienthoai,diachi)VALUES(?,?,?)");
		
			stmt.setString(1,ten);
			stmt.setString(2,sdt);
			stmt.setString(3,diachi);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public DefaultTableModel docTableQLKH(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) *from khachhang order by makhachhang desc";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sodienthoai=rs.getString(3);
				String diachi=rs.getString(4);
				String[] rowData= {ma,ten,sodienthoai,diachi};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public String[] docTextFieldQLKH(String makh){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from khachhang\r\n"
					+ "where makhachhang=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,makh);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String sodienthoai=rs.getString(3);
				String diachi=rs.getString(4);
				String[] rowData2= {ma,ten,sodienthoai,diachi};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	public boolean suaKhachHang(String ten,String sodienthoai, String diachi,String ma) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update khachhang set hoten=?, sodienthoai=?, diachi=? where makhachhang=?");
			stmt.setString(1,ten);
			stmt.setString(2,sodienthoai);
			stmt.setString(3,diachi);
			stmt.setString(4,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public DefaultTableModel locKH(String ten,String sodienthoai,String diachi){
		DefaultTableModel tableModel;
		String[] headers= {"Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from khachhang where hoten like ? and sodienthoai like ? and diachi like ?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,"%"+ten+"%");
			stm.setString(2,"%"+sodienthoai+"%");
			stm.setString(3,"%"+diachi+"%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String tenkh=rs.getString(2);
				String sdt=rs.getString(3);
				String dc=rs.getString(4);
				
				String[] rowData= {ma,tenkh,sdt,dc};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	
}
