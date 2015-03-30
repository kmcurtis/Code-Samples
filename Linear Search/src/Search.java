



public class Search {

    public static String linearSer(int arr[], int key)

    {

        for (int i = 0; i < arr.length; i++) {
            if (arr.length < 1) {
                return "List Emppty!!! Number is not in list.";
            } else if (arr[i] == key) {

                return Integer.toString(key) + " is at index "
                        + Integer.toString(i);
            }

        }
        return Integer.toString(key)+" is not in the list";

    }


    public static String binarySearch(int arr[], int key, int min, int max) {
        

        int mid = ((min + max) / 2);

        if (max < min) {
            return Integer.toString(key)+" is not in the list";
        }

        else if (arr[mid] > key) {

            return binarySearch(arr, key, min, mid - 1);
        }

        else if (arr[mid] < key) {
            return binarySearch(arr, key, mid + 1, max);
        }
        else
            return key+" is at idex "+mid;

    }

}

