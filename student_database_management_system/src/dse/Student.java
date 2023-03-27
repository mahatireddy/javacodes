package dse;

import java.util.Scanner;

public class Student {
	Node head;
	Node tail;

	class Node {
		String stname, Regno, Course;
		String mks;
		Node next;

		Node(String stname, String Regno, String Course, String mks2) {
			this.stname = stname;
			this.Regno = Regno;
			this.Course = Course;
			this.mks = mks2;
			this.next = null;
		}
	}

	 public void addNode(String stname, String Regno, String Course, String mks) {    
	        //Create a new node    
	        Node newNode = new Node(stname,Regno,Course,mks);    
	            
	        //Checks if the list is empty    
	        if(head == null) {    
	            //If list is empty, both head and tail will point to new node    
	            head = newNode;    
	            tail = newNode;    
	        }    
	        else {    
	            //newNode will be added after tail such that tail's next will point to newNode    
	            tail.next = newNode;    
	            //newNode will become new tail of the list    
	            tail = newNode;    
	        }    
	    }    
	
	public void Insertfirst(String stname, String Regno, String Course, String mks) {
		Node newNode = new Node(stname, Regno, Course, mks);
		if (head == null) {
			head = newNode;
			return;
		}

		newNode.next = head;
		head = newNode;
	}

	void Insertafter(String nsn, String nrgn, String nc, String nmks, String k) {
		Node newNode = new Node(nsn, nrgn, nc, nmks);
		Node ptr = head;
		while (!ptr.Regno.equals(k)) {
			ptr = ptr.next;
		}
		Node t = ptr.next;
		ptr.next = newNode;
		newNode.next = t;
	}

	void deletefirst() {
		if (head == null) {
			System.out.println("List is Empty");
		}

		head = head.next;
	}

	void deletelast() {
		if (head == null) {
			System.out.println("List is Empty");
		}

		if (head.next == null) {
			head = null;
		}

		Node lastnode = head.next;
		Node seclastnode = head;

		while (lastnode.next != null) {
			lastnode = lastnode.next;
			seclastnode = seclastnode.next;
		}

		seclastnode.next = null;
	}

	void deletmid(String b) {
		if (head == null) {
			System.out.println("List is Empty");
		}
		else if(head.Regno.equals(b)) {
			if(head.next==null){
				head=null;
			}
			else {
				head=head.next;
			}
		}
		
		else
		{
		Node ptr = head;
		while (!ptr.next.Regno.equals(b)) {
			ptr = ptr.next;
		}
		ptr.next = ptr.next.next;
		
		}
	}

	void Search(String srh) {
		Node ptr = head;
		while (!ptr.Regno.equals(srh)) {
			if (ptr.Regno.equals(null)) {
				System.out.println("No match Found");
				break;
			}
			ptr = ptr.next;
		}
		System.out.println("The details of the Searched Student");
		System.out.println("The Name of the Student : " + ptr.stname);
		System.out.println("The Registration Number : " + ptr.Regno);
		System.out.println("The Course of the student : " + ptr.Course);
		System.out.println("The Marks obtained by the student : " + ptr.mks);
		
	}

	void display() {
        if (head == null) {
            System.out.println("List is Empty");
        }
        Node tempnode = head;
        while (tempnode != null) {
            System.out.println("Reg.no\tName\tCourse\tMarks");
            System.out.print(tempnode.Regno + "\t");
            System.out.print(tempnode.stname + "\t");
            System.out.print(tempnode.Course + "\t");
            System.out.println(tempnode.mks);
            tempnode = tempnode.next;
        }
    }

	public static void main(String[] args) {
        Student list = new Student();
        Scanner sc = new Scanner(System.in);
        System.out.println("                            Welcome to student management system                        ");
        int choice=0;
        while(choice!=5) {
        	System.out.println();
        	System.out.println("1. Enter a new students record ");
        	System.out.println("2. Delete a record ");
        	System.out.println("3. Search a record ");
        	System.out.println("4. display ");
        	System.out.println("5. stop");
        	System.out.println("Enter a choice value: ");
        	choice=sc.nextInt();
        	sc.nextLine();
        	switch(choice) {
        	
        		case 1:
        			String s1,s2,s3;
        			System.out.println("Enter a new student record");
            		System.out.println("Details :");
            		System.out.println("Name: ");
            		s1=sc.nextLine();
            		System.out.println("Registration number: ");
            		s2=sc.nextLine();
            		System.out.println("Course: ");
            		s3=sc.nextLine();
            		String s4;
            		System.out.println("Marks: ");
            		s4=sc.nextLine();
            		list.Insertfirst(s1,s2,s3,s4);
            		break;
        		case 2:
        			String x1;
        			System.out.println("Enter the registration number of the student whose record is to be deleted ");
        			x1=sc.nextLine();
        			list.deletmid(x1);
        			break;
        		case 3:
        			String x2;
        			System.out.println("Enter the registration number of the students whose record you want to search");
        			x2=sc.nextLine();
        			list.Search(x2);
        			break;
        		case 4:
        			System.out.println("Student records :");
        			list.display();
        			break;
        	}
        
	}
}
}