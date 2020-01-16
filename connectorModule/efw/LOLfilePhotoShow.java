package efw;

import java.io.File;

public class LOLfilePhotoShow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Administrator\\Desktop\\LOLTEST4";		//要遍历的路径
		File file = new File(path);		//获取其file对象
		File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
		for(File f:fs){					//遍历File[]数组
			if(!f.isDirectory())		//若非目录(即文件)，则打印
				System.out.println(f.getName());
		}
	}

	
	
//	public static void show(File f){
//		
//		if(!f.exists()){
//			throw new IllegalArgumentException("文件："+f+"不存在.");
//		}
//		
//		
//		
//	}
}
