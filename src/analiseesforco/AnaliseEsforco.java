
package analiseesforco;


import controllers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.PackagedElement;
import models.Root;

/**
 *
 * @author ariel
 */
public class AnaliseEsforco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        XMIcontroller arquivoXmi = new XMIcontroller();
        
        Root raizXmi = arquivoXmi.loadModel("./Escola.xmi");
        String nomeClasse = "";
        for (int i = 0; i < raizXmi.getModel().getPackagedElement().getPackagedElements().size(); i++) {
            nomeClasse += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getXmiId() + "\n";
        }
        ArrayList<PackagedElement> classes = raizXmi.getModel().getPackagedElement().getPackagedElements();
        System.out.println(nomeClasse);
    }
    
}
