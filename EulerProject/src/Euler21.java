

class Euler21 {
	public static void main(String [] args){
		P21 p = new P21();
		p.friendlySu();
	}
}

class P21{
	int one[]=new int[2];
	/*
	 * d(a) = b 에서
	 * d(i) = findDivisor(i) 에 해당
	 */
	int count=0;
	public void friendlySu(){
		for(int i=1; i<=10000; i++){
			one[0]=findDivisor(i); 
			one[1]=findDivisor(one[0]); 
			if(i==one[1] && i!=one[0]){ //i!=one[0] 같은수를 두번 더하면 안됨.
				count = count+one[1];   //예를 들면 d(6)=6 같은 수.
			}
			System.out.println(count);
		}
	}
	private int findDivisor(int divisor){
		int total=0; //합을 구함
		int check=0; //약수가 교차되서 두번 곱해지는 것을 방지
		int i=1;
		do{
			if(divisor%i==0){
				check = divisor/i;
				total+=i+divisor/i; //약수를 두개 다 더함
			}
			i++;
		}while(check>i);
		total = total-divisor;
		return total;
	}
}