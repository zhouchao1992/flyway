package com.zc.flywaydemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserInfo {
    private String id;
    private String name;
    private String age;
    private String sex;
    private String address;
    private String phon;
    private String log_id;

}
