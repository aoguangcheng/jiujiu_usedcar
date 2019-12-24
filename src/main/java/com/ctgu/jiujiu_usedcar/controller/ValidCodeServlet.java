package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.RandomStringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@Controller
public class ValidCodeServlet extends HttpServlet {
    private static final long serialVersionUID = 7785319966330896339L;
    String VerificationCode;
    //设置字母的大小,大小
    private Font mFont = new Font("Times New Roman", Font.PLAIN, 20);
    public void init() throws ServletException
    {
        super.init();
    }
    Color getRandColor(int fc,int bc)
    {
        Random random = new Random();
        if(fc>255) fc=255;
        if(bc>255) bc=255;
        int r=fc+random.nextInt(bc-fc);
        int g=fc+random.nextInt(bc-fc);
        int b=fc+random.nextInt(bc-fc);
        return new Color(r,g,b);
    }

   @GetMapping("code")
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);
        //表明生成的响应是图片
        response.setContentType("image/jpeg");

        int width=80, height=18;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200,250));
        g.fillRect(1, 1, width-1, height-1);
        g.setColor(new Color(102,102,102));
        g.drawRect(0, 0, width-1, height-1);
        g.setFont(mFont);

        g.setColor(getRandColor(160,200));

        //画随机线
        for (int i=0;i<155;i++)
        {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(6) + 1;
            int yl = random.nextInt(12) + 1;
            g.drawLine(x,y,x + xl,y + yl);
        }

        //从另一方向画随机线
        for (int i = 0;i < 70;i++)
        {
            int x = random.nextInt(width - 1);
            int y = random.nextInt(height - 1);
            int xl = random.nextInt(12) + 1;
            int yl = random.nextInt(6) + 1;
            g.drawLine(x,y,x - xl,y - yl);
        }

        //生成随机数,并将随机数字转换为字母
        String sRand="";
        for (int i=0;i<4;i++)
        {
            VerificationCode = RandomStringUtil.getRandomString(4);
//            String ctmp = VerificationCode;
            sRand += String.valueOf(VerificationCode);
            g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            g.drawString(String.valueOf(VerificationCode),15*i+10,16);
        }

        HttpSession session = request.getSession(true);
        System.out.println(sRand);
        session.setAttribute("code",sRand);
        g.dispose();
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }

}

