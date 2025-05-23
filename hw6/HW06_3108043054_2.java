import java.util.Arrays;
public class HW06_3108043054_2 {
        public static void main(String[] args) {
            int[][] example1 = {{1, 3, 10}, {-1, 5, 7}, {-2, 5, 12}};
            int[][] example2 = {{3}, {-1, 5}, {-2, 5, 12}};
            System.out.println(find_median(example1)); // Output: 5.0
            System.out.println(find_median(example2)); // Output: 4.0

            int[][] largeArray = new int[10000][];
            for (int i = 0; i < 10000; i++) {
                int arraySize = (int) (Math.random() * 10000) + 1;
                largeArray[i] = new int[arraySize];
                for (int j = 0; j < arraySize; j++) {
                    largeArray[i][j] = (int) (Math.random() * 10000000) - 10000000;
                }
                Arrays.sort(largeArray[i]);
            }

            double startTime = System.currentTimeMillis();
            double ans = find_median(largeArray);
            double endTime = System.currentTimeMillis();
            double elapsedTime = (endTime - startTime) / 1000;

            System.out.println(ans);
            System.out.println(elapsedTime);
        }

        public static double find_median(int[][] arrays) {
            int totalElements = 0;
            int minValue = Integer.MAX_VALUE;
            int maxValue = Integer.MIN_VALUE;

            for (int[] array : arrays) {
                totalElements += array.length;
                minValue = Math.min(minValue, array[0]);
                maxValue = Math.max(maxValue, array[array.length - 1]);
            }

            if (totalElements % 2 == 0) {
                int first = findKthElement(arrays, totalElements / 2 - 1, minValue, maxValue);
                int second = findKthElement(arrays, totalElements / 2, minValue, maxValue);
                return (first + second) / 2.0;
            } else {
                return findKthElement(arrays, totalElements / 2, minValue, maxValue);
            }
        }

        private static int findKthElement(int[][] arrays, int k, int minValue, int maxValue) {
            int low = minValue;
            int high = maxValue;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int countLessThan = 0;
                int countLessThanOrEqual = 0;

                for (int[] array : arrays) {
                    int[] counts = findLessThanOrEqualAndLessThan(array, mid);
                    countLessThanOrEqual += counts[0];
                    countLessThan += counts[1];
                }

                if (countLessThanOrEqual <= k) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return low;
        }

        private static int[] findLessThanOrEqualAndLessThan(int[] array, int value) {
            int index = binarySearch(array, value);

            if (index < 0) {
                index = -index - 1;
            } else {
                while (index < array.length && array[index] == value) {
                    index++;
                }
            }

            return new int[]{index, index};
        }
        public static int binarySearch(int[] a, int key) {
            return binarySearch0(a, 0, a.length, key);
        }
        private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                         int key) {
            int low = fromIndex;
            int high = toIndex - 1;

            while (low <= high) {
                int mid = (low + high) >>> 1;
                int midVal = a[mid];

                if (midVal < key)
                    low = mid + 1;
                else if (midVal > key)
                    high = mid - 1;
                else
                    return mid; // key found
            }
            return -(low + 1);  // key not found.
        }
    }
