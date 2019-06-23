import java.sql.SQLException;

public interface IManagementDBAutentificare {
	public Cont VerificaExistentaUtilizator(String NumeUtilizator, String Parola) throws SQLException;
}
