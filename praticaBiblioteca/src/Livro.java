
class Livro {
    @SuppressWarnings("FieldMayBeFinal")
    private String titulo;
    @SuppressWarnings("FieldMayBeFinal")
    private String autor;
    @SuppressWarnings("FieldMayBeFinal")
    private int ano;
    private boolean disponivel;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ano: " + ano + ", Disponível: "
                + (disponivel ? "Sim" : "Não");
    }
}
