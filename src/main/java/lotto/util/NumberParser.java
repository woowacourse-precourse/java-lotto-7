package lotto.util;

import lotto.common.ViewConstant;
import lotto.model.LottoNumber;

import java.util.List;
import java.util.stream.Stream;

public class NumberParser {

    public static List<LottoNumber> parseWinningNumbers(String input) {
        return Stream.of(input.replace(" ", "").split(ViewConstant.DELIMITER))
                .map(LottoNumber::valueOf)
                .toList();
    }

}
