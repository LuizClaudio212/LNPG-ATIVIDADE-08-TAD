public class Biblioteca {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int numCopiasDisponiveis;

    public void inicializar(String titulo, String autor, int anoPublicacao, int numCopias) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.numCopiasDisponiveis = numCopias;
    }

    public int emprestarCopia() {
        return --this.numCopiasDisponiveis;
    }

    public int devolverCopia() {
        return ++this.numCopiasDisponiveis;
    }

    public void verificarCopiasDisponiveis() {
        if (this.numCopiasDisponiveis > 0) {
            System.out.printf("Número de cópias disponíveis: %d.\n", this.numCopiasDisponiveis);
        } else {
            System.out.println("Não há cópias disponíveis.");
        }
    }

    void imprimir(String formato, Object... args) {
        System.out.printf(formato, args);
    }

    public void imprimirDetalhes() {
        imprimir("Título: %s\n", this.titulo);
        imprimir("Autor: %s\n", this.autor);
        imprimir("Ano de publicação: %d\n", this.anoPublicacao);
        imprimir("Número de cópias disponíveis: %d\n", this.numCopiasDisponiveis);
    }

    public static void main(String[] args) {
        Biblioteca livroUm = new Biblioteca();
        livroUm.inicializar("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881, 10);
        livroUm.imprimirDetalhes();
    }
}
