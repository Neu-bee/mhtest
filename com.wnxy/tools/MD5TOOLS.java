package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;


public class MD5TOOLS {

	public static String getMD5String(String psw) throws NoSuchAlgorithmException{
		
		MessageDigest md= MessageDigest.getInstance("MD5");
		byte bs[]=md.digest(psw.getBytes());
		Formatter format=new Formatter();
		for(byte b:bs){
			format.format("%02x",b);
		}
		String p=format.toString();
		format.close();
		System.out.println("已转化为哈希数"+p);
		return p;
		
	}
//	
//	public static void main(String[] args) throws NoSuchAlgorithmException {
//		String s=getMD5String("123456");
//		
//		System.out.println(s);
//		
//	}
	
}
