package lotto.util;

import static lotto.constant.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.constant.ErrorMessage.NOT_A_NUMBER;
import static lotto.constant.LottoInfo.LOTTO_NUMBER_DELIMITER;
import static lotto.constant.LottoInfo.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoInfo.MIN_LOTTO_NUMBER;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static final int INCLUDE_TRAILING = -1;

    private Converter() {
    }

    public static int toLottoNumber(String number) {
        final int lottoNumber = parseInt(number);

        if (outOfLottoNumberRange(lottoNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
        return lottoNumber;
    }

    public static List<Integer> toLottoNumberList(String numbers) {
        return Arrays.stream(numbers.split(LOTTO_NUMBER_DELIMITER, INCLUDE_TRAILING))
                .map(Converter::toLottoNumber)
                .toList();
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }

    private static boolean outOfLottoNumberRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }
}
