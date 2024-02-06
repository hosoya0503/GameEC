package jp.ac.morijyobi.game_management.controller.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/").permitAll()   //というURLはログイン無しでアクセスできる
                        .requestMatchers("/common/**").permitAll()
                        .requestMatchers("/tag/**").hasRole("ADMIN")
                        .requestMatchers("/book/list").permitAll()
                        .requestMatchers("/book/**").hasAnyRole("ADMIN","GENERAL")
                        .anyRequest().authenticated()    //それ以外のURLはログインが必要
                ).formLogin(Login -> Login
                        .loginProcessingUrl("/login")  //ユーザーID・PWの送信先URL(POST)
                        .loginPage("/login")  //ログイン画面のURL(URL)
                        .defaultSuccessUrl("/")   //ログイン成功時のリダイレクト先URL
                        .failureUrl("/login?error")   //ログイン失敗時のリダイレクト先
                        .permitAll()    //ログイン画面のアクセス先
                );

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}