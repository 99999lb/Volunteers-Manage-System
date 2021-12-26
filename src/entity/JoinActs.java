package entity;

public class JoinActs {
    private String actID;
    private String actname;
    private String sort;
    private String place;
    private String st;
    private String et;
    private String fin;
    private String apoint;

    public JoinActs(){}

    public JoinActs(String actID,String actname,String sort,String place,String st,String et,String fin,String apoint){
        this.actID=actID;
        this.actname=actname;
        this.sort=sort;
        this.place=place;
        this.st=st;
        this.et=et;
        this.fin=fin;
        this.apoint=apoint;
    }

    public String getActname() {
        return actname;
    }

    public void setActname(String actname) {
        this.actname = actname;
    }

    public String getEt() {
        return et;
    }

    public void setEt(String et) {
        this.et = et;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSort() {
        return sort;
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getApoint() {
        return apoint;
    }

    public void setApoint(String apoint) {
        this.apoint = apoint;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

}
