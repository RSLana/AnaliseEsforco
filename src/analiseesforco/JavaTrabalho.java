package analiseesforco;

import controllers.XmiController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Model;
import models.PackagedElement;
import models.Root;

public class JavaTrabalho {

    public static void main(String[] args) {
        XmiController arquivoXmi = new XmiController();
        
        try {
            Root raizXmi = arquivoXmi.loadModel("./Escola.xmi");
            
            String nomeClasse = "";
            for (int i = 0; i < raizXmi.getModel().getPackagedElement().getPackagedElements().size(); i++) {
                nomeClasse += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getXmiId() + "\n";
            }
            
            ArrayList<PackagedElement> classes = raizXmi.getModel().getPackagedElement().getPackagedElements(); 
            
            for (int i = 0; i < classes.size(); i++) {
                nomeClasse += classes.get(i).getIsAbstract()+ "\n";
            }
            
            System.out.println(nomeClasse);
        } catch (IOException ex) {
            Logger.getLogger(JavaTrabalho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
