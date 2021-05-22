// Merge Sort Starter      A+CR
class Main {
  
	static int[] arr;

	// Creates temporary array and calls sortHelper
	public static void mergeSort(int[] elements){
		int [] temp = new int[elements.length];
    sortHelper(elements,0,elements.length-1,temp);

	}

	// Recursively calls itself to split the array before merging the array in order
	public static void sortHelper(int[] elements, int from, int to, int[] temp){
		if(from<to){
      int middle = (from+to)/2;
      sortHelper(elements,from,middle,temp);
      sortHelper(elements,middle+1,to,temp);
      merge(elements,from,middle,to,temp);
    }
	}

	// Merges the elements into the temp array. Lastly a copy is made to the static array, arr.
	public static void merge(int[] elements, int from, int middle, int to, int[] temp){
		int i= from;
    int j = middle+1;
    int k = from;

    while(i<=middle && j<=to){
      if(elements[i]<elements[j]){
        temp[k] = elements[i];
        i++;
      }else{
        temp[k] = elements[j];
        j++;
      }
      k++;
    }
    while(i<=middle){
      temp[k] = elements[i];
      i++;
      k++;
    }
		while(j<=to){
      temp[k] = elements[j];
      j++;
      k++;
    }

    for(int m=from;m<=to;m++){
      elements[m] = temp[m];
    }
	}

	public static void printArray(int[] arr){
		System.out.print("[ ");
		for(int n : arr){
			System.out.print(n + " ");
		}
		System.out.println("]");
		System.out.println();
	}

	public static void main(String[] args) {
    
	arr = new int[4];
	// for(int i = 0; i < arr.length; i++){
	// 	arr[i] = (int)(Math.random() * 100);
	// }
	arr[0] = 99;
	arr[1] = 38;
	arr[2] = 46;
	arr[3] = 87;

	System.out.println("Unsorted:");
	printArray(arr);

	mergeSort(arr);

	System.out.println("Sorted:");
	printArray(arr);
  }
}