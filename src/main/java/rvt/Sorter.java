package rvt;

public class Sorter {

    public static int smallest(int[] arr){

        int smallest = arr[0];

        for(int number : arr)
        {
            if(smallest > number)
            {
                smallest = number;
            }
        }
        return smallest;
    }

    public static int indexOfSmallest(int[] arr){

        int smallest = arr[0];
        int index = 0;

        for(int i = 0; i < arr.length; i++)
        {
            if(smallest > arr[i])
            {
                smallest = arr[i];
                index = i;

            }
        }
        return index;
    }

    public static int indexOfSmallestFrom(int[] arr, int startIndex) {
        
        int smallest = arr[startIndex];
        int index = startIndex;

        for (int i = startIndex; i < arr.length; i++){
            if(smallest > arr[i])
            {
                smallest = arr[i];
                index = i;

            }
        }
        return index;
    }

    public static void swap(int[] array, int index1, int index2) {

        int backup = array[index1];
        array[index1] = array[index2];
        array[index2] = backup;
    }

    public static void sort(int[] array) {
 
        int index;
        for (int i = 0; i < array.length; i++){
            index = indexOfSmallestFrom(array, i);
            swap(array, i, index);
        }
    }
}
