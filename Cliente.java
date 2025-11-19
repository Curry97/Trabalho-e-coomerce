import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static List<Cliente> listaDeClientes = new ArrayList<>();

public static void adicionarCliente(Cliente cliente) {
        listaDeClientes.add(cliente);
    }

public static List<Cliente> listarTodos() {
        return listaDeClientes;
    }

public static Cliente buscarClientePorId(int id) 
    {
       Cliente clienteEncontrado = listaDeClientes
                .stream()
                .filter(c -> c.id == id)      
                .findFirst()
                .orElse(null);
    
        if (clienteEncontrado == null) 
            System.out.println("Cliente não encontrado!");          
        {
            return clienteEncontrado;
        }

    }

    private int id;

public int getId() 
    {
        return this.id;
    }

    private String nome;

public String getNome() 
    {
        return this.nome;
    }

public void setNome(String novoNome)
    {
        this.nome = novoNome;
    }

    private String email;

public String getEmail() {
        return this.email;
    }

public void setEmail(String novoEmail) 
    {
        if (novoEmail.contains("@")) 
        {
            this.email = novoEmail;
        }
    }

public Cliente(String n, String e) 
    {
        this.id = listaDeClientes.size() + 1;
        this.nome = n;
        this.email = e;
    }

public void exibirCliente()
 {
        System.out.println("Id: "+ this.id +" | Nome: " + this.nome + " | Email: "+ this.email);
 }
}