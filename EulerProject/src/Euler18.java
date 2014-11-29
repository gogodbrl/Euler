import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Euler18 {
	public static void main(String [] args){
		ArrayList<Integer> al = null;
		FileRead fr = new FileRead();
		al = fr.read();
		/*Triangle t= new Triangle();
		t.triangle(al);*/
		
		/*Test t1 = new Test();
		t1.tri(al);*/
		
		Test2 t2= new Test2();
		t2.tri2(al);
	}
}
class FileRead{
	BufferedReader br = null;
	FileInputStream fis = null;
	InputStreamReader isr = null;
	ArrayList<Integer> arrayList = new ArrayList<Integer>();
	
	public ArrayList<Integer> read(){ //파일을 읽어볼까요
		File file = new File("C:\\Users\\JUNGA\\Desktop\\Oiler18.txt");
		String temp = "";
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);
			
			while((temp=br.readLine())!=null){
				StringTokenizer st = new StringTokenizer(temp);
				while(st.hasMoreTokens()){
					int tmp = Integer.parseInt(st.nextToken());
					//System.out.println(tmp + "\t");
					arrayList.add(tmp);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arrayList;
	}
}
class Triangle{
	public void triangle(ArrayList<Integer> al){
		int k=0;
		int max = 0;
		int sum = 0;
		int findIndex =0;
		final int LINE = 15; //라인수
		for(int i=0; i<LINE; i++){
			k = i+k+1; //삼각형 오른쪽 맨 마지막 인덱스
			max=0;
			//find MAX
			for(int j=k-i-1; j<k; j++){ //각 줄의 처음부터 마지막까지
				if((int)al.get(j)>max){
					max = (int)al.get(j);
					findIndex = j; //한 줄에서 최댓값을 갖는 인덱스
				}
			}
			//find IndexLine(n-1, n, n+1)
			System.out.println("k: "+k+" "+max+ " ");
			//sum = sum+findIndex;
		}
		System.out.println(sum);
	}
}
class Test{
	public void tri(ArrayList al){
		int max = (int)al.get(0);
		int sum = max;
		int findIndex =0;
		for(int i=1; i<15; i++){ //LINE 갯수
			max=0;
			int tmp = i+findIndex;
			System.out.println("i : "+i+" index : "+findIndex);
			System.out.println(" i+findIndex : "+(i+findIndex) + "   i+findIndex+1 : "+(i+findIndex+1));
			for(int p=tmp; p<=tmp+1; p++){
				System.out.println("p : "+p);
				if((int)al.get(p)>max){
					max = (int)al.get(p);
					findIndex = p; //한 줄에서 최댓값을 갖는 인덱스
				}
			}
			sum = sum+(int)al.get(findIndex);
			System.out.println("findIndex :"+findIndex+ " value :"+(int)al.get(findIndex) + " sum : "+sum);
		}
	}
}
class Test2{
	ArrayList<Integer> tmpList = new ArrayList<Integer>();
	public void tri2(ArrayList<Integer> al){
		tmpList.add(al.get(0));
		int k=1; //말하자면 한 행의 끝을 잡아주는 역할
		int index = 0; //상위 인덱스
		int beforeP=0; //겹치는 값에 대해 비교해주기 위함
		int beforeIndex = 0; // 겹치는 인덱스를 비교하기 위함
		for(int i=1; i<15; i++){
			int tmp = index+i;
			k= i+k+1;
			for(int j=k-i; j<k; j++){ //한행씩 for문 계산
				for(int p=tmp; p<tmp+2; p++){ //상위 인덱스에 대해 인접한 두개만 
					if(beforeP==p){ //만약에 겹치게 되면 (예를들어 인덱스 4나 7,8같은거)
						int beforeValue = tmpList.get(beforeIndex)+al.get(p); //이전 인덱스에서 가진 값
						int nowValue = tmpList.get(index)+al.get(p); //이후 인덱스에서 가진 값
						if(beforeValue<nowValue){ //이후값이 더크면
							tmpList.add(p,nowValue); //교체해줘야지 
						}
					}else{ //안겹치는값(예를 들어 인덱스 3, 5 같은거)
						tmpList.add(p,(int)tmpList.get(index)+al.get(p)); //그냥 추가하면 됨
					}
					beforeP = p; 
				}
				tmp = tmp+1;
				beforeIndex = index;
				index++;
			}
		}
		k =0; // 출력
		for(int i=0; i<15; i++){
			k = i+k+1; //삼각형 오른쪽 맨 마지막 인덱스
			//find MAX
			for(int j=k-i-1; j<k; j++){ //각 줄의 처음부터 마지막까지
				System.out.print(" "+tmpList.get(j));
			}
			System.out.println();
		}
	}
}