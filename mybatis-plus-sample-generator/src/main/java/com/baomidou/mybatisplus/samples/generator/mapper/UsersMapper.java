package com.baomidou.mybatisplus.samples.generator.mapper;

import com.baomidou.mybatisplus.samples.generator.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 *  dao层
 * </p>
 *
 * @author ML
 * @since 2020-03-08
 */
@Mapper
@Repository
public interface UsersMapper extends BaseMapper<Users> {

    public List<Users> findAll();

    public boolean addUser(Users users);

    public Users findById(Long id);

    public boolean deleteById(Users users);

    public boolean deleteAll(Users users);

//    public boolean deleteMore(int[] arr);
    public void deleteMore(List<String> list);
//删除实现类
//      public boolean deleteMore(int[] arr) {
//        SqlSession sqlSession = null;
//        try {
//            sqlSession = MybatisSqlSessionFactory.getMySqlSession();
//            int result = sqlSession.delete("cn.sz.hcq.pojo.Emp.deleteMoreEmp",
//                    arr);
//            sqlSession.commit();
//            return result > 0 ? true : false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            sqlSession.rollback();
//        } finally {
//            MybatisSqlSessionFactory.closeSqlSession();
//        }
//        return false;
//    }

    public Users setById(Users users);

    //用@Param("password")来获取到usersService传过来的参数，不能少，否则接收不了参数
    public Users updatePassword(Users users);

    Users login(@Param("name")String name,@Param("password")String password);

}
