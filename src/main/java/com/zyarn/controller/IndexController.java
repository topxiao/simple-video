package com.zyarn.controller;

import com.zyarn.common.domain.JsonData;
import com.zyarn.vo.NavigationVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/amisplayer")
    public String amisplayer() {
        return "amisplayer";
    }


    @GetMapping("/aliplayer")
    public String aliplayer() {
        return "aliplayer";
    }

    @GetMapping("/gridNav")
    public String gridNav() {
        return "gridNav";
    }

    @GetMapping("/gridNavData")
    @ResponseBody
    public JsonData gridNavData() {
        List<NavigationVO> navigationVOS = Arrays.asList(
                new NavigationVO("https://internal-amis-res.cdn.bcebos.com/images/icon-1.png", "外部跳转", "https://www.baidu.com", true),
                new NavigationVO("https://internal-amis-res.cdn.bcebos.com/images/icon-1.png", "弹框", "https://www.baidu.com", true),
                new NavigationVO("https://internal-amis-res.cdn.bcebos.com/images/icon-1.png", "内部跳转", "https://www.baidu.com", true),
                new NavigationVO("https://internal-amis-res.cdn.bcebos.com/images/icon-1.png", "导航4", "https://www.baidu.com", true)
        );
        Map<String, Object> map = new HashMap<>();
        map.put("items", navigationVOS);
        return JsonData.success(map);
    }
}
