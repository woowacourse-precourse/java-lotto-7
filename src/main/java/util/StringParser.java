package util;

import java.util.ArrayList;
import java.util.List;
import validator.Validator;

public class StringParser {
    public static List<Integer> parse(String string) {
        String[] _numbers = string.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : _numbers) {
            Validator.moneyShouldNotBeTooBig(number);
            Validator.shouldBeOnlyNumber(number);
            
            numbers.add(Integer.parseInt(number));
        }

        return numbers;
    }
}
