import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/**
 * Experiment with bubble sort.
 */
public class BubbleSort {


    // **** define sort order ****
    static final int ASC_ORDER  = 0;
    static final int DES_ORDER  = 1;


    /**
     * Swap adjacent elements in array index i and i + 1.
     * Auxiliary function.
     */
    private static int[] swapAdjacent(int[] arr, int i) {

        // **** swap elements ****
        int tmp     = arr[i];
        arr[i]      = arr[i + 1];
        arr[i + 1]  = tmp;

        // **** return swapped array ****
        return arr;
    }


    /**
     * Sort the array using Bubble Sort.
     * 
     * Runtime: O(n**2) Space: O(1)
     * 
     * @param args
     * @throws IOException
     */
    static int[] bubbleSort(int[] arr, int sortOrder) {

        // **** sanity check(s) ****
        if (arr == null) return null;
        int n = arr.length;
        if (n <= 1) return arr;

        // **** initialization (to avoid changing order of the input array) ****
        int[] sorted = arr.clone();

        // **** sort array ****
        for (var i = 0; i < n - 1; i++) {

            // **** ****
            for (var j = 0; j < n - i - 1; j++) {

                // **** swap values in ascending order ****
                if (sortOrder == ASC_ORDER && sorted[j] > sorted[j + 1]) {
                    sorted = swapAdjacent(sorted, j);
                } 
                
                // **** swap values in descending order ****
                else if (sortOrder == DES_ORDER && sorted[j] < sorted[j + 1]) {
                    sorted = swapAdjacent(sorted, j);
                }
            }
        }

        // **** return sorted array ****
        return sorted;
    }


    /**
     * Test scaffold.
     * 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        // **** open buffered reader ****
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // **** read array of integers ****
        int[] arr = Arrays.stream(br.readLine().trim().split(","))
                            .map(x -> x.trim())
                            .mapToInt(Integer::parseInt)
                            .toArray();

        // **** close buffered reader ****
        br.close();

        // ???? display array ????
        System.out.println("main <<<        arr: " + Arrays.toString(arr));

        // **** sort array using bubble sort ****
        int[] sorted = bubbleSort(arr, ASC_ORDER);
        
        // ???? display sorted array ????
        System.out.println("main <<<  ascending: " + Arrays.toString(sorted));


        // ???? ????
        System.out.println("main <<<        arr: " + Arrays.toString(arr));

        
        // **** sort array using bubble sort ****
        sorted = bubbleSort(arr, DES_ORDER);

        // ???? display sorted array ????
        System.out.println("main <<< descending: " + Arrays.toString(sorted));
    }

}