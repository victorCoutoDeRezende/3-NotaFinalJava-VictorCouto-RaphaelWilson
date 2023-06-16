import  java.util.Scanner;
public class Main{
    public static Scanner ler = new Scanner(System.in);
    public static void cadastro(){
        System.out.println("---------------   Sistema de Logística   ---------------");
        System.out.println("[1]Registrar um Produto\n[2]Consultar um Produto\n[3]Atualizar um Produto\n[4]Deletar um Produto\n[5]Sair");
        int escolha = ler.nextInt();
        switch(escolha){
            case 1:
                registrarProduto();
                cadastro();
                break;
            case 2:
                consultarProduto();
                cadastro();
                break;
            case 3:
                atualizarProduto();
                cadastro();
                break;
            case 4:
                excluirProduto();
                cadastro();
                break;
            case 5:
                break;
            default:
                System.out.println("Digite uma opção válida!");
                break;
        }
    }
    public static void registrarProduto(){
        InserindoDados insersao = new InserindoDados();
        System.out.println("Digite o número do produto: ");
        int numero = ler.nextInt();
        System.out.println("Digite o nome do produto: ");
        String nome = ler.next();
        System.out.println("Digite o valor do produto");
        double valor = ler.nextDouble();
        insersao.inserir(numero, nome, valor);
    }
    public static void consultarProduto(){
        ConsultandoDados consultas = new ConsultandoDados();
        System.out.println("--------------Escolha o método de consulta--------------");
        System.out.println("[1]Consultar por ID\n" +
                "[2]Consultar por Número\n" +
                "[3]Consultar por Nome\n" +
                "[4]Consultar por Valor\n" +
                "[5]Listar produtos com valor acima de R$100,00\n" +
                "[6]Listar todos os produtos");
        int escolhaConsulta = ler.nextInt();
        switch(escolhaConsulta){
            case 1:
                System.out.println("Digite o ID do produto: ");
                int id = ler.nextInt();
                consultas.consultar(1, String.valueOf(id));
                break;
            case 2:
                System.out.println("Digite o número do produto: ");
                int numero = ler.nextInt();
                consultas.consultar(2, String.valueOf(numero));
                break;
            case 3:
                System.out.println("Digite o nome do produto: ");
                String nome = ler.next();
                consultas.consultar(3, nome);
                break;
            case 4:
                System.out.println("Digite o valor do produto: ");
                double valor = ler.nextDouble();
                consultas.consultar(4, String.valueOf(valor));
                break;
            case 5:
                consultas.consultar(5, null);
                break;
            case 6:
                consultas.consultar(6, null);
                break;
            default:
                System.out.println("Digite uma opção válida!");
                break;
        }
    }
    public static void atualizarProduto(){
        AtualizandoDados atualizacao = new AtualizandoDados();
        System.out.println("--------------Escolha o que deseja Atualizar--------------");
        System.out.println("[1]Atualizar Número\n[2]Atualizar Nome\n[3]Atualizar Valor");
        int escolhaAtualização = ler.nextInt();
        switch(escolhaAtualização){
            case 1:
                System.out.println("Digite o produto que desejas alterar o Número: ");
                int numero_antigo = ler.nextInt();
                System.out.println("Digite o novo número do produto: ");
                int numero_novo = ler.nextInt();
                atualizacao.atualizar(1, String.valueOf(numero_antigo), String.valueOf(numero_novo));
                break;
            case 2:
                System.out.println("Digite o produto que desejas alterar o Nome: ");
                String nome_antigo = ler.next();
                System.out.println("Digite o novo nome do produto: ");
                String nome_novo = ler.next();
                atualizacao.atualizar(2, nome_antigo, nome_novo);
                break;
            case 3:
                System.out.println("Digite o produto que desejas alterar o Valor: ");
                double valor_antigo = ler.nextDouble();
                System.out.println("Digite o novo valor do produto: ");
                double valor_novo = ler.nextDouble();
                atualizacao.atualizar(3, String.valueOf(valor_antigo), String.valueOf(valor_novo));
                break;
            default:
                System.out.println("Digite uma opção válida!");
                break;
        }
    }
    public static void excluirProduto(){
        ExcluindoDados exclusao = new ExcluindoDados();
        System.out.println("--------------Escolha o método de exclusão--------------");
        System.out.println("[1]Excluir por ID\n[2]Excluir por Número\n[3]Excluir por Nome\n[4]Excluir por Valor\n[5]Excluir Tudo(CUIDADO!!!)");
        int escolhaExclusao = ler.nextInt();
        switch(escolhaExclusao){
            case 1:
                System.out.println("Digite o ID do produto a ser excluído: ");
                int id_exclusao = ler.nextInt();
                exclusao.excluir(1, String.valueOf(id_exclusao));
                break;
            case 2:
                System.out.println("Digite o número do produto a ser excluído: ");
                int numero_exclusao = ler.nextInt();
                exclusao.excluir(2, String.valueOf(numero_exclusao));
                break;
            case 3:
                System.out.println("Digite o nome do produto a ser excluído: ");
                String nome_exclusao = ler.next();
                exclusao.excluir(3, nome_exclusao);
                break;
            case 4:
                System.out.println("Digite o valor do produto a ser excluído: ");
                double valor_exclusao = ler.nextDouble();
                exclusao.excluir(4, String.valueOf(valor_exclusao));
                break;
            case 5:
                exclusao.excluir(5, null);
                break;
            default:
                System.out.println("Digite uma opção válida!");
                break;
        }
    }

    public static void main(String[] args){
        ConectandoDriver conexaoDriver = new ConectandoDriver();
        ConectandoBD criacaoBanco = new ConectandoBD();
        CriandoTabela criacaoTabela = new CriandoTabela();

        conexaoDriver.conectarDriver();
        criacaoBanco.conectarBD();
        criacaoTabela.criarTabela();

        cadastro();
    }
}
