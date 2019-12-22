package com.ctgu.jiujiu_usedcar.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderCon {

    @RequestMapping("topayPage")
    public String ayPage(){
        return "order/payPage";
    }

}
