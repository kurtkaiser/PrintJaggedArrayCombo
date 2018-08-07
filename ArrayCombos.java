/*
Kurt Kaiser
CTIM 168
08.02.2018
Homework: Recursive Array Combining
Chapter 11 Practice Problem 7
 */


public class ArrayCombos
{
    /* Find correct row column using remainder operator
           Combination #11, combo count starts at 0
             rowLengths: 2, 2, 3
             11 % 3  =  2 last element of line
             11 / 3 % 2  = 3 % 2 = 1 middle element
             11 / 3 / 2 % 2  = 1 % 2 = 1 first element
             */
    static void printCombinations(String[][] jaggedArray, int[]allLengths, int[]counts){
       // Count up to the number of combos in an array
        int countCombos = counts[0];
        int countArrayLength = counts[1];
        if(countCombos < allLengths[jaggedArray.length] ){
            if(counts[1] < jaggedArray.length) {
                int jaggedDivRow = countCombos / allLengths[countArrayLength];
                int counter = countArrayLength;
                jaggedDivRow = jaggedDivRow % jaggedArray[counter].length;
                if (counts[1] != 0) System.out.print(" ");
                System.out.print(jaggedArray[countArrayLength][jaggedDivRow]);
                countArrayLength++;
            } else {
                countArrayLength = 0;
                countCombos++;
                System.out.println();
            }
        } else {
            return;
        }
        counts[0] = countCombos;
        counts[1] = countArrayLength;
        printCombinations(jaggedArray, allLengths,counts);
    }

    // Count every element in the array
    // Get length of each internal array, output to int array
    public static int[] getLengths (String[][] jaggedArray){
        /* allLengths lengths will count all elements up until the end of that row, starting at 0
            the last number of the array is the total number of combinations possible*/
        int[] allLengths = new int[jaggedArray.length + 2];
        int jaggedArrayLength = jaggedArray.length;
        int totalCombinations = 1;
        // First element in int array is total count of combinations of elements
        allLengths[0] = 1;
        for (int i = jaggedArrayLength - 1; i >= 0; i--) {
            allLengths[i] = totalCombinations;
            totalCombinations *= jaggedArray[i].length;
            System.out.println("all: " + allLengths[i]);
            if (allLengths[i] <= 0)
                throw new IllegalStateException("Empty object in in multi-dimensional array");
        }
        allLengths[jaggedArrayLength] = totalCombinations;
        return allLengths;
    }

    // Go main! Go!
    public static void main(String[] args) {
        String[][] jaggedArray = {{"A","B"},
                {"1","2"},
                {"XX","YY","ZZ"}};
        int[] allLengths = getLengths(jaggedArray);
        int[] counts = {0, 0};
        printCombinations(jaggedArray, allLengths, counts);
    }

}
