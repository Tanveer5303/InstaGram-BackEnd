package com.bilal.instaclonebackend.dto;

public class UserDTO {

    private Integer uid;
    private String name;
    private String email;
    private String address;

    public UserDTO() {
    }

    public UserDTO(Integer uid, String name, String email, String address) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
