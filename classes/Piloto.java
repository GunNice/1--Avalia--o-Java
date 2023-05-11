package classes;

public class Piloto extends Pessoa {

    protected String breve;
   
    

   
    @Override
    public String toString() {
        String texto = " ";
        texto += "Nome: " + nome;
        texto += " - CPF: " + cpf;
        texto += " - Brevê: " + breve;
        if(nave != null){
            texto += " - Aeronave: " + nave;
       
        }
        return texto;
       }

        
    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }

}
