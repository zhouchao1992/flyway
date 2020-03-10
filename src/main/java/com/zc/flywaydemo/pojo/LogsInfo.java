package com.zc.flywaydemo.pojo;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class LogsInfo {
    private String id;
    private String logtype;
    private String logurl;
    private String logip;
    private String logdz;
    private String ladduser;
    private String lfadduser;
    private Date laddtime;
    private String htmlname;
}
