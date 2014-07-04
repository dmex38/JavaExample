package com.example.jee7.rest;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class MyPojo {

    private String code;

    private String descr;

    public MyPojo() {
    }

    public MyPojo(String code, String descr) {
        this.code = code;
        this.descr = descr;
    }

    public String getCode() {
        return code;
    }

    public String getDescr() {
        return descr;
    }

}
