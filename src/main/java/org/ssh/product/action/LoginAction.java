package org.ssh.product.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport implements ModelDriven<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//此处必须实例化
	private User user = new User();
	
	public String login(){
		//调用ServletActionContext的方法获得servlet API
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("user", user);
		System.out.println("调用action！" + "\n参数传递：姓名：" + user.getUsername() + "爱好：" + user.getHobbyList().get(0) + user.getHobbyList().get(1));
		
		return SUCCESS;
	}
	//实现接口中的方法，返回在开始处实例化的Model对象
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}	
}
