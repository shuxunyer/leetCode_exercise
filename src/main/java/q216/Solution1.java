package q216;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    List<Integer> tmp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    int max = 1 << 9;

    public List<List<Integer>> combinationSum3(int k, int n) {
        for (int mask = 0; mask < max; mask++) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<Integer>(tmp));
                System.out.println(tmp.toString());
            }
        }
        return ans;
    }

    private boolean check(int mask, int k, int n) {
        tmp.clear();
        for (int i = 0; i < 9; i++) {
            if ((1 << i & mask) != 0) {
                tmp.add(i+1);
            }
        }
        if (tmp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int ele : tmp) {
            sum += ele;
        }
        if (sum != n) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution =new Solution1();
        List<List<Integer>> lists = solution.combinationSum3(4, 22);
        for (List<Integer> list :lists) {
            System.out.println(list.toString());
        }
        System.out.println("size="+lists.size());
    }
}
