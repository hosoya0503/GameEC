package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.dto.LoginUserDto;
import jp.ac.morijyobi.game_management.controller.security.LoginUserDetails;
import jp.ac.morijyobi.game_management.mapper.UsersMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    private final UsersMapper usersMapper;
    public LoginUserDetailsService(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUserDto user = usersMapper.selectUserByUsername(username);

        if ( user == null ){
            throw new UsernameNotFoundException("ユーザーがみつかりません");
        }
        return new LoginUserDetails(user);
    }
}