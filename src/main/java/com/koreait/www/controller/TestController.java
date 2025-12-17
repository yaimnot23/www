package com.koreait.www.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.stream.IntStream;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
@Slf4j
public class TestController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("msg","Test Thymeleaf");
        List<String> list = Arrays.asList("one", "two", "three");
        model.addAttribute("list", list);

                return "index";
    }

    @GetMapping("/ex01")
    public String ex01(Model model){
        List<String> list = Arrays.asList("ok", "no", "maybe");
        model.addAttribute("list", list);
        return "/ex01/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name, @RequestParam("age") int age, Model model) {
        log.info("name : {}", name);
        log.info("age : {}", age);
        TestVO testVO = new TestVO(name,age);
        model.addAttribute("testVO", testVO);
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "/ex01/ex02";
    }

    @GetMapping("/ex03")
    public String ex03(Model model){
        List<String> strList = IntStream.range(1,10)
                .mapToObj(i -> "data"+i)
                .toList();
        log.info("strList : {}", strList);
        model.addAttribute("strList", strList);

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 100);
        map.put("two", 200);
        map.put("three", 300);
        map.put("four", 400);
        model.addAttribute("map", map);

        List<TestVO> testList = new ArrayList<>();
        testList.add(new TestVO("qqq",100));
        testList.add(new TestVO("www",200));
        testList.add(new TestVO("eee",300));
        testList.add(new TestVO("rrr",400));
        testList.add(new TestVO("ttt",500));
        model.addAttribute("testList", testList);

        return "/ex01/ex03";
    }






    
}


