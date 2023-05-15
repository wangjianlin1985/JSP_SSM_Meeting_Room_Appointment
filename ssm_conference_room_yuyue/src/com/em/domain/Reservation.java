// 
// 
// 

package com.em.domain;

import java.util.Date;

public class Reservation
{
    private int id;
    private int roomId;
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
    
    public int getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(final int roomId) {
        this.roomId = roomId;
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
