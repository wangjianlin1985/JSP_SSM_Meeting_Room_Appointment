// 
// 
// 

package com.em.domain;

import java.util.Date;

public class ReservationVo
{
    private int id;
    private String name;
    private String user;
    private String mobile;
    private Date date;
    private Date beginTime;
    private Date endTime;
    private String mark;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getUser() {
        return this.user;
    }
    
    public void setUser(final String user) {
        this.user = user;
    }
    
    public String getMobile() {
        return this.mobile;
    }
    
    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(final Date date) {
        this.date = date;
    }
    
    public Date getBeginTime() {
        return this.beginTime;
    }
    
    public void setBeginTime(final Date beginTime) {
        this.beginTime = beginTime;
    }
    
    public Date getEndTime() {
        return this.endTime;
    }
    
    public void setEndTime(final Date endTime) {
        this.endTime = endTime;
    }
    
    public String getMark() {
        return this.mark;
    }
    
    public void setMark(final String mark) {
        this.mark = mark;
    }
}
