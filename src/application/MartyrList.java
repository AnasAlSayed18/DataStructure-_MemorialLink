//Anas Al Sayed **1221020**

package application;


import java.util.Date;

public class MartyrList {
	public MartyrNode first;
	MartyrNode last;
	static int count=-1;
	
	
	public Object getFirst() {
		if(first==null) {
			return null;
		}else {
			return  first.getData();
		}

	}

	public Object getLast() {
		if(last==null) {
			return null;
		}else {
			return  last.getData();
		}
	}



	public static int getCount() {
		return count;
	}



	public static void setCount(int count) {
		MartyrList.count = count;
	}



	public void setFirst(MartyrNode first) {
		this.first = first;
	}



	public void setLast(MartyrNode last) {
		this.last = last;
	}


	public void swap(MartyrNode curr,MartyrNode min) {
		Martyr temp;

		temp=(Martyr)curr.getData();
		curr.setData(min.getData());
		min.setData(temp);
	}

	

	public void martyrSort() {
		MartyrNode curr = first;
		MartyrNode min = null;
		
		do {
			min=curr.next;
			while(min.next!=first.next) {	
				if ((((Martyr) curr.getData())).getAge() > (((Martyr) min.getData())).getAge()) {

					swap(curr,min);
				}
				min=min.next;
			}
			curr=curr.next;
		}while(curr.next!=first);	
	}
	public MartyrNode getMartyr(String name) {
		MartyrNode temp = first;

		for (int i = 0; i <count; i++) {

			if(((Martyr)temp.getData()).getName().contains(name)) {
				break;

			}

			temp = temp.next;
		}
		
		if(((Martyr)temp.getData()).getName().contains(name)) {
			return temp;}
		else
			return null;
	}
		
	public boolean uppdateMartyr(String oldName,String name, Date dateOfDeath,int age,Location location,District district  ,String gender) {
		MartyrNode node = getMartyr(oldName);
		Martyr m =((Martyr)node.getData());
		if(node==null) {
			return false;
		}
		m.setName(name);
		m.setAge(age);
		m.setDateOfDeath(dateOfDeath);
		m.setDistrict(district);
		m.setGender(gender);
		m.setLocation(location);
		
		martyrSort();
		return true;

	}
	
	public void removeMartyr(String name) {
		MartyrNode node = getMartyr(name);
		removeByData(node.getData());
	}

	public void printList() {
		MartyrNode temp = first;
		for(int i=0;i<count;i++) {
			System.out.print(((Martyr)temp.getData()).getName()+" "); 
System.out.println();
			temp=temp.next;

		}
		System.out.print(((Martyr)temp.getData()).getName()+" "); 

	}

	

	public void addFirst(Object data) {
		MartyrNode newNode = new MartyrNode(data);
		if(first==null) {
			first=last=newNode;
			last.next=first;

		}else {
			newNode.next = first;
			first=newNode;
			last.next=first;
			martyrSort();
		}

		count++;
	}
	public boolean removeByData(Object data) {

		if(count<0 ) {
			return false;
		}
		else if(((Object)first.getData()).equals(data)) {
			return removeFirst();
		}
		else if(((Object)last.getData()).equals(data)) {
			return removeLast();
		}

		else {
			MartyrNode ptr = first;
			for(int i=0; i<count-1;i++) {
				if(((Object)ptr.getData()).equals(data)){
					return remove(i);
				}else
					ptr=ptr.next;
			}
		}
		return false;
	}
	public boolean remove(int index) {

		if(count<0 || index>count) {
			return false;
		}
		else if(index==0 ||count==0) {
			return removeFirst();
		}
		else if(index==count) {
			return removeLast();
		}

		else {
			MartyrNode ptr = first;
			for(int i=0; i<index-1;i++) {
				ptr=ptr.next;
			}
			MartyrNode temp = ptr.next;

			ptr.next=temp.next;
			temp.next=null;
			count--;

		}
		return true;
	}
	public boolean removeFirst() {

		if(count<0) {
			return false;
		}
		else if(count==0) {
			first=last=null;
		}else {
			MartyrNode temp = first;
			first = first.next;
			temp.next=null;
			last.next=first;

		}
		count--;
		return true;
	}
	public boolean removeLast() {

		if(count<0) {
			return false;
		}
		else if(count==0) {
			first=last=null;
		}else {
			MartyrNode ptr = first;
			for(int i=0; i<count-1;i++) {
				ptr=ptr.next;
			}
			ptr.next=null;
			last=ptr;
			last.next=first;

		}
		count--;
		return true;
	}


	
	public void addLast(Object data) {
		MartyrNode newNode = new MartyrNode(data);
		if(last==null) {
			first=last=newNode;
			last.next=first;

		}else {
			last.next = newNode;
			last=newNode;
			last.next=first;
			martyrSort();
		}
		count++;
	}

	public void add(Object data,int index) {
		MartyrNode newNode = new MartyrNode(data);
		if(count<0) {
			addFirst(data);
		}else if(index>count){
			addLast(data);
		}
		else{
			MartyrNode temp = first;
			for(int i=0;i<count-1;i++) {
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			martyrSort();
			count++;

		}
	}


}
