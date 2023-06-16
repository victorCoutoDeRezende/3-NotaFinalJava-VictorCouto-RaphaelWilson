import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
public class ExcluindoDados {
    public static void excluir(int escolha, String parametro){
        String SQLexcluirDados = "";
        switch(escolha){
            case 1:
                SQLexcluirDados = "DELETE from produto where id = " + parseInt(parametro) + "";
                break;
            case 2:
                SQLexcluirDados = "DELETE from produto where numeroproduto = " + parseInt(parametro) + "";
                break;
            case 3:
                SQLexcluirDados = "DELETE from produto where nomeproduto = '" + parametro + "'";
                break;
            case 4:
                SQLexcluirDados = "DELETE from produto where valorproduto = " + parseDouble(parametro) + "";
                break;
            case 5:
                SQLexcluirDados = "DELETE from produto";
            default:
                System.out.println("Digite uma opção válida!");
        }
        String driver = "jdbc:postgresql://127.0.0.1:5432/SistemaLogistica";
        Statement st = null;
        try(Connection conn = DriverManager.getConnection(driver, "postgres", "08072003")){
            if(conn == null){
                System.out.println("Failed to make connection");
            }
            System.out.println("Excluindo dados na Tabela...");
            st = conn.createStatement();
            st.executeUpdate(SQLexcluirDados);
            System.out.println("Dados Excluídos!");
            st.close();
            conn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
