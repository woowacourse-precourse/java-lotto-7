package lotto.parser;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.ErrorConstant;

public class StringParser {

    private static final String DELIMITER = ",";

    public static List<Integer> numbers(final String input) {
        final String[] split = input.split(DELIMITER);
        List<Integer> result = new ArrayList<>();
        for (String s : split) {
            try {
                result.add(Integer.parseInt(s.strip()));
            } catch (NumberFormatException ne) {
                throw new IllegalArgumentException(ErrorConstant.ERROR.getContent() + " 당첨번호는 숫자여야 합니다.");
            }
        }
        return result;
    }
}
