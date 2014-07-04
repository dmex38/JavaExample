package com.example.jee7.rest.beanparam;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 *
 * @author David EXCOFFIER <david.excoffier@st.com>
 */
public class BeanParam1 {

    @HeaderParam("header")
    private String headerParam;

//    @CookieParam(value = "User-Agent") 
//    String userAgent
    @PathParam("username")
    private String username;

    @QueryParam("q")
    @DefaultValue("TOTO")
    private String queryParam;

    public String getQueryParam() {
        return queryParam;
    }
}
