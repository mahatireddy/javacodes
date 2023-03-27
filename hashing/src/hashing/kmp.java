package hashing;

public class kmp {
	static void lps_array(String p,int m,int lps[]) {
		int j=0;
		int i=1;
		lps[0]=0;
		while(i<m) {
		if(p.charAt(i)==p.charAt(j)) {
		j++;
		lps[i]=j;
		i++;
		}else {
		if(j!=0) {
		j=lps[j-1];
		}else {
		lps[i]=j;
		i++;
		}
		}
		}
		for(int a=0;a<m;a++) {
			System.out.println(lps[a]);
		}
		}
		static void KMP(String p,String t) {
		int m=p.length();
		int n=t.length();
		int lps[]=new int[m];
		int j=0;//pointer for p
		lps_array(p,m,lps);
		int i=1;//pointer for text
		while (i<n) {
			if(p.charAt(j)==t.charAt(i)) {
				j++;
				i=i+2;
				}
				else if(j!=0) {
				j=lps[j-1];
				}
				else {
				i=i+2;
				}
				if(j==m) {
				System.out.println("Pattern is at index "+(i-j-2));
				j=lps[j-1];
				}
		}
}
		public static void main(String[] args) {
		KMP("caa","bcaadabc");
		}
}


