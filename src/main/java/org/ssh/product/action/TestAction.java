package org.ssh.product.action;

import javax.annotation.Resource;

import org.junit.Assert;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.Product;
import org.ssh.product.model.User;
import org.ssh.product.service.ProductService;

@Controller
@Scope("prototype")
public class TestAction extends BaseAction<Product> {
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = -4549098226452866964L;
	private ProductService productService;

	private String role;
	
	public ProductService getProductService() {
		return productService;
	}

	@Resource(name = "productServiceImpl")
	public void setDepartmentService(ProductService productService) {
		this.productService = productService;
	}
		
	public String add() {
		productService.save(this.t);
		return "toList";
	}
	
	
    @Override
    public String execute() throws Exception {
    	 if ("student".equals(role)) {
           /*  LoginDao logindao = new LoginDaoImpl();
             if (logindao.studentlogin(student)) {
                 return "studentsuccess";
             } else {
                 return ERROR;
             }*/
         }else if("teacher".equals(role)){
            /* LoginDao logindao=new LoginDaoImpl();
             if(logindao.teacherlogin(teacher)){
                 return "teachersuccess";
             }else{
                 return ERROR;
             }*/
         }
    	 User user1 = new User();
    	 user1.setUsername("username1");
    	 User user2 = new User();
    	 user2.setPassword("pwd2");
    	 BeanUtils.copyProperties(user1, user2);
         return role;
    } 
}
