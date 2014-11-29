
class Euler19 {
	public static void main(String [] args){
		Problem19 p19 = new Problem19();
		p19.findDay();
	}
}
class Problem19{
	public boolean thirtyMonth(int month){ //30일인날 계산
		if(month==4 ||month==6||month==9||month==11){
			return true;
		}
		return false;
	}
	public int leapYear(int year){ //윤년계산
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
		/* lastdate (lastdate가 토요일로 끝나는날 즉 "6"의 값을 가지면 count를 올려줍니다.)
		 * 월 = 1, 화 = 2, 수 = 3,
		 * 목 = 4, 금 = 5, 토 = 6, 일 = 0;
		 */
		for(int year=1900; year<2001; year++){
			for(int month=1; month<=12; month++){
				if(lastdate==6){
					count = count+1;
				}
				System.out.println(month+"월");
				if(thirtyMonth(month)){ //4월 6월 9월 11월
					day = 30;
					date(arr,day,lastdate);
				}
				else if(month==2){//2월
					day = leapYear(year);
					date(arr,day,lastdate);
				}else{//나머지 월
					day = 31;
					date(arr,day,lastdate);
				}
				lastdate = (lastdate+day)%7; //첫째날이 무슨요일인지 계산합니다.
				System.out.println("lastdate ="+lastdate);
				System.out.println();
			}
			for(int i=0; i<day; i++){ //배열 초기화
				arr[i]=0;
			}
			System.out.println("누적 YEAR("+year+") count ="+count+"에서 -2해줘야됨 그래서 답은"+(count-2));
		}
	}
	public int date(int arr[], int day, int lastdate){ 
		for(int i=1; i<=day; i++){
			arr[i]=i;
			System.out.print(arr[i]+"\t");
			if((lastdate+i)%7==0){ //7일로 나누어지면
				System.out.println();
			}
		}
		return lastdate;
	}
}