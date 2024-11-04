package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class InputParsingUtil {
    private static final String DELIMITER = ",";
    private static final String INPUT_CONTAINS_CHAR_NOT_NUM = "입력값 사이에 숫자가 아닌 문자가 있습니다.";

    public static List<Integer> parseWinningLottoNumbers(final String input) {
        List<Integer> winningLottoNumbers = new ArrayList<>();
        String[] numbers = splitWinningLotto(input);

        for (String num : numbers) {
            winningLottoNumbers.add(parseWinningNum(num));
        }
        return winningLottoNumbers;
    }

    private static String[] splitWinningLotto(final String input) {
        return input.split(DELIMITER);
    }

    private static int parseWinningNum(final String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_CONTAINS_CHAR_NOT_NUM);
        }
    }

}
