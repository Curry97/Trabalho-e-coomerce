import java.util.ArrayList;
import java.util.List;

public class fazerPedido {

    private int id;
    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    private static List<fazerPedido> listaPedidos = new ArrayList<>();
    private static int contador = 1;

    public fazerPedido(Cliente cliente)
    {
        this.id = contador;
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.total = 0;
        contador++;
        listaPedidos.add(this);
    }

    public int getId()
    {
        return this.id;
    }

    public Cliente getCliente()
    {
        return this.cliente;
    }

    public List<Produto> getProdutos()
    {
        return this.produtos;
    }

    public double getTotal() {
        return this.total;
    }

    public void adicionarProduto(Produto produto)
    {
        this.produtos.add(produto);
        this.total += produto.getValor();
    }

    public void exibirPedido() {
        System.out.println ("\n--- Pedido #" + this.id + " ---");
        System.out.println("Cliente: " + this.cliente.getNome());

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no pedido.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println("- " + p.getNome() + " | R$ " + String.format("%.2f", p.getValor()));
        }

        System.out.println("Total da nota: R$ " + String.format("%.2f", this.total));
    }

    public static List<fazerPedido> listarTodos()
    {
        return listaPedidos;
    }

    public static fazerPedido buscarPedidoPorId(int id)
    {
        return listaPedidos
                .stream()
                .filter(p -> p.id == id)
                .findFirst()
                .orElse(null);
    }
}
