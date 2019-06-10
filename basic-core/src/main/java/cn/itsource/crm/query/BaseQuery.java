package cn.itsource.crm.query;

public class BaseQuery {

    private int page = 1;
    private int rows = 10;

    private String keyword = null;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getBegin(){
        return (page-1)*rows;
    }
}
