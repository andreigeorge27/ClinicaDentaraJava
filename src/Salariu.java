import java.util.Date;

public class Salariu {
	private int IdSalariu;
	private Angajat Angajat;
	private Date Data;
	private float Valoare;
	
	public Salariu() {
		super();
		this.IdSalariu = -1;
		this.Angajat = new Angajat();
		this.Data = new Date();
		this.Valoare = 0;
	}
	
	public Salariu(int IdSalariu, Angajat Angajat, Date Data, float Valoare) {
		super();
		this.IdSalariu = IdSalariu;
		this.Angajat = Angajat;
		this.Data = Data;
		this.Valoare = Valoare;
	}

	public int getIdSalariu() {
		return IdSalariu;
	}

	public void setIdSalariu(int idSalariu) {
		IdSalariu = idSalariu;
	}

	public Angajat getAngajat() {
		return Angajat;
	}

	public void setAngajat(Angajat angajat) {
		Angajat = angajat;
	}

	public Date getData() {
		return Data;
	}

	public void setData(Date data) {
		Data = data;
	}

	public float getValoare() {
		return Valoare;
	}

	public void setValoare(float valoare) {
		Valoare = valoare;
	}
}
