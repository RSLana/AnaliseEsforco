package models;

public class Model {
    private String xmiId;
    private String xmiType;
    private String name;
    private PackagedElement packagedElement;

    public String getXmiId() {
        return xmiId;
    }

    public void setXmiId(String xmiId) {
        this.xmiId = xmiId;
    }

    public String getXmiType() {
        return xmiType;
    }

    public void setXmiType(String xmiType) {
        this.xmiType = xmiType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackagedElement getPackagedElement() {
        return packagedElement;
    }

    public void setPackagedElement(PackagedElement packagedElement) {
        this.packagedElement = packagedElement;
    }

}
