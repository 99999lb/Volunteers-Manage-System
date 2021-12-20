package entity;

public class Activity {
    private String actID;
    private String actName;
    private String sort;
    private String place;
    private String startTime;
    private String endTime;
    private String rStartTime;
    private String rEndTime;
    private String duration;
    private String peoNum;
    private String actBrif;
    private String pass;
    public Activity(){}
    public Activity(String actID,String actName,String sort,String place,String startTime,String endTime,String rStartTime,String rEndTime,
                    String duration,String peoNum,String actBrif,String pass){
        this.actID=actID;
        this.actName=actName;
        this.sort=sort;
        this.place=place;
        this.startTime=startTime;
        this.endTime=endTime;
        this.rStartTime=rStartTime;
        this.rEndTime=rEndTime;
        this.duration=duration;
        this.peoNum=peoNum;
        this.actBrif=actBrif;
        this.pass=pass;
    }

    public String getActID() {
        return actID;
    }

    public void setActID(String actID) {
        this.actID = actID;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public String getrStartTime() {
        return rStartTime;
    }

    public void setrStartTime(String rStartTime) {
        this.rStartTime = rStartTime;
    }

    public String getrEndTime() {
        return rEndTime;
    }

    public void setrEndTime(String rEndTime) {
        this.rEndTime = rEndTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPeoNum() {
        return peoNum;
    }

    public void setPeoNum(String peoNum) {
        this.peoNum = peoNum;
    }

    public String getActBrif() {
        return actBrif;
    }

    public void setActBrif(String actBrif) {
        this.actBrif = actBrif;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
