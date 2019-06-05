package cn.itsource.crm.domain;

/**
 * <p>
 *
 * </p>
 *
 * @author solargen
 * @since 2019-06-05
 */
public class Department{


    private Long id;

    private String sn;

    private String name;

    private Long managerId;

    private Long parentId;

    private String dirPath;

    private Integer status;


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

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDirPath() {
        return dirPath;
    }

    public void setDirPath(String dirPath) {
        this.dirPath = dirPath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Department{" +
        "id=" + id +
        ", sn=" + sn +
        ", name=" + name +
        ", managerId=" + managerId +
        ", parentId=" + parentId +
        ", dirPath=" + dirPath +
        ", status=" + status +
        "}";
    }
}
