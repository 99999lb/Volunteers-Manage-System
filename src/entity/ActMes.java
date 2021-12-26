package entity;

public class ActMes {
    private String actID;
    private String cid;
    private String actName;
    private String startTime;
    private String endTime;
    private float point;
    public ActMes(){}
    public ActMes(String actID,String actName,String cid,String startTime,String endTime,float point){
        this.actID=actID;
        this.actName=actName;
        this.cid=cid;
        this.startTime=startTime;
        this.endTime=endTime;
        this.point=point;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String toString(){return actID+""+actName+""+cid+""+startTime+""+endTime+""+point;}
}
