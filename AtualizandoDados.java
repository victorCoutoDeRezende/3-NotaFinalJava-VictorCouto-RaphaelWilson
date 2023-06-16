import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
public class AtualizandoDados{
    public static void atualizar(int escolha, String antigo, String novo){
        String SQLatualizarDados = "";
        switch(escolha){
            case 1:
                SQLatualizarDados = "update produto set numeroproduto = " + parseInt(novo) + " where numeroproduto = " + parseInt(antigo) + "";
                break;
            case 2:
                SQLatualizarDados = "update produto set nomeproduto = '" + novo + "' where nomeproduto = '" + antigo + "'";
                break;
            case 3:
                SQLatualizarDados = "update produto set valorproduto = " + parseDouble(novo) + " where valorproduto = " + parseDouble(antigo) + "";
                break;
            default:
                System.out.println("Digite uma opção válida!");
        }
        String driver = "jdbc:postgresql://127.0.0.1:5432/SistemaLogistica";
        Statement st = null;
        try(Connection conn = DriverManager.getConnection(driver, "postgres", "08072003")){
            if(conn == null){
                System.out.println("Failed to make connection");
            }
            System.out.println("Atualizando dados na Tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLatualizarDados);
            System.out.println("Dados atualizados!");
            st.close();
            conn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
