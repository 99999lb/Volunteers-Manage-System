package entity;

public class JoinNum {
    private String actid;
    private String jcid;

    public JoinNum(){}

    public JoinNum(String actid,String jcid){
        this.actid=actid;
        this.jcid=jcid;
    }

    public String getActid() {
        return actid;
    }

    public void setActid(String actid) {
        this.actid = actid;
    }

    public String getJcid() {
        return jcid;
    }

    public void setJcid(String jcid) {
        this.jcid = jcid;
    }
}
