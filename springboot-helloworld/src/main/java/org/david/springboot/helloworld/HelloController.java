package org.david.springboot.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author david
 * @date 2020/3/31
 */

@RestController
public class HelloController {

    @Autowired
    HelloService helloService ;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){

        String result = helloService.getName("david");

        return "david";
    }
}