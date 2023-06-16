public class ConectandoDriver {
    public static void conectarDriver(){
        try{
            System.out.println("Carregando driver JDBC...");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver carregado!");
        }catch(Exception e){
            System.out.printf("Falha no carregamento! %c", e);
        }
    }
}
