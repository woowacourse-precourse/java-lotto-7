package lotto.validator;

import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_COUNT;
import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_RANGE_END;
import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_RANGE_START;
import static lotto.config.LottoRegularExpression.LOTTO_NUMBER_REGEX;
import static lotto.config.LottoRegularExpression.SEPARATOR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoWinningNumbersValidator {
    private LottoWinningNumbersValidator() {
    }

    public static void validateLottoWinningNumbers(String lottoWinningNumbers) {
        try {
            List<Integer> list = Arrays.stream(lottoWinningNumbers.split(SEPARATOR))
                    .map(Integer::parseInt)
                    .filter(LottoWinningNumbersValidator::checkLottoWinningNumbersRange)
                    .toList();
            checkDuplicateLottoWinningNumber(list);
        } catch (NumberFormatException e) {
            checkIncludeSpecialCharacters(lottoWinningNumbers);
            throw new IllegalArgumentException("로또 당첨 번호는 1 이상 45 이하입니다");
        }
    }

    private static boolean checkLottoWinningNumbersRange(int lottoWinningNumber) {
        if (LOTTO_NUMBER_RANGE_START > lottoWinningNumber || lottoWinningNumber > LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException("로또 당첨 번호는 1 이상 45 이하입니다");
        }
        return true;
    }

    private static void checkIncludeSpecialCharacters(String lottoWinningNumbers) {
        if (!lottoWinningNumbers.matches(LOTTO_NUMBER_REGEX)) {
            throw new IllegalArgumentException("로또 당첨 번호는 숫자로 입력해야 합니다.");
        }
    }

    private static void checkDuplicateLottoWinningNumber(List<Integer> lottoWinningNumbers) {
        if (new HashSet<>(lottoWinningNumbers).size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 당첨 번호 중 중복된 번호가 있습니다.");
        }
    }
}
