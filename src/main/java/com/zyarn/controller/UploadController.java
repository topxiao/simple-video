package com.zyarn.controller;

import com.zyarn.common.domain.JsonData;
import com.zyarn.utils.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 上传文件处理
 */
@Controller
public class UploadController {

    /**
     * 自定义 Minio 服务器上传请求
     */
    @ResponseBody
    @PostMapping("/uploadMinio")
    public JsonData uploadFileMinio(MultipartFile file) throws Exception {
        try {
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.uploadMinio(file);
            Map<String, Object> map = new HashMap<>();
            map.put("url", fileName);
            map.put("fileName", fileName);
            map.put("originalFilename", file.getOriginalFilename());
            return JsonData.success(map);
        } catch (Exception e) {
            return JsonData.error(e.getMessage());
        }
    }
}
