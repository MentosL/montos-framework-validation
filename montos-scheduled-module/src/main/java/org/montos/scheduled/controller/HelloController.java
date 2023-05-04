package org.montos.scheduled.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : MentosL
 * @date : 2023/4/18 21:47
 */
@RestController
@RequestMapping("/hello/")
public class HelloController {

    @RequestMapping("v1")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping("v2/{id}")
    public String v2(@PathVariable String id){
        return "v2-{id}";
    }

    @RequestMapping("v2/id")
    public String v21(){
        return "v2-id";
    }

    @RequestMapping("v3")
    public String v3(@RequestBody Requ re){
        return re.toString();
    }

    public static class Requ{
        private String name;
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
