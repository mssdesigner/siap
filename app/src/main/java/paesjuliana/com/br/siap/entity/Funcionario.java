package paesjuliana.com.br.siap.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MarceloSilva on 08/08/17.
 */

public class Funcionario implements Serializable {

    private String CNOME;
    private String CMATFUN;
    private String CFOTO;
    private String CDIA;
    private String CMES;
    private String CANO;
    private String CCPF;
    private String CSITUA;
    private String CSENHA;

    public String getCNOME() {
        return CNOME;
    }

    public void setCNOME(String CNOME) {
        this.CNOME = CNOME;
    }

    public String getCMATFUN() {
        return CMATFUN;
    }

    public void setCMATFUN(String CMATFUN) {
        this.CMATFUN = CMATFUN;
    }

    public String getCFOTO() {
        return CFOTO;
    }

    public void setCFOTO(String CFOTO) {
        this.CFOTO = CFOTO;
    }

    public String getCDIA() {
        return CDIA;
    }

    public void setCDIA(String CDIA) {
        this.CDIA = CDIA;
    }

    public String getCMES() {
        return CMES;
    }

    public void setCMES(String CMES) {
        this.CMES = CMES;
    }

    public String getCANO() {
        return CANO;
    }

    public void setCANO(String CANO) {
        this.CANO = CANO;
    }

    public String getCCPF() {
        return CCPF;
    }

    public void setCCPF(String CCPF) {
        this.CCPF = CCPF;
    }

    public String getCSITUA() {
        return CSITUA;
    }

    public void setCSITUA(String CSITUA) {
        this.CSITUA = CSITUA;
    }

    public String getCSENHA() {
        return CSENHA;
    }

    public void setCSENHA(String CSENHA) {
        this.CSENHA = CSENHA;
    }
}
