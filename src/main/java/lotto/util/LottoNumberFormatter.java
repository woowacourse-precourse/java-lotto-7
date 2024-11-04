package lotto.util;

import lotto.model.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberFormatter {

    public static String formatLottoNumbers(List<LottoNumber> numbers) {
        return numbers.stream()
                .map(LottoNumber::number)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
