package entity;

public class NhanVien {
	private String maNhanVien;
	private String hoTen;
	private String cmnd;
	private String gioiTinh;
	private String soDienThoai;
	private String diaChi;
	private int loaNhanVien;
	
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getLoaNhanVien() {
		return loaNhanVien;
	}
	public void setLoaNhanVien(int loaNhanVien) {
		this.loaNhanVien = loaNhanVien;
	}
	public NhanVien(String maNhanVien, String hoTen, String cmnd, String gioiTinh, String soDienThoai, String diaChi,
			int loaNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
		this.hoTen = hoTen;
		this.cmnd = cmnd;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.loaNhanVien = loaNhanVien;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", hoTen=" + hoTen + ", cmnd=" + cmnd + ", gioiTinh=" + gioiTinh
				+ ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", loaNhanVien=" + loaNhanVien + "]";
	}
}
	