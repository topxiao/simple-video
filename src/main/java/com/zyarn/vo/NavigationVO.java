package com.zyarn.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NavigationVO {

    private String icon;
    private String text;
    private String link;
    private boolean blank;
}
