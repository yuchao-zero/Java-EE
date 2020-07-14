package club.banyuan.entity;

public class User {
    private Integer id;
    private String userName;
    private String password;
    private Long idOfNumber;
    private Long telNumber;
    private String address;
    private Integer postalCode;

    public User(){}

    public User(Integer id, String userName, String password, Long idOfNumber,
        Long telNumber, String address, Integer postalCode) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.idOfNumber = idOfNumber;
        this.telNumber = telNumber;
        this.address = address;
        this.postalCode = postalCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdOfNumber() {
        return idOfNumber;
    }

    public void setIdOfNumber(Long idOfNumber) {
        this.idOfNumber = idOfNumber;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", idOfNumber=" + idOfNumber +
            ", telNumber=" + telNumber +
            ", address='" + address + '\'' +
            ", postalCode=" + postalCode +
            '}';
    }
}

