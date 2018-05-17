package cn.zjn.jx.bigdata.domain.sys;

import java.io.Serializable;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-17 11:37
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class User implements Serializable{


    private static final long serialVersionUID=1L;

    String username;
    String password;
    String companyId;

    public User() {
    }

    public User(String username, String password, String companyId) {
        this.username = username;
        this.password = password;
        this.companyId = companyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}
