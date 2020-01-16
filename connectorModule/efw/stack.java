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
	
	//设置栈容量
	public void setSize(int size){
		for(int i=0;i<size;i++){
			arrayT[i]=null;
		}
	}
	
	//读取大小
	public int getSize(int size){
		return arrayT.length;
	}
	
	//根据下标查找
	public T getValue(int k){
		if(arrayT==null||k<0||k>arrayT.length){
			System.out.println("失败了");
			return null;
		}
		return arrayT[k];
	}
	
	//压栈
	public void add(T bun){
		if(arrayT[size-1]==null){
			for(int i=0;i<size;i++){
				if(arrayT[i]==null){
					arrayT[i]=bun;
				}
			}
			System.out.println("压栈成功");
		}else{
			System.out.println("栈满了！");
		}
	}
	
	//弹栈
	public T remove(){
		if(arrayT[0]==null){
			System.out.println("没有了！失败了");
			return null;
		}else{
			T bun=null;
			for(int i=0;i<size;i++){
				if(arrayT[i]==null){
					bun=arrayT[i-1];
					arrayT[i-1]=null;
				}
			}
			System.out.println("弹出成功");
			return bun;
		}
	}
}
