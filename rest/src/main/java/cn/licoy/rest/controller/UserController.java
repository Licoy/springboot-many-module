package cn.licoy.rest.controller;

import cn.licoy.service.entity.User;
import cn.licoy.service.mapper.UserMapper;
import cn.licoy.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author licoy.cn
 * @version 2017/9/13
 */
@RestController
@RequestMapping(value = "/")
public class UserController implements Serializable {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list(){
        List<User> users = new ArrayList<>();
        User user = null;
        for (int i = 0; i < 10; i++) {
            user = User.builder().id(UUID.randomUUID().toString()).age(i*10)
                    .name("李"+i+"娃").build();
            userService.save(user);
            users.add(user);
        }
        return users;
    }

}
