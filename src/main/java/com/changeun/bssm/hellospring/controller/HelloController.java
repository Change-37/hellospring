package com.changeun.bssm.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody()
    public String hello(){
        return "Hello";
    }

    @GetMapping("/hi")
    public String hi(){
        return "hi";
    }

    @GetMapping("/hi/data")
    public String hiData(Model model){
        model.addAttribute("name", "bssm");
        return "hiData";
    }

    @GetMapping("/hi/param")
    public String hiParam(@RequestParam("data") String data, Model model){
        model.addAttribute("name", data);
        return "hiData";
    }

    @GetMapping("/hello/param")
    @ResponseBody
    public String helloParam(@RequestParam("data") String data){
        return "hello " + data;
    }

    @GetMapping("/hello/api")
    @ResponseBody
    public Person helloApi(@RequestParam("name") String name){
        Person person = new Person();
        person.setName(name);
        return person;
    }

    static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
