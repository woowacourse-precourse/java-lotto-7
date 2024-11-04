package lotto.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public static int parseLottoPrice(String lottoPrice) {
        return Integer.parseInt(lottoPrice);
    }

    public static List<Integer> parseLottoNumber(String lottoNumber) {
        List<String> lottoNumbers = Arrays.asList(lottoNumber.split(","));
        return lottoNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int parseBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }
}
