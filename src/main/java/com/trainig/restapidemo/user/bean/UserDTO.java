package com.trainig.restapidemo.user.bean;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDTO {

    private Integer id;
    @Size(min = 2, message = "Name should atleast 2 ")
    private String name;
    @Past(message = "Birth Date must be a past date")
    private LocalDate birthDate;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserDTO user = (UserDTO) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}