package models;

import java.util.ArrayList;


public class OwnedMember {
    
    /*
    <generalization xmi:id="AAAAAAFm31LCKD0j6fo=" name="generalizationExample" visibility="public" xmi:type="uml:Generalization" 
    specific="AAAAAAFm31AVtTqs2QM=" general="AAAAAAFm31A1EjrWHXI="/>
     */

    private String xmiId;
    private String name;
    private String visibility;
    private String xmiType;
    private Boolean isDerived;
    private String specific;
    private String general;
    private String client;
    private String supplier;
    private ArrayList<OwnedEnd> ownedEnds;
    private ArrayList<MemberEnd> memberEnds;

    public String getClient() {
        return client;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    
    
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

    public String getXmiType() {
        return xmiType;
    }

    public void setXmiType(String xmiType) {
        this.xmiType = xmiType;
    }

    public Boolean getIsDerived() {
        return isDerived;
    }

    public void setIsDerived(Boolean isDerived) {
        this.isDerived = isDerived;
    }

    public ArrayList<OwnedEnd> getOwnedEnds() {
        return ownedEnds;
    }

    public void setOwnedEnds(ArrayList<OwnedEnd> ownedEnds) {
        this.ownedEnds = ownedEnds;
    }

    public ArrayList<MemberEnd> getMemberEnds() {
        return memberEnds;
    }

    public void setMemberEnds(ArrayList<MemberEnd> memberEnds) {
        this.memberEnds = memberEnds;
    }
    
    
    
}
