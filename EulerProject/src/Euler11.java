import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Euler11 {
	public static void main(String [] args){
		FileRead fileread = new FileRead();
		Calc calc = new Calc();
		calc.parrall(fileread.read());
		calc.vertax(fileread.read());
		calc.crossGaro(fileread.read());
		calc.crossSero(fileread.read());
	}
}
class FileRead{
	BufferedReader br = null;
	FileInputStream fis = null;
	InputStreamReader isr = null;
	public int[][] read(){ //파일 불러와서 배열에 저장하기
		File file = new File("C:\\Users\\JUNGA\\Desktop\\Oiler11.txt");
		String temp = "";
		int arr[][] = new int[20][20];
		
		int i=0;
		int j=0;
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			while((temp = br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(temp);
				while(st.hasMoreTokens()){
					String t = st.nextToken();
					arr[i][j] = Integer.parseInt(t);
					//System.out.println("i :"+i+" j :"+j+" arr="+arr[i][j]);
					j++;
				}
				i=i+1;
				j=0;
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	}
	
}
class Calc{
	public void parrall(int arr[][]){
		int tmp;
		int max=0;
		for(int i=0; i<20; i++){
			for(int j=0; j<20-3; j++){
				tmp = arr[i][j]*arr[i][j+1]*arr[i][j+2]*arr[i][j+3];
				if(tmp>max)
					max = tmp;
			}
		}
		System.out.println("max : "+max);
	}
	public void vertax(int arr[][]){
		int tmp;
		int max =0;
		for(int i=0; i<20; i++){
			for(int j=0; j<20-3; j++){
				tmp = arr[j][i]* arr[j+1][i]*arr[j+2][i]*arr[j+3][i];
				if(tmp>max)
					max = tmp;
			}
		}
		System.out.println("max : "+max);
	}
	public void crossGaro(int arr[][]){
		int tmp;
		int max =0;
		for(int i=0; i<20-3; i++){
			for(int j=0; j<20-3; j++){
				tmp = arr[i][j]*arr[i+1][j+1]*arr[i+2][j+2]*arr[i+3][j+3];
				if(tmp>max)
					max=tmp;
			}
		}
		System.out.println("max : "+max);
	}
	public void crossSero(int arr[][]){
		int tmp;
		int max =0;
		for(int i=0; i<20-3; i++){
			for(int j=20-1; j>3; j--){
				tmp = arr[i][j]*arr[i+1][j-1]*arr[i+2][j-2]*arr[i+3][j-3];
				if(tmp>max)
					max=tmp;
			}
		}
		System.out.println("max : "+max);
	}
}