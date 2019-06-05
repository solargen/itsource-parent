package cn.itsource.crm.domain;

import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author solargen
 * @since 2019-06-05
 */
public class Employee{


    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    private Long deptId;

    private Date inputtime;

    private Integer state;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Date getInputtime() {
        return inputtime;
    }

    public void setInputtime(Date inputtime) {
        this.inputtime = inputtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "id=" + id +
        ", username=" + username +
        ", realname=" + realname +
        ", password=" + password +
        ", tel=" + tel +
        ", email=" + email +
        ", deptId=" + deptId +
        ", inputtime=" + inputtime +
        ", state=" + state +
        "}";
    }
}
