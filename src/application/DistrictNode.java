//Anas Al Sayed **1221020**
package application;

public class DistrictNode <T>{
	T data;
	DistrictNode next,prev;
	LocationNode nextLocation;
	public LocationList Llist= new LocationList();
	int countLocation = -1;
	int countMartyr = -1;
  
	
	//n+4+n^2 ------> O(n^2).
	public void addMartyr(Martyr m) {

		LocationNode temp = Llist.getLocation(m.getLocation().getLname());

		if(temp==null) {
			//System.out.println("Canot add to non enter location");
			return;
		}

		MartyrNode newNode = new MartyrNode(m);


		if (temp.nextMaryer == null) {
			temp.nextMaryer = newNode;
		} else {
			newNode.setNext(temp.nextMaryer);
			temp.nextMaryer = newNode;
		}
		Llist.martyrSort(newNode);
		temp.countMaryer++;



	}
	//1+1+1+1 ----->O(1).
	public void addFirst(Object data) {
		LocationNode newNode = new LocationNode(data);
		
		if(Llist.first==null) {
			Llist.first=Llist.last=newNode;
			Llist.last.next=Llist.first;
		}else {
			
			newNode.next = Llist.first;
			Llist.first=newNode;
			Llist.last.next=Llist.first;
		//	Llist.locationSort();

		}
		Llist.count++;
	}
	
	//n+1+1+n^2 ----->O(n^2).
	public void removeLocation(String name) {
		LocationNode node = Llist.getLocation(name);
		if(node==null) {
			System.out.println("The Location is not exsist...");
			return;
		}
		if(node.equals(Llist.first)) {
		nextLocation=Llist.first.next;
		}
		Llist.removeByData(node.getData());
		
	}
	
	//O(1).
	public DistrictNode getPrev() {
		return prev;
	}
	//O(1).
	public void setPrev(DistrictNode prev) {
		this.prev = prev;
	}
	//O(1).
	public LocationList getLlist() {
		return Llist;
	}
	//O(1).
	public void setLlist(LocationList llist) {
		Llist = llist;
	}
	//O(1).
	public int getCountMartyr() {
		return countMartyr;
	}
	//O(1).
	public void setCountMartyr(int countMartyr) {
		this.countMartyr = countMartyr;
	}
	public DistrictNode(T data) {
	this.data=data;
	}
	//O(1).
	public T getData() {
		return data;
	}
	//O(1).
	public void setData(T data) {
		this.data = data;
	}
	//O(1).
	public DistrictNode getNext() {
		return next;
	}
	//O(1).
	public void setNext(DistrictNode next) {
		this.next = next;
	}
	
}
