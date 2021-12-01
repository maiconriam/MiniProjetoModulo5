package br.com.zup.bancostar.enuns;

public enum Tipo {
    PF("Pessoa Fisica"),
    PJ("Pessoa Juridica");

    private String nomeTipo;

    Tipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }
}
