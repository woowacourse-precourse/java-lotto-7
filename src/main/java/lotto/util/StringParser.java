package lotto.util;

import java.util.ArrayList;
import java.util.List;
import lotto.policy.StringParserPolicy;

public class StringParser {
    public static List<Integer> parse(String string) {
        String[] _numbers = string.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String number : _numbers) {
            new StringParserPolicy().checkStringParserPolicy(number);
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
