package com.yecc.rpc02;

import com.yecc.rpc.common.IUserService;
import com.yecc.rpc.common.User;

public class UserServiceImpl implements IUserService {
    @Override
    public User findUserById(Integer id) {
        return new User(id, "kobe");
    }
}
