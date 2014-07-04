package com.example.jee7.jpa.entity.listener;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.Id;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Entity
@EntityListeners(EmployeeListener.class)
//@ExcludeDefaultListeners
//@ExcludeSuperclassListeners
public class EmployeeB implements Serializable {

    @Id
    @Column(name = "NAME")
    private String name;

    public EmployeeB() {
    }

    public EmployeeB(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
