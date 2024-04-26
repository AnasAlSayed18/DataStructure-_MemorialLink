//Anas Al Sayed **1221020**
package application;

import javafx.scene.control.TextArea;

public class LocationList {
	public LocationNode first,last;
	public int count=0;

	//O(1).
	public  int getCount() {
		return count;
	}

	//O(1).
	public void setFirst(LocationNode first) {
		this.first = first;
	}
	//O(1).
	public void setLast(LocationNode last) {
		this.last = last;
	}
	//O(1).
	public Object getFirst() {
		if(first==null) {
			return null;
		}else {
			return  first.getData();
		}

	}
	//O(1).
	public Object getLast() {
		if(last==null) {
			return null;
		}else {
			return  last.getData();
		}
	}
	
	
	
	
	
	
	
//	public void insert(Object data) {
//		LocationNode current = new LocationNode(data);
//        if (first==null){
//            first=last=current;
//            last.next=first;
//            count++;
//            return;
//        }
//        LocationNode temp = first;
//        do {
//            if (((Location) first.getData()).getLname().compareToIgnoreCase(((Location) data).getLname()) > 0){
//                current.next=first;
//                first=current;
//                last.next=first;
//                count++;
//                return;
//
//            }
//            if (((Location) temp.next.getData()).getLname().compareToIgnoreCase(((Location) data).getLname()) > 0) {
//                break;
//            }
//            if(temp.next==first){
//                temp.next=current;
//                last=current;
//                last.next=first;
//                count++;
//                return;
//            }
//            temp = temp.getNext();
//
//        } while (temp != first);
//        current.next=temp.next;
//        temp.next=current;
//        count++;
//
//
//    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//1+n+1+1 ----->O(n).
	public void addFirst(Object data) {

		LocationNode newNode = new LocationNode(data);
		if (notHere(((Location) newNode.getData()).getLname()) == false) {
			System.out.println("***ERROR 404***");
			return;
		}

		if(first==null) {
			first=last=newNode;
			last.next=first;
		}else {

			newNode.next = first;
			first=newNode;
			last.next=first;

		}
		//locationSort();

		count++;
	}
	//1+1+n+(n*n) ----> O(n^2).
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
			LocationNode ptr = first;
			for(int i=0; i<count-1;i++) {
				if(((Object)ptr.getData()).equals(data)){
					return remove(i);
				}else
					ptr=ptr.next;
			}
		}
		return false;
	}
	//1+1+n+n -----> O(n)
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
			LocationNode ptr = first;
			for(int i=0; i<index-1;i++) {
				ptr=ptr.next;
			}
			LocationNode temp = ptr.next;

			ptr.next=temp.next;
			temp.next=null;
			count--;

		}
		return true;
	}
	//O(1).
	public boolean removeFirst() {

		if(count<0) {
			return false;
		}
		else if(count==0) {
			first=last=null;
		}else {
			LocationNode temp = first;
			first = first.next;
			temp.next=null;
			last.next=first;
		}
		count--;

		return true;
	}

	//O(n).
	public boolean removeLast() {

		if(count<0) {
			return false;
		}
		else if(count==0) {
			first=last=null;
		}else {
			LocationNode ptr = first;
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
	//O(1).
	public void addLast(Object data) {
		LocationNode newNode = new LocationNode(data);
		if(notHere(((Location)newNode.getData()).getLname())==false) {
			System.out.println("***ERROR 404***");
			return;
		}
		if(last==null) {
			first=last=newNode;
			last.next=first;
		}else {
			last.next = newNode;
			last=newNode;
			last.next=first;
			//locationSort();

		}
		count++;
	}
	//1+n+1+1+n ----> O(n).
	public void add(Object data,int index) {
		LocationNode newNode = new LocationNode(data);
		if(notHere(((Location)newNode.getData()).getLname())==false) {
			System.out.println("***ERROR 404***");
			return;
		}
		if(count<0) {
			addFirst(data);
		}else if(index>count){
			addLast(data);
		}
		else{
			LocationNode temp = first;
			for(int i=0;i<count-1;i++) {
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			//locationSort();
			count++;

		}
	}
	//O(1).
	public void swap(LocationNode curr, LocationNode min) {
		Location temp;

		MartyrNode tempNextM = curr.nextMaryer;
		MartyrList tempList = curr.Mlist;
		temp = (Location) curr.getData();

		curr.setData(min.getData());
		curr.Mlist=min.Mlist;
		curr.nextMaryer=min.nextMaryer;


		min.setData(temp);
		min.Mlist=tempList;
		min.nextMaryer=tempNextM;


	}

	//1+1+(n*(n+1)+1+1 ------> O(n^2).
	public void locationSort() {
		LocationNode curr = first;
		LocationNode min = null;

		do {
			min=curr.getNext();
			while(min.next!=first.next) {	
				if ((((Location) curr.getData())).getLname().compareToIgnoreCase(((Location) min.getData()).getLname()) > 0) {

					swap(curr,min);
				}
				min=min.getNext();
			}
			curr=curr.getNext();
		}while(curr.next!=first);	
	}
	//O(1).
	public void swap(MartyrNode curr,MartyrNode min) {
		Martyr temp;

		temp=(Martyr)curr.getData();
		curr.setData(min.getData());
		min.setData(temp);
	}

	//1+1+(n*(n+1)+1 ------>O(n^2).
	public void martyrSort(MartyrNode x) {
		MartyrNode curr = x;
		MartyrNode min = null;

		do {
			min=curr.getNext();
			while(min!=null) {	
				if ((((Martyr) curr.getData())).getAge() > (((Martyr) min.getData())).getAge()) {

					swap(curr,min);
				}
				min=min.getNext();
			}
			curr=curr.getNext();
		}while(curr!=null);	
	}


	//n+1+1+1+n^2-----> O(n^2).
	public void addMartyr(Martyr m) {

		LocationNode temp = getLocation(m.getLocation().getLname());

		if(temp==null) {
			return;
		}

		MartyrNode newNode = new MartyrNode(m);

		if (temp.nextMaryer == null) {
			temp.nextMaryer = newNode;
		} else {
			newNode.next=(temp.nextMaryer);
			temp.nextMaryer = newNode;
		}
		martyrSort(newNode);
		temp.countMaryer++;
	}

	//O(n).
	public LocationNode getLocation(String name) {
		LocationNode temp = first;
		for (int i = 0; i <count; i++) {
			if(((Location)temp.getData()).getLname().equals(name)) {
				break;
			}
			temp = temp.next;
		}

		if(temp==null) {
			return null;
		}

		if(((Location)temp.getData()).getLname().equals(name)) {
			return temp;}
		else {
			return null;	
		}
	}

	//n+(n*n)+1 ----->O(n^2).
	public MartyrNode getMartyr(String name,String Mname) throws NullPointerException{
		MartyrNode temp = getLocation(name).nextMaryer;
		try {
			for (int i = 0; i <getLocation(name).countMaryer; i++) {
				if(temp.next==null) {
					return getLocation(name).nextMaryer;
				}
				if(((Martyr)temp.next.getData()).getName().equals(Mname)) {
					return temp.next;
				}
				temp = temp.getNext();
			}}catch(NullPointerException v) {

			}

		if(temp==null) {
			return null;
		}

		if(((Martyr)temp.getData()).getName().contains(name)) {

			return temp;}
		else
			return null;
	}
	//n+1+1+1+n+1 ----->O(n).
	public String getMartyerListB7(String name) {
		LocationNode node = getLocation(name);
		String res="";
		if(node==null) {
			System.out.println("Erorr enter valid location");
			return res;
		}
		MartyrNode temp = node.nextMaryer;

		for (int i = 0; i < getLocation(name).countMaryer; i++) {
			if(temp==null) {
				return res;
			}

			res+=((Martyr) temp.getData()).getName()+ ",";
			temp = temp.getNext();

		}

		return res;

	}

	//n+1+1+1 -------> O(n).
	public double getMartyrCount(String name){
		LocationNode loc =  getLocation(name);
		if(loc==null) {
			System.out.println("Canot add to non enter location");
			return -1;
		}
		return loc.countMaryer;
	}

	//n+1+1+(n*1*1) ------>O(n).
	public int getMartyrMaleCount(String name){
		LocationNode temp =getLocation(name);
		if(temp==null) {
			System.out.println("Canot add to non enter location");
			return -1;
		}

		MartyrNode newNode = getLocation(name).nextMaryer;
		int count =1;
		for(int i=0;i<temp.countMaryer-1;i++) {

			if(((Martyr)newNode.getData()).getGender().equals("M")) {

				count++;

			}
			newNode = newNode.getNext();

		}
		return count;
	}

	//n+1+n+(n*1) -------> O(n).
	public int getMartyrFmaleCount(String name){
		LocationNode temp =getLocation(name);
		if(temp==null) {
			System.out.println("Canot add to non enter location");
			return -1;
		}
		MartyrNode newNode = getLocation(name).nextMaryer;

		int count =0;
		for(int i=0;i<temp.countMaryer;i++) {
			if(((Martyr)newNode.getData()).getGender().equals("F")) {
				count++;
			}
			newNode = newNode.getNext();

		}
		return count;
	}

	//n+n+1+2+(n*1)+1------>O(n).
	public double getMartyrAverage(String name){

		LocationNode loc =getLocation(name);
		MartyrNode mNode = getLocation(name).nextMaryer;

		if(mNode==null) {
			System.out.println("Canot add to non enter location");
			return -1;
		}


		double sum=0;
		double res=0;
		for(int i=0;i<loc.countMaryer;i++){
			sum+=((Martyr)mNode.getData()).getAge();
			if(mNode.getNext()==null) {
				return sum/loc.countMaryer;

			}
			mNode=mNode.getNext();
		}

		res=sum/loc.countMaryer;
		return res;
	}
	//O(n).
	public boolean notHere(String curr) {
		LocationNode loc = first;
		for (int i = 0; i < count; i++) {
			if (loc==null) {
				return false;
			}
			if (((Location)loc.getData()).getLname().equals(curr)) {
				return false;
			}
			loc = loc.next;
		}

		return true;
	}
	//O(n).
	public boolean uppdateLocation(String oldName,String newName) {
		LocationNode node = getLocation(oldName);
		if(node==null) {
			return false;
		}
		((Location)node.getData()).setLname(newName);
		//locationSort();
		return true;

	}
	//n+1+n^2 -------> O(n^2).
	public void removeLocation(String name) {
		LocationNode node = getLocation(name);
		if(node==null) {
			System.out.println("The Location is not exsist...");
			return;
		}
		removeByData(node.getData());

	}

	//n+n+1+(n*1*1) ------>O(n).
	public void MartyrToString(String name){
		LocationNode loc =getLocation(name);
		MartyrNode temp = getLocation(name).nextMaryer;

		if(temp==null) {
			System.out.println("Canot add to non enter location");
			return ;
		}

		for(int i=0;i<loc.countMaryer+1;i++){
			System.out.print("[Martyr Name: " + ((Martyr) temp.getData()).getName()+ "   //  " + "Age: "
					+ ((Martyr) temp.getData()).getAge() + "] ");	
			System.out.println();
			if(temp.getNext()==null) {
				break;
			}
			temp=temp.getNext();

		}

	}
	public void searchMartyr(String name,TextArea b9textAtea  ){

		LocationNode loc =first;
		if(loc==null) {
			System.out.println("Canot add to non enter location");
			return ;
		}

		for(int j=0;j<count;j++){
			MartyrNode temp = loc.nextMaryer;

			for (int i = 0; i <loc.countMaryer; i++) {
				if(((Martyr)temp.getData()).getName().contains(name)) {
					 b9textAtea.appendText(((Martyr)temp.getData()).getName() + "\n");;
				}
				temp = temp.getNext();
			}
			loc=loc.getNext();

		}

	}

	//1+1+(n*n+1)----->O(n^2).
	public MartyrNode searchMartyr(String name){

		LocationNode loc =first;
		if(loc==null) {
			System.out.println("Canot add to non enter location");
			return null;
		}

		for(int j=0;j<count;j++){
			MartyrNode temp = loc.nextMaryer;

			for (int i = 0; i <loc.countMaryer; i++) {
				if(((Martyr)temp.getData()).getName().contains(name)) {
					return temp;
				}
				temp = temp.getNext();
			}
			loc=loc.getNext();

		}
		return null;

	}

	//n+n+1+1+(n*(1+1+n))----->O(n^2).
	public boolean removeMartyerByData(Object data,String LocName) {
		LocationNode lec =getLocation(LocName);
		MartyrNode temp = getLocation(LocName).nextMaryer;
		if(lec.countMaryer<0 ) {
			return false;
		}

		else {
			MartyrNode ptr = temp;
			for(int index=0; index<lec.countMaryer;index++) {
				if(((Object)ptr.getData()).equals(data)){
					if(count<0 || index>count) {
						return false;
					}
					else {
						MartyrNode ptr1 = temp;
						for(int i=0; i<index-1;i++) {
							ptr1=ptr1.next;
						}
						MartyrNode temp1 = ptr1.next;

						ptr1.next=temp1.next;
						temp1.next=null;
						lec.countMaryer--;

					}
					return true;
				}else
					ptr=ptr.next;
			}
		}
		return false;
	}
	//n+1+(n*(n+1))+1------>O(n^2).
	public boolean removeMartyr(String LocName,String name) {
		LocationNode loc=getLocation(LocName);
		MartyrNode mNode = loc.nextMaryer;


		for (int i = 0; i < loc.countMaryer; i++) {

			if ((((Martyr)mNode.getData()).getName().equals(name))) {
				return removeMartindex(i,LocName);
			}
			mNode = mNode.next;

		}

		return false;

	}
	//n+1+n+n+1+1+1 ------->O(n).
	public boolean removeMartindex(int index,String name) {
		LocationNode loc=getLocation(name);
		MartyrNode mNode=loc.nextMaryer;

		if (index==0) {
			return removeMartFirst(name);
		}

		for(int i=0;i<index-1;i++) {
			mNode=mNode.next;
		}
		MartyrNode temp=mNode.next;
		if(temp!=null) {
			mNode.next=temp.next;
			temp.next=null;
			loc.countMaryer--;
		}
		else {
			temp=mNode;
		}
		return true;	}

	//n+1+1+1 ------>O(n).
	public boolean removeMartFirst(String name) {
		LocationNode loc=getLocation(name);
		MartyrNode mFirst=loc.nextMaryer;

		if (mFirst == null) {

			return false;
		} 
		loc.nextMaryer=mFirst.next;

		loc.countMaryer--;
		return true;				

	}

	//n+1+1+1+1 -------> O(n).
	public Martyr martyrYoungest (String name) {
		LocationNode loc=getLocation(name);
		if(loc!=null) {
			MartyrNode M=loc.nextMaryer;
			MartyrNode mFirst=M;
			int min=((Martyr)M.getData()).getAge();

			while(M!=null) {
				if(((Martyr)M.getData()).getAge()<min) {
					min=((Martyr)M.getData()).getAge();
					mFirst=M;
				}
				M=M.getNext();
			}
			return ((Martyr)mFirst.getData());
		}
		else {
			return null;
		}
	}

	//n+1+1+1+1 -------> O(n).
	public Martyr martyrOldest (String name) {
		LocationNode loc=getLocation(name);
		if(loc!=null) {
			MartyrNode M=loc.nextMaryer;
			MartyrNode mFirst=M;
			int max=0;

			while(M!=null) {
				if(((Martyr)M.getData()).getAge()>max) {
					max=((Martyr)M.getData()).getAge();
					mFirst=M;
				}
				M=M.getNext();
			}
			return ((Martyr)mFirst.getData());
		}
		else {
			return null;
		}
	}


	//n+1+1+1+(n*(1+1))+1 ------->O(n).
	public String getMartyrList(String name) {
		LocationNode node = getLocation(name);
		String res="";
		if(node==null) {
			System.out.println("Erorr enter valid location");
			return res;
		}

		MartyrNode temp = node.nextMaryer;



		for (int i = 0; i < getLocation(name).countMaryer; i++) {
			if(temp==null) {
				return res="";
			}
			res+="[Martyr Name: " + ((Martyr) temp.getData()).getName()+ "   //  " + "Age: "
					+ ((Martyr) temp.getData()).getAge() + "] "+"\n";

			temp = temp.getNext();

		}

		return res;

	}

	//1+n -------> O(n).
	public void printList() {
		LocationNode temp = first;
		for(int i=0;i<count;i++) {
			System.out.print(temp.getData()+" "); 

			temp=temp.next;

		}
		System.out.println(temp.getData()+" "); 

	}

	//1+n -------> O(n).
	public void locationToString() {

		LocationNode temp = first;

		for (int i = 0; i <count; i++) {
			System.out.print("[Location Name: " + ((Location) temp.getData()).getLname());
			System.out.println();
			temp = temp.getNext();

		}



	}

}
