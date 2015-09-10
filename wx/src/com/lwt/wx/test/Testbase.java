package com.lwt.wx.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lwt.wx.dao.IDepartmentDao;
import com.lwt.wx.dao.IProPatternDao;
import com.lwt.wx.dao.IUserDao;
import com.lwt.wx.entity.Department;
import com.lwt.wx.entity.ProCategory;
import com.lwt.wx.entity.User;
import com.lwt.wx.service.IAttachmentService;
import com.lwt.wx.service.IChannelService;
import com.lwt.wx.service.IDepartmentService;
import com.lwt.wx.service.IProCategoryService;
import com.lwt.wx.service.IUserService;
import com.lwt.wx.util.enums.Sex;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")

public class Testbase extends AbstractJUnit4SpringContextTests {
    
@Resource
private IDepartmentService departmentService;
@Resource
private IDepartmentDao departmentDao;
@Resource
private IUserDao userDao;
@Resource
private IUserService userService;
@Resource
private IProPatternDao proPatternDao;
@Resource
private IProCategoryService proCategoryService;
@Resource 
private IAttachmentService attachmentService;
@Resource
private IChannelService channelService;

//@Test
//@Rollback(value=true)
//public void findBeanProp(){
////departmentService.findByPid(1L);
////departmentService.findById(1L);
//Department department=new Department();
//department.setName("银联通莞");
//User user = new User();
//user.setDepartment(department);
//user.setEmail("www.qw@qq.com");
//user.setPassword("123");
//user.setPhone(123211212);
//user.setSex(Sex.MALE);
//user.setUserName("刘备");
//
//departmentService.save(department);
//userDao.save(user);
//}
    @Test
    public void addCategory(){
    	ProCategory category=new ProCategory();
    	category.setName("手机");
    	proCategoryService.save(category);
    }
    @Test
    public void addCy(){
    	String[] a=new String[]{"asd","qwe"};
    	Object[] o=a;
    	System.out.println(o[0]);
    }
    @Test
    public void findatt(){
    	attachmentService.findByProductId(1L);
    	
    }
    @Test
    public void generateTree(){
    	System.out.println(channelService.generateTree().size());
    	
    }
    @Test
    public void updateOrder(){
    	channelService.updateOrders(1l, 2);
    	
    }
    @Test
    public void updateAtt(){
    	//attachmentService.updateIndexPic(new Long[]{38l,39l});
      	attachmentService.updateIsAttach(new Long[]{38l,39l});
    }
}