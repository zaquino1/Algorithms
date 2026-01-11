public class BubbleSort {
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.sort(arr);
        System.out.println("Sorted array");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
    }
}

/*
* {64, 34, 25, 12, 22, 11, 90}
*
* i=0 i<7-1 = 6; i++
*  ...
*
*
*
* */