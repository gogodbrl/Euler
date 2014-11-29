class Euler12 {
	public static void main(String [] args){
		Yaksu yaksu = new Yaksu();
		yaksu.su();
	}
}
class Yaksu{
	public int sangaksu(int num){
		int k=0;
		for(int i=1; i<=num; i++){
				k = k+i;
			}
		return k;
	}
	public void su(){
		int num=1;
		int sankak = 1;
		int i=1;
		while(getCount(sankak)<=500){
			i=i+1;
			num=num+1;
			sankak = sangaksu(num);
		}
		
	}
	public int getCount(int sankaksu){
		int i=0;
		int count=0;
		while(sankaksu!=i){
			i++;
			if(sankaksu%i==0){
				count++;
			}
		}
		return count;
	}
}