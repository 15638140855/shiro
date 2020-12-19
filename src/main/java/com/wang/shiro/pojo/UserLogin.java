package com.wang.shiro.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin extends VoUserLogin implements Serializable {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private String user_phone;
    private String user_email;
    private String user_qx;
}
