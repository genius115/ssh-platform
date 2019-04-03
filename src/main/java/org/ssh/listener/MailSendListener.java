package org.ssh.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

import org.ssh.task.MailSendTask;

/**
 * 
 * 文件发送的监听 需要再WEB-XML中配置
 */
public class MailSendListener extends HttpServlet implements ServletContextListener {

	/**
	 * 监听开始销毁
	 */
	public void contextDestroyed(ServletContextEvent sce) {

	}

	/**
	 * 监听开始执行
	 */
	public void contextInitialized(ServletContextEvent sce) {
		// 当监听开始执行时,设置一个TIME
		Timer timer = new Timer();
		System.out.println("-------MailSend   Timer开始进行执行--------------");
		MailSendTask msendTask = new MailSendTask();
		timer.schedule(msendTask, 60 * 1000, 10 * 1000);
		System.out.println("-------MailSend   Timer已经在执行--------------");
	}
}
