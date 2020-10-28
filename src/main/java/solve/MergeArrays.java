package solve;

import java.util.Arrays;

class MergeArrays {
    public static int[] merge(int[] a, int[] b) {

        int aLength = a.length;
        int bLength = b.length;

        if(aLength == 0 && bLength == 0) {
            return new int[0];
        }
        if(aLength == 0) {
            return b;
        }
        if(bLength == 0) {
            return a;
        }

        int[] result = new int[aLength + bLength];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length && j < b.length) {
            result[k++] = a[i] < b[j] ? a[i++] :  b[j++];
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int []{1,2,3};
        int[] b = new int []{2,5,6};
        int[] merge = merge(a, b);
        System.out.println(Arrays.toString(merge));
    }
}
