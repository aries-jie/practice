package com.aries.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadFileController {

    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file to upload.";
        }
        System.out.println(file.getOriginalFilename());

        // TODO: 这里可以添加文件上传的业务逻辑

        return file.getOriginalFilename();
    }

}
