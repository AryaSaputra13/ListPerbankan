package Tubes;

public class FormKeluhan {
	public static void main(String[] args) {
		Sistem list = new Sistem();
		list.addTail(1, "Nama", "NamaIbu", "123", "Keluhan Jenis", "Deskripsi keluhan");
		list.addTail(2, "Nama", "NamaIbu", "123", "Keluhan Jenis", "Deskripsi keluhan");
		list.addTail(3, "Nama", "NamaIbu", "123", "Keluhan Jenis", "Deskripsi keluhan");
		list.addTail(4, "Nama", "NamaIbu", "123", "Keluhan Jenis", "Deskripsi keluhan");
		list.addTail(5, "Nama", "NamaIbu", "123", "Keluhan Jenis", "Deskripsi keluhan");
		list.MainMenu();
	}
}