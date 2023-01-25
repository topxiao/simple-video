package com.zyarn.controller;

import com.zyarn.common.domain.JsonData;
import com.zyarn.entity.FileRecordDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FileRecordController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/fileRecord")
    public String fileRecord() {
        return "fileRecord";
    }

    @GetMapping("/fileRecordPlay")
    public String fileRecordPlay(ModelMap modelMap, String fileUrl) {
        modelMap.put("fileUrl", fileUrl);
        return "fileRecordPlay";
    }

    @ResponseBody
    @GetMapping("/fileRecordData")
    public JsonData fileRecordData() {
        String sql = "select * from t_file_record";
        List<FileRecordDO> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FileRecordDO.class));
        Map<String, Object> map = new HashMap<>();
        map.put("rows", list);
        return JsonData.success(map);
    }
}
