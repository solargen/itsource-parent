package cn.itsource.crm.util;

import java.util.ArrayList;
import java.util.List;

public class PageList<T> {

    private long total = 0;
    private List<T> rows = new ArrayList<>();

    public PageList() {
    }

    public PageList(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
