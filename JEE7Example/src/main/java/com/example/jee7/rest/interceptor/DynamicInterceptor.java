package com.example.jee7.rest.interceptor;

import java.lang.reflect.Method;
import javax.ws.rs.GET;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Provider
public class DynamicInterceptor implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        final String resourcePackage = resourceInfo.getResourceClass()
                .getPackage().getName();
        final Method resourceMethod = resourceInfo.getResourceMethod();

        if ("my.package.admin".equals(resourcePackage)
                && resourceMethod.getAnnotation(GET.class) != null) {
            context.register(CompressInterceptor.class);
        }
    }

}
