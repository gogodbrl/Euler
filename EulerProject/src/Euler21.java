

class Euler21 {
	public static void main(String [] args){
		P21 p = new P21();
		p.friendlySu();
	}
}

class P21{
	int one[]=new int[2];
	/*
	 * d(a) = b ����
	 * d(i) = findDivisor(i) �� �ش�
	 */
	int count=0;
	public void friendlySu(){
		for(int i=1; i<=10000; i++){
			one[0]=findDivisor(i); 
			one[1]=findDivisor(one[0]); 
			if(i==one[1] && i!=one[0]){ //i!=one[0] �������� �ι� ���ϸ� �ȵ�.
				count = count+one[1];   //���� ��� d(6)=6 ���� ��.
			}
			System.out.println(count);
		}
	}
	private int findDivisor(int divisor){
		int total=0; //���� ����
		int check=0; //����� �����Ǽ� �ι� �������� ���� ����
		int i=1;
		do{
			if(divisor%i==0){
				check = divisor/i;
				total+=i+divisor/i; //����� �ΰ� �� ����
			}
			i++;
		}while(check>i);
		total = total-divisor;
		return total;
	}
}