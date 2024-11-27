import java.util.Scanner;

public class App {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("--- Menu Biblioteca ---");
            System.out.println("1. Adicionar livro");
            System.out.println("2. Remover livro");
            System.out.println("3. Listar livros");
            System.out.println("4. Buscar livro");
            System.out.println("5. Emprestar livro");
            System.out.println("6. Devolver livro");
            System.out.println("7. Adicionar usuário");
            System.out.println("8. Listar usuários");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.adicionarLivro(titulo, autor, ano);
                }
                case 2 -> {
                    System.out.print("Título do livro a remover: ");
                    String titulo = scanner.nextLine();
                    biblioteca.removerLivro(titulo);
                }
                case 3 -> biblioteca.listarLivros();
                case 4 -> {
                    System.out.print("Título do livro a buscar: ");
                    String titulo = scanner.nextLine();
                    biblioteca.buscarLivro(titulo);
                }
                case 5 -> {
                    System.out.print("Título do livro a emprestar: ");
                    String titulo = scanner.nextLine();
                    System.out.print("ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.emprestarLivro(titulo, idUsuario);
                }
                case 6 -> {
                    System.out.print("Título do livro a devolver: ");
                    String titulo = scanner.nextLine();
                    System.out.print("ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.devolverLivro(titulo, idUsuario);
                }
                case 7 -> {
                    System.out.print("Nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do usuário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    biblioteca.adicionarUsuario(nome, id);
                }
                case 8 -> biblioteca.listarUsuarios();
                case 9 -> System.out.println("Encerrando o programa.");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);

        scanner.close();
    }
}
