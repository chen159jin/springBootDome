package com.jin.demo.security;

import com.jin.demo.common.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * @author jin
 * @Title: config
 * @ProjectName demo
 * @Description: 安全框架配置文件
 * @date 2019/4/2714:15
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomUserService customUserService;

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/js/**", "/login", "/css/**", "/**/favicon.ico", "/img/**", "/images/**", "/lib/**", "/error");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and()
                .formLogin().loginPage("/login").failureUrl("/login?err=1")
                .defaultSuccessUrl("/index").permitAll().and()
                //退出登录后的默认url是"/home"
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=1").permitAll()
                //session失效后跳转
                .and().sessionManagement().invalidSessionUrl("/login");
        //Spring Security 4.0之后，引入了CSRF，默认是开启。 不支持POST提交登录请求
        http.csrf().disable();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                return MD5.md5((String) rawPassword);
//            }
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return encodedPassword.equals(MD5.md5((String) rawPassword));
//            }
//        });
//    }

    /**
     * 无密码方式
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService);
    }

    /**
     * 这个是由于没有使用加密 在spring5.0之后，springsecurity存储密码的格式发生了改变
     *
     * @return
     */
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }


}
