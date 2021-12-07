package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.CTHD;
import entity.HoaDon;
import xuly.Database;

public class DanhSachCTHD {
	ArrayList<CTHD> ds;
	CTHD ct;
	public DanhSachCTHD() {
		ds=new ArrayList<CTHD>();
		ct=new CTHD();
	}
	public ArrayList<CTHD> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from cthd";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String mahd=rs.getString(1);
				String malk=rs.getString(2);
				int sl=rs.getInt(3);
				Double dg=rs.getDouble(4);
				CTHD s=new CTHD(mahd,malk,sl,dg);
				ds.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean themCTHD(String mahd, String malk, String sl, String dg) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO CTHD (MAHOADON,MALINHKIEN,SOLUONG,DONGIA) VALUES (?,?,?,?)");	
			int soluong=Integer.parseInt(sl);
			Double dongia=Double.parseDouble(dg);
			stmt.setString(1,mahd);
			stmt.setString(2, malk);
			stmt.setInt(3, soluong);
			stmt.setDouble(4, dongia);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}

}
