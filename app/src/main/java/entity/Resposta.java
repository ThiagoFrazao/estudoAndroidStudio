package entity;

public class Resposta {

    private String resposta;

    public  Resposta(){

    }

    public  Resposta(String msg){
        this.resposta = msg;
    }

    public String getMensagem() {
        return resposta;
    }

    public void setMensagem(String mensagem) {
        this.resposta = mensagem;
    }
}
