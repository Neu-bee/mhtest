package entitys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class LoginCache {

	private static LoginCache instance=new LoginCache();
	
	private Map<String,HttpSession> userSessions=new HashMap<String,HttpSession>();

	private LoginCache() {
	}
	
	public static LoginCache getInstance(){
		return instance;
	}
	public void saveUserSession(String userName,HttpSession session){
		userSessions.put(userName, session);
	}
	public HttpSession getSessionByUser(String userName){
		return userSessions.get(userName);
	}
}
