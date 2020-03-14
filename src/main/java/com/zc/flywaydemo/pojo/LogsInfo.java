package com.zc.flywaydemo.pojo;

import java.util.Date;

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

    public LogsInfo() {
    }

    public LogsInfo(String id, String logtype, String logurl, String logip, String logdz, String ladduser, String lfadduser, Date laddtime, String htmlname) {
        this.id = id;
        this.logtype = logtype;
        this.logurl = logurl;
        this.logip = logip;
        this.logdz = logdz;
        this.ladduser = ladduser;
        this.lfadduser = lfadduser;
        this.laddtime = laddtime;
        this.htmlname = htmlname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogtype() {
        return logtype;
    }

    public void setLogtype(String logtype) {
        this.logtype = logtype;
    }

    public String getLogurl() {
        return logurl;
    }

    public void setLogurl(String logurl) {
        this.logurl = logurl;
    }

    public String getLogip() {
        return logip;
    }

    public void setLogip(String logip) {
        this.logip = logip;
    }

    public String getLogdz() {
        return logdz;
    }

    public void setLogdz(String logdz) {
        this.logdz = logdz;
    }

    public String getLadduser() {
        return ladduser;
    }

    public void setLadduser(String ladduser) {
        this.ladduser = ladduser;
    }

    public String getLfadduser() {
        return lfadduser;
    }

    public void setLfadduser(String lfadduser) {
        this.lfadduser = lfadduser;
    }

    public Date getLaddtime() {
        return laddtime;
    }

    public void setLaddtime(Date laddtime) {
        this.laddtime = laddtime;
    }

    public String getHtmlname() {
        return htmlname;
    }

    public void setHtmlname(String htmlname) {
        this.htmlname = htmlname;
    }
}
