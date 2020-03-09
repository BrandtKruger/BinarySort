package com.kruger.brandt;

public class Main {

    static int partition(int[] array, int begin, int end) {
        int pivot = end;

        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter];
                array[counter] = array[i];
                array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot];
        array[pivot] = array[counter];
        array[counter] = temp;

        return counter;
    }

    public static int[] quickSort(int[] array, int begin, int end) {
        if (end <= begin) return array;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot-1);
        quickSort(array, pivot+1, end);

        return array;
    }

    private  static int searchNumberIndex(int[] data, int valueToSearch){

        int[] sortedArray = quickSort(data, 0, data.length - 1);
        int middle = data.length / 2;

        for (int i = 0; i < sortedArray.length; i++) {

            if (valueToSearch < sortedArray[middle]){
                middle = (middle - 1) /  2;

                if (valueToSearch == sortedArray[middle]) {
                    return middle;
                }
            } else if (valueToSearch == sortedArray[middle]){
                return middle;
            } else if (valueToSearch > sortedArray[middle]){
                middle =  middle + (sortedArray.length - middle) / 2;

                if (valueToSearch == sortedArray[middle]) {
                    return middle;
                }
            }
        }
        return middle;
    }

    public static void main(String[] args) {

        int[] data = {3,2,5,7,4,1,3,8,9,5,44,23,67,54,11,};

        System.out.println(searchNumberIndex(data, 23));

    }
}
