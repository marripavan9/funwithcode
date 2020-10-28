package solve;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RemoveMin {

    public static void main(String[] args) {
        int[] numbers = new int[]{3,3,3,3,5,5,5,2,2,7};
        int i = removeMinSet(numbers);
        System.out.println(i);
    }

    public static int removeMinSet(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return 0;
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int num : arr) {
            if (countsMap.containsKey(num)) {
                countsMap.put(num, countsMap.get(num) + 1);
            } else {
                countsMap.put(num, 1);
            }
        }

        List<Integer> countsSorted = countsMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int minSize = 0;
        int remainingLength = arr.length;

        for (Integer count : countsSorted) {
            remainingLength -= count;
            minSize++;
            if (remainingLength <= (arr.length) / 2) {
                break;
            }
        }
        return minSize;
    }
}

