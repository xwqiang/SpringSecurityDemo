package com.hskj.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.hskj.controller.TestService;

/**
 * 
 * �����ڳ�ʼ��ʱ��Ӧ��ȡ��������Դ�����Ӧ��ɫ�Ķ���
 * 
 * 
 */
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();;
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    /*
     * ģ��service Ϊʲôע�벻��ȥ���������� LoginController ��test�����ܹ�ע�롣����������������������
     */
    private TestService test;
    public MyInvocationSecurityMetadataSource( TestService test) {
    	this.test = test;
        loadResourceDefine();
    }
    private void loadResourceDefine() {
    	resourceMap = test.get(resourceMap);
//        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
//        Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
//        ConfigAttribute ca11 = new SecurityConfig("ROLE_ADMIN");
//        ConfigAttribute ca12 = new SecurityConfig("ROLE_DEV");
//        atts.add(ca11);
//        atts.add(ca12);
//        
//        Collection<ConfigAttribute> atts2 = new ArrayList<ConfigAttribute>();
//        ConfigAttribute ca21 = new SecurityConfig("ROLE_OTHER");
//        atts2.add(ca21);
//        //��ȡurl ÿ��url����Ӧ�Ľ�ɫ����Щ 
//        resourceMap.put("/login.do", atts);
//        resourceMap.put("/test.do", atts);
//        
//        resourceMap.put("/other.do", atts2);
        
    }

    // According to a URL, Find out permission configuration of this URL.
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        // guess object is a URL.
        String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            if (urlMatcher.pathMatchesUrl(resURL, url)) {
                 return resourceMap.get(resURL);
            }
        }
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
    
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

}