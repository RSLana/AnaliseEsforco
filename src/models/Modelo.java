/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.ArrayList;

/**
 *
 * @author jjti
 */
public class Modelo {
        private ArrayList<Classe> classes;

    public Modelo(){
        this.classes = new ArrayList();
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    
    public void addClasse(Classe classe){
        this.classes.add(classe);
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }
}
