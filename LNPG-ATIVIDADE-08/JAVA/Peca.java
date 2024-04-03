public class Peca {
    private String tipoPeca;
    private String corPeca;
    protected int linhaAtual;
    protected int colunaAtual; // Modificado para protected

    public Peca(String tipoPeca, String corPeca, int linhaAtual, int colunaAtual) {
        this.tipoPeca = tipoPeca;
        this.corPeca = corPeca;
        this.linhaAtual = linhaAtual;
        this.colunaAtual = colunaAtual;
    }

    public void imprimirInformacoes() {
        imprimir("Tipo da peça: " + this.tipoPeca);
        imprimir("Cor da peça: " + this.corPeca);
        imprimir("Posição: (" + this.linhaAtual + ", " + this.colunaAtual + ")");
    }

    protected void imprimir(String texto) {
        System.out.println(texto);
    }
}

class Peao extends Peca {
    public Peao(String tipoPeca, String corPeca, int linhaAtual, int colunaAtual) {
        super(tipoPeca, corPeca, linhaAtual, colunaAtual);
    }

    public void movimentarPeao(int novaLinha) {
        if (verificarMovimento(novaLinha)) {
            this.linhaAtual = novaLinha;
            imprimir("Movimento realizado");
        } else {
            imprimir("Movimento inválido");
        }
    }

    private boolean verificarMovimento(int novaLinha) {
        if ((this.linhaAtual == 2 || this.linhaAtual == 7) && (novaLinha == 4 || novaLinha == 5)) {
            return true;
        } else return Math.abs(novaLinha - this.linhaAtual) == 1;
    }

    public void capturarPeca(int colunaCapturar, int linhaCapturar, String pecaCapturada) {
        if (Math.abs(colunaCapturar - this.colunaAtual) == 1 && Math.abs(linhaCapturar - this.linhaAtual) == 1) {
            System.out.printf("A peça %s foi capturada com sucesso na linha %d coluna %d!\n", pecaCapturada, linhaCapturar, colunaCapturar);
        } else {
            imprimir("Movimento inválido!");
        }
    }
}
