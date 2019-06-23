import java.sql.SQLException;
import java.util.ArrayList;

public class Administrator  {
	private static ManagementDB db = new ManagementDB();
	
	//Sectiune CRUD Medic
	public Boolean AddMedic(Cont utilizator, Angajat Medic) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {
			db.addMedic(Medic);	
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean UpdateMedic(Cont utilizator, Angajat Medic) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {
			db.updateMedic(Medic);	
			return true;
		}else {
			return false;
		}
	}
	
	public Boolean DeleteMedic(Cont utilizator, int IdMedic) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {
			db.deleteMedic(IdMedic);
			DeleteContDupaIdAngajat(utilizator, IdMedic);
			return true;
		}else {
			return false;
		}
	}
	
	public Angajat GetMedicDupaId(Cont utilizator, int IdMedic) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {			
			return db.GetMedicDupaId(IdMedic);	
		}else {
			return null;
		}
	}
	
	public ArrayList<Angajat> GetAllAngajati(Cont utilizator) throws SQLException{
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {			
			return db.GetAllAngajati();	
		}else {
			return null;
		}
	}
	
	//Salariu pentru un anumit medic pe anul curent
	public ArrayList<Salariu> SalariileMedicUltimulAn(Cont utilizator, int IdMedic) throws SQLException{
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {			
			return db.GetSalariuMedicUltimulAn(IdMedic);	
		}else {
			return null;
		}		
	}
	
	//
	public Boolean AddTipInterventie(Cont utilizator, TipInterventie TipInterventie, Pret Pret) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {
			db.addTipInterventie(TipInterventie, Pret);	
			return true;
		}else {
			return false;
		}
	}
	
	//CRUD Cont angajat
	public Boolean AddContAngajat(Cont utilizator, Cont contNou) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {	
			db.AddContAngajat(contNou);
			return true;
		}else {
			return null;
		}	
	}
	
	public Boolean DeleteContAngajat(Cont utilizator, int IdCont) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {	
			db.deleteCont(IdCont);
			return true;
		}else {
			return null;
		}	
	}
	
	public Boolean DeleteContDupaIdAngajat(Cont utilizator, int IdAngajat) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {	
			db.deleteContDupaIdAngajat(IdAngajat);
			return true;
		}else {
			return null;
		}	
	}
	
	//Obtinere rolu dupa id din baza de date
	public Rol GetRolDupaId(Cont utilizator, int IdRol) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {		
			return db.GetRolDupaId(IdRol);
		}else {
			return null;
		}
	}
	
	//Afisare preturi mai vechi pentru o interventie specifica
	public ArrayList<Pret> PreturiMaiVechiPentruInterventieSpecifica(Cont utilizator, int IdTipInterventie, String DataMinima) throws SQLException{
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Administrator")) {		
			return db.PreturiMaiVechiPentruInterventieSpecifica(IdTipInterventie, DataMinima);
		}else {
			return null;
		}
	}
	
}
