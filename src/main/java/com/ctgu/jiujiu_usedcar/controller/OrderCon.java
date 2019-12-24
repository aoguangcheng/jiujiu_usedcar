package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.dao.GoodsDao;
import com.ctgu.jiujiu_usedcar.dao.OrderDao;
import com.ctgu.jiujiu_usedcar.dao.UserDao;
import com.ctgu.jiujiu_usedcar.entity.Goods;
import com.ctgu.jiujiu_usedcar.entity.Order;
import com.ctgu.jiujiu_usedcar.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class OrderCon {
    @Autowired
    GoodsDao goodsDao;

    @Autowired
    UserDao userDao;

    @Autowired
    OrderDao orderDao;

    @RequestMapping("topayPage")
    public String payPage(){
        return "order/payPage";
    }

    @RequestMapping("tocanclePay")
    public String canclePay(HttpSession session){
        Goods goods = (Goods)session.getAttribute("goodsobj");
        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
    }

    @RequestMapping("toensurePay")
    public String ensurePay(Model model,
                            @RequestParam("password1") String password1,
                            @RequestParam("password2") String password2,
                            HttpSession session){

        User user = (User)session.getAttribute("user");
        Goods goods = (Goods)session.getAttribute("goodsobj");
        double balance = Double.parseDouble(user.getBalance());
        double price = Double.parseDouble(goods.getPrice());

        if (password1.equals(password2))
        {
            if(password1.equals(user.getPassword())){
                if(price <= balance)
                {
                    List<Order> orderList = orderDao.findByBuyerAndGoodnum(user.getTelenum(),goods.getGoodNum());
                    if(orderList.size() == 0){
                        Order order = new Order();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm:ss");
//                    插入数据
                        order.setBuyer(user.getTelenum());
                        order.setSeller(goods.getOwner());
                        order.setDescription(goods.getDescription());
                        order.setDate(simpleDateFormat.format(new Date()));
                        order.setGoodnum(goods.getGoodNum());
                        order.setPrice(goods.getPrice());
                        order.setState(1);
                        order.setPic(goods.getPic1());
                        System.out.println(order);
                        orderDao.save(order);

//                    修改余额
                        user.setBalance(String.valueOf(balance - price));
                        userDao.save(user);
                        return "redirect:/toorderApply";
                    }
                    else {
                        model.addAttribute("paytips","已购买");
                        return "order/payPage";
                    }
                }
                else {
                    model.addAttribute("paytips","余额不足");
                    return "order/payPage";
                }
            }
            else {
                model.addAttribute("paytips","密码不正确");
                return "order/payPage";
            }
        }
        else {
            model.addAttribute("paytips","两次密码不一致");
            return "redirect:/orderApply";
        }
    }

//    余额不足，去充值
    @RequestMapping("toaddBalancePage")
    public String addBalancePage(){
        return "redirect:/touserInfo";
    }
//    从主页去我的下单
    @RequestMapping("toorderApply")
    public String orderApply(Model model,
                             HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Order> orderList = orderDao.findByBuyerAndState(user.getTelenum(),1);
        model.addAttribute("applyOrderList",orderList);
        return "order/orderApply";
    }
//    从主页去我的售卖
    @RequestMapping("toorderSold")
    public String orderSold(Model model,
                            HttpSession session){
        User user = (User)session.getAttribute("user");
        List<Order> orderList = orderDao.findBySellerAndState(user.getTelenum(),1);
        model.addAttribute("applyOrderList",orderList);
        List<Order> orderList1 = orderDao.findByBuyerAndState(user.getTelenum(),2);
        model.addAttribute("applyOrderList1",orderList);
        return "order/orderSold";
    }
//    从主页去完结订单
    @RequestMapping("toorderFinish")
    public String orderFinish(){
        return "order/orderFinish";
    }

//    从我的订单调到物品详细，传入的参数是物品编号
    @RequestMapping("/todetailOrderApply/{goodsnum}")
    public String detailOrderApply(@PathVariable("goodsnum") Integer goodsNum){
//        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
//        return "redirect:/todetailGoods/"+ goodsNum;
        return "redirect:/todetailGoods/"+ String.valueOf(goodsNum);
    }


//    传入的参数是订单编号，直接修改订单的状态
    @RequestMapping("/tocancleOrderApply/{orderid}")
    public String cancleOrderApply(@PathVariable("orderid") Integer orderid){
//        return "redirect:/todetailGoods/"+ goods.getGoodNum().toString();
        Order order = orderDao.findByOrderid(orderid);
        order.setState(5);
        orderDao.save(order);
        return "redirect:/toorderApply";
    }
}