import java.util.ArrayList;
import java.util.List;

class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                indexes.add(i);
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            nums[i] = nums[indexes.get(i)];
        }
        return indexes.size();
    }
}