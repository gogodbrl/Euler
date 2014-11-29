
class Euler19 {
	public static void main(String [] args){
		Problem19 p19 = new Problem19();
		p19.findDay();
	}
}
class Problem19{
	public boolean thirtyMonth(int month){ //30���γ� ���
		if(month==4 ||month==6||month==9||month==11){
			return true;
		}
		return false;
	}
	public int leapYear(int year){ //������
		if(year%4==0 && year%100!=0){
			return 29;
		}
		if(year%400==0){
			return 29;
		}
		return 28;
	}
	public void findDay(){ 
		int arr[] = new int[37];
		int day=0;
		int lastdate=0;
		int count=0;
		/* lastdate (lastdate�� ����Ϸ� �����³� �� "6"�� ���� ������ count�� �÷��ݴϴ�.)
		 * �� = 1, ȭ = 2, �� = 3,
		 * �� = 4, �� = 5, �� = 6, �� = 0;
		 */
		for(int year=1900; year<2001; year++){
			for(int month=1; month<=12; month++){
				if(lastdate==6){
					count = count+1;
				}
				System.out.println(month+"��");
				if(thirtyMonth(month)){ //4�� 6�� 9�� 11��
					day = 30;
					date(arr,day,lastdate);
				}
				else if(month==2){//2��
					day = leapYear(year);
					date(arr,day,lastdate);
				}else{//������ ��
					day = 31;
					date(arr,day,lastdate);
				}
				lastdate = (lastdate+day)%7; //ù°���� ������������ ����մϴ�.
				System.out.println("lastdate ="+lastdate);
				System.out.println();
			}
			for(int i=0; i<day; i++){ //�迭 �ʱ�ȭ
				arr[i]=0;
			}
			System.out.println("���� YEAR("+year+") count ="+count+"���� -2����ߵ� �׷��� ����"+(count-2));
		}
	}
	public int date(int arr[], int day, int lastdate){ 
		for(int i=1; i<=day; i++){
			arr[i]=i;
			System.out.print(arr[i]+"\t");
			if((lastdate+i)%7==0){ //7�Ϸ� ����������
				System.out.println();
			}
		}
		return lastdate;
	}
}