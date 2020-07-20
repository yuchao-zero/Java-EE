package club.banyuan.vo;

import club.banyuan.entity.Order;

public class OrderAndUser extends Order {
    private String loginName;
    private String userName;
    private int sex;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "OrderAndUser{" +
                super.toString()+
                "loginName='" + loginName + '\'' +
                ", userName='" + userName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
