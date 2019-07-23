package com.cy.sys.service.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.sys.dao.SysUserDao;
import com.cy.sys.pojo.SysUser;

/**
 * 	完成认证信息的获取与封装
 * @author admin
 *
 */
@Service
public class ShiroUserRealm extends AuthorizingRealm{
	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//1.获取用户名(用户页面输入 )
		UsernamePasswordToken  upToken = (UsernamePasswordToken)token;
		String username = upToken.getUsername();
		//2.基于用户名查询
		SysUser user = sysUserDao.findUserByUserName(username);
		//3.判定用户名是否存在
		if(user==null)
			throw new UnknownAccountException();	
		//4.判定用户是否被禁用
		//5.封装用户信息
		//ByteSource.Util.bytes(user.getSalt());
		//6.返回封装结果
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
		return info;
	}

}
