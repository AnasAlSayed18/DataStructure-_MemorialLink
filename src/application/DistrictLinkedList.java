//Anas Al Sayed **1221020**
package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DistrictLinkedList {
	private DistrictNode first;
	private DistrictNode last;
	static int count = -1;

	//O(1).
	public int getSize() {
		return count;
	}
	//O(1).
	public void setFirst(DistrictNode first) {
		this.first = first;
	}
	//O(1).
	public DistrictNode getFirst() {
		if (first == null) {
			return null;
		}
		return first;
	}
	//O(1).
	public DistrictNode getLast() {
		if (last == null) {
			return null;
		}
		return last;
	}
	//1+n+1+n^2-----> O(n^2).
	public void addFirst(Object data) {
		DistrictNode node = new DistrictNode(data);
		if (notHere(((District) node.getData()).getDname()) == false) {
			System.out.println("***ERROR 404***");
			return;
		}
		if (first == null) {
			last = first = node;
		} else {
			node.next = first;
			first.prev = node;
			first = node;
			first.prev = last;
			last.next = first;
			districtSort();
		}
		count++;
	}


	//1+n ---> O(n).
	public boolean notHere(String curr) {
		DistrictNode dis = first;
		if (dis == null) {
			return true;
		}
		for (int i = 0; i < count+1; i++) {
			if (((District) dis.getData()).getDname().equals(curr)) {
				return false;
			}
			dis = dis.next;
		}
		return true;
	}



	//1+1+(n*(n+1)) ------> O(n^2)
	public void districtSort() {
		DistrictNode curr = first;
		DistrictNode min = null;
		do {
			min = curr.next;
			while (min.next != first.next) {
				if ((((District) curr.getData())).getDname().compareToIgnoreCase(((District) min.getData()).getDname()) > 0) {
					swap(curr, min);
				}
				min = min.next;
			}
			curr = curr.next;
		} while (curr.next != first);
	}

	//o(1)
	public void swap(DistrictNode curr, DistrictNode min) {
		District temp;



		LocationNode tempNextL = curr.nextLocation;
		LocationList tempList = curr.Llist;
		temp = (District) curr.getData();

		curr.setData(min.getData());
		curr.setLlist(min.Llist);
		curr.nextLocation=min.nextLocation;

		min.setData(temp);
		min.setLlist(tempList);
		min.nextLocation=tempNextL;
	}

	//1+n+1+1+1 ----->O(n).
	public DistrictNode getDistrict(String name) {
		DistrictNode temp = first;
		for (int i = 0; i < count + 1; i++) {
			if (((District) temp.getData()).getDname().equals(name)) {
				break;
			}
			temp = temp.next;
		}
		if (temp == null) {
			return null;
		}
		if (((District) temp.getData()).getDname().equals(name)) {
			return temp;
		} else
			return null;                                    
	}
	//n+1+1+1+1------> O(n).
	public void addLocation(String name, LocationList l) {
		DistrictNode temp = getDistrict(name);
		if (temp == null) {
			System.out.println("Erorr enter valid Distric");
			return;
		}
		temp.setLlist(l);
		LocationNode newNode = l.first;
		if (temp.nextLocation == null) {
			temp.nextLocation = newNode;
		} else {
			newNode.setNext(temp.nextLocation);
			temp.nextLocation = newNode;
		}
		temp.countLocation = l.getCount();

	}



	// Total number of martyrs
	//n+1+1+n+1 ----> O(n).
	public int getTotalMartyrCount(String name) {
		DistrictNode temp = getDistrict(name);
		if (temp == null) {
			System.out.println("Erorr enter valid Distric");
			return -1;
		}

		LocationNode newNode = temp.Llist.first;
		int count = 0;
		for (int i = 0; i < temp.Llist.count ; i++) {
			count += newNode.countMaryer;

			newNode = newNode.next;
		}

		return count;
	}

	//n+1+2+1+n^2 ------> O(n^2).
	public int getTotalMale(String dname) {
		DistrictNode temp = getDistrict(dname);

		if (temp == null) {
			System.out.println("Canot add to non enter District");
			return -1;
		}
		LocationNode lNode = temp.Llist.first;
		MartyrNode mNode = lNode.nextMaryer;

		int res = 0;
		for (int i = 0; i < temp.Llist.count ; i++) {
			for (int j = 0; j < lNode.countMaryer; j++) {
				if (((Martyr) mNode.getData()).getGender().equals("M")) {

					res++;
				}
				mNode = mNode.getNext();
			}

			lNode = lNode.next;
			mNode = lNode.nextMaryer;

		}
		return res;
	}

	//n+1+2+1+n^2 ------> O(n^2).
	public int getTotalFmale(String dname) {
		DistrictNode temp = getDistrict(dname);

		if (temp == null) {
			System.out.println("Canot add to non enter District");
			return -1;
		}

		LocationNode lNode = temp.Llist.first;
		MartyrNode mNode = lNode.nextMaryer;
		int res = 0;

		for (int i = 0; i < temp.Llist.count ; i++) {

			for (int j = 0; j < lNode.countMaryer; j++) {
				if (((Martyr) mNode.getData()).getGender().equals("F")) {

					res++;
				}
				mNode = mNode.getNext();
			}

			lNode = lNode.next;
			mNode = lNode.nextMaryer;

		}
		return res;
	}

	//n+1+1+4+(n*n*1) ------> O(n^2).
	public double totalAgeAverage(String name) {
		DistrictNode temp = getDistrict(name);

		if (temp == null) {
			System.out.println("Canot add to non enter District");
			return -1;
		}

		LocationNode lNode = temp.Llist.first;
		MartyrNode mNode = lNode.nextMaryer;
		double res = 0;
		double dev = 0;
		for (int i = 0; i < temp.Llist.count ; i++) {
			for (int j = 0; j < lNode.countMaryer; j++) {
				res += ((Martyr) mNode.getData()).getAge();
				mNode = mNode.getNext();
			}
			dev += lNode.countMaryer;
			lNode = lNode.next;
			mNode = lNode.nextMaryer;

		}
		return res / dev;
	}



	



	//n+1+4+1+(n*n*n)+1 ------>O(n^3).
	public Date TotalDateCount(String name) {
		DistrictNode temp = getDistrict(name);
		if (temp == null) {
			System.out.println("The District");
			return null;
		}

		LocationNode lNode = temp.Llist.first;
		MartyrNode mNode = lNode.nextMaryer;
		MartyrNode max = mNode;

		int res = 0;

		for (int i = 0; i < temp.Llist.count; i++) {

			if(mNode==null) {
				if(mNode.getNext()==null) {
					max = mNode.getNext();
				}
			}


			for (int j = 0; j < lNode.countMaryer; j++) {

				if(max!=null) {
					if (dateMcount(mNode, lNode) > dateMcount(max, lNode)) {
						max = mNode;
					}
				}
				mNode = mNode.getNext();

			}

			lNode = lNode.next;
			mNode = lNode.nextMaryer;

		}
		if(max==null) {
			max =mNode;
		}
		return ((Martyr) max.getData()).getDateOfDeath();

	}
	//1+1+1+n+2+1 -----< O(n).
	public int dateMcount(MartyrNode m, LocationNode lNode) {
		int res = 0;
		if(m!=null) {



			MartyrNode max = m.getNext();

			for (int j = 0; j < lNode.countMaryer; j++) {
				if (m != null && max != null) {
					if (((Martyr) m.getData()).getDateOfDeath().equals(((Martyr) max.getData()).getDateOfDeath())) {
						res++;
					}
					max = max.getNext();
				}

			}
			return res;
		}
		return res;

	}
	//1+1+1+(n*n^2) ------> O(n^2).
	public int TotalMartyrNumberInDate(LocalDate date) {
		DistrictNode temp = first;

		if (temp == null) {
			System.out.println("Canot add to non enter District..w..");
			return -1;
		}

		int res = 0;
		for(int k=0;k<count+1;k++) {

			res+=TotalMartyrNumberInDate_forDistrict(((District)temp.getData()).getDname(),date);

			temp=temp.next;
		}
		return res;

	}

	//n+1+2+(n*n*1)+1 -----> O(n^2).
	public int TotalMartyrNumberInDate_forDistrict(String name,LocalDate date) {
		DistrictNode temp = getDistrict(name);

		if (temp == null) {
			return -1;
		}

		LocationNode l= temp.Llist.first;
		MartyrNode m = l.nextMaryer;


		int res = 0;
		for (int i = 0; i < temp.Llist.count ; i++) {

			for (int j = 0; j < l.countMaryer; j++) {
				if (Instant.ofEpochMilli(((Martyr) m.getData()).getDateOfDeath().getTime()).atZone(ZoneId.systemDefault()).toLocalDate().equals(date)) {

					res++;
				}

				m = m.getNext();

			}

			l = l.next;
			m = l.nextMaryer;

		}
		return res;

	}


	//n+1+1+n^2 -----> O(n^2).
	public boolean uppdateDistrict(String oldName, String newName) {
		DistrictNode node = getDistrict(oldName);

		if (node == null) {
			return false;
		}
		((District) node.getData()).setDname(newName);
		districtSort();
		return true;
	}
	//n+n^2 -----> O(n^2).
	public void removeDistrict(String name) {
		DistrictNode node = getDistrict(name);
		removeByData(node.getData());
	}
	//(n).
	public void addLast(Object data) {
		DistrictNode node = new DistrictNode(data);

		if (notHere(((District) node.getData()).getDname()) == false) {
			System.out.println("***ERROR 404***");
			return;
		}

		if (last == null) {
			last = first = node;
		} else {
			node.prev = last;
			last.next = node;
			last = node;
			last.next = first;
			first.prev = last;
			districtSort();

		}
		count++;
	}
	//n+1+1+1 ------> O(n).
	public void add(Object data, int index) {
		DistrictNode node = new DistrictNode(data);
		if (notHere(((District) node.getData()).getDname()) == false) {
			System.out.println("***ERROR 404***");
			return;
		}

		if (index <= 0) {
			addFirst(data);
		} else if (index > count) {
			addLast(data);
		} else {
			DistrictNode curr = first;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			node.next = curr.next;
			node.prev = curr;
			curr.next = node;
			node.next.prev = node;
			districtSort();

			count++;
		}

	}
	//O(1).
	public boolean removeFirst() {
		if (first == null) {
			return false;
		} else if (count == 0) {
			last = first = null;

		} else {
			DistrictNode temp = first;
			first = first.next;
			first.prev = null;
			first.prev = last;
			last.next = first;
			temp.next = null;
			districtSort();

		}
		count--;
		return true;

	}
	//O(1).
	public boolean removeLast() {
		if (count < 0) {
			return false;
		} else if (count == 0) {
			first = last = null;
		} else {
			DistrictNode temp = last;
			last = last.prev;
			last.next = null;
			last.next = first;
			first.prev = last;
			temp.prev = null;
			districtSort();

		}
		count--;
		return true;

	}

	//1+1+n+n+5 -----> O(n).
	public boolean remove(int index) {
		if (count < 0 || index > count) {
			return false;

		} else if (index == 0) {
			return removeFirst();
		} else if (count == index) {
			return removeLast();
		} else {
			DistrictNode curr = first;
			for (int i = 0; i < index - 1; i++) {
				curr = curr.next;
			}
			DistrictNode temp = curr.next;
			curr.next = temp.next;
			temp.next.prev = curr;
			temp.next = null;
			temp.prev = null;
			count--;

		}
		return true;
	}

	//1+1+1+n^2 ----> O(n^2).
	public boolean removeByData(Object data) {
		DistrictNode node = new DistrictNode(data);
		if (first == null) {
			return false;
		} else if (first.getData().equals(data)) {
			return removeFirst();

		} else if (last.getData().equals(data)) {
			return removeLast();

		} else {
			DistrictNode ptr = first.next;
			for (int i = 1; i < count - 1; i++) {
				if (ptr.getData().equals(data)) {
					return remove(i);
				}
				ptr = ptr.next;
			}
		}
		return false;
	}


	//n+1+1 ------> O(n).
	public String getFirstlocationToString(String name) {
		LocationNode temp = getDistrict(name).nextLocation;
		if(temp==null) {
			return "null";
		}
		return ((Location)temp.getData()).getLname();
	}


	//1+1+n+1 ----> O(n).
	public String getDistrictList() {
		DistrictNode temp = first;
		String res="";
		for (int i = 0; i < count + 1; i++) {
			res+=((District) temp.getData()).getDname() + ",";
			temp = temp.next;
		}
		return res;
	}

	//n+1+n+1 ------>O(n).
	public String getLocationList(String name) {
		LocationNode temp = getDistrict(name).Llist.first;
		String res="";


		for (int i = 0; i <getDistrict(name).Llist.getCount(); i++) {
			if(temp==null) {
				return res="";
			}
			res+=((Location) temp.getData()).getLname() + ",";
			temp = temp.next;
		}


		return res;

	}

	//n+1+(n*1*1) ------>O(n).
	public void locationToString(String name) {
		LocationNode temp = getDistrict(name).nextLocation;
		if(temp==(null)){
			return;			}

		for (int i = 0; i < getDistrict(name).Llist.getCount(); i++) {
			if(temp==(null)){
				return;			}
			System.out.print("[Location Name: " + ((Location) temp.getData()).getLname() + "\n");
			temp = temp.next;
		}
	}

	//1+(n*1*1) ------>O(n).
	public void printList1() {
		DistrictNode temp = first;
		for (int i = 0; i < count + 1; i++) {
			System.out.print(((District) temp.getData()).getDname() + " ");
			System.out.println();
			temp = temp.next;
		}

	}
}
