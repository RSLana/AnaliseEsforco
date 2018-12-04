package analiseesforco;

import controllers.*;
import java.io.IOException;
import java.util.ArrayList;
import models.Classe;
import models.Modelo;

/**
 *
 * @author raj
 */
public class AnaliseEsforco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*
        XmiController arquivoXmi = new XmiController();

        Root raizXmi = arquivoXmi.loadModel("./Escola.xmi");
        String nomeClasse = "";
        String idClasse = "";
        String tipo = "";

        for (int i = 0; i < raizXmi.getModel().getPackagedElement().getPackagedElements().size(); i++) {
            idClasse += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getXmiId() + "\n";
            nomeClasse += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getName() + "\n";
            tipo += raizXmi.getModel().getPackagedElement().getPackagedElements().get(i).getVisibility() + "\n";

        }
         */

        // ArrayList<PackagedElement> classes = raizXmi.getModel().getPackagedElement().getPackagedElements();       
        XmiToModel xtm = new XmiToModel();

        Modelo modelo = xtm.xmiToModel("./marco.xmi");
        imprimirFi(modelo);
        imprimirFitInicial(modelo);
        //imprimirFit(modelo);
        imprimirOrdem(modelo);        
        
    }

    public static void imprimirFi(Modelo modelo) {
        String str = "Classe\t\tFI\n------------------------------------------------\n";
        for (Classe c : modelo.getClasses()) {
            str += c.getNome();
            if (c.getNome().length() < 7) {
                str += "\t";
            }
            str += "\t" + c.getFi() + "\n";
        }
        System.out.println(str);
    }

    public static void imprimirFitInicial(Modelo modelo) {
        String str = "Classe\t\tFIT inicial\n------------------------------------------------\n";
        for (Classe c : modelo.getClasses()) {
            str += c.getNome();
            if (c.getNome().length() < 7) {
                str += "\t";
            }
            str += "\t" + c.getFit() + "\n";
        }
        System.out.println("--------------------------------------------");
        System.out.println(str);

    }

    public static void imprimirFit(Modelo modelo) {
        String str = "Classe\t\t";
        for (int i = 1; i <= modelo.getClasses().size(); i++) {
            str += "FIT" + i + "\t";
        }
        str += "\n---------------------------------------------------------------------------\n";
        int[][] fits = modelo.getFITs();
        for (int i = 0; i < modelo.getClasses().size(); i++) {
            str += modelo.getClasses().get(i).getNome() + "\t\t";
            for (int j = 0; j < modelo.getClasses().size(); j++) {
                if (fits[i][j] != -1) {
                    str += fits[i][j] + "\t";
                } else {
                    str += "-\t";
                }
            }
            str += "\n";
        }

        System.out.println(str);
    }

    public static void imprimirOrdem(Modelo modelo) {
        String str = "Ordem de criação sugerida:\nClasse\t\tStub(caso necessario)\n";

        ArrayList<Classe> ordem = modelo.getOrdemConstrucao();
        ArrayList<ArrayList<String>> stub = modelo.getStub();
        for (int i = 0; i < ordem.size(); i++) {
            str += (i + 1) + " - ";

            str += ordem.get(i).getNome() + "\t\t";
            for (int j = 0; j < stub.get(i).size(); j++) {
                if (stub.get(i).size() - 1 == j) {
                    str += stub.get(i);
                } else {
                    str += stub.get(i) + ",";
                }

            }
            str += "\n";
        }

        System.out.println(str);
    }
}
