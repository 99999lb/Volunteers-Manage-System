package entity;

public class Acts {
    private String cid;
    private String actID;
    private String actName;
    private String YON;
    public Acts(){}
    public Acts(String cid,String actID,String actName,String YON){
        this.cid=cid;
        this.actID=actID;
        this.actName=actName;
        this.YON=YON;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    public String getYON() {
        return YON;
    }

    public void setYON(String YON) {
        this.YON = YON;
    }
}
