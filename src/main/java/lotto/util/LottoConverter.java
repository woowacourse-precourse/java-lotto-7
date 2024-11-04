package lotto.util;

import java.util.ArrayList;
import java.util.List;

public class LottoConverter {
    public static List<Integer> parseLottoNumbers(String lottoNumbers) {
        String[] splitNumbers = lottoNumbers.split(",");
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
