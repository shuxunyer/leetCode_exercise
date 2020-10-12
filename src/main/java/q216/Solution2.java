package q216;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<Integer> tmp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum3(int k, int sum) {
        dfs(1, 9, k, sum);
        return ans;
    }

    private void dfs(int cur, int max, int k, int sum) {
        if (tmp.size() > k || (tmp.size() + max - cur + 1) < k) {
            return;
        }
        if (tmp.size() == k) {
            int tmpSum = 0;
            for (int ele : tmp) {
                tmpSum += ele;
            }
            if (tmpSum == sum) {
                ans.add(new ArrayList<Integer>(tmp));
                return;
            }
        }
        tmp.add(cur);
        dfs(cur+1,max,k,sum);
        tmp.remove(tmp.size()-1);
        dfs(cur+1,max,k,sum);
    }

    public static void main(String[] args) {
        Solution2 solution2 =new Solution2();
        List<List<Integer>> lists = solution2.combinationSum3(4, 22);
        for (List<Integer> list :lists) {
            System.out.println(list.toString());
        }
        System.out.println("size="+lists.size());
    }
}
