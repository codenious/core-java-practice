package dsapractice.questions.array;

public class SortZeroes {

    public static void main(String[] args) {
        int arr[] = {1,0,0,4,9,10,0,0,18};

        sortZeroes(arr);

        for(int a: arr){
            System.out.print(a + " ");
        }
    }

    public static void sortZeroes(int[] arr){
        int nonZero = 0;

        for(int i = 0;  i< arr.length; i++){
            if(arr[i] != 0){
                arr[nonZero++] = arr[i];
            }
        }

        while(nonZero < arr.length){
            arr[nonZero++] = 0;
        }

    }
}
