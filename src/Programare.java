import java.util.Date;

public class Programare {
	private int IdProgramare;
	private Angajat Angajat;
	private Pacient Pacient;
	private Date Data;
	
	public Programare() {
		super();
		this.IdProgramare = -1;
		this.Angajat = new Angajat();
		this.Pacient = new Pacient();
		this.Data = new Date();
	}
	
	public Programare(int IdProgramare, Angajat Angajat, Pacient Pacient, Date Data) {
		super();
		this.IdProgramare = IdProgramare;
		this.Angajat = Angajat;
		this.Pacient = Pacient;
		this.Data = Data;
	}

	public int getIdProgramare() {
		return IdProgramare;
	}

	public void setIdProgramare(int idProgramare) {
		IdProgramare = idProgramare;
	}

	public Angajat getAngajat() {
		return Angajat;
	}

	public void setAngajat(Angajat angajat) {
		Angajat = angajat;
	}

	public Pacient getPacient() {
		return Pacient;
	}

	public void setPacient(Pacient pacient) {
		Pacient = pacient;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}
}
