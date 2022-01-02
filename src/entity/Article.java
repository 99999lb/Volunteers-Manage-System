package entity;

public class Article {
    private String aid;
    private String title;
    private String tText;
    private int tid;

    public Article(){
    }

    public Article(String aid, String title, String tText, int tid){
        this.aid=aid;
        this.title=title;
        this.tText=tText;
        this.tid=tid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }


    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
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
}
