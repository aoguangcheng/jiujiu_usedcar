package com.ctgu.jiujiu_usedcar.controller;

import com.ctgu.jiujiu_usedcar.config.UploadConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    /**上传地址*/
//    @Value("${file.upload.path}")
//    private String filePath;

    // 跳转上传页面
    @RequestMapping("test")
    public String test() {
        return "uploadpage";
    }

    // 执行上传
//    @RequestMapping("upload")
//    public String upload(@RequestParam("file") MultipartFile file, Model model) {
//        // 获取上传文件名
//        String oldfilename = file.getOriginalFilename();
//        System.out.println("初始的文件名"+oldfilename);
//        String filename = (new RandomStringUtil().getRandomString(18)) +"-"+ oldfilename;
//
//        System.out.println("添加随机字符串后的文件名：" + filename);
//        // 定义上传文件保存路径
//        String path = filePath+"rotPhoto/";
//        // 新建文件
//        File filepath = new File(path, filename);
//        // 判断路径是否存在，如果不存在就创建一个
//        if (!filepath.getParentFile().exists()) {
//            filepath.getParentFile().mkdirs();
//        }
//        try {
//            // 写入文件
//            file.transferTo(new File(path + File.separator + filename));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("文件名："+filename);
//        System.out.println("文件路径：" + path);
//        System.out.println("文件完整路径" + filepath);
//        // 将src路径发送至html页面
//        //       model.addAttribute("filename", path+filename);
//        //存储在数据库的路径："/images/rotPhoto/"+filename
//        model.addAttribute("filename", "/images/rotPhoto/"+filename);
//        return "uploadpage";
//    }
    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        UploadConfig uploadConfig = new UploadConfig();
        uploadConfig.uploadFile(file);
        model.addAttribute("filename",uploadConfig.getCompleteFilepath());
        return "uploadpage";
    }

}