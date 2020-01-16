package efw;


public class stack<T> {
	int size=0;
	private T[] arrayT;
	//constructor
	public stack(T[] arrayT) {
		this.arrayT = arrayT;
	}
	
	public stack(int size, T[] arrayT) {
		super();
		this.size = size;
		this.arrayT = arrayT;
	}

	public T[] getArrayT() {
		return arrayT;
	}

	public void setArrayT(T[] arrayT) {
		this.arrayT = arrayT;
	}
	
	//����ջ����
	public void setSize(int size){
		for(int i=0;i<size;i++){
			arrayT[i]=null;
		}
	}
	
	//��ȡ��С
	public int getSize(int size){
		return arrayT.length;
	}
	
	//�����±����
	public T getValue(int k){
		if(arrayT==null||k<0||k>arrayT.length){
			System.out.println("ʧ����");
			return null;
		}
		return arrayT[k];
	}
	
	//ѹջ
	public void add(T bun){
		if(arrayT[size-1]==null){
			for(int i=0;i<size;i++){
				if(arrayT[i]==null){
					arrayT[i]=bun;
				}
			}
			System.out.println("ѹջ�ɹ�");
		}else{
			System.out.println("ջ���ˣ�");
		}
	}
	
	//��ջ
	public T remove(){
		if(arrayT[0]==null){
			System.out.println("û���ˣ�ʧ����");
			return null;
		}else{
			T bun=null;
			for(int i=0;i<size;i++){
				if(arrayT[i]==null){
					bun=arrayT[i-1];
					arrayT[i-1]=null;
				}
			}
			System.out.println("�����ɹ�");
			return bun;
		}
	}
}
