package hashing;
import java.util.Scanner;
public class quad
{
	int a[];
	int b;
	public quad(int max)
	{
		a = new int[max];
		b = max; 
	}
	int hash(int k)
	{
		return k % b;
	}
	int insert(int k)
	{
		int probe = 0;
		if(a[hash(k)]==0)
		{
			a[hash(k)] = k;
			probe = 0;
		}
		else //quadratic probing
		{
			int i = hash(k);
			int j = 1;
			while(a[i]!=0)
			{
				i = (i+j*j)%b;
				j++;
				probe++;
			}
			a[i] = k;
		}
		return probe;
	}
	int search(int k)
	{
		int res = 0;
		int i = hash(k);
		int t = hash(k);
		if(a[i]==k)
			return i;
		else
		{
			int j = 0;
			while(a[i]!=k)
			{
				i = (t+j*j)%b;
				j++;
			}
			res = i;
		}
		return res;
	}

	public static void main(String args[])
	{
		Scanner S = new Scanner(System.in);
		System.out.println("Max size of hash : ");
		quad D = new quad(S.nextInt());
		int ch = 0;
		do
		{
			System.out.println("1. Insert (quadratic probing) ");
			System.out.println("2. Search ");
			System.out.println("3. Display");
			System.out.println("4. Exit");
			ch = S.nextInt();
			switch(ch)
			{
			case 1: 
				System.out.println("Enter the values: ");
				int p = D.insert(S.nextInt());
				System.out.println("Number of probes = "+p);
				break;
			case 2:
				System.out.println("Enter the value to Search : ");
				int i = D.search(S.nextInt());
				System.out.println("Search result : "+i);
				break;
			case 3:
				System.out.println("Displaying elements:");
				for(int i1 = 0;i1<D.b;i1++)
				{
					System.out.println("Loc "+i1+" Value = "+D.a[i1]);
				}
				break;
			case 4:
				System.out.println("Exit");
				break;
				default: 
					System.out.println("Invalid Input");
					break;
			}
		}
		while(ch!=4);
		S.close();

	}
}