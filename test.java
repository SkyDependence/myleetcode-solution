import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                if (j != nums.length - 1 && nums[j] == nums[j + 1]) {
                    j--;
                    continue;
                }
                if (i != k + 1 && nums[i] == nums[i - 1]) {
                    i++;
                    continue;
                }
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    List<Integer> arr = new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j]));
                    res.add(arr);
                }
            }
        }        
        return res;
    }

}
