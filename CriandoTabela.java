import java.sql.*;
public class CriandoTabela{
    public static void criarTabela(){
        String SQLcriarTabela = "CREATE TABLE produto(id SERIAL PRIMARY KEY, numeroproduto INT, nomeproduto VARCHAR(60), valorproduto REAL)";
        String driver = "jdbc:postgresql://127.0.0.1:5432/SistemaLogistica";
        Statement st = null;
        try(Connection conn = DriverManager.getConnection(driver, "postgres", "08072003")){
            if(conn == null){
                System.out.println("Failed to make connection");
            }
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet result = metaData.getTables(null, null, "produto", null);
            if(!(result.next())){
                System.out.println("Criando tabela, aguarde...");
                st = conn.createStatement();
                st.executeUpdate(SQLcriarTabela);
                System.out.println("Tabela criada c/ sucesso!");
                st.close();
            }
            result.close();
            conn.close();
        }catch(SQLException e){
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }
}
