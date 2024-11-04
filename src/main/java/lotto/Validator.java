package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    static public boolean validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers); 
        return set.size() < numbers.size();
    }
}
