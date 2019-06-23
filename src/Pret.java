import java.util.Date;

public class Pret {
	private int IdPret;
	private Date DataInceput;
	private Date DataSfarsit;
	private TipInterventie TipInterventie;
	private float Pret;
	
	public Pret() {
		super();
		this.IdPret = -1;
		this.DataInceput = new Date();
		this.DataSfarsit = new Date();
		this.TipInterventie = new TipInterventie();
		this.Pret = 0;
	}
	
	public Pret(int IdPret, Date DataInceput,Date DataSfarsit, TipInterventie TipInterventie, float Pret) {
		super();
		this.IdPret = IdPret;
		this.DataInceput = DataInceput;
		this.DataSfarsit = DataSfarsit;
		this.TipInterventie = TipInterventie;
		this.Pret = Pret;
	}

	public int getIdPret() {
		return IdPret;
	}

	public void setIdPret(int idPret) {
		IdPret = idPret;
	}

	public Date getDataInceput() {
		return DataInceput;
	}

	public void setDataInceput(Date dataInceput) {
		DataInceput = dataInceput;
	}

	public Date getDataSfarsit() {
		return DataSfarsit;
	}

	public void setDataSfarsit(Date dataSfarsit) {
		DataSfarsit = dataSfarsit;
	}

	public TipInterventie getTipInterventie() {
		return TipInterventie;
	}

	public void setTipInterventie(TipInterventie tipInterventie) {
		TipInterventie = tipInterventie;
	}

	public float getPret() {
		return Pret;
	}

	public void setPret(float pret) {
		Pret = pret;
	}
}
