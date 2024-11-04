package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class LottoConverter {
    public static List<Integer> parseWinningNumbers(String WinningNumbers) {
        String[] splitNumbers = WinningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber));
        }
        return numbers;
    }

    public static int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
