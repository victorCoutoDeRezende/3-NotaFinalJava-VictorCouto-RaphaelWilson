import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
public class ConsultandoDados{
    public static void consultar(int escolha, String parametro){
        String SQLconsultarDados = "";
        switch(escolha){
            case 1:
                SQLconsultarDados = "SELECT * from produto where id = " + parseInt(parametro) + "";
                break;
            case 2:
                SQLconsultarDados = "SELECT * from produto where numeroproduto = " + parseInt(parametro) + "";
                break;
            case 3:
                SQLconsultarDados = "SELECT * from produto where nomeproduto = '" + parametro + "'";
                break;
            case 4:
                SQLconsultarDados = "SELECT * from produto where valorproduto = " + parseDouble(parametro) + "";
                break;
            case 5:
                SQLconsultarDados = "SELECT * from produto where valorproduto >= 100";
                break;
            case 6:
                SQLconsultarDados = "SELECT * from produto";
                break;
            default:
                System.out.println("Digite uma opção válida!");
                break;
        }
        String driver = "jdbc:postgresql://127.0.0.1:5432/SistemaLogistica";
        Statement st = null;
        ResultSet result;
        try(Connection conn = DriverManager.getConnection(driver, "postgres", "08072003")){
            if(conn == null){
                System.out.println("Failed to make connection");
            }
            System.out.println("Consultando dados na Tabela...");
            st = conn.createStatement();
            result = st.executeQuery(SQLconsultarDados);
            while(result.next()){
                System.out.println("-------------------------");
                System.out.println("ID: " + result.getString(1));
                System.out.println("Numero do Produto: " + result.getString(2));
                System.out.println("Nome: " + result.getString(3));
                System.out.println("Valor: " + result.getString(4));
            }
            result.close();
            st.close();
            conn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
