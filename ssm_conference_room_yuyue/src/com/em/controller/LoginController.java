// 
// 
// 

package com.em.controller;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import com.em.domain.User;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController
{
    @RequestMapping(value = { "/login" }, method = { RequestMethod.GET })
    public String loginUI() throws Exception {
        return "../../login";
    }
    
    @RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
    public String login(final User user) throws Exception {
        final UsernamePasswordToken token = new UsernamePasswordToken(user.getId(), user.getPassword());
        final Subject subject = SecurityUtils.getSubject();
        try {
            subject.login((AuthenticationToken)token);
        }
        catch (Exception e) {
            return "/login";
        }
        if (subject.hasRole("admin")) {
            return "redirect:/admin/showRoom";
        }
        if (subject.hasRole("ordinary")) {
            return "redirect:/ordinary/showRoom";
        }
        return "/login";
    }
}
