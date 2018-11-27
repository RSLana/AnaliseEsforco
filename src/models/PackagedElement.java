package models;

import java.util.ArrayList;


public class PackagedElement {
    
    private String xmiId;
    private String name;
    private String visibility;
    private Boolean isAbstract;
    private Boolean isFinalSpecialization;
    private Boolean isLeaf;
    private String xmiType;
    private Boolean isActive;
    private ArrayList<PackagedElement> packagedElements;
    private ArrayList<OwnedAttribute> ownedAttributes;
    private ArrayList<OwnedOperation> ownedOperations;
    private ArrayList<OwnedMember> ownedMembers;

    public String getXmiId() {
        return xmiId;
    }

    public void setXmiId(String xmiId) {
        this.xmiId = xmiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Boolean getIsAbstract() {
        return isAbstract;
    }

    public void setIsAbstract(Boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    public Boolean getIsFinalSpecialization() {
        return isFinalSpecialization;
    }

    public void setIsFinalSpecialization(Boolean isFinalSpecialization) {
        this.isFinalSpecialization = isFinalSpecialization;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getXmiType() {
        return xmiType;
    }

    public void setXmiType(String xmiType) {
        this.xmiType = xmiType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public ArrayList<PackagedElement> getPackagedElements() {
        return packagedElements;
    }

    public void setPackagedElements(ArrayList<PackagedElement> packagedElements) {
        this.packagedElements = packagedElements;
    }

    public ArrayList<OwnedAttribute> getOwnedAtributes() {
        return ownedAttributes;
    }

    public void setOwnedAtributes(ArrayList<OwnedAttribute> ownedAtributes) {
        this.ownedAttributes = ownedAtributes;
    }

    public ArrayList<OwnedOperation> getOwnedOperations() {
        return ownedOperations;
    }

    public void setOwnedOperations(ArrayList<OwnedOperation> ownedOperations) {
        this.ownedOperations = ownedOperations;
    }

    public ArrayList<OwnedAttribute> getOwnedAttributes() {
        return ownedAttributes;
    }

    public void setOwnedAttributes(ArrayList<OwnedAttribute> ownedAttributes) {
        this.ownedAttributes = ownedAttributes;
    }

    public ArrayList<OwnedMember> getOwnedMembers() {
        return ownedMembers;
    }

    public void setOwnedMembers(ArrayList<OwnedMember> ownedMembers) {
        this.ownedMembers = ownedMembers;
    }
    
    
}
