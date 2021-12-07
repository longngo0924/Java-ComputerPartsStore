package entity;

public class LinhKien {
	private String maLinhKien;
	private String tenLinhKien;
	private int soLuong;
	private Double donGiaGoc;
	private Double donGiaBan;
	private String maNhaCungCap;
	private int thoiHanBaoHanh;
	private String maLoai;
	private String anh;
	private String moTa1;
	private String moTa2;
	private String moTa3;
	private String moTa4;
	public String getMaLinhKien() {
		return maLinhKien;
	}
	public void setMaLinhKien(String maLinhKien) {
		this.maLinhKien = maLinhKien;
	}
	public String getTenLinhKien() {
		return tenLinhKien;
	}
	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public Double getDonGiaGoc() {
		return donGiaGoc;
	}
	public void setDonGiaGoc(Double donGiaGoc) {
		this.donGiaGoc = donGiaGoc;
	}
	public Double getDonGiaBan() {
		return donGiaBan;
	}
	public void setDonGiaBan(Double donGiaBan) {
		this.donGiaBan = donGiaBan;
	}
	public String getMaNhaCungCap() {
		return maNhaCungCap;
	}
	public void setMaNhaCungCap(String maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}
	public int getThoiHanBaoHanh() {
		return thoiHanBaoHanh;
	}
	public void setThoiHanBaoHanh(int thoiHanBaoHanh) {
		this.thoiHanBaoHanh = thoiHanBaoHanh;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getMoTa1() {
		return moTa1;
	}
	public void setMoTa1(String moTa1) {
		this.moTa1 = moTa1;
	}
	public String getMoTa2() {
		return moTa2;
	}
	public void setMoTa2(String moTa2) {
		this.moTa2 = moTa2;
	}
	public String getMoTa3() {
		return moTa3;
	}
	public void setMoTa3(String moTa3) {
		this.moTa3 = moTa3;
	}
	public String getMoTa4() {
		return moTa4;
	}
	public void setMoTa4(String moTa4) {
		this.moTa4 = moTa4;
	}
	
	public LinhKien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LinhKien(String maLinhKien, String tenLinhKien, int soLuong, Double donGiaGoc, Double donGiaBan,
			String maNhaCungCap, int thoiHanBaoHanh, String maLoai, String anh, String moTa1, String moTa2,
			String moTa3, String moTa4) {
		super();
		this.maLinhKien = maLinhKien;
		this.tenLinhKien = tenLinhKien;
		this.soLuong = soLuong;
		this.donGiaGoc = donGiaGoc;
		this.donGiaBan = donGiaBan;
		this.maNhaCungCap = maNhaCungCap;
		this.thoiHanBaoHanh = thoiHanBaoHanh;
		this.maLoai = maLoai;
		this.anh = anh;
		this.moTa1 = moTa1;
		this.moTa2 = moTa2;
		this.moTa3 = moTa3;
		this.moTa4 = moTa4;
	}
	@Override
	public String toString() {
		return "LinhKien [maLinhKien=" + maLinhKien + ", tenLinhKien=" + tenLinhKien + ", soLuong=" + soLuong
				+ ", donGiaGoc=" + donGiaGoc + ", donGiaBan=" + donGiaBan + ", maNhaCungCap=" + maNhaCungCap
				+ ", thoiHanBaoHanh=" + thoiHanBaoHanh + ", maLoai=" + maLoai + ", anh=" + anh + ", moTa1=" + moTa1
				+ ", moTa2=" + moTa2 + ", moTa3=" + moTa3 + ", moTa4=" + moTa4 + "]";
	}
	
}
