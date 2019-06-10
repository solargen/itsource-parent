package cn.itsource.crm.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author solargen
 * @since 2019-06-05
 */
public class Menu{


    private Long id;

    private String sn;

    private String name;

    private Long parentId;

    private String icon;

    private String path;

    private String component;

    private String intro;

    private List<Menu> children = new ArrayList<>();

    private boolean hasChildren = true;


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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "id=" + id +
        ", sn=" + sn +
        ", name=" + name +
        ", parentId=" + parentId +
        ", icon=" + icon +
        ", path=" + path +
        ", component=" + component +
        ", intro=" + intro +
        "}";
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
