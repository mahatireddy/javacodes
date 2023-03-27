package hashing;

import java.util.Scanner;

public class chain {
	node l[];
	int a;
	public chain(int max)
	{
		l = new node[max];
		a = max;
	}
	int hash(int k)
	{
		return k%this.a;
	}
	void insert(int k)
	{
		
		int pos = hash(k);
		node n = l[pos];
		if(l[pos]==null)
		{
			l[pos] = new node(k);
		}
		else
		{
			while(l[pos].next!=null)
			{
				n = n.next;
			}
			node N1 = new node(k);
			n.next = N1;
		}
	}
	int search(int k)
	{
		int pos = hash(k);
		node n = l[pos];
		if(l[pos].data==k)
		{
			return pos;
		}
		else
		{
			while(l[pos].next!=null)
			{
				if(n.data==k)
				{
					return pos;
				}
				n = n.next;
			}
			return 0;
			
		}
	}
	void display()
	{
		System.out.println();
		for (int i = 0; i < this.a; i++) 
		{
			System.out.print("At " + i + ": ");

			node start = this.l[i];

			while (start != null) 
			{
				System.out.print(start.data + " ");
				start = start.next;
			}

			System.out.println();
		}
	}
	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Max size of hash table : ");
		chain ch = new chain(S.nextInt());
		int c = 0;
		do
		{
			System.out.println("1. Insert ");
			System.out.println("2. Search ");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			c = S.nextInt();
			switch(c)
			{
			case 1: 
				System.out.println("Enter the value: ");
				ch.insert(S.nextInt());
				break;
			case 2:
				System.out.println("Enter the value to Search : ");
				int i = ch.search(S.nextInt());
				System.out.println("Search result : "+i);
				break;
			case 3:
				ch.display();
				break;
			case 4:
				System.out.println("Exit prompt!");
				break;
				default: 
					System.out.println("Invalid Input!");
					break;
			}

		}
		while(c!=4);
		S.close();
	}


}