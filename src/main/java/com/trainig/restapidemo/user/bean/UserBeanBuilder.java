package com.trainig.restapidemo.user.bean;

import java.time.LocalDate;

public class UserBeanBuilder {
    private Integer id;
    private String name;
    private LocalDate birthDate;

    public UserBeanBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public UserBeanBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserBeanBuilder setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBean createUserBean() {
        return new UserBean(id, name, birthDate);
    }
}