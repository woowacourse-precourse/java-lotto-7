package lotto.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoWinningNumbersValidator {
    private static final String LOTTO_WINNING_NUMBER_REGEX = "^[0-9]+$";
    private static final String LOTTO_WINNING_NUMBERS_SEPARATOR = ",";

    private LottoWinningNumbersValidator() {
    }

    public static void validateLottoWinningNumbers(String lottoWinningNumbers) {
        try {
            List<Integer> list = Arrays.stream(lottoWinningNumbers.split(LOTTO_WINNING_NUMBERS_SEPARATOR))
                    .map(Integer::parseInt)
                    .filter(LottoWinningNumbersValidator::checkLottoWinningNumbersRange)
                    .toList();
            checkDuplicateLottoWinningNumber(list);
        } catch (NumberFormatException e) {
            checkIncludeSpecialCharacters(lottoWinningNumbers);
            throw new IllegalArgumentException("로또 당첨 번호는 0 이상 45 이하입니다");
        }
    }

    private static boolean checkLottoWinningNumbersRange(int lottoWinningNumber) {
        if (0 >= lottoWinningNumber || lottoWinningNumber > 45) {
            throw new IllegalArgumentException("로또 당첨 번호는 0 이상 45 이하입니다");
        }
        return true;
    }

    private static void checkIncludeSpecialCharacters(String lottoWinningNumbers) {
        if (!lottoWinningNumbers.matches(LOTTO_WINNING_NUMBER_REGEX)) {
            throw new IllegalArgumentException("로또 당첨 번호는 숫자로 입력해야 합니다.");
        }
    }

    private static void checkDuplicateLottoWinningNumber(List<Integer> lottoWinningNumbers) {
        if (new HashSet<>(lottoWinningNumbers).size() != 6) {
            throw new IllegalArgumentException("로또 당첨 번호 중 중복된 번호가 있습니다.");
        }
    }
}
