import java.math.BigDecimal;

class Euler16 {
	public static void main(String [] args){
		SquareDigit1 sd = new SquareDigit1();
		sd.example();
	}
}
class SquareDigit{
	double count = 0;
	public void square(){
		double pow = Math.pow(2,1000);
		while(pow>=1){
			count = count+pow%10;
			double tmp = (pow%10)/10;
			pow = pow/10;
			pow = pow - tmp;
			System.out.println(pow+" "+count);
		}
	}
}
class SquareDigit1{
	public void example(){
		BigDecimal mBigDecimal = new BigDecimal(Math.pow(2, 1000));
		System.out.println(mBigDecimal);
		String squareNum = mBigDecimal.toString();
		int count= 0;
		for(int i=0; i<squareNum.length(); i++){
			int x = Character.getNumericValue(squareNum.charAt(i));
			count = count+x;
			System.out.println(count);
		}
	}
}