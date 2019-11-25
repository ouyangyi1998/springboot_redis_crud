package com.jerry.springboot_redis_crud.pojo;


import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor

public class User implements Serializable {
    private static final long serialVersionUID = -6818395271462531780L;
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
       return JSONObject.toJSONString(this);
    }
}
