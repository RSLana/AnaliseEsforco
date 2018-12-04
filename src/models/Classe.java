package models;

import java.util.ArrayList;

public class Classe {

    private String id;
    private String nome;
    private int fi;
    private boolean construida;
    private int fit;
    private ArrayList<Classe> libera;
    private ArrayList<Classe> depende;

    public Classe(String id, String nome) {
        this.id = id;
        this.nome = nome;

        this.libera = new ArrayList();
        this.depende = new ArrayList();

    }

    public Classe() {
        this.libera = new ArrayList();
        this.depende = new ArrayList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFi() {
        return libera.size();
    }

    public int getFit() {
        if (!this.isConstruida()) {
            fit = 0;
            for (Classe c : depende) {
                if (!c.isConstruida()) {
                    fit += c.getFi();
                }
            }
            return fit;
        } else {
            return -1;
        }
    }

    public void setFit(int fit) {
        this.fit = fit;
    }

    public void setFi(int fi) {
        this.fi = fi;
    }

    public ArrayList<Classe> getLibera() {
        return libera;
    }

    public void setLibera(ArrayList<Classe> libera) {
        this.libera = libera;
    }

    public ArrayList<Classe> getDepende() {
        return depende;
    }

    public void setDepende(ArrayList<Classe> depende) {
        this.depende = depende;
    }

    public boolean isConstruida() {
        return construida;
    }

    public void setConstruida() {
        this.construida = true;
    }

    public void setNaoConstruida() {
        this.construida = false;
    }
}
