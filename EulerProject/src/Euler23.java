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
			if(sum==number){//������
			}else if(sum<number){//������
			}else{//�ʰ���
				isOver[number]=-1;
			}
			sum=0;
		}
		isOver = overtake(isOver);
		Sum(isOver);
	}
	//�ʰ������� ��
	private int[] overtake(int[] over){//�ΰ��� �ʰ����� ��Ÿ�� �� �ִ� ������
		int twoArr[] = new int[28123];
		for(int i=1; i<28123; i++){
			if(over[i]==-1){ //���� i�� �ʰ����̸�
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
	private long Sum(int[] over){//�ʰ��� �ΰ��� ��Ÿ�� �� ���� ������ ��
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