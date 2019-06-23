
public class TipInterventie {
	private int IdTipInterventie;
	private String Denumire;

	public TipInterventie() {
		super();
		this.IdTipInterventie = -1;
		this.Denumire = "";
	}
	
	public TipInterventie(int IdTipInterventie, String Denumire) {
		super();
		this.IdTipInterventie = IdTipInterventie;
		this.Denumire = Denumire;
	}

	public int getIdTipInterventie() {
		return IdTipInterventie;
	}

	public void setIdTipInterventie(int idTipInterventie) {
		IdTipInterventie = idTipInterventie;
	}

	public String getDenumire() {
		return Denumire;
	}

	public void setDenumire(String denumire) {
		Denumire = denumire;
	}	
}
