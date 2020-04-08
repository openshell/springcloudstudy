package cn.caiqz.service.provider.service;


import cn.caiqz.service.provider.mapper.UserMapper;
import cn.caiqz.service.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author openshell
 * @since 2020-04-07
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
