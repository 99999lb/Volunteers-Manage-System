package entity;

public class Customer {
    private String cid;
    private String cname;
    private String sex;
    private String sig;
    private String phone;
    private String pass;
    private String csort;
    private String pwd;
    public Customer(){}
    public Customer(String cid,String cname,String sex,String sig,
                    String phone,String pwd)
    {
        this.cid=cid;
        this.cname=cname;
        this.sex=sex;
        this.sig=sig;
        this.phone=phone;
        this.pwd=pwd;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSig() {
        return sig;
    }

    public void setSig(String sig) {
        this.sig = sig;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCsort() {
        return csort;
    }

    public void setCsort(String csort) {
        this.csort = csort;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
