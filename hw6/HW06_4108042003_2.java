package hw6;
public class HW06_4108042003_2 extends MedianOfArrays{

        public double find_median(int[][] arrays) {
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
