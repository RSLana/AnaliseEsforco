
package models;


public class OwnedEnd {
    private String xmiId;
    private String visibility;
    private Boolean isStatic;
    private Boolean isLeaf;
    private Boolean isReadOnly;
    private Boolean isOrdered;
    private Boolean isUnique;
    private String xmiType;
    private String aggregation;
    private Boolean isDerived;
    private Boolean isId;
    private String type;
    private Extension xmiExtension;
    
    public String getXmiId() {
        return xmiId;
    }

    public void setXmiId(String xmiId) {
        this.xmiId = xmiId;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Boolean getIsStatic() {
        return isStatic;
    }

    public void setIsStatic(Boolean isStatic) {
        this.isStatic = isStatic;
    }

    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public Boolean getIsReadOnly() {
        return isReadOnly;
    }

    public void setIsReadOnly(Boolean isReadOnly) {
        this.isReadOnly = isReadOnly;
    }

    public Boolean getIsOrdered() {
        return isOrdered;
    }

    public void setIsOrdered(Boolean isOrdered) {
        this.isOrdered = isOrdered;
    }

    public Boolean getIsUnique() {
        return isUnique;
    }

    public void setIsUnique(Boolean isUnique) {
        this.isUnique = isUnique;
    }

    public String getXmiType() {
        return xmiType;
    }

    public void setXmiType(String xmiType) {
        this.xmiType = xmiType;
    }

    public String getAggregation() {
        return aggregation;
    }

    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }

    public Boolean getIsDerived() {
        return isDerived;
    }

    public void setIsDerived(Boolean isDerived) {
        this.isDerived = isDerived;
    }

    public Boolean getIsId() {
        return isId;
    }

    public void setIsId(Boolean isId) {
        this.isId = isId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Extension getXmiExtension() {
        return xmiExtension;
    }

    public void setXmiExtension(Extension xmiExtension) {
        this.xmiExtension = xmiExtension;
    }
    
}
