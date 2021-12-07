package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.LinhKien;
import entity.NhanVien;
import xuly.Database;



public class DanhSachNhanVien {
	ArrayList<NhanVien> ds;
	NhanVien nv;
	public DanhSachNhanVien() {
		ds=new ArrayList<NhanVien>();
		nv=new NhanVien();
	}
	public ArrayList<NhanVien> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from nhanvien";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String cmnd=rs.getString(3);
				String gt=rs.getString(4);
				String sdt=rs.getString(5);
				String diachi=rs.getString(6);
				int loai=rs.getInt(7);
				NhanVien s=new NhanVien(ma,ten,cmnd,gt,sdt,diachi,loai);
			
				ds.add(s);
			
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
}
