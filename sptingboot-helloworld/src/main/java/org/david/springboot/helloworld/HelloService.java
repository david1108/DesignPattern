package org.david.springboot.helloworld;

import org.springframework.stereotype.Service;

/**
 * @author david
 * @date 2020/3/31
 */
@Service
public class HelloService {

    public String getName(String name){

        return "hello world" + name;
    }

}
