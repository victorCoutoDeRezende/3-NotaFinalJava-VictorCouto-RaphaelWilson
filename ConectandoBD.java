import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConectandoBD {
    public static void conectarBD(){
        String driver = "jdbc:postgresql://127.0.0.1:5432/SistemaLogistica";
        try(Connection conn = DriverManager.getConnection(driver, "postgres", "08072003")){
            if(conn == null){
                System.out.println("A conexão falhou");
            }
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
