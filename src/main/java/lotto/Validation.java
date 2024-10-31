package lotto;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public static boolean isUnique(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int number:numbers) {
            if(!set.add(number)) return false;
            set.add(number);
        }
        return true;
    }

    public static boolean isNumeric(String number) {
        if(isEmptyInput(number)) return false;
        return number.chars().allMatch(Character::isDigit);
    }

    public static boolean isEmptyInput(String input) {
        return input.isEmpty();
    }

    public static boolean isInRange1To45(List<Integer> numbers) {
        for(int number:numbers) {
            if(!(number<=45 && number >=1)) return false;
        }
        return true;
    }
}
