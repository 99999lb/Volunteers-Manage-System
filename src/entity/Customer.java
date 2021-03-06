package entity;

public class Customer {
    private String cid;
    private String cname;
    private String sex;
    private String sig;
    private String phone;
    private String address;
    private String pass;
    private String csort;
    private String cpwd;
    public Customer(){}
    public Customer(String cid,String cname){
        this.cid=cid;
        this.cname=cname;
    }
    public Customer(String cid,String cname,String sex,String sig,String phone,String address,
                    String pass,String csort){
        this.cid=cid;
        this.cname=cname;
        this.sex=sex;
        this.sig=sig;
        this.phone=phone;
        this.address=address;
        this.pass=pass;
        this.csort=csort;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }


}
