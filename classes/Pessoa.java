package classes;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Aeronave nave;
    

    
    public Aeronave getNave() {
        return nave;
    }
    public void setNave(Aeronave nave) {
        this.nave = nave;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
