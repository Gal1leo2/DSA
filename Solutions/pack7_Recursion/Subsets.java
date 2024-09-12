package Solutions.pack7_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void printSubsets_Recurse(List<Integer> set) {
        List<Integer> current = new ArrayList<>();
        rec2(set, current, 0);
    }
    
    private static void rec2(List<Integer> set, List<Integer> current, int index) {
        if (index == set.size()) {
            System.out.println(current);
            return;
        }
        current.add(set.get(index));
        rec2(set, current, index + 1);

        current.remove(current.size() - 1);
        rec2(set, current, index + 1);

    }
    public static void printSubsetsDP(List<Integer> set) {
        List<List<Integer>> dpSub = new ArrayList<>();
        dpSub.add(new ArrayList<>());

        for (int num : set) {
            int n = dpSub.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSubset = new ArrayList<>(dpSub.get(i));
                newSubset.add(num);
                dpSub.add(newSubset);
            }
        }
        for (List<Integer> subset : dpSub) {
            System.out.println(subset);
        }
    }
}
