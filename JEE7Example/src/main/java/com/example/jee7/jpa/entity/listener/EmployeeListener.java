package com.example.jee7.jpa.entity.listener;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
public class EmployeeListener {

    @PrePersist
    public void prePersist(EmployeeB c) {

    }

    @PostPersist
    public void postPersist(EmployeeB c) {

    }

    @PostLoad
    public void postLoad(EmployeeB c) {

    }

    @PreUpdate
    public void preUpdate(EmployeeB c) {

    }

    @PostUpdate
    public void postUpdate(EmployeeB c) {

    }

    @PreRemove
    public void preRemove(EmployeeB c) {

    }

    @PostRemove
    public void postRemove(EmployeeB c) {

    }

}
