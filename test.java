import java.util.*;

public class test {
    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[i] = nums[i + 1];
                }
                nums[nums.length - 1] = 0;
            }
        }
    }

}
