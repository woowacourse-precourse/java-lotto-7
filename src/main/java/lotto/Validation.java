package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean isValidWinningNumber(String input) {
        String regex = "^(?:\\d+,){5}\\d+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        return matcher.matches();
    }
}
