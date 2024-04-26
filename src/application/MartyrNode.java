//Anas Al Sayed **1221020**

package application;

public class MartyrNode <object>{
	private object data;
	 public MartyrNode next;

	//O(1).
	public MartyrNode(object data) {
	this.data=data;
	}
	//O(1).
	public object getData() {
		return data;
	}
	//O(1).
	public void setData(object data) {
		this.data = data;
	}
	//O(1).
	public MartyrNode getNext() {
		return next;
	}
	//O(1).
	public void setNext(MartyrNode next) {
		this.next = next;
	}
	
	
	

}
