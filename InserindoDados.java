import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InserindoDados{
    public static void inserir(int numeroproduto, String nomeproduto, double valorproduto){
        String SQLinserirDados = "INSERT INTO produto(numeroproduto, nomeproduto, valorproduto) VALUES(" + numeroproduto + ", '" + nomeproduto + "', " + valorproduto + ")";
        String driver = "jdbc:postgresql://127.0.0.1:5432/SistemaLogistica";
        Statement st = null;
        try(Connection conn = DriverManager.getConnection(driver, "postgres", "08072003")){
            if(conn == null){
                System.out.println("Failed to make connection");
            }
            System.out.println("Inserindo dados na Tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLinserirDados);
            System.out.println("Dados inseridos!");
            st.close();
            conn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
