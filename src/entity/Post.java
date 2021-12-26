package entity;

public class Post {
    private String cid;
    private String cname;
    private String title;
    private String tText;
    private String pass;
    private int TID;
    public Post(){}
    public Post(String cid,String cname,
                String title,String tText){
        this.cid=cid;
        this.cname=cname;
        this.title=title;
        this.tText=tText;
    }


    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String gettText() {
        return tText;
    }

    public void settText(String tText) {
        this.tText = tText;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getTID() {
        return TID;
    }

    public void setTID(int TID) {
        this.TID = TID;
    }
}
