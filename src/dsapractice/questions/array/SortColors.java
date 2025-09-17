package dsapractice.questions.array;

//Dutch National Flag Algorithm
/*You are given an array nums with n integers where each integer is one of these three values:
0 → represents color Red
1 → represents color White
2 → represents color Blue
You need to sort the array in-place (without using the built-in sort function), so that the same colors are adjacent, in the order:
*Input:
nums = [2,0,2,1,1,0]
Output:
[0,0,1,1,2,2]
*
*
* */
public class SortColors {

    public static void main(String[] args) {

        int[] arr = {2,0,2,1,1,0};

        sortColors(arr);

        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static void sortColors(int[] arr){

        int low = 0, mid = 0, high = arr.length - 1;

        while(mid <= high){

            if(arr[mid] == 0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low ++;
                mid++;
            } else if(arr[mid] == 1) mid++;
            else {
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                high--; //because high can contain either 1 or 0 or 2 so mid won't be sorted but high is that why high -- and not mid++
            }
        }
    }
}
