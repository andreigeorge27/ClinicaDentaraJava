
public class Cont {
	private int IdCont;
	private Angajat Angajat;
	private Rol rol;
	private String NumeUtilizator;
	private String Parola;
	
	public Cont() {
		super();
		this.IdCont = -1;
		this.Angajat = new Angajat();
		this.rol = new Rol();
		this.NumeUtilizator = "";
		this.Parola = "";
	}
	
	public Cont(int IdCont, Angajat Angajat, Rol rol, String NumeUtilizator, String Parola) {
		super();
		this.IdCont = IdCont;
		this.Angajat = Angajat;
		this.rol = rol;
		this.NumeUtilizator = NumeUtilizator;
		this.Parola = Parola;
	}
	
	public int getIdCont() {
		return IdCont;
	}
	
	public void setIdCont(int idCont) {
		IdCont = idCont;
	}
	
	public Angajat getAngajat() {
		return Angajat;
	}
	
	public void setAngajat(Angajat Angajat) {
		this.Angajat = Angajat;
	}
	
	public Rol getRol() {
		return rol;
	}
	
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public String getNumeUtilizator() {
		return NumeUtilizator;
	}
	
	public void setNumeUtilizator(String numeUtilizator) {
		NumeUtilizator = numeUtilizator;
	}
	
	public String getParola() {
		return Parola;
	}
	
	public void setParola(String parola) {
		Parola = parola;
	}
}
