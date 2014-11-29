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
	
	public ArrayList<Integer> read(){ //������ �о���
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
		final int LINE = 15; //���μ�
		for(int i=0; i<LINE; i++){
			k = i+k+1; //�ﰢ�� ������ �� ������ �ε���
			max=0;
			//find MAX
			for(int j=k-i-1; j<k; j++){ //�� ���� ó������ ����������
				if((int)al.get(j)>max){
					max = (int)al.get(j);
					findIndex = j; //�� �ٿ��� �ִ��� ���� �ε���
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
		for(int i=1; i<15; i++){ //LINE ����
			max=0;
			int tmp = i+findIndex;
			System.out.println("i : "+i+" index : "+findIndex);
			System.out.println(" i+findIndex : "+(i+findIndex) + "   i+findIndex+1 : "+(i+findIndex+1));
			for(int p=tmp; p<=tmp+1; p++){
				System.out.println("p : "+p);
				if((int)al.get(p)>max){
					max = (int)al.get(p);
					findIndex = p; //�� �ٿ��� �ִ��� ���� �ε���
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
		int k=1; //�����ڸ� �� ���� ���� ����ִ� ����
		int index = 0; //���� �ε���
		int beforeP=0; //��ġ�� ���� ���� �����ֱ� ����
		int beforeIndex = 0; // ��ġ�� �ε����� ���ϱ� ����
		for(int i=1; i<15; i++){
			int tmp = index+i;
			k= i+k+1;
			for(int j=k-i; j<k; j++){ //���྿ for�� ���
				for(int p=tmp; p<tmp+2; p++){ //���� �ε����� ���� ������ �ΰ��� 
					if(beforeP==p){ //���࿡ ��ġ�� �Ǹ� (������� �ε��� 4�� 7,8������)
						int beforeValue = tmpList.get(beforeIndex)+al.get(p); //���� �ε������� ���� ��
						int nowValue = tmpList.get(index)+al.get(p); //���� �ε������� ���� ��
						if(beforeValue<nowValue){ //���İ��� ��ũ��
							tmpList.add(p,nowValue); //��ü������� 
						}
					}else{ //�Ȱ�ġ�°�(���� ��� �ε��� 3, 5 ������)
						tmpList.add(p,(int)tmpList.get(index)+al.get(p)); //�׳� �߰��ϸ� ��
					}
					beforeP = p; 
				}
				tmp = tmp+1;
				beforeIndex = index;
				index++;
			}
		}
		k =0; // ���
		for(int i=0; i<15; i++){
			k = i+k+1; //�ﰢ�� ������ �� ������ �ε���
			//find MAX
			for(int j=k-i-1; j<k; j++){ //�� ���� ó������ ����������
				System.out.print(" "+tmpList.get(j));
			}
			System.out.println();
		}
	}
}