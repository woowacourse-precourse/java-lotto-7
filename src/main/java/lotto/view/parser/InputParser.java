package lotto.view.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputParser {

    public int parseInteger(String input) {
        validInteger(input);
        return Integer.parseInt(input);
    }

    public List<Integer> parseWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, ",");

        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();
            validInteger(token);
            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    private void validInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}
