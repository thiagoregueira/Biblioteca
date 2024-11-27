import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    @SuppressWarnings("FieldMayBeFinal")
    private List<Livro> livros;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void adicionarLivro(String titulo, String autor, int ano) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Livro já existe no acervo.");
                return;
            }
        }
        livros.add(new Livro(titulo, autor, ano));
        System.out.println("Livro adicionado com sucesso.");
    }

    public void removerLivro(String titulo) {
        livros.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
        System.out.println("Livro removido com sucesso.");
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro no acervo.");
        } else {
            livros.forEach(System.out::println);
        }
    }

    public void buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(livro);
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public void emprestarLivro(String titulo, int idUsuario) {
        Livro livro = null;
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo) && l.isDisponivel()) {
                livro = l;
                break;
            }
        }
        if (livro == null) {
            System.out.println("Livro não disponível para empréstimo.");
            return;
        }

        Usuario usuario = usuarios.stream().filter(u -> u.getId() == idUsuario).findFirst().orElse(null);
        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        usuario.getLivrosEmprestados().add(titulo);
        livro.setDisponivel(false);
        System.out.println("Livro emprestado com sucesso.");
    }

    public void devolverLivro(String titulo, int idUsuario) {
        Usuario usuario = null;
        for (Usuario u : usuarios) {
            if (u.getId() == idUsuario) {
                usuario = u;
                break;
            }
        }

        if (usuario == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        if (usuario.getLivrosEmprestados().remove(titulo)) {
            for (Livro l : livros) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    l.setDisponivel(true);
                    break;
                }
            }
            System.out.println("Livro devolvido com sucesso.");
        } else {
            System.out.println("Livro não encontrado nos empréstimos do usuário.");
        }
    }

    public void adicionarUsuario(String nome, int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                System.out.println("Usuário já cadastrado.");
                return;
            }
        }
        usuarios.add(new Usuario(nome, id));
        System.out.println("Usuário adicionado com sucesso.");
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            usuarios.forEach(System.out::println);
        }
    }
}
