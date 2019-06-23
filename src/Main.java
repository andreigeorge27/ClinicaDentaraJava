import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	private static ManagementDB db = new ManagementDB();
	private static Administrator admin = new Administrator();
	private static Medic medic = new Medic();

	public static void main(String[] args) throws SQLException, ParseException {
		System.out.print("Introduceti numele de utilizator: ");
		String NumeUtilizator = scan.next();
		System.out.print("Introduceti parola: ");
		String Parola = scan.next();
		Cont cont = db.VerificaExistentaUtilizator(NumeUtilizator, Parola);
		System.out.println(cont.getAngajat().getNume() + " " + cont.getAngajat().getPrenume()+ " are functia de " + cont.getRol().getDenumire());
		
		//Functii administrator
		//1. Adaugare in baza de date medic
		/*
		Angajat medic = new Angajat();
		medic.setNume("Ramon");
		medic.setPrenume("Ioana");
		medic.setCNP("24343432432");
		System.out.println(admin.AddMedic(cont, medic));	
	    */
		
		//Cautare medic
		/*
		Angajat medic = new Angajat();	
		medic = admin.GetMedicDupaId(cont, 2);
		medic.setNume("Marinescu");
		System.out.println(admin.UpdateMedic(cont, medic));
		*/
		
		//Stergere medic
		/*
		admin.DeleteMedic(cont, 2);
		*/
		
		//Adaugare cont pentru medic
		/*
		Cont contNou = new Cont();
		Angajat angajat = new Angajat();
		Rol rol = new Rol();
		rol = admin.GetRolDupaId(cont, 2);
		angajat = admin.GetMedicDupaId(cont, 2);
		contNou.setAngajat(angajat);
		contNou.setRol(rol);
		contNou.setNumeUtilizator("Ioana");
		contNou.setParola("1234");
		admin.AddContAngajat(cont, contNou);
		*/
		
		//4. Salariu pe lunile anului curent pentru un anumit medic
		
		ArrayList<Salariu> listaSalarii = admin.SalariileMedicUltimulAn(cont, 1);
		for(int i = 0; i < listaSalarii.size(); i++) {
			System.out.println(listaSalarii.get(i).getValoare());
		}
		
		
		//5. Afisare preturi pentru o anumita interventie mai mica decat o anumita data
		/*
		ArrayList<Pret> listapreturi = new ArrayList<Pret>();
		String dataMinimaString = "2019-06-07"; 
		listapreturi = admin.PreturiMaiVechiPentruInterventieSpecifica(cont, 1, dataMinimaString);
		System.out.println(listapreturi.size());
		System.out.println("Preturi pentru interventia cautata mai mici decat data introdusa");
		for(int i = 0; i < listapreturi.size(); i++) {
			System.out.println(listapreturi.get(i).getPret() + " - data inceput: " + listapreturi.get(i).getDataInceput() + " - data sfarsit: " + listapreturi.get(i).getDataSfarsit());
		}
		*/
		
		//Functii medic
		//1. Adauga pacient
		/*
		Pacient pacient = new Pacient();
		pacient.setAngajat(cont.getAngajat());
		pacient.setCNP("1234322343");
		pacient.setNume("Dumitrescu");
		pacient.setPrenume("Mihai");	
		System.out.println(medic.addPacient(cont, pacient));
		*/
		
		//Modificare pacient
		/*
		Pacient pacient = new Pacient();
		pacient = medic.getPacient(cont, 1);
		pacient.setNume("Danescu");
		medic.updatePacient(cont, pacient);
		*/
		
		//Medic 3. Lista Preturi interventii stomatologice curente
		/*
		ArrayList<Pret> listaPreturiCurente = medic.listaPreturiCurente(cont);
		for(int i = 0; i < listaPreturiCurente.size(); i++) {
			System.out.println(listaPreturiCurente.get(i).getTipInterventie().getDenumire() + " " + listaPreturiCurente.get(i).getPret() + " " + listaPreturiCurente.get(i).getDataInceput());
		}
		 */
		
		
			
	}
}
