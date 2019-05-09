package com.jin.demo.security;

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
import java.util.List;


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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(userName);
        if (user == null) {
            LOGGER.error("没有找到用户{}", userName);
            throw new UsernameNotFoundException(String.format("没有找到用户 '%s'.", userName));
        }
        List<GrantedAuthority> authList = new ArrayList<>();
        GrantedAuthority gauth = new SimpleGrantedAuthority(user.getOneuser());
        authList.add(gauth);
        return new User(user.getOneuser(), user.getPassword()
                , authList);

    }
}
