
public class Angajat {
	private int IdAngajat;
	private String Nume;
	private String Prenume;
	private String CNP;
	
	public Angajat() {
		super();
		this.IdAngajat = -1;
		this.Nume = "";
		this.Prenume = "";
		this.CNP = "";
	}
	
	public Angajat(int IdAngajat, String Nume, String Prenume, String CNP) {
		super();
		this.IdAngajat = IdAngajat;
		this.Nume = Nume;
		this.Prenume = Prenume;
		this.CNP = CNP;
	}

	public int getIdAngajat() {
		return IdAngajat;
	}

	public void setIdAngajat(int idAngajat) {
		IdAngajat = idAngajat;
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
