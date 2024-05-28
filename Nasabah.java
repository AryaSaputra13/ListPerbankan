package Tubes;

public class Nasabah {
	protected String id;
	protected String nama, noRek;
	protected String keluhan, deskripsi;
	protected String namaIbu;
	protected Nasabah next;
	

	public Nasabah(String id, String nama, String namaIbu, String noRek, String keluhan, String deskripsi) {
		this.id = id;
		this.nama = nama;
		this.namaIbu = namaIbu;
		this.noRek = noRek;
		this.keluhan = keluhan;
		this.deskripsi = deskripsi;
		this.next = null;
	}
	
	public void setNext(Nasabah next) {
		this.next = next;
	}

	public String getId() {
		return id;
	}
	
	public String getNama() {
		return nama;
	}
	
	public String getNamaIbu() {
		return namaIbu;
	}
	
	public String getNoRek() {
		return noRek;
	}
	
	public String getKeluhan() {
		return keluhan;
	}
	
	public String getDeskripsi() {
		return deskripsi;
	}
	
	public Nasabah getNext() {
		return next;
	}
}
