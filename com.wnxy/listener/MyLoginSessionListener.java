package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


import entitys.LoginCache;

public class MyLoginSessionListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
//		//在线人数
//		ServletContext context=arg0.getSession().getServletContext();
//		int count=0;
//		if(context.getAttribute("online")!=null){
//			count=(Integer)context.getAttribute("online");
//		}
//		count++;
//		context.setAttribute("online", count);
		
		
		
		System.out.println("启动监听器");
		String name=arg0.getName();
		
		if(name.equals("uname")){
			String value=(String) arg0.getValue();
			LoginCache instance=LoginCache.getInstance();
			HttpSession oldSession= instance.getSessionByUser(value);
			
			if(oldSession!=null){
				//销毁之前的对象
				oldSession.invalidate();
				System.out.println("已销毁");
			}
			//保存新对象
			HttpSession newSession=arg0.getSession();
			instance.saveUserSession(value, newSession);
		}
		System.out.println("value"+arg0.getValue()+"name:"+name);
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
//		ServletContext context=arg0.getSession().getServletContext();
//		int count = (int)context.getAttribute("online");
//		context.setAttribute("online", count-1);
		
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
