package lotto;

import java.util.HashSet;
import java.util.List;

public class Validation {
    public static boolean validateNoDuplication(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for(int number:numbers) {
            if(!set.add(number)) return false;
            set.add(number);
        }
        return true;
    }

    public static boolean validateNumber(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    public static boolean isEmptyInput(String input) {
        return input.isEmpty();
    }
}
