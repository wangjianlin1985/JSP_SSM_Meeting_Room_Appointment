// 
// 
// 

package com.em.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import com.em.domain.User;
import java.util.Set;
import java.util.HashSet;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import com.em.service.RoleService;
import javax.annotation.Resource;
import com.em.service.UserService;
import org.springframework.stereotype.Component;
import org.apache.shiro.realm.AuthorizingRealm;

@Component
public class LoginRealm extends AuthorizingRealm
{
    @Resource(name = "userServiceImpl")
    private UserService userService;
    @Resource(name = "roleServiceImpl")
    private RoleService roleService;
    
    protected AuthorizationInfo doGetAuthorizationInfo(final PrincipalCollection principalCollection) {
        final String id = (String)this.getAvailablePrincipal(principalCollection);
        String role = null;
        try {
            final User user = this.userService.findUserById(id);
            final Integer i = user.getRole();
            role = this.roleService.findNameById(i);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        final SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        final Set<String> set = new HashSet<String>();
        if (role != null) {
            set.add(role);
            info.setRoles((Set)set);
        }
        return (AuthorizationInfo)info;
    }
    
    protected AuthenticationInfo doGetAuthenticationInfo(final AuthenticationToken token) throws AuthenticationException {
        final String id = (String)token.getPrincipal();
        final String password = new String((char[])token.getCredentials());
        User user = null;
        try {
            user = this.userService.findUserById(id);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if (user == null) {
            throw new UnknownAccountException("\u6b64\u7528\u6237\u4e0d\u5b58\u5728\uff01");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("\u5bc6\u7801\u9519\u8bef");
        }
        final AuthenticationInfo loginInfo = (AuthenticationInfo)new SimpleAuthenticationInfo((Object)id, (Object)password, this.getName());
        return loginInfo;
    }
}
