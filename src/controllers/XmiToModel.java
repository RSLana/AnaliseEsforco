package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Classe;
import models.Modelo;
import xmi.*;

public class XmiToModel {

    private XmiController xmi;
    private Root modeloXmi;
    private Modelo modelo;

    public XmiToModel() {
        this.xmi = new XmiController();
        this.modeloXmi = new Root();
        this.modelo = new Modelo();
    }

    public Root getModeloXmi() {
        return modeloXmi;
    }

    public void setModeloXmi(Root modeloXmi) {
        this.modeloXmi = modeloXmi;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public Modelo xmiToModel(Root modeloXmi) {
        this.modeloXmi = modeloXmi;
        return xmiToModel();
    }

    public Modelo xmiToModel(String path) {
        try {
            return xmiToModel(this.xmi.loadModel(path));
        } catch (IOException ex) {
            System.out.println(".xmi not found");
        }
        return null;
    }

    public Modelo xmiToModel() {

        Modelo modelo = new Modelo();
        ArrayList<PackagedElement> classesXmi = modeloXmi.getModel().getPackagedElement().getPackagedElements();
        ArrayList<Classe> classes = new ArrayList();

        classes = readClasses(classesXmi);
        modelo.setClasses(classes);

        modelo = preencheLiberaEDepende(classesXmi, modelo);

        return modelo;

    }

    private ArrayList<Classe> readClasses(ArrayList<PackagedElement> classesXmi) {

        ArrayList<Classe> classes = new ArrayList();

        for (PackagedElement classeXmi : classesXmi) {
            Classe classe = xmiToClasse(classeXmi);
            classes.add(classe);
        }

        return classes;
    }

    //Se você precisar ler esse código, me desculpe
    private Modelo preencheLiberaEDepende(ArrayList<PackagedElement> classesXmi, Modelo modelo) {

        for (PackagedElement pe : classesXmi) {
            if (pe.getOwnedMembers() != null) {
                for (OwnedMember om : pe.getOwnedMembers()) {

                    String tipo = om.getXmiType();

                    switch (tipo) {
                        case "uml:Association":
                            if (om.getOwnedEnds().get(0).getAggregation().equals("none")) {
                                
                                if (om.getOwnedEnds().get(0).getType().equals(pe.getXmiId())) {
                                    //entra aqui só em caso de association

                                    //Pega a classe referente ao PackagedElement
                                    Classe classePe = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId()));

                                    //Adiciona a lista de depende e libera seguindo a lógica do XMI
                                    classePe.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType())));
                                    classePe.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType())));

                                    //A classe que a classe anterior é ligada na association
                                    Classe classePe2 = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType()));

                                    //Adiciona a lista de depende e libera seguindo a lógica do XMI
                                    classePe2.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId())));
                                    classePe2.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId())));

                                } else {
                                    //entra aqui só em caso de association class

                                    //Pega a classe referente ao PackagedElement
                                    //essa é a classe intermediaria do association class
                                    Classe classePe = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId()));

                                    //Adiciona a lista de depende seguindo a lógica do XMI
                                    classePe.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(0).getType())));
                                    classePe.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType())));

                                    Classe classePe1 = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(0).getType()));

                                    classePe1.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType())));
                                    classePe1.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType())));
                                    classePe1.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId())));

                                    Classe classePe2 = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType()));
                                    classePe2.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(0).getType())));
                                    classePe2.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(0).getType())));
                                    classePe2.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId())));
                                }
                            } else {
                                //entra aqui só em caso de aggregation ou composition

                                Classe classePe = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId()));
                                classePe.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType())));

                                Classe classePe2 = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getOwnedEnds().get(1).getType()));
                                classePe2.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), pe.getXmiId())));
                            }

                            break;
                        case "uml:Dependency":
                            //entra aqui só em caso de dependecy
                            Classe classePe = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getClient()));
                            classePe.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getSupplier())));

                            Classe classePe2 = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getSupplier()));
                            classePe2.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getClient())));
                            break;
                        case "uml:Generalization":
                            //entra aqui só em caso de Generalization

                            Classe classeP = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getSpecific()));
                            classeP.getDepende().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getGeneral())));

                            Classe classeP2 = modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getGeneral()));
                            classeP2.getLibera().add(modelo.getClasses().get(procuraClasseIndex(modelo.getClasses(), om.getSpecific())));
                            break;
                    }
                }
            }
        }
        return modelo;
    }

    private int procuraClasseIndex(ArrayList<Classe> classes, String id) {
        for (int i = 0; i < classes.size(); i++) {
            if (classes.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private Classe xmiToClasse(PackagedElement pe) {

        Classe classe = new Classe();
        classe.setId(pe.getXmiId());
        classe.setNome(pe.getName());
        return classe;

    }
}