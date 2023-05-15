// 
// 
// 

package com.em.service.impl;

import com.em.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import com.em.dao.UserMapper;
import org.springframework.stereotype.Service;
import com.em.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public User findUserById(final String id) throws Exception {
        return this.userMapper.findUserById(id);
    }
    
    @Override
    public void addNewUser(final User user) throws Exception {
        this.userMapper.addNewUser(user);
    }
}
