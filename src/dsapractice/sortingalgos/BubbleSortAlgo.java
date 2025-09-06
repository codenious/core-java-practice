package dsapractice.sortingalgos;

public class BubbleSortAlgo {

    public static void main(String[] args) {
        int[] array = {13,46,24,52,20,9};
        bubbleSortMethod(array);
        for(int n: array) System.out.println(n);
    }

    public static void bubbleSortMethod(int[] arr){

       for(int i =0;i<arr.length -1 ;i++){
           int didSwap = 0;
           for(int j = 0; j < arr.length - 1 - i; j++){
               if(arr[j] > arr[j + 1]){
                   int temp = arr[j];
                   arr[j] = arr[j + 1];
                   arr[j +  1]  = temp;
                   didSwap = 1;
               }
           }
           if( didSwap == 0 ) break;
       }


        }
}
