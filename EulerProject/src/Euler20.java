import java.math.BigInteger;
import java.util.ArrayList;


class Euler20 {
	public static void main(String [] args){
		/*Problem20 p = new Problem20();
		p.problem();*/
		P20 p = new P20();
		p.bigInteger();
	}
}
/*class Problem20{
	ArrayList<Integer> al = new ArrayList<>();
	int arr[] = new int[101];
	
	public int [] init(int arr[]){
		int value=1;
		for(int i=0; i<10; i++){
			arr[i]=value;
			value++;
		}
		return arr;
	}
	public void problem(){
		init(arr);
		
		al.add(0,1);
		int index=0;
		for(int i=2; i<10; i++){
			int value = al.get(index)*i;
			al.set(index, value);
			for(int k=0; k<al.size(); k++){
				int tmp = al.get(index);
				
				if(al.get(index)>=10){
					if(index==0){
					}
					System.out.println(value);
				}
			}
			for(int j=0; j<al.size();j++){
				System.out.println(value);
			}
		}
		
	}
	public void alHandle(int index){
		if(al.get(index)>=10){
			if(index==0 && al.get(index+1)>=0){
				
			}
		}
	}
}
*/
class P20{
	public void bigInteger(){
		BigInteger big = new BigInteger("1");
		for(int i=1; i<=100; i++){
			big = big.multiply(BigInteger.valueOf(i));
			System.out.println("arr["+i+"] = "+ big);
		}
		String tmp = big.toString();
		int count=0;
		for(int j=0; j<tmp.length(); j++){
			count = count+tmp.charAt(j)-'0';
			System.out.println(count + " "+tmp.charAt(j));
		}
		
	}
}