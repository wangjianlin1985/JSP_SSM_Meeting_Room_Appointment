// 
// 
// 

package com.em.domain;

public class User
{
    private String id;
    private String password;
    private int role;
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public int getRole() {
        return this.role;
    }
    
    public void setRole(final int role) {
        this.role = role;
    }
}
