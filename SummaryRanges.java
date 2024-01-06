import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        BiFunction<Integer, Integer, String> range = (Integer s, Integer e) -> s.equals(e) ? Integer.toString(s) : s + "->" + e;
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;
        int start = nums[0];
        int end = start;
        for (int i = 1, n = nums.length; i < n; i++) {
            int num = nums[i];
            if (end == num - 1) {
                end = num;
                continue;
            }
            ranges.add(range.apply(start, end));
            start = end = num;
        }
        ranges.add(range.apply(start, end));
        return ranges;
    }
}
