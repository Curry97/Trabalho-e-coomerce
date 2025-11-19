import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 6) {
            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {

                case 1:
                    System.out.println("Digite seu nome:");
                    String nome = scanner.nextLine();

                    System.out.println("Digite seu email:");
                    String email = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, email);
                    Cliente.adicionarCliente(cliente);

                    cliente.exibirCliente();
                    break;

                case 2:
                    System.out.println("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.println("Digite o preço do produto: ");
                    double valor = Double.parseDouble(scanner.nextLine());

                    System.out.println("Estoque do produto: ");
                    int quantidadeEstoque = Integer.parseInt(scanner.nextLine());

                    Produto p = new Produto(nomeProduto, valor, quantidadeEstoque);
                    Produto.adicionarProduto(p);

                    System.out.println("Produto cadastrado!");
                    break;

                case 3:
                    List<Produto> produtos = Produto.listarTodos();

                    if (produtos.isEmpty()) {
                        System.out.println("Produto não cadastrado.");
                    } else {
                        produtos.forEach(pr -> pr.exibirProduto());
                    }
                    break;

                case 4:
                    List<Cliente> listaDeClientes = Cliente.listarTodos();
                    listaDeClientes.forEach(c -> c.exibirCliente());
                    break;

                case 5:
                    System.out.println("Digite o ID do cliente: ");
                    int idCliente = Integer.parseInt(scanner.nextLine());

                    Cliente c = Cliente.buscarClientePorId(idCliente);

                    if (c == null) {
                        System.out.println("Cliente não encontrado!");
                        break;
                    }

                    fazerPedido pedido = new fazerPedido(c);

                    while (true) {
                        System.out.println("Digite o ID do produto para adicionar (ou 0 para finalizar compra): ");
                        int idProduto = Integer.parseInt(scanner.nextLine());

                        if (idProduto == 0) {
                            break;
                        }

                        Produto prod = Produto.buscarProdutoPorId(idProduto);

                        if (prod == null) {
                            System.out.println("Produto não encontrado!");
                        } else if (prod.getQuantidadeEstoque() <= 0) {
                            System.out.println("Sem estoque!");
                        } else {

                            // Remove do estoque
                            prod.setQuantidadeEstoque(prod.getQuantidadeEstoque() - 1);

                            // Adiciona ao pedido
                            pedido.adicionarProduto(prod);

                            System.out.println("Produto adicionado!");
                        }
                    }

                    System.out.println("Pedido finalizado:");
                    pedido.exibirPedido();
                    break;

                case 6:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void exibirMenu()
    {
        System.out.println("--- Sistema de E-commerce ---");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Cadastrar Produto");
        System.out.println("3. Exibir Produtos");
        System.out.println("4. Exibir Clientes");
        System.out.println("5. Fazer Pedido");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner)
    {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
