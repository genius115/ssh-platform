package org.ssh.product.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.ssh.product.model.Product;
import org.ssh.product.service.ProductService;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.opensymphony.xwork2.ActionSupport;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * 商品操作-控制层
 *
 */
@Controller
@Scope("prototype")
public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ProductService productService;

	private String pname;
	private double price;

	/**
	 * 保存商品操作
	 *
	 * @return
	 * @throws Exception 
	 */
	public String saveProduct() throws Exception {
		try {
		    Algorithm algorithm = Algorithm.HMAC256("secret");
		    String token = JWT.create()
		        .withIssuer("auth0")
		        .sign(algorithm);
		    System.out.println("生成的token："+token);
		} catch (UnsupportedEncodingException exception){
		    //UTF-8 encoding not supported
		} catch (JWTCreationException exception){
		    //Invalid Signing configuration / Couldn't convert Claims.
		}
		
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取浏览器代理的对象
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();
	    OperatingSystem os = userAgent.getOperatingSystem();
	    System.out.println("客户端："+browser+";"+os);
	    Object ob = new Object();
	    Long.parseLong(ob.toString());
	    
		Product product = new Product(pname, price);
		productService.saveProduct(product);
		this.addActionMessage("保存成功...");
//		return SUCCESS;
		throw new NullPointerException();  //手动抛出空指针异常

	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void validate() {

		if (pname == null || "".equals(pname.trim())) {
			this.addFieldError("pname", "商品名称不能为空");
		}

	}

}