package com.ctgu.jiujiu_usedcar.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadConfig {
    /**上传地址*/
//    @Value("${file.upload.path.relative}")
    @Value("${file.upload.path}")
    private String filePath = "C://images/";

    private String completeFilepath;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCompleteFilepath() {
        return completeFilepath;
    }

    public void setCompleteFilepath(String completeFilepath) {
        this.completeFilepath = completeFilepath;
    }

    public void uploadFile(MultipartFile file){
        String oldfilename = file.getOriginalFilename();
        System.out.println("初始的文件名"+oldfilename);
        String filename = (new RandomStringUtil().getRandomString(18)) +"-"+ oldfilename;

        System.out.println("添加随机字符串后的文件名：" + filename);
        // 定义上传文件保存路径
        String path = filePath+"rotPhoto/";
        // 新建文件
        System.out.println("文件上传的路径：" + filePath);
        File filepath = new File(path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("文件名："+filename);
        System.out.println("文件路径：" + path);
        System.out.println("文件完整路径" + filepath);
        // 将src路径发送至html页面
        //       model.addAttribute("filename", path+filename);
        //存储在数据库的路径："/images/rotPhoto/"+filename
//        model.addAttribute("filename", "/images/rotPhoto/"+filename);
        this.completeFilepath = "/images/rotPhoto/"+filename;
    }
}
