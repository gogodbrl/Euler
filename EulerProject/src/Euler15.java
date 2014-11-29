
class Euler15 {
	public static void main(String [] args){
		RoadSearch rodeSearch = new RoadSearch();
		rodeSearch.array();
	}
}
class RoadSearch{
	private static final int WIDTH = 21; //가로
	private static final int LENGTH = 21; //세로
	private long arr[][] = new long[WIDTH][LENGTH];
	public void array(){
		for(int i=0; i<WIDTH; i++){
			for(int j=0; j<LENGTH; j++){
				if(i==0 || j==0){
					arr[i][j]=1;
				}else{
					arr[i][j]=arr[i-1][j]+arr[i][j-1];
				}
			}
		}
	}
}