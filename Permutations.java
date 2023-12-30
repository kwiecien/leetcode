import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, 0, permutations);
        return permutations;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> permutations) {
        if (start == nums.length) {
            List<Integer> permutation = Arrays.stream(nums).boxed().collect(Collectors.toList());
            permutations.add(permutation);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, permutations);
            swap(nums, start, i);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}