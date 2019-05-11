package com.jin.demo.security;

import com.jin.demo.entity.Role;
import com.jin.demo.entity.UserRole;
import com.jin.demo.service.RoleService;
import com.jin.demo.service.UserRoleService;
import com.jin.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author jin
 * @Title: CustomUserService
 * @ProjectName demo
 * @Description: TODO
 * @date 2019/4/2715:37
 */
@Service
public class CustomUserService implements UserDetailsService {
    /**
     * org.slf4j.Logger 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomUserService.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        com.jin.demo.entity.User user = userService.findUserByUsername(userName);
        if (user == null) {
            LOGGER.error("没有找到用户{}", userName);
            throw new UsernameNotFoundException(String.format("没有找到用户 '%s'.", userName));
        }
        Set<GrantedAuthority> authorities = new HashSet<>();
        UserRole userRole = UserRole.builder().userId(user.getUserId()).build();
        List<UserRole> userRoleList = userRoleService.queryAll(userRole);
        for (UserRole ur: userRoleList){
            authorities.add(new SimpleGrantedAuthority(ur.getRoleId()+""));
        }
        return new User(
                userName, user.getPassword(),
                //是否可用
                true,
                //是否过期
                true,
                //证书不过期为true
                true,
                //账户未锁定为true
                "1".equals(user.getStatus()),
                authorities);

    }
}
