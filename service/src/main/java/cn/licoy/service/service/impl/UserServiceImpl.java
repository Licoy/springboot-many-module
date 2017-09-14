package cn.licoy.service.service.impl;

import cn.licoy.service.entity.User;
import cn.licoy.service.mapper.UserMapper;
import cn.licoy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author licoy.cn
 * @version 2017/9/14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }
}
