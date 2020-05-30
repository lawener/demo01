public class test{

	public static void main(String[] args){

	int arr[] = {3,1,5,4,2};
	
	int temp=0;
	for (int i=0;i<5;i++){
		for(int j=4;j>=0;j--){

			if(arr[i]>arr[j]){
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
}

}	
	
}
	for(int k=0;k<5;k++){
	System.out.println(arr[k]);
}


}


}