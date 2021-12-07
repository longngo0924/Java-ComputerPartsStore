package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.HoaDon;
import entity.TaiKhoan;
import xuly.Database;


public class DanhSachHoaDon {
	ArrayList<HoaDon> ds;
	HoaDon hd;
	public DanhSachHoaDon() {
		ds=new ArrayList<HoaDon>();
		hd=new HoaDon();
	}
	
	/**
	 * select hd.mahoadon, hd.ngaylap, nv.hoten, kh.hoten, ct.tongTien
from hoadon hd inner join (select mahoadon,sum(dongia) as tongTien from CTHD group by mahoadon) ct on ct.mahoadon=hd.mahoadon
inner join nhanvien nv on hd.MANHANVIEN=nv.manhanvien
inner join khachhang kh on hd.MAKHACHHANG=kh.MAKHACHHANG
	 * @return
	 */
	public ArrayList<HoaDon> docTuBang(){
		try {
			Connection con=Database.getInstance().getConnection();
			String sql="select *from hoadon";
			Statement statement=con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				Date ngaylap=rs.getDate(4);
				String nv=rs.getString(2);
				String kh=rs.getString(3);
				HoaDon s=new HoaDon(ma,kh,nv,ngaylap);
				ds.add(s);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	public boolean themHoaDon(String manv, String makh) {
		Connection con=Database.getInstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("INSERT INTO HOADON (MANHANVIEN,MAKHACHHANG,NGAYLAP)VALUES(?,?,GETDATE())");	
			stmt.setString(1,manv);
			stmt.setString(2, makh);	
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}finally {
			return n>0;
		}
	}

}
