import java.util.Random;

public class Application {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// This will get the unique array for the selection and shell sort
		int randomArray[] = createArray(1050, 700);


// Selection sort 
        System.out.println("The Selection Sort");
        // This will track the wall clock time of the current selection sort
        long startTime = System.nanoTime();
        selectionSort(randomArray);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;

        // Displays the wall-clock time
        System.out.println("wall-clock: " + duration + "ms");


 // Shell Sort
        System.out.println("\nThe Shell Sort");

        // Tracks wall clock time of the current shell sort
        startTime = System.nanoTime();
        shellSort(randomArray);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000;


        // Returns the wall clock time
        System.out.println("wall-clock: " + duration + "ms");
        
        
        
       
        
	}

	public static int[] selectionSort(int[] randomArray) {
		int n = randomArray.length;

        for(int i = 0; i < n-1; i++){
            int min_index = i;
            for(int j = i + 1; j < n; j++){
                if(randomArray[j] < randomArray[min_index]){
                    min_index = j;
                }
            }
            int temp = randomArray[min_index];
            randomArray[min_index] = randomArray[i];
            randomArray[i] = temp;
        }
        int comparisons = ((n + 1) * (n/2));
        System.out.println("Comparisons: " + comparisons);
        //return the sorted array
        return randomArray;
	}

	public static int[] shellSort(int[] randomArray) {
		int n = randomArray.length;
		int shellcomparisons = 0;
	     
        for (int gap = n/2; gap > 0; gap /= 2)
        {
             
            for (int i = gap; i < n; i += 1)
            {
            	shellcomparisons++;
                int temp = randomArray[i];
 
                // Shift the earlier gap elements up until the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && randomArray[j - gap] > temp; j -= gap)
                    randomArray[j] = randomArray[j - gap];

                randomArray[j] = temp;

            }
        }
        System.out.println("Comparisons: " + shellcomparisons);
        return randomArray;
	}

	public static int[] createArray(int range, int arrayLength) {
		int[] arr = new int[arrayLength];
   		Random rand = new Random();
           for(int i=0; i < arrayLength; i++){
               arr[i] = rand.nextInt(range);   
               for (int j = 0; j < i; j++){
                   if (arr[i] == arr[j]){
                       i--;
                   }
               }
           }
           
           //return the array;
           return arr;
           
	}

}
