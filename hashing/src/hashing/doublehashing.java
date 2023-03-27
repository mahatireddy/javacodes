package hashing;

import java.util.Scanner;

public class doublehashing {
    int p[];
    int a;

    public doublehashing(int max){
        p = new int[max];
        a = max;
    }

    int hash(int k){
        int i = k%a;
        return i;
    }
    int hash2(int k){
        int i = 1+(k%(a-1));
        return i;
    }

    int insert(int k){
        int pb = 0;
        if(p[hash(k)]==0){
            p[hash(k)]=k;
            pb = 0;
        }
        else{
            int i=hash(k);
            int f = i;
            int r = 1;
    		while(p[i]!=0&&r<a) {
    			int l = hash2(k);
                i = (f + r*l)%a;
                r++;
    		}
    		p[i]=k;
		}
		return pb;
    }

    int search(int k){
        int res = 0;
        int i = hash(k);
        int j =i;
		if(p[i]==k){
            return i;
        }
		else{
			while(p[j]!=k){
				j = (j+1)%a;
                if(j==i){
                    System.out.println("Element not found");
                    break;
                }
			}
            res = j;

		}
        return res;
    }

    public static void main(String args[]) {
        Scanner A = new Scanner(System.in);
        System.out.println("Enter the size");
        doublehashing H = new doublehashing(A.nextInt());
        int c = 0;
        do{
            System.out.println("1. Insert\n 2. Search \n 3. Display\n 4. Exit");
            c = A.nextInt();
            switch(c){
                case 1:
                System.out.println("Enter the value: ");
				int p = H.insert(A.nextInt());
				System.out.println("Number of probes = "+p);
				break;
			case 2:
				System.out.println("Enter the value to Search : ");
				int i = H.search(A.nextInt());
				System.out.println("Search result : "+i);
				break;
			case 3:
				System.out.println("Displaying elements");
				for(int h = 0;h<H.a;h++){
                    System.out.println("Loc "+h+" Value = "+H.p[h]);
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
		while(c!=4);
		A.close();
    }

}
