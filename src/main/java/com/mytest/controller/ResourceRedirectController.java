package com.mytest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用于访问静态界面的Controller
 *
 */
@Controller
public class ResourceRedirectController {

    /**
     * 直接访问jsp资源
     * @param url
     * @return
     */
    @RequestMapping(value = "/redirect/jsp", method = RequestMethod.GET)
    public String redirect2jsp(String url) {
        return url;
    }

}
