package org.ssh.task;

import java.util.Date;
import java.util.TimerTask;

/**
 * JAVA 一个定时任务
 * 
 * @author Guox2011-05-10
 * 
 */
public class MailSendTask extends TimerTask {

	public MailSendTask() {

	}

	/**
	 * RUN方法放入一个SCHEDULE的时候 进行执行 一个定时程序执行的进口
	 */
	public void run() {
		System.out.println(new Date() + "---MailSendTask begin to RUN ------------");
		/*MailSendManager mainSendManager = new MailSendManager();
		mainSendManager.waitingMailRemind();*/
		System.out.println("定时任务执行完成");
	}
	
	/**
	 示例代码二：
	private ServletContext sc = null;
	private static boolean running=false;
 
	//constructor method of CCoreTask
	public CCoreTask(ServletContext sc){
		this.sc = sc;
	}
 
	@Override
	public void run() {
		if (!running){
			running = true;
			this.sc.log("start running CCoreTask...");
			doTask();
			running = false;
			this.sc.log("CCoreTask runned.");
		}
	}
 
	private void doTask(){
		CSessionUtils.checkExpirySession();
	}
	 */

}