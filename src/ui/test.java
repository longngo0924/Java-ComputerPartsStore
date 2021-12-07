package ui;

import java.sql.Connection;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import xuly.Database;



public class test {
	public static int col=0;
	public static String tenNhanVien="";
	public static String maNhanVien="";
	public static DecimalFormat formatter = new DecimalFormat("###,###,###.##");
	public static void main(String[] args) {
        UI_DangNhap fm = new UI_DangNhap();
	//	UI_QuanLyLinhKien fm = new UI_QuanLyLinhKien();
	//	UI_TrangChu fm = new UI_TrangChu();
		
		
	//	UI_QuanLyHoaDon fm = new UI_QuanLyHoaDon();
	//	UI_QuanLyLinhKien fm = new UI_QuanLyLinhKien();
		//UI_ThemHoaDon fm=new UI_ThemHoaDon();
      
        fm.setVisible(true);
        Connection con=Database.getInstance().getConnection();
    }
}
