package com.video.Database;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.video.Bean.Chek;
import com.video.Bean.User;



public class AllMethod {
	
	private DatabaseCon conn;//封装数据库连接
	private PreparedStatement ps; //预处理
	private ResultSet rs;//结果集
	private Connection connection;
    
	private User users;//声明一个Users对象
	//List<User> allusers;//声明一个返回所有用户的结果集
	
	boolean check;//判断账号密码是否正确
	
	public AllMethod(){
		
		this.conn = new DatabaseCon();
		this.connection = (Connection) conn.getConnection();
		this.rs = null;
		this.ps = null;
		
		
		
	}
	
	public Chek CheckLogin(User user){
		//判断账号密码登录方法
		Chek ck2 = new Chek();//实例化一个返回值的对象
		check = false;//初始值为false

		String sql="SELECT username,passwd,time FROM user WHERE username=? and passwd=?";
		
		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPasswd());
           
            rs = ps.executeQuery();
               
            while (rs.next()) {
            	
            	check = true;//有结果集就返回成功，也就是登录成功
				ck2.setChek(check);//调用返回值属性类的setChek方法
				ck2.setTime(rs.getString("time"));//调用返回值属性类的setTime方法,把查询到的时间加进去
				
			}
			
            //关闭连接
			conn.closeResultSet(rs);
			conn.closeStatement(ps);
            conn.closeConnection(connection);
            
			
		  } catch (SQLException e) {
			
			e.printStackTrace();
		}
 
		       return ck2;
	}
	
	/*
	 * 我放弃了这种做法，因为多个Servlet不好做数据之间的交换，除非用Spring MVC框架(不会~~)
     * 所以查找所有用户的页面写用的是最原始的方法-把SQL写在页面中。
     * 
         public List<User> All(){
		//查询并且显示所有用户方法
		
		String sql = "SELECT * FROM user";
		allusers = new ArrayList<User>();
		
		try {
			//预处理
			ps = (PreparedStatement) connection.prepareStatement(sql);
			
			//执行查询。
			 rs = ps.executeQuery();
			 
            while(rs.next()){
            	users = new User();
            	users.setId(rs.getInt("id"));
            	users.setUsername(rs.getString("username"));
            	users.setPasswd(rs.getString("passwd"));
            	users.setTime(rs.getString("time"));         	
            	allusers.add(users);//将查询到的所有商品添加到集合中
            	
            }
			//关闭查询
            conn.closeResultSet(rs);
			conn.closeStatement(ps);
			conn.closeConnection(connection);
			
		   } catch (SQLException e) {
			e.printStackTrace();
		}
		return allusers;
	}
	*/
	public void Add(User users){
		
		//添加用户方法
		
		String sql = "INSERT INTO user (username, passwd, time,beizhu) values(?,?,?,?)";
		try {
			//预处理，准备向数据库插入新的用户
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, users.getUsername());
			ps.setString(2, users.getPasswd());
			ps.setString(3, users.getTime());
			ps.setString(4, users.getBeizhu());
			//执行查询。
			ps.executeUpdate();
			//关闭查询
			
			conn.closeStatement(ps);
			conn.closeConnection(connection);
				
		   } catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Del(String id){
		      //删除方法
		     
				String sql = "DELETE FROM user WHERE id=?;";
				try {
					//预处理
					ps = (PreparedStatement) connection.prepareStatement(sql);
					ps.setString(1, id);
					//执行查询。
					ps.executeUpdate();
					//关闭查询
					
					conn.closeStatement(ps);
					conn.closeConnection(connection);
						
				   } catch (SQLException e) {
					e.printStackTrace();
				}
	         }
	public User findOneAll(int id) {
		User user =new User();	
		String sql = "select * from user where id =?;";
		try {
			//预处理
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setInt(1, id);
			//执行查询。
			rs = ps.executeQuery();
				
			while(rs.next()){
				
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPasswd(rs.getString("passwd"));
				user.setTime(rs.getString("time"));
				user.setBeizhu(rs.getString("beizhu"));
			}
			
			    conn.closeResultSet(rs);
				conn.closeStatement(ps);
				conn.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
		return user;
	}	
	public void Up(User users){
		
		//更新用户属性方法
		
		String sql = "UPDATE user SET username=?,passwd=?,time=?,beizhu=? WHERE id=?;";
		try {
			//预处理
			ps = (PreparedStatement) connection.prepareStatement(sql);
			ps.setString(1, users.getUsername());
			ps.setString(2, users.getPasswd());
			ps.setString(3, users.getTime());
			ps.setString(4, users.getBeizhu());
			ps.setInt(5, users.getId());
			//执行查询。
			ps.executeUpdate();
			//关闭查询
			
			conn.closeStatement(ps);
			conn.closeConnection(connection);
				
		   } catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public int SQLall(){
		
		//统计会员总人数
		int sqlalluser = 0;
		String sql = "select count(*) aLLSQL from user";
		try {
			//预处理
			ps = (PreparedStatement) connection.prepareStatement(sql);
			
			//执行查询。
			 rs = ps.executeQuery();
			while(rs.next()){
				sqlalluser = rs.getInt("aLLSQL");
				
			} 
			
			conn.closeStatement(ps);
			conn.closeConnection(connection);
				
		   } catch (SQLException e) {
			e.printStackTrace();
		}
		return sqlalluser;
		
	}
	public boolean findByUsername(String username){
	//Ajax判断用户是否存在方法
		boolean isExist = false;
		String sql = "select * from user where username=?";

		try {
			ps = (PreparedStatement) connection.prepareStatement(sql);
			
			ps.setString(1, username);
			
			rs = ps.executeQuery();//执行
			
			if(rs.next()){
				isExist = true;
			}
			
			 
				conn.closeStatement(ps);
				conn.closeConnection(connection);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist;
	}
		
	
}
