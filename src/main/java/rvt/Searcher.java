package rvt;

public class Searcher {

    public static int linearSearch(int[] array, int searched) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searched) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int value){

        int begin = 0; 
        int end = arr.length - 1;
        int middle;

        while (begin <= end){

            middle = (end + begin) / 2;

            if (arr[middle] == value){
                return middle;
            }
            else if (value > arr[middle]){
                begin = middle + 1;
            }
            else if (value < arr[middle]){
                end = middle - 1;
            }
        }
        return -1;
    }
}
