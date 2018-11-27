package models;

public class Root {
    private String xmiVersion;
    private String xmlnsUML;
    private String xmlnsXmi;
    private Documentation documentation;
    private Model model;

    public String getXmiVersion() {
        return xmiVersion;
    }

    public void setXmiVersion(String xmiVersion) {
        this.xmiVersion = xmiVersion;
    }

    public String getXmlnsUML() {
        return xmlnsUML;
    }

    public void setXmlnsUML(String xmlnsUML) {
        this.xmlnsUML = xmlnsUML;
    }

    public String getXmlnsXmi() {
        return xmlnsXmi;
    }

    public void setXmlnsXmi(String xmlnsXmi) {
        this.xmlnsXmi = xmlnsXmi;
    }

    public Documentation getDocumentation() {
        return documentation;
    }

    public void setDocumentation(Documentation documentation) {
        this.documentation = documentation;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }
    
    
    
}
