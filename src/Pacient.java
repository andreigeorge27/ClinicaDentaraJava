
public class Pacient {
	private int IdPacient;
	private Angajat Angajat;
	private String Nume;
	private String Prenume;
	private String CNP;
	
	public Pacient() {
		super();
		this.IdPacient = -1;
		this.Angajat = new Angajat();
		this.Nume = "";
		this.Prenume = "";
		this.CNP = "";
	}
	
	public Pacient(int IdPacient, Angajat Angajat, String Nume, String Prenume, String CNP) {
		super();
		this.IdPacient = IdPacient;
		this.Angajat = Angajat;
		this.Nume = Nume;
		this.Prenume = Prenume;
		this.CNP = CNP;
	}

	public int getIdPacient() {
		return IdPacient;
	}

	public void setIdPacient(int idPacient) {
		IdPacient = idPacient;
	}

	public Angajat getAngajat() {
		return Angajat;
	}

	public void setAngajat(Angajat angajat) {
		Angajat = angajat;
	}

	public String getNume() {
		return Nume;
	}

	public void setNume(String nume) {
		Nume = nume;
	}

	public String getPrenume() {
		return Prenume;
	}

	public void setPrenume(String prenume) {
		Prenume = prenume;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}
}
