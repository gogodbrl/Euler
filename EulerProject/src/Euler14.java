
class Euler14 {
	public static void main(String args[]){
		CollatzConjecture c = new CollatzConjecture();
		c.calc();
	}
}
class CollatzConjecture{
	public long even(long k){
		return k/2;
	}
	public long odd(long k){
		return k*3+1;
	}
	public int calc(){
		int tmp[]=new int[2];
		int count=0;
		for(int i=1000000; i>1; i--){
			long k = i;
			while(k!=1){
				/*if(k<0){
					System.out.println(i);
					return i;
				}*/
				if(k%2==0){
					k=even(k);
					count++;
				}else{
					k=odd(k);
					count++;
				}
			}
			if(count>tmp[0]){
				tmp[0] = count;
				tmp[1] = i;
				System.out.println(tmp[0]+" "+ tmp[1]);
			}
			count=0;
		}
		return 0;
	}
}