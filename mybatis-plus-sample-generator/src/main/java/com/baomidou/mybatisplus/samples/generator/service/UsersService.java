package com.baomidou.mybatisplus.samples.generator.service;

import com.baomidou.mybatisplus.samples.generator.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-03-08
 */
@Service
public interface UsersService extends IService<Users> {

    public List<Users> findAll();

    public boolean addUser(Users users);

    public Users findById(Long id);

    public boolean deleteById(Users users);

    public boolean deleteAll(Users users);

//    public boolean deleteMore(int[] arr);
    public void deleteMore(String id);

    public Users setById(Users users);

    //用@Param("password")来获取到usersService传过来的参数，不能少，否则接收不了参数
    //Integer updatePassword(@Param("password") String password,@Param("id") Integer uid);


    public Users updatePassword(Users users);


    // 登录
    Users login(String name, String password);
}
