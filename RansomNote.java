import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Integer> magazineChars = new HashMap<>();
        magazine.chars().boxed().forEach(c -> magazineChars.merge(c, 1, Integer::sum));
        for (Integer c : ransomNote.chars().boxed().collect(Collectors.toList())) {
            Integer counter = magazineChars.get(c);
            if (counter == null || counter == 0) {
               return false;
            }
             magazineChars.put(c, --counter);
        };
        return true;
    }
}
