package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.validator.Validator;

public class StringParser {
    public static List<Integer> parse(String string) {
        String[] _numbers = string.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : _numbers) {
            // TODO: 문자나 실수가 들어갈 수 있음
            Validator.shouldBeOnlyNumber(number);
            Validator.shouldNotBeTooBig(number);
            Validator.shouldBeOnlyNumber(number);

            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
