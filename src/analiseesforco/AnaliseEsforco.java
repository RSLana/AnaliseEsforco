
package analiseesforco;


import controllers.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import xmi.PackagedElement;
import xmi.Root;

/**
 *
 * @author raj
 */
public class AnaliseEsforco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        XmiController arquivoXmi = new XmiController();

        Root raizXmi = arquivoXmi.loadModel("./Escola.xmi");
        String nomeClasse = "";
        String idClasse = "";
        String tipo = "";
        
        for (int i = 0; i < raizXmi.getModel().getPackagedElement().getPackagedElements().size(); i++) {
            idClasse += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getXmiId() + "\n";
            nomeClasse += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getName()+ "\n";
            tipo += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getVisibility() + "\n";

        }
        ArrayList<PackagedElement> classes = raizXmi.getModel().getPackagedElement().getPackagedElements();
        System.out.println(idClasse);
        System.out.println(nomeClasse);
        //System.out.println(tipo);
    }

}
