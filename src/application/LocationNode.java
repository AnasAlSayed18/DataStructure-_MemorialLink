//Anas Al Sayed **1221020**
package application;

public class LocationNode <object>{
	public object data;
	public LocationNode next;
	public int countMaryer = 0;
	public MartyrNode nextMaryer;
	public MartyrList Mlist= new MartyrList();
	
	
	//O(1).
	public MartyrList getMlist() {
		return Mlist;
	}
	//O(1).
	public void setMlist(MartyrList mlist) {
		Mlist = mlist;
	}
	//O(1).
	public LocationNode(object data) {
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
	public LocationNode getNext() {
		return next;
	}
	//O(1).
	public void setNext(LocationNode next) {
		this.next = next;
	}
	
	
	

}
