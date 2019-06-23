import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

public class ManagementDB implements IManagementDBAutentificare {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONN = "jdbc:mysql://localhost:3306/bazadedateclinicadentara?useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	//Sectiune conturi
	@Override
	public Cont VerificaExistentaUtilizator(String NumeUtilizator, String Parola) throws SQLException{
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM cont INNER JOIN rol ON cont.IdRol = rol.IdRol INNER JOIN angajat ON cont.IdAngajat = angajat.IdAngajat WHERE (NumeUtilizator='"+ NumeUtilizator +"' AND Parola='"+ Parola +"') AND cont.sters != 1");
	        Cont utilizator = new Cont();
	    	Rol rol = new Rol();
	    	Angajat angajat = new Angajat();
	        while (srs.next()) {     
	            utilizator.setIdCont(srs.getInt("IdCont"));      
	            utilizator.setNumeUtilizator(srs.getString("NumeUtilizator"));
	            utilizator.setParola(srs.getString("Parola"));
	            rol.setDenumire(srs.getString("Denumire"));
	            rol.setIdRol(srs.getInt("IdRol"));
	            angajat.setIdAngajat(srs.getInt("IdAngajat"));
	            angajat.setNume(srs.getString("Nume"));
	            angajat.setPrenume(srs.getString("Prenume"));
	            angajat.setCNP(srs.getString("CNP"));        
	        }
	        utilizator.setRol(rol);
	        utilizator.setAngajat(angajat);
	        return utilizator;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	//Sectiune operatii adiminstrator
	//CRUD Medici
	public void addMedic(Angajat angajat) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("INSERT INTO angajat ( Nume, Prenume, CNP) VALUES ('"+ angajat.getNume() +"','"+ angajat.getPrenume() +"','"+ angajat.getCNP() + "')");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void updateMedic(Angajat angajat) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("UPDATE angajat SET Nume = '"+ angajat.getNume() + "', Prenume = '"+ angajat.getPrenume() +"', CNP = '"+ angajat.getCNP() + "' WHERE IdAngajat = '"+ angajat.getIdAngajat() + "'");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void deleteMedic(int IdMedic) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("UPDATE angajat SET Sters = '1' WHERE IdAngajat = '"+ IdMedic + "'");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public Angajat GetMedicDupaId(int IdMedic) throws SQLException{
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM angajat WHERE IdAngajat='"+ IdMedic +"' AND sters != 1");
	    	Angajat angajat = new Angajat();
	        while (srs.next()) {                 
	            angajat.setIdAngajat(srs.getInt("IdAngajat"));
	            angajat.setNume(srs.getString("Nume"));
	            angajat.setPrenume(srs.getString("Prenume"));
	            angajat.setCNP(srs.getString("CNP"));        
	        }	        
	        return angajat;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public ArrayList<Angajat> GetAllAngajati() throws SQLException{
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM angajat WHERE sters != 1");
	    	ArrayList<Angajat> listaAngajati = new ArrayList<Angajat>();
	        while (srs.next()) {   
	        	Angajat angajat = new Angajat();
	            angajat.setIdAngajat(srs.getInt("IdAngajat"));
	            angajat.setNume(srs.getString("Nume"));
	            angajat.setPrenume(srs.getString("Prenume"));
	            angajat.setCNP(srs.getString("CNP"));     
	            listaAngajati.add(angajat);
	        }	        
	        return listaAngajati;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	//Rol
	public Rol GetRolDupaId(int IdRol) throws SQLException{
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM rol WHERE IdRol='"+ IdRol +"'");
	    	Rol rol = new Rol();
	        while (srs.next()) {                 
	        	rol.setIdRol(srs.getInt("IdRol"));
	        	rol.setDenumire(srs.getString("Denumire"));       
	        }	        
	        return rol;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	//CRUD Conturi
	public void AddContAngajat(Cont cont) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("INSERT INTO cont ( IdAngajat, IdRol, NumeUtilizator, Parola) VALUES ('"+ cont.getAngajat().getIdAngajat() +"','"+ cont.getRol().getIdRol() +"','"+ cont.getNumeUtilizator() + "','"+ cont.getParola() + "')");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void deleteCont(int IdCont) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("UPDATE cont SET Sters = '1' WHERE IdCont = '"+ IdCont + "'");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void deleteContDupaIdAngajat(int IdAngajat) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("UPDATE cont SET Sters = '1' WHERE IdAngajat = '"+ IdAngajat + "'");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	//Salariu medici
	public ArrayList<Salariu> GetSalariuMedicUltimulAn(int IdMedic) throws SQLException{
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM salariu WHERE IdAngajat='"+ IdMedic +"' AND YEAR(Data) = '"+ Year.now() + "' ORDER BY Data");
	        ArrayList<Salariu> listaSalariu = new ArrayList<Salariu>();
	        while (srs.next()) {     
	        	Salariu salariu = new Salariu();
	        	salariu.setIdSalariu(srs.getInt("IdSalariu"));
	        	salariu.setData(srs.getDate("Data"));
	        	salariu.setValoare(srs.getFloat("Valoare"));  
	        	listaSalariu.add(salariu);
	        }	        
	        return listaSalariu;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	//Preturi interventii dupa o anumita perioada si perioada de valabilitate a acelor preturi
	public ArrayList<Pret> PreturiMaiVechiPentruInterventieSpecifica(int IdTipInterventie, String DataMinima) throws SQLException{
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM preturi WHERE IdTipInterventie='"+ IdTipInterventie +"' AND CAST(DataInceput AS Datetime) < '"+ DataMinima +"'");
	    	ArrayList<Pret> listaPreturi = new ArrayList<Pret>();
	        while (srs.next()) {                 
	        	Pret pret = new Pret();
	        	pret.setIdPret(srs.getInt("IdPret"));
	        	pret.setPret(srs.getFloat("Pret")); 
	        	pret.setDataInceput(srs.getDate("DataInceput"));
	        	pret.setDataSfarsit(srs.getDate("DataSfarsit"));
	        	listaPreturi.add(pret);
	        }	        
	        return listaPreturi;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	//Pacienti
	public Boolean existaPacientDupaCNP(String CNP) throws SQLException {
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM pacient WHERE CNP = '"+ CNP +"'");
	        Pacient pacient = new Pacient();
	        while (srs.next()) {     
	        	pacient.setIdPacient(srs.getInt("IdPacient"));
	        	pacient.setNume(srs.getString("Nume"));
	        	pacient.setPrenume(srs.getString("Prenume"));
		        pacient.setCNP(srs.getString("CNP"));
	        }	 
	        if(pacient.getIdPacient() > 0) {
	        	return true;
	        }else {
	        	return false;
	        }	     
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void addPacient(Pacient pacient) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("INSERT INTO pacient ( IdAngajat, Nume, Prenume, CNP) VALUES ('"+ pacient.getAngajat().getIdAngajat() +"', '"+ pacient.getNume() +"','"+ pacient.getPrenume() +"','"+ pacient.getCNP() + "')");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void updatePacient(Pacient pacient) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("UPDATE pacient SET Nume = '"+ pacient.getNume() + "', Prenume = '"+ pacient.getPrenume() +"', CNP = '"+ pacient.getCNP() + "' WHERE IdPacient = '"+ pacient.getIdPacient() + "'");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public void deletePacient(int IdPacient) throws SQLException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			
			PreparedStatement posted = con.prepareStatement("UPDATE pacient SET Sters = '1' WHERE IdPacient = '"+ IdPacient + "'");
			posted.executeUpdate();
						
		}catch(SQLException e) {
			System.err.print(e);
		}
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
	
	public Pacient getPacient(int IdPacient) throws SQLException {
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM pacient WHERE IdPacient = '"+ IdPacient +"'");
	        Pacient pacient = new Pacient();
	        while (srs.next()) {     
	        	pacient.setIdPacient(srs.getInt("IdPacient"));
	        	pacient.setNume(srs.getString("Nume"));
	        	pacient.setPrenume(srs.getString("Prenume"));
		        pacient.setCNP(srs.getString("CNP"));
	        }	     
	        return pacient;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
	}
		
	//Preturi pentru toate tipurile de interventii
	public ArrayList<Pret> getPretTipInterventii() throws SQLException {
		Connection con = null;
		try {			
			con = DriverManager.getConnection(CONN,USERNAME,PASSWORD);	
			java.sql.Statement st =  con.createStatement();
	        ResultSet srs = ((java.sql.Statement) st).executeQuery("SELECT * FROM preturi INNER JOIN tipinterventie ON preturi.IdTipInterventie = tipinterventie.IdTipInterventie WHERE DataSfarsit IS NULL");
	        ArrayList<Pret> listaPreturi = new ArrayList<Pret>();
	        while (srs.next()) {
	        	Pret pret = new Pret();
	        	pret.setIdPret(srs.getInt("IdPret"));
	        	pret.setDataInceput(srs.getDate("DataInceput"));
	        	pret.setPret(srs.getFloat("Pret"));
	        	TipInterventie tipInterventie = new TipInterventie();
	        	tipInterventie.setDenumire(srs.getString("Denumire"));
	        	tipInterventie.setIdTipInterventie(srs.getInt("IdTipInterventie"));
	        	pret.setTipInterventie(tipInterventie);
	        	listaPreturi.add(pret);
	        }	          
	        return listaPreturi;
		}catch(SQLException e) {
			System.err.print(e);
			return null;			
		} 
		finally {
			if(con != null) {
				con.close();
			}
		}
		
	}
	
	
	
	public void addTipInterventie(TipInterventie TipInterventie, Pret Pret) {
		
		
	}
}
