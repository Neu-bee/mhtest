package efw;

import java.io.File;

public class LOLfilePhotoShow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\Administrator\\Desktop\\LOLTEST4";		//Ҫ������·��
		File file = new File(path);		//��ȡ��file����
		File[] fs = file.listFiles();	//����path�µ��ļ���Ŀ¼������File������
		for(File f:fs){					//����File[]����
			if(!f.isDirectory())		//����Ŀ¼(���ļ�)�����ӡ
				System.out.println(f.getName());
		}
	}

	
	
//	public static void show(File f){
//		
//		if(!f.exists()){
//			throw new IllegalArgumentException("�ļ���"+f+"������.");
//		}
//		
//		
//		
//	}
}
