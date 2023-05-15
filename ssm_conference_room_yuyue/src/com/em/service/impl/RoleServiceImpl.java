// 
// 
// 

package com.em.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.em.dao.RoleMapper;
import org.springframework.stereotype.Service;
import com.em.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    private RoleMapper roleMapper;
    
    @Override
    public String findNameById(final Integer roleId) throws Exception {
        return this.roleMapper.findNameById(roleId);
    }
}
