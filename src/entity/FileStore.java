package entity;

public class FileStore {
    private int fid;
    private String fileName;
    private String newFileName;
    private int did;
    private int size;
    private String sort;
    private String date;
    private String aid;
    public FileStore(){}
    public FileStore(int fid,String fileName,String newFileName,int did,int size,String sort,String date,String aid){
        this.fid=fid;
        this.fileName=fileName;
        this.newFileName=newFileName;
        this.did=did;
        this.size=size;
        this.sort=sort;
        this.date=date;
        this.aid=aid;
    }
    public FileStore(String fileName,String newFileName,int size,String sort){
        this.fileName=fileName;
        this.newFileName=newFileName;
        this.size=size;
        this.sort=sort;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getNewFileName() {
        return newFileName;
    }

    public void setNewFileName(String newFileName) {
        this.newFileName = newFileName;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }
}
