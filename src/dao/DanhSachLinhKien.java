package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import entity.HoaDon;
import entity.LinhKien;
import ui.test;
import xuly.Database;



public class DanhSachLinhKien {
	ArrayList<LinhKien> ds;
	LinhKien lk;
	public DanhSachLinhKien() {
		ds=new ArrayList<LinhKien>();
		lk=new LinhKien();
	}
	public ArrayList<LinhKien> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from linhkien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				int sl=rs.getInt(3);
				Double dgg=rs.getDouble(4);
				Double dgb=rs.getDouble(5);
				String mancc=rs.getString(6);
				int bh=rs.getInt(7);
				String loai=rs.getString(8);
				String anh=rs.getString(9);
				String mt1=rs.getString(10);
				String mt2=rs.getString(11);
				String mt3=rs.getString(12);
				String mt4=rs.getString(13);
				LinhKien s=new LinhKien(ma,ten,sl,dgg,dgb,mancc,bh,loai, anh,mt1,mt2,mt3,mt4);
				ds.add(s);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	
	public DefaultTableModel docTableQLLK(){
		DefaultTableModel tableModel;
		String[] headers= {"Mã linh kiện","Tên linh kiện","Số lượng","Loại","Đơn giá gốc","Đơn giá bán","Nhà cung cấp","Thời hạn bảo hành"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select top(50) lk.malinhkien, lk.tenlinhkien, lk.soluong,loai.tenloai,lk.dongiagoc,lk.dongiaban,ncc.tenncc,lk.thoihanbaohanh\r\n"
					+ "from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai\r\n"
					+ "inner join nhacungcap ncc on lk.manhacungcap=ncc.manhacungcap";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				int sl=rs.getInt(3);
				String loai=rs.getString(4);
				Double goc=rs.getDouble(5);
				Double ban=rs.getDouble(6);
				String ncc=rs.getString(7);
				int bh=rs.getInt(8);
				String[] rowData= {ma,ten,sl+"",loai,test.formatter.format(goc)+" VND",test.formatter.format(ban)+" VND",ncc,bh+" Tháng"};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	
	public String[] docTextFieldQLLK(String malk){
		String[] rowData= {};
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select lk.malinhkien, lk.tenlinhkien, lk.soluong,loai.tenloai,lk.dongiagoc,lk.dongiaban,ncc.tenncc,lk.thoihanbaohanh,lk.anh,lk.mota1,lk.mota2,lk.mota3,lk.mota4,lk.manhacungcap,lk.maloai\r\n"
					+ "from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai\r\n"
					+ "inner join nhacungcap ncc on lk.manhacungcap=ncc.manhacungcap\r\n"
					+ "where lk.malinhkien=?";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,malk);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				int sl=rs.getInt(3);
				String loai=rs.getString(4);
				Double goc=rs.getDouble(5);
				Double ban=rs.getDouble(6);
				String ncc=rs.getString(7);
				int bh=rs.getInt(8);
				String anh=rs.getString(9);
				String mt1=rs.getString(10);
				String mt2=rs.getString(11);
				String mt3=rs.getString(12);
				String mt4=rs.getString(13);
				String mancc=rs.getString(14);
				String maloai=rs.getString(15);
				String[] rowData2= {ma,ten,sl+"",loai,test.formatter.format(goc)+" VND",test.formatter.format(ban)+" VND",ncc,bh+" Tháng",anh,mt1,mt2,mt3,mt4,mancc,maloai};
				rowData=rowData2;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return rowData;
	}
	
	
	public boolean themLinhKien(String ten,String sl,String giagoc,String giaban,String ncc,String bh,String loai,String anh, String mt1,String mt2,String mt3,String mt4) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO LINHKIEN (TENLINHKIEN,SOLUONG,DONGIAGOC,DONGIABAN,MANHACUNGCAP,THOIHANBAOHANH,MALOAI,ANH,MOTA1,MOTA2,MOTA3,MOTA4)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
			int soluong=Integer.parseInt(sl);
			int baohanh=Integer.parseInt(bh);
			double dgg = Double.parseDouble(giagoc);
			double dgb= Double.parseDouble(giaban);
			stmt.setString(1,ten);
			stmt.setInt(2, soluong);
			stmt.setDouble(3,dgg);
			stmt.setDouble(4, dgb);
			stmt.setString(5,ncc);
			stmt.setInt(6, baohanh);
			stmt.setString(7,loai);
			stmt.setString(8,anh);
			stmt.setString(9,mt1);
			stmt.setString(10,mt2);
			stmt.setString(11,mt3);
			stmt.setString(12,mt4);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public boolean suaLinhKien(String ten,String sl,String giagoc,String giaban,String ncc,String bh,String loai,String anh,String ma, String mt1,String mt2,String mt3,String mt4) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
		
			stmt=con.prepareStatement("update linhkien set tenlinhkien=?, soluong=?, dongiagoc=?,dongiaban=?,manhacungcap=?,thoihanbaohanh=?,maloai=?,anh=?,mota1=?,mota2=?,mota3=?,mota4=? where malinhkien=?");
			int soluong=Integer.parseInt(sl);
			int baohanh=Integer.parseInt(bh);
			double dgg = Double.parseDouble(giagoc);
			double dgb= Double.parseDouble(giaban);
			stmt.setString(1,ten);
			stmt.setInt(2, soluong);
			stmt.setDouble(3,dgg);
			stmt.setDouble(4, dgb);
			stmt.setString(5,ncc);
			stmt.setInt(6, baohanh);
			stmt.setString(7,loai);
			stmt.setString(8,anh);
			stmt.setString(9,mt1);
			stmt.setString(10,mt2);
			stmt.setString(11,mt3);
			stmt.setString(12,mt4);
			stmt.setString(13,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public boolean suaLinhKien2(String sl,String ma) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update linhkien set  soluong=? where malinhkien=?");
			int soluong=Integer.parseInt(sl);
			stmt.setInt(1, soluong);
			stmt.setString(2,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	
	public boolean xoaLinhKien(String ma) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from linhkien where (malinhkien=?)");
			stmt.setString(1,ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}
	public ArrayList<String> docMoTa1(String tenLoai){
		ArrayList<String> kq=new ArrayList<String>();
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select lk.mota1 from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai where loai.tenloai=? group by mota1";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,tenLoai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ten=rs.getString(1);
				kq.add(ten);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public ArrayList<String> docMoTa2(String tenLoai){
		ArrayList<String> kq=new ArrayList<String>();
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select lk.mota2 from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai where loai.tenloai=? group by mota2";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,tenLoai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ten=rs.getString(1);
				kq.add(ten);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public ArrayList<String> docMoTa3(String tenLoai){
		ArrayList<String> kq=new ArrayList<String>();
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select lk.mota3 from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai where loai.tenloai=? group by mota3";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,tenLoai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ten=rs.getString(1);
				kq.add(ten);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	public ArrayList<String> docMoTa4(String tenLoai){
		ArrayList<String> kq=new ArrayList<String>();
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select lk.mota4 from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai where loai.tenloai=? group by mota4";
			PreparedStatement stm=con.prepareStatement(sql);
			stm.setString(1,tenLoai);
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ten=rs.getString(1);
				kq.add(ten);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}
	
	public DefaultTableModel locTableQLLK(String tenloai, String mota1, String mota2, String mota3, String mota4, String tenSearch){
		DefaultTableModel tableModel;
		String[] headers= {"Mã linh kiện","Tên linh kiện","Số lượng","Loại","Đơn giá gốc","Đơn giá bán","Nhà cung cấp","Thời hạn bảo hành"};
		tableModel=new DefaultTableModel(headers,0);
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select lk.malinhkien, lk.tenlinhkien, lk.soluong,loai.tenloai,lk.dongiagoc,lk.dongiaban,ncc.tenncc,lk.thoihanbaohanh\r\n"
					+ "from linhkien lk inner join loailinhkien loai on lk.maloai=loai.maloai\r\n"
					+ "inner join nhacungcap ncc on lk.manhacungcap=ncc.manhacungcap\r\n"
					+ "where loai.tenloai like ? and mota1 like ? and mota2 like ? and mota3 like ? and mota4 like ? and lk.tenlinhkien like ?";
			PreparedStatement stm=con.prepareStatement(sql);
			if (tenloai.equals("Tất cả")) stm.setString(1,"%%"); else stm.setString(1,tenloai);
			if (mota1.equals("Tất cả")) stm.setString(2,"%%"); else stm.setString(2,mota1);
			if (mota2.equals("Tất cả")) stm.setString(3,"%%"); else stm.setString(3,mota2);
			if (mota3.equals("Tất cả")) stm.setString(4,"%%"); else stm.setString(4,mota3);
			if (mota4.equals("Tất cả")) stm.setString(5,"%%"); else stm.setString(5,mota4);
			stm.setString(6,"%"+tenSearch+"%");
		
			ResultSet rs = stm.executeQuery();
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				int sl=rs.getInt(3);
				String loai=rs.getString(4);
				Double goc=rs.getDouble(5);
				Double ban=rs.getDouble(6);
				String ncc=rs.getString(7);
				int bh=rs.getInt(8);
				String[] rowData= {ma,ten,sl+"",loai,test.formatter.format(goc)+" VND",test.formatter.format(ban)+" VND",ncc,bh+" Tháng"};
				tableModel.addRow(rowData);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tableModel;
	}
	
	
}
