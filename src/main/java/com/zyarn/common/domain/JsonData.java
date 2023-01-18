package com.zyarn.common.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int status;
    private String msg;
    private Object data;

    public static JsonData success(Object data) {
        return new JsonData(0, "success", data);
    }

    public static JsonData error(String msg) {
        return new JsonData(-1, msg, null);
    }
}
