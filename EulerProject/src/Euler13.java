import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Euler13 {
	public static void main(String [] args){
		FileRead fileread = new FileRead();
		fileread.read();
	}
}
class FileRead{
	BufferedReader br = null;
	FileInputStream fis = null;
	InputStreamReader isr = null;
	int arr[] = new int[50];
	int result[] = new int[70];
	public void read(){//한줄씩 가져와서 배열에 넣는다.
		File file = new File("C:\\Users\\JUNGA\\Desktop\\Oiler13-1.txt");
		String temp = "";
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			while((temp = br.readLine())!=null){
				for(int i=0; i<temp.length(); i++){
					arr[temp.length()-i-1] = temp.charAt(i)-'0';
					System.out.print("arr["+(temp.length()-i-1)+"]="+arr[temp.length()-i-1]);
				}
				plus(result,arr);
				System.out.println();
			}
			for(int i=0; i<result.length; i++){
				System.out.print(" "+result[result.length-i-1]);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int[] plus(int result[], int arr[]){
		int i=0;
		while(i<arr.length){
			result[i] = result[i]+arr[i];
			System.out.print("  "+result[arr.length-1-i]);
			i++;
		}
		return isPlus(result);
	}
	public int[] isPlus(int result[]){
		for(int i=0; i<result.length; i++){
			if(result[i]<10){
				continue;
			}else{
				result[i+1]= result[i+1]+1;
				result[i]= result[i]-10;
			}
		}
		return result;
	}
	public int tenPlus(){
		int tmp=0;
		for(int i=0; i<10; i++){
			tmp=tmp+result[i];
		}
		return tmp;
	}
}