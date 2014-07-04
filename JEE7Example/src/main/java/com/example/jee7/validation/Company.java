package com.example.jee7.validation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class Company {

    @NotNull
    @Size(max = 50)
    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
