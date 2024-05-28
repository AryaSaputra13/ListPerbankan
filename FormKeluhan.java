package Tubes;

public class FormKeluhan {
	public static void main(String[] args) {
		Sistem list = new Sistem();
		
		list.addTail("ID-1","Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.addTail("ID-2","Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.addTail("ID-3","Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.addTail("ID-4","Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.MainMenu();
	}
}