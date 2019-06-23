import java.sql.SQLException;
import java.util.ArrayList;

public class Medic {
	private static ManagementDB db = new ManagementDB();
	
	public Boolean addPacient(Cont utilizator, Pacient pacient) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Medic")) {
			Angajat medic = new Angajat();
			medic.setIdAngajat(utilizator.getAngajat().getIdAngajat());
			medic.setCNP(utilizator.getAngajat().getCNP());
			medic.setNume(utilizator.getAngajat().getNume());
			medic.setPrenume(utilizator.getAngajat().getPrenume());
			pacient.setAngajat(medic);
			if(!db.existaPacientDupaCNP(pacient.getCNP())) {
				db.addPacient(pacient);	
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public Boolean updatePacient(Cont utilizator, Pacient pacient) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Medic")) {
			db.updatePacient(pacient);
			return true;
		}
		else {
			return false;
		}
	}
	
	public Pacient getPacient(Cont utilizator, int IdPacient) throws SQLException {
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Medic")) {
			return db.getPacient(IdPacient);
		}
		else {
			return null;
		}
	}
	
	//Afisarea lista preturi curente
	public ArrayList<Pret> listaPreturiCurente(Cont utilizator) throws SQLException{
		if(utilizator.getRol().getDenumire().equalsIgnoreCase("Medic")) {
			return db.getPretTipInterventii();
		}
		return null;
	}
}
