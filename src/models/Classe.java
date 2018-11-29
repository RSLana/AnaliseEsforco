/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.ArrayList;

/**
 *
 * @author raj
 */
public class Classe {
    
    private String id;
    private String nome;
    private int fi;
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
        return fi;
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
    
    
    

    
}
