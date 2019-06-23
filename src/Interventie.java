import java.util.Date;

public class Interventie {
	private int IdInterventie;
	private Angajat Medic;
	private TipInterventie TipInterventie;
	private Pacient Pacient;
	private Date DataInterventie;
	private Pret PretInterventie;
	
	public Interventie() {
		super();
		this.IdInterventie = -1;
		this.Medic = new Angajat();
		this.TipInterventie = new TipInterventie();
		this.Pacient = new Pacient();
		this.DataInterventie = new Date();
		this.PretInterventie = new Pret();
	}
	
	public Interventie(int IdInterventie, Angajat Medic, TipInterventie TipInterventie, Pacient Pacient, Date DataInterventie, Pret PretInterventie) {
		super();
		this.IdInterventie = IdInterventie;
		this.Medic = Medic;
		this.TipInterventie = TipInterventie;
		this.Pacient = Pacient;
		this.DataInterventie = DataInterventie;
		this.PretInterventie = PretInterventie;
	}

	public int getIdInterventie() {
		return IdInterventie;
	}

	public void setIdInterventie(int idInterventie) {
		IdInterventie = idInterventie;
	}

	public Angajat getMedic() {
		return Medic;
	}

	public void setMedic(Angajat medic) {
		Medic = medic;
	}

	public TipInterventie getTipInterventie() {
		return TipInterventie;
	}

	public void setTipInterventie(TipInterventie tipInterventie) {
		TipInterventie = tipInterventie;
	}

	public Pacient getPacient() {
		return Pacient;
	}

	public void setPacient(Pacient pacient) {
		Pacient = pacient;
	}

	public Date getDataInterventie() {
		return DataInterventie;
	}

	public void setDataInterventie(Date dataInterventie) {
		DataInterventie = dataInterventie;
	}

	public Pret getPretInterventie() {
		return PretInterventie;
	}

	public void setPretInterventie(Pret pretInterventie) {
		PretInterventie = pretInterventie;
	}
}
