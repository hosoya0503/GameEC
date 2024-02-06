package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.User;
import jp.ac.morijyobi.game_management.bean.form.UserForm;
import jp.ac.morijyobi.game_management.constants.AccountRoleConstants;
import jp.ac.morijyobi.game_management.mapper.UsersMapper;
import jp.ac.morijyobi.game_management.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UsersMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(UsersMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User registerUser(UserForm userForm) {
        User user= new User();
        user.setUsername(userForm.getUsername());
        user.setPassword(userForm.getPassword());
        String hashedPassword = passwordEncoder.encode(userForm.getPassword());
        user.setPassword(hashedPassword);
        user.setName(userForm.getName());
        user.setAuthorityId(AccountRoleConstants.GENERAL);

        userMapper.insertUser(user);

        return null;
    }
}