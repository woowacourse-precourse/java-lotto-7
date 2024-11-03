package lotto.util;

import static lotto.exception.LottoErrorStatus.INVALID_BONUS_NUMBER;
import static lotto.exception.LottoErrorStatus.INVALID_LOTTO_FORMAT;

import java.util.Arrays;
import java.util.List;
import lotto.exception.LottoException;

public class LottoNumberParser {
    private LottoNumberParser() {
    }


    public static List<Integer> parseLottoNumbers(String inputLottoNumbers) {
        try {
            return Arrays.stream(inputLottoNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_LOTTO_FORMAT);
        }
    }

    public static int parseBonusNumber(String inputBonusNumbers) {
        try {
            return Integer.parseInt(inputBonusNumbers);
        } catch (NumberFormatException e) {
            throw new LottoException(INVALID_BONUS_NUMBER);
        }
    }
}
