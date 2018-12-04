package models;

import java.util.ArrayList;

public class Modelo {

    private ArrayList<Classe> classes;
    private ArrayList<ArrayList<String>> stub;
    private ArrayList<Classe> ordemConstrucao;

    public Modelo() {
        this.classes = new ArrayList();
        this.ordemConstrucao = new ArrayList();
        this.stub = new ArrayList<>();

    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }

    public void addClasse(Classe classe) {
        this.classes.add(classe);
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public ArrayList<Classe> getOrdemConstrucao() {
        for (int i = 0; i < classes.size(); i++) {

            int index = getIndexMenorFit();
            ordemConstrucao.add(classes.get(index));

            if (classes.get(index).getFit() != 0) {
                //stub^
                ArrayList<String> stubSTR = new ArrayList<>();
                for (int j = 0; j < classes.get(index).getDepende().size(); j++) {
                    if (!classes.get(index).getDepende().get(j).isConstruida()) {

                        stubSTR.add(classes.get(index).getDepende().get(j).getNome());

                    }
                }
                stub.add(stubSTR);
            } else {
                ArrayList<String> stubSTR = new ArrayList<>();
                stubSTR.add("-");
                stub.add(stubSTR);
            }
            classes.get(index).setConstruida();
        }
        return ordemConstrucao;
    }

    public int[][] getFITs() {
        int[][] fits = new int[classes.size()][classes.size()];
        for (int coluna = 0; coluna < classes.size(); coluna++) {
            for (int linha = 0; linha < classes.size(); linha++) {
                fits[linha][coluna] = classes.get(linha).getFit();
            }
            calculaProximoFIT();

        }
        return fits;
    }

    private void calculaProximoFIT() {
        int index = getIndexMenorFit();
        if (index != -1) {
            if (classes.get(index).getFit() != 0) {
                //stub
            }
            classes.get(index).setConstruida();
        }
    }

    private int getIndexMenorFit() {
        Classe classe = null;
        for (int i = 0; i < classes.size(); i++) {
            if (!classes.get(i).isConstruida()) {
                classe = classes.get(i);
                break;
            }
        }

        for (int i = 0; i < classes.size(); i++) {
            if (!classes.get(i).isConstruida()) {
                if (classes.get(i).getFit() <= classe.getFit() || classe == null) {
                    if ((classes.get(i).getFit() == classe.getFit() && classes.get(i).getFi() > classe.getFit())
                            || classes.get(i).getFit() < classe.getFit() || classe == null) {
                        classe = classes.get(i);

                    }
                }
            }

        }

        return classes.indexOf(classe);

    }

    public ArrayList<ArrayList<String>> getStub() {
        return stub;
    }

}
