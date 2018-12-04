package appprint.domain;

public class PaperType {
    private String type;
    private Side singleSided;
    private Side doubleSided;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Side getSingleSided() {
        return singleSided;
    }

    public void setSingleSided(Side singleSided) {
        this.singleSided = singleSided;
    }

    public Side getDoubleSided() {
        return doubleSided;
    }

    public void setDoubleSided(Side doubleSided) {
        this.doubleSided = doubleSided;
    }
}
