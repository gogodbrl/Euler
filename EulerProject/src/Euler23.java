public class Euler23 {
	public static void main(String args[]){
		Dividor d1 = new Dividor();
		d1.dividor();
		
	}
}
class Dividor{
	int isOver[] = new int[28124];
	public void dividor(){
		long sum=0;
		for(int number=1; number<28124; number++){
			for(int j=1; j<=number/2; j++){
				if(number%j==0){
					sum = sum+j;
				}
			}
			if(sum==number){//완전수
			}else if(sum<number){//부족수
			}else{//초과수
				isOver[number]=-1;
			}
			sum=0;
		}
		isOver = overtake(isOver);
		Sum(isOver);
	}
	//초과수들의 합
	private int[] overtake(int[] over){//두개의 초과수로 나타낼 수 있는 합집합
		int twoArr[] = new int[28123];
		for(int i=1; i<28123; i++){
			if(over[i]==-1){ //만약 i가 초과수이면
				for(int j=1; j<28123; j++){
					if(over[j]==-1){
						if(i+j<28123){
							twoArr[i+j]=1;
						}else{
							break;
						}
					}
				}
			}
		}
		return twoArr;
	}
	private long Sum(int[] over){//초과수 두개로 나타낼 수 없는 수들의 합
		int sum=0;
		for(int i=1; i<28123; i++){
			if(over[i]!=1){
				sum = sum+i;
			}
		}
		System.out.println(sum);
		return sum;
	}
}