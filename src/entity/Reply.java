package entity;

public class Reply {
    private int tid;
    private String cid;
    private String cname;
    private String rep;
    private int rid;
    public Reply(){}
    public Reply(int tid,String cid,String cname,String rep,int rid){
        this.tid=tid;
        this.cid=cid;
        this.cname=cname;
        this.rep=rep;
        this.rid=rid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
