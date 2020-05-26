 package nguyentrinhan.example.com.model;

import java.util.Vector;

public class NhomKhachHang {
	private String ma;
	private String ten;
	Vector<KhachHang> khachHangs;
	
	
	public NhomKhachHang() {
		super();
		this.khachHangs = new Vector<KhachHang>();
	}
	public NhomKhachHang(String ma, String ten) {
		super();
		this.ma = ma;
		this.ten = ten;
		this.khachHangs = new Vector<KhachHang>();
	}
	
	public void themKhachHang(KhachHang kh){
		this.khachHangs.add(kh);
		kh.setNhom(this);
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public Vector<KhachHang> getKhachHangs() {
		return khachHangs;
	}
	public void setKhachHangs(Vector<KhachHang> khachHangs) {
		this.khachHangs = khachHangs;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.ten;
	}

}
