package lotto.generator;

import java.util.List;
import lotto.constant.LottoConfiguration;

public class RawInputGenerator {

    public static String makeRawWinningNumbers(List<Integer> winningNumbers) {
        List<String> castedNumbers = winningNumbers.stream().map(String::valueOf).toList();
        return String.join(LottoConfiguration.WINNING_NUMBER_DELIMITER, castedNumbers);
    }
}
