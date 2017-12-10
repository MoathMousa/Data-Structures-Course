
public class HashNode {
	
	private int flag=-1;
	private Object data;
	
	public HashNode(Object p,int f){
		this.data=p;
		flag=f;
		
	}
	public HashNode(Object k){
		data=k;
		flag=1;		
	}
	public void setData(Object p){
		this.data=p;
	}
	public Object getData(){
		return this.data;
	}
	public void setOut() {
		this.flag=0;
		
	}
	public int getFlag(){
		return flag;
	}
	public void setInServ() {
		flag=1;
		
	}
}
