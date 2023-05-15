// 
// 
// 

package com.em.dao;

import com.em.domain.User;

public interface UserMapper
{
    User findUserById(String p0);
    
    void addNewUser(User p0);
}
