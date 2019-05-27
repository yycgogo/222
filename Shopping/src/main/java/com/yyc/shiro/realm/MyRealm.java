package com.yyc.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yyc.dao.SysUserDao;
import com.yyc.pojo.SysUser;



/**  
* Title: MyRealm.java 
* Description: 
* Copyright: Copyright (c) 2018    
* @author zhh  
* @date 2019年4月23日  
* @version 1.0  
*/
public class MyRealm extends AuthorizingRealm{
	
	@Autowired
	private SysUserDao dao;

	/* 授权
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* 认证
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token=
				(UsernamePasswordToken)arg0;
		String username=token.getUsername();//用户名
		String password=new String(token.getPassword());//密码
		//对前端传进来的参数进行加密
		SimpleHash simpleHash=new SimpleHash("Md5", password, username, 1024);
		String md5pwd=simpleHash.toString();
		SysUser user=dao.findByNameAndPwd(username, md5pwd);
//		LoginUser user=dao.findByNamdAndPwd(username, md5pwd);//查询数据库
		AuthenticationInfo info=null;
		if(user!=null){//登录成功
			//SimpleAuthenticationInfo（主体信息可以为用户主体，密码(用户传进来的原始字符串)，realname的名称）
			info=new SimpleAuthenticationInfo(username,
					password,getName());
					
		}else{//登录失败
			throw new AuthenticationException();
		}
		return info;
	}
	public static void main(String[] args) {
		SimpleHash simpleHash=new SimpleHash("Md5", "123", "boogie@admin.com", 1024);
		System.out.println(simpleHash);
	}
}
