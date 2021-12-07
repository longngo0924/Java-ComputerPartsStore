package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.KhachHang;
import entity.NhaCungCap;
import xuly.Database;



public class DanhSachNhaCungCap {
	ArrayList<NhaCungCap> ds;
	NhaCungCap ncc;
	public DanhSachNhaCungCap() {
		ds=new ArrayList<NhaCungCap>();
		ncc=new NhaCungCap();
	}
	public ArrayList<NhaCungCap> docTuBang(){
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
				NhaCungCap s=new NhaCungCap(ma,ten,dc,sdt,email);
				ds.add(s);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean themNCC(String ten, String dc, String sdt,String email) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO nhacungcap (tenncc,diachi,sodienthoai,email)VALUES(?,?,?,?)");
		
			stmt.setString(1,ten);
			stmt.setString(2,dc);
			stmt.setString(3,sdt);
			stmt.setString(4,email);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public DefaultTableModel docTableQLNCC(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã nhà cung cấp","Tên nhà cung cấp","Địa chỉ","Số điện thoại","Email"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) *from nhacungcap order by manhacungcap desc";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String diachi=rs.getString(3);
				String sodienthoai=rs.getString(4);
				String email=rs.getString(5);
				String[] rowData= {ma,ten,diachi,sodienthoai,email};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public String[] docTextFieldQLNCC(String mancc){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhacungcap\r\n"
					+ "where manhacungcap=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,mancc);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String diachi=rs.getString(3);
				String sodienthoai=rs.getString(4);
				String email=rs.getString(5);
				String[] rowData2= {ma,ten,diachi,sodienthoai,email};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	public boolean suaNhaCungCap(String ten, String diachi,String sodienthoai,String email,String ma) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update nhacungcap set tenncc=?, diachi=?,sodienthoai=?, email=? where manhacungcap=?");
			stmt.setString(1,ten);
			stmt.setString(2,diachi);
			stmt.setString(3,sodienthoai);
			stmt.setString(4,email);
			stmt.setString(5,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public DefaultTableModel locNCC(String ten,String diachi,String sodienthoai,String email){
		DefaultTableModel tableModel;
		String[] headers= {"Mã nhà cung cấp","Tên nhà cung cấp","Địa chỉ","Số điện thoại","Email"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhacungcap where tenncc like ? and diachi like ? and sodienthoai like ? and email like ?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,"%"+ten+"%");
			stm.setString(2,"%"+diachi+"%");
			stm.setString(3,"%"+sodienthoai+"%");
			stm.setString(4,"%"+email+"%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String tenncc=rs.getString(2);
				String dc=rs.getString(3);
				String sdt=rs.getString(4);
				String emailncc=rs.getString(4);
				
				String[] rowData= {ma,tenncc,dc,sdt,emailncc};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
}
