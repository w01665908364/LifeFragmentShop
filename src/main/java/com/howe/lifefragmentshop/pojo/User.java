package com.howe.lifefragmentshop.pojo;

import java.time.LocalDateTime;

/**
 * 用户实体类
 */
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickname;//昵称
    private String avatar;//头像
    private String role;//角色admin是管理员，user 是用户
    private LocalDateTime createdAt;//注册时间

    // ==================== Getter and Setter ====================

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}