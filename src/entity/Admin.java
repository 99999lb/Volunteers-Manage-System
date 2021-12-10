package entity;

public class Admin {
    private String aid;
    private String pwd;
    public Admin(){}
    public Admin(String aid,String pwd){
        this.aid=aid;
        this.pwd=pwd;
    }
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
