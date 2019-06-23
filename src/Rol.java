
public class Rol {
	private int IdRol;
	private String Denumire;
	
	public Rol() {
		super();
		this.IdRol = -1;
		this.Denumire = "";
	}
	
	public Rol(int IdRol, String Denumire) {
		super();
		this.IdRol = IdRol;
		this.Denumire = Denumire;
	}
	
	public int getIdRol() {
		return IdRol;
	}
	
	public void setIdRol(int IdRol) {
		this.IdRol = IdRol;
	}
	
	public String getDenumire() {
		return Denumire;
	}
	
	public void setDenumire(String Denumire) {
		this.Denumire = Denumire;
	}
}
