package com.shine.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shine.mapper.UserMapper;
import com.shine.model.User;
import com.shine.model.UserExample;
import com.shine.model.vo.CodeMsg;
import com.shine.model.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper mapper;

    public Result add(User user){
        int row = mapper.insertSelective(user);//只插入值不为null的属性
        if (row==1) return Result.ok();

        return Result.error(CodeMsg.REQUEST_ERROR);
    }
    public Result updateById(int id){
//        int row = mapper.deleteByPrimaryKey(id);
        User user = new User()
                .withUid(id)
                .withEnabled(false);
        // 禁用用户，而不是物理删除
        int row = mapper.updateByPrimaryKeySelective(user);
        if (row==1) return Result.ok();

        return Result.error(CodeMsg.REQUEST_ERROR);
    }
    public Result update(User user){
        int row = mapper.updateByPrimaryKeySelective(user);
        if (row==1) return Result.ok();
        return Result.error(CodeMsg.REQUEST_ERROR);
    }

    public Result getPage(int page,int size){
        UserExample example = new UserExample();
        example.createCriteria()
                .andEnabledNotEqualTo(false)
                .getAllCriteria();
        PageHelper.startPage(page,size);
        List<User> list =  mapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(list);
        long count = pageInfo.getTotal();
        return Result.success (list,count);
    }
    public Result updateByIds(List<Integer> ids){
        User user = new User();
        user.withEnabled(false);
        UserExample example = new UserExample();
        example.createCriteria()
        .andUidIn(ids);
        mapper.updateByExampleSelective(user,example);
        return Result.ok();
    }

}
