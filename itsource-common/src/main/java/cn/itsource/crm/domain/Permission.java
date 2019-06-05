package cn.itsource.crm.domain;

/**
 * <p>
 * 
 * </p>
 *
 * @author solargen
 * @since 2019-06-05
 */
public class Permission{


    private Long id;

    private String sn;

    private String name;

    private String url;

    private Long menuId;

    private Integer ismenu;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    @Override
    public String toString() {
        return "Permission{" +
        "id=" + id +
        ", sn=" + sn +
        ", name=" + name +
        ", url=" + url +
        ", menuId=" + menuId +
        ", ismenu=" + ismenu +
        "}";
    }
}
