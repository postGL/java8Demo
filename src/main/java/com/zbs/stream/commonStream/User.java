package com.zbs.stream.commonStream;

import lombok.Data;

/**
 * description: User
 * date: 2020/7/31 16:46
 * author: zhangbs
 * version: 1.0
 */
@Data
public class User {
    private Long id;
    private String userName;
    private Integer userId;
    private Integer age;
    private Integer gender;
    private String phone;
    private String address;

}
