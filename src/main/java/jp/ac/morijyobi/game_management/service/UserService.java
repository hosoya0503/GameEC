package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.User;
import jp.ac.morijyobi.game_management.bean.form.UserForm;

public interface UserService {
    User registerUser(UserForm userForm);
}