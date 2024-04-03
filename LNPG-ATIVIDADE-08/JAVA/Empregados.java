import java.util.ArrayList;

public class Empregados {
    private String nomeCompleto;
    private int identificador;
    private String cargo;
    private float salario;
    private Departamento setor;

    public Empregados(String nomeCompleto, int identificador, String cargo, float salario) {
        this.nomeCompleto = nomeCompleto;
        this.identificador = identificador;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void atualizarInformacoes(String nomeCompleto, String cargo, float salario) {
        this.nomeCompleto = nomeCompleto;
        this.cargo = cargo;
        this.salario = salario;
    }
    
    public void transferirParaDepartamento(Departamento setor, Empregados empregado){
        this.setor = setor;
        setor.adicionarEmpregado(empregado);
    }
    
    public void imprimirInformacoes(){
        System.out.println("Nome: " + this.nomeCompleto);
        System.out.println("Identificador: " + this.identificador);
        System.out.println("Cargo: " + this.cargo);
        System.out.println("Salário: " + this.salario);
        System.out.println("");
    }
    
    public void imprimirSetor(){
        setor.exibirInformacoes();
    }
}

class Departamento {
    private String nome;
    private int identificador;
    private String localizacao;
    private ArrayList<Empregados> empregados;
    
    public Departamento(String nome, int identificador, String localizacao){
        this.nome = nome;
        this.identificador = identificador;
        this.localizacao = localizacao;
        this.empregados = new ArrayList<>();
    }
    
    public void adicionarEmpregado(Empregados empregado){
        this.empregados.add(empregado);
    }
    
    public void imprimirEmpregados(){
        System.out.printf("Lista de Empregados:\n\n");
        for(Empregados pessoa : empregados){
            pessoa.imprimirInformacoes();
        }
    }
    
    public void removerEmpregado(Empregados empregado){
        this.empregados.remove(empregado);
    }
    
    public void exibirInformacoes(){
        System.out.println("Nome: " + this.nome);
        System.out.println("Identificador: " + this.identificador);
        System.out.println("Localização: " + this.localizacao);
    }
}

class Aplicativo {
    public static void main(String[] args) throws Exception {
        Empregados Luiz = new Empregados("Luiz", 18, "Atendente", 1300.00f);
        Empregados Carlos = new Empregados("Carlos", 18, "Atendente", 1300.00f);
        Departamento Recepcao = new Departamento("Recepção", 1, "Entrada");
        Carlos.transferirParaDepartamento(Recepcao, Carlos);
        Luiz.transferirParaDepartamento(Recepcao, Luiz);
        Recepcao.imprimirEmpregados();
        Luiz.imprimirSetor();
    }
}
