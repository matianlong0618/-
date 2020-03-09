package com.baomidou.mybatisplus.samples.generator.service.impl;

import com.baomidou.mybatisplus.samples.generator.entity.Users;
import com.baomidou.mybatisplus.samples.generator.mapper.UsersMapper;
import com.baomidou.mybatisplus.samples.generator.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.samples.generator.util.MybatisSqlSessionFactory;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.samples.generator.util.MybatisSqlSessionFactory;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-03-08
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public List<Users> findAll() {
    return usersMapper.findAll();
    }

    @Override
    public boolean addUser(Users users) {
        return usersMapper.addUser(users);
    }

    @Override
    public Users findById(Long id) {
        return usersMapper.findById(id);
    }

    @Override
    public boolean deleteById(Users users) {
        return usersMapper.deleteById(users);
    }

    @Override
    public boolean deleteAll(Users users) {
        return usersMapper.deleteAll(users);
    }

    @Override
    public void deleteMore(String id) {
        // TODO Auto-generated method stub
        List<String> list = getList(id);
        usersMapper.deleteMore(list);
    }
//id放入list,@param id,id(多个已逗号分隔);@return List集合
    public List<String> getList(String id) {
        List<String> list = new ArrayList<String>();
        String[] str = id.split(",");
        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }
        return list;
    }

    @Override
    public Users setById(Users users) {
        return usersMapper.setById(users);
    }

    @Override
    public Users updatePassword(Users users) {
        return usersMapper.updatePassword(users);
    }

    @Override
    public Users login(String name, String password) {
        return usersMapper.login(name, password);
    }
}
