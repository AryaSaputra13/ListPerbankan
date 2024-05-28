package Tubes;

import java.util.Scanner;

public class Sistem {
	private int HID = 1;
	private int Pilihan;
	private int Pilihan2;
	private int JKeluhan;
	Nasabah HEAD;
	
	public Sistem() {
		this.HEAD = null;
	}
	
	public boolean isEmpty() {
		return HEAD == null;
	}
	
	public void JenisKeluhan(Nasabah nasabah) {
		switch(JKeluhan) {
			case 1: nasabah.keluhan = "Transaksi tidak tercatat"; break;
			case 2: nasabah.keluhan = "Petugas tidak ramah"; break;
			case 3: nasabah.keluhan = "Kesalahan penarikan uang"; break;
			case 4: nasabah.keluhan = "Keterlambatan pengkreditan gaji"; break;
			case 5: nasabah.keluhan = "Kartu kredit ditolak"; break;
			case 6: 
					Scanner sc = new Scanner(System.in);
					System.out.println("Tuliskan Keluhan lainnya: "); nasabah.keluhan = sc.next();
					break;
				default: System.out.println("Jenis Keluhan tidak ditemukan");
		}
	}
	
	public void PilihanList() {
		switch(Pilihan2) {
			case 1: CariKeluhan(); break;
			case 2: HapusId(); break;
			case 3: MainMenu();break;
				default: System.out.println("Not Found 404");
		}
	}
	
	public void pilihan() {
		switch(Pilihan) {
			case 1: displayElement(); break;
			case 2: FormIsian(); break;
			case 3: System.out.println("Terima Kasih"); System.exit(0); break;
				default: System.out.println("Pilihan tidak tersedia"); break;
		}
	}
	
	public void MainMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========== Main Menu ==========");
		System.out.println("1. List Keluhan \n"
							+ "2. Tambah Keluhan \n"
							+ "3. Keluar");
		Pilihan = sc.nextInt();
		pilihan();
	}
	
	public void FormIsian() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("========== Form Keluhan ==========");
		CekId();
		int id = HID++;
		System.out.print("Nama : "); 
		String nama = sc.next();
		System.out.print("Nama Ibu : "); 
		String namaIbu = sc.next();
		System.out.print("Nomor Rekening : "); 
		String noRek = sc.next();
		System.out.println("1. Transaksi tidak tercatat \n"
							+ "2. Petugas tidak ramah \n"
							+ "3. Kesalahan penarikan uang \n"
							+ "4. Keterlambatan pengkreditan gaji \n"
							+ "5. Kartu kredit ditolak \n"
							+ "6. Lainnya");
		System.out.print("Jenis Keluhan: "); 
		JKeluhan = sc.nextInt();
		Nasabah newNasabah = new Nasabah(id, nama, namaIbu, noRek, null, null);
		JenisKeluhan(newNasabah);
		System.out.print("Deskripsi keluhan: "); 
		newNasabah.deskripsi = sc.next();
		addTail(newNasabah.id, newNasabah.nama, newNasabah.namaIbu, newNasabah.noRek, newNasabah.keluhan, newNasabah.deskripsi);
		System.out.println("===== Terima Kasih Form anda akan segera diproses =====");
		System.out.println();
		MainMenu();
	}
	
	public void displayElement() {
		Nasabah curNode = HEAD;
		while (curNode != null) {
			System.out.println(	"ID Keluhan : ID-" + curNode.getId() + "\n"
								+ "Nama Nasabah : " + curNode.getNama() + "\n" 
								+ "Nama Ibu Nasabah : " + curNode.getNamaIbu() + "\n" 
								+ "Nomor Rekening Nasabah : " + curNode.getNoRek() + "\n"
								+ "Jenis Keluhan Nasabah : " + curNode.getKeluhan() + "\n"
								+ "Deskripsi Keluhan : \n" + curNode.getDeskripsi());
			System.out.println();
			curNode = curNode.getNext();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1. Cari Keluhan \n"
							+ "2. Hapus Keluhan \n"
							+ "3. Kembali\n");
		System.out.print("Masukkan Pilihan: "); 
		Pilihan2 = sc.nextInt(); 
		PilihanList();
		System.out.println();
	}
	
	public void addTail(int id, String nama, String namaIbu, String noRek, String keluhan, String deskripsi) {
		Nasabah posNode = null, curNode = null;
		
		Nasabah newNode = new Nasabah(id, nama, namaIbu, noRek, keluhan, deskripsi);
		if (isEmpty()) {
			HEAD = newNode;
		} else {
			curNode = HEAD;
			while(curNode != null) {
				posNode = curNode;
				curNode = curNode.getNext();
			}
			posNode.setNext(newNode);
		}
	}
	
	public void addHead(int id, String nama, String namaIbu, String noRek, String keluhan, String deskripsi) {
		Nasabah newNode = new Nasabah(id, nama, namaIbu, noRek, keluhan, deskripsi);
		if(isEmpty()) {
			HEAD = newNode;
		} else {
			newNode.setNext(HEAD);
			HEAD = newNode;
		}
	}
	
	private void CekId() {
        Nasabah curNode = HEAD;
        int maxId = 0;
        while (curNode != null) {
            if (curNode.getId() > maxId) {
                maxId = curNode.getId();
            }
            curNode = curNode.getNext();
        }
        HID = maxId + 1;
    }
	
	public void HapusForm(int id) {
        if (HEAD != null) {
            boolean ketemu = false;
            int i = 1;

            Nasabah delNode = HEAD;
            Nasabah preNode = null;

            while (delNode != null && !ketemu) {
                if (delNode.getId() == id) {
                    ketemu = true;
                } else {
                    preNode = delNode;
                    delNode = delNode.next;
                    i++;
                }
            }

            if (ketemu) {
                if (i == 1) {
                    HEAD = delNode.getNext();
                } else {
                    preNode.next = delNode.getNext();
                }
                System.out.println("Form keluhan dengan ID-" + id + " telah selesai.");
            } else {
                System.out.println("Form keluhan dengan ID-" + id + " tidak ditemukan.");
            }
        } else {
            System.out.println("List form keluhan kosong.");
        }
    }
	
	 public void HapusId() {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Masukkan ID Form yang telah selesai: ");
	        int id = sc.nextInt();
	        HapusForm(id);
	        MainMenu();
	 }
	 
	 public Nasabah CariId(int id) {
	        Nasabah curNode = HEAD;
	        while (curNode != null) {
	            if (curNode.getId() == id) {
	                return curNode;
	            }
	            curNode = curNode.getNext();
	        }
	        return null;
	    }
	 
	 public void CariKeluhan() {
		    Scanner sc = new Scanner(System.in);
		    System.out.print("Masukkan ID Keluhan yang ingin dicari: ");
		    int id = sc.nextInt();
		    Nasabah keluhan = CariId(id);
		    if (keluhan != null) {
		        System.out.println("Keluhan ditemukan:");
		        System.out.println("ID Keluhan : ID-" + keluhan.getId() + "\n"
		                           + "Nama Nasabah : " + keluhan.getNama() + "\n"
		                           + "Nama Ibu Nasabah : " + keluhan.getNamaIbu() + "\n"
		                           + "Nomor Rekening Nasabah : " + keluhan.getNoRek() + "\n"
		                           + "Jenis Keluhan Nasabah : " + keluhan.getKeluhan() + "\n"
		                           + "Deskripsi Keluhan : " + keluhan.getDeskripsi());
		    } else {
		        System.out.println("Keluhan dengan ID " + id + " tidak ditemukan.");
		    }
		    MainMenu();
	 }
}

