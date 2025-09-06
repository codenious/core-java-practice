package dsapractice.sortingalgos;

public class SelectionSortPractice {

    public static void main(String[] args) {

        int[] array = {13,46,24,52,20,9};
        selectionSort(array);
        for(int n: array) System.out.println(n);
    }

    public static void selectionSort(int[] arr){

        for(int i=0;i<arr.length -1;i++){
            int min = i;
            for(int j=i+1;j<arr.length ;j++){
                if(arr[j] < arr[min]) {
                    min = j;
                }

            }
            swapNumbers(arr, i , min);
        }
    }

    public static void swapNumbers (int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
