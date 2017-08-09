package paesjuliana.com.br.siap.entity;

/**
 * Created by MarceloSilva on 08/08/17.
 */

public class Funcionario {

    private String nome;
    private String codigo;
    private String senha;
    private int foto;

    public Funcionario(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
