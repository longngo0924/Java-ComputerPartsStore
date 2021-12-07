package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entity.LinhKien;
import entity.LoaiLinhKien;
import xuly.Database;

public class DanhSachLoaiLinhKien {
	ArrayList<LoaiLinhKien> ds;
	LoaiLinhKien llk;
	public DanhSachLoaiLinhKien() {
		ds=new ArrayList<LoaiLinhKien>();
		llk=new LoaiLinhKien();
	}
	public ArrayList<LoaiLinhKien> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				LoaiLinhKien llk= new LoaiLinhKien(ma,ten);
				ds.add(llk);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	public boolean themllk(String ten) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO loailinhkien (tenloai)VALUES(?)");
			stmt.setString(1,ten);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public DefaultTableModel docTableQLLLK(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã loại","Tên loại"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) *from loailinhkien order by maloai desc";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String[] rowData= {ma,ten};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	public String[] docTextFieldQLLLK(String mal){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien\r\n"
					+ "where maloai=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,mal);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String[] rowData2= {ma,ten};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	public boolean suaLoai(String ten,String ma) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update loailinhkien set tenloai=? where maloai=?");
			stmt.setString(1,ten);
			stmt.setString(2,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public DefaultTableModel locLLK(String ten){
		DefaultTableModel tableModel;
		String[] headers= {"Mã loại","Tên loại"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from loailinhkien where tenloai like ?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,"%"+ten+"%");
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String tenloai=rs.getString(2);
				String[] rowData= {ma,tenloai};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
}
