import java.util.ArrayList;
import java.util.List;

class Usuario {
    @SuppressWarnings("FieldMayBeFinal")
    private String nome;
    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private List<String> livrosEmprestados;

    public Usuario(String nome, int id) {
        this.nome = nome;
        this.id = id;
        this.livrosEmprestados = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<String> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", ID: " + id + ", Livros emprestados: " + livrosEmprestados;
    }
}
