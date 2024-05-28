package Tubes;

public class FormKeluhan {
	public static void main(String[] args) {
		Sistem list = new Sistem();
		
		list.addTail(1,"Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.addTail(2,"Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.addTail(3,"Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.addTail(4,"Nama", "Nama ibu", "123", "Keluhan", "Desk keluhan");
		list.MainMenu();
	}
}