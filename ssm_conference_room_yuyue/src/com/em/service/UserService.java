// 
// 
// 

package com.em.service;

import com.em.domain.User;

public interface UserService
{
    User findUserById(String p0) throws Exception;
    
    void addNewUser(User p0) throws Exception;
}
