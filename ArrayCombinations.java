/*
Kurt Kaiser
CTIM 168
08.02.2018
Homework: Recursive Array Combining
Chapter 11 Practice Problem 7
 */


public class ArrayCombinations
{
    // Count every element in the array
    // Get length of each internal array, output to int array
    public static void main(String[] args) {
        String[][] jaggedArray = {{"A","B"}, {"1","2"}, {"XX","YY","ZZ"}};
        // Row lengths will count all elements up until the end of that row, starting at 0
        int[] rowLengths = new int[jaggedArray.length];
        int totalJaggedCombos = 1;
        int jaggedArrayLength = jaggedArray.length;
        for (int i = jaggedArrayLength - 1; i >= 0; i--) {
            rowLengths[i] = totalJaggedCombos;
            System.out.println("all: " + rowLengths[i]);
            totalJaggedCombos *= jaggedArray[i].length;
            if (totalJaggedCombos <= 0)
                throw new IllegalStateException("Empty object in in multi-dimensional array");
        }
        /* Find correct row column using remainder operator
           Combination #11, combo count starts at 0
             rowLengths: 2, 2, 3
             11 % 3  =  2 last element of line
             11 / 3 % 2  = 3 % 2 = 1 middle element
             11 / 3 / 2 % 2  = 1 % 2 = 1 first element
             */
        for (int countJaggedElements = 0; countJaggedElements < totalJaggedCombos;
             countJaggedElements++) {
            for (int count = 0; count < jaggedArrayLength; count++) {
                int jaggedDivRow = countJaggedElements / rowLengths[count];
                jaggedDivRow = jaggedDivRow % jaggedArray[count].length;
                if (count != 0)
                   System.out.print(' ');
                System.out.print(jaggedArray[count][jaggedDivRow]);
            }
            System.out.println();
        }
    }
}


























