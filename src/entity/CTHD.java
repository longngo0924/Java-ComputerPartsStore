package entity;

public class CTHD {
	private String maHoaDon;
	private String maLinhKien;
	private int soLuong;
	private Double donGia;
	public CTHD(String maHoaDon, String maLinhKien, int soLuong, Double donGia) {
		super();
		this.maHoaDon = maHoaDon;
		this.maLinhKien = maLinhKien;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}
	public CTHD() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CTHD [maHoaDon=" + maHoaDon + ", maLinhKien=" + maLinhKien + ", soLuong=" + soLuong + ", donGia="
				+ donGia + "]";
	}
	
}
