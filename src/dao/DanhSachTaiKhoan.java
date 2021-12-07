package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.LinhKien;
import entity.TaiKhoan;
import xuly.Database;

public class DanhSachTaiKhoan {
	ArrayList<TaiKhoan> ds;
	TaiKhoan tk;
	public DanhSachTaiKhoan() {
		ds=new ArrayList<TaiKhoan>();
		tk=new TaiKhoan();
	}
	

	public ArrayList<TaiKhoan> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from taikhoan";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String tk=rs.getString(1);
				String mk=rs.getString(2);
				TaiKhoan s=new TaiKhoan(tk,mk);
				ds.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
		
	}
}
