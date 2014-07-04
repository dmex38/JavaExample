package com.example.jee7.jpa.converter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Entity
public class EmployeeA implements Serializable {

    @Id
    @Column(name = "NAME")
    private String name;

    @Convert(converter = EmployeeIsActiveConverter.class) //Optional if autoApply = true on @Converter.
    private Boolean isActive;

    public EmployeeA() {
    }

    public EmployeeA(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
