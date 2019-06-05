package cn.itsource.crm.domain;

/**
 * <p>
 * 
 * </p>
 *
 * @author solargen
 * @since 2019-06-05
 */
public class Role{


    private Long id;

    private String sn;

    private String name;

    private String intro;


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

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "Role{" +
        "id=" + id +
        ", sn=" + sn +
        ", name=" + name +
        ", intro=" + intro +
        "}";
    }
}
