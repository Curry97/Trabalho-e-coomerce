import java.util.ArrayList;
import java.util.List;


public class Produto
{
    private int id;
    private String nome;
    private double valor;
    private int quantidadeEstoque;

    private static List<Produto> listaProdutos = new ArrayList<>();
    private static int contador = 1;

public Produto (String nome, double valor, int quantidadeEstoque)
    {
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.id = contador; 
        contador++;          
    }

public static void adicionarProduto(Produto produto)
    {
        listaProdutos.add(produto);
    }

public static List<Produto> listarTodos()
    {
        return listaProdutos;
    }

public int getId() 
    {
        return this.id;
    }

public String getNome() 
    {
        return this.nome;
    }

public double getValor()
    {
        return this.valor;
    }

public int getQuantidadeEstoque()
    {
        return this.quantidadeEstoque;
    }

public void setQuantidadeEstoque(int novaQuantidade) 
    {
        this.quantidadeEstoque = novaQuantidade;
    }

public static Produto buscarProdutoPorId (int id)
    {
       Produto produtoEncontrado = listaProdutos
                .stream()
                .filter(p -> p.id == id)
                .findFirst()
                .orElse(null);

        if (produtoEncontrado == null)      
        {
            System.out.println("Produto não cadastrado!");                      
        }
         return produtoEncontrado;
    }
public void exibirProduto() 
    { 
        System.out.println("Id: "+ this.id+ " | Nome do produto: " + this.nome + " | Preço do produto: R$ " + String.format("%.2f", this.valor) +" | Estoque: "+ this.getQuantidadeEstoque());
    }
}