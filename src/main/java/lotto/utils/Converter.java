package lotto.utils;

import static lotto.view.OutputView.LOTTO_NUMBER_DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static int priceToLottoCount(String input) {
        int count = Integer.parseInt(input);
        return count/1000;
    }

    public static int StringToPrice(String input) {
        return Integer.parseInt(input);
    }

    public static List<Integer> StringToLottoNumbers(String input) {
        return Arrays.stream(input.split(LOTTO_NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int StringToBonusNumber(String input) {
        return Integer.parseInt(input);
    }
}
