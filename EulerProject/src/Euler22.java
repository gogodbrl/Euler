import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Euler22 {
	public static void main(String [] args){
		P22 p = new P22();
		p.print();
	}
}

class P22{
	ArrayList<String> al = new ArrayList<String>();
	private void fileRead(){
		BufferedReader br = null;
		InputStreamReader isr = null; 
		FileInputStream fis = null; 
		File file = new File("C:\\Users\\JUNGA\\Desktop\\Euler22.txt");
		String tmp = "";
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			while((tmp = br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(tmp,"\",\"");
				while(st.hasMoreElements()){
					String temp = st.nextToken();
					al.add(temp);
				}
				Collections.sort(al);
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void getNumber(){
		String tmp = "";
		long innerCount=0;
		long totalCount=0;
		for(int i=0; i<al.size(); i++){
			tmp = al.get(i);
			for(int j=0; j<tmp.length(); j++){
				innerCount = innerCount + (tmp.charAt(j)-'0'-16);
				System.out.println((tmp.charAt(j)-'0'-16) + " " +tmp.charAt(j));
			}
			totalCount = totalCount + (i+1)*innerCount;
			System.out.println( "innerCount = "+innerCount+" i = "+(i+1)+" mul = "+(innerCount*(i+1))+" arr["+i+"] = "+totalCount);
			innerCount=0;
		}
		//System.out.println(al.size());
	}
	public void print(){
		fileRead();
		getNumber();
	}
}