package lotto.validation;

import static lotto.util.Constants.ERROR_CONTAIN_LETTER_MSG;
import static lotto.util.Constants.ERROR_EXCEED_LOTTO_END_NUMBER_MSG;
import static lotto.util.Constants.ERROR_INIT;
import static lotto.util.Constants.ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG;
import static lotto.util.Constants.ERROR_IS_VACANT_MSG;
import static lotto.util.Constants.LOTTO_END_NUMBER;
import static lotto.util.Constants.LOTTO_START_NUMBER;

import lotto.mvc.model.Lotto;

public class LottoBonusNumberValidator {
    private static final String ERROR_MSG_INFIX = "로또 보너스 번호";
    private static final String ERROR_IS_DUPLICATED_LOTTO_NUMBER_MSG = "로또 보너스 번호는 로또 당첨 번호와 중복되면 안됩니다.";

    public static void isValid(Lotto lotto, String input) {
        isVacant(input);

        isValidLottoBonusNumber(lotto, input);
    }

    private static void isVacant(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_IS_VACANT_MSG);
        }
    }

    private static void isValidLottoBonusNumber(Lotto lotto, String input) {
        try {
            int number = Integer.parseInt(input);

            UnderLottoStartNumber(number);

            ExceedLottoEndNumber(number);

            isDuplicatedLottoNumber(lotto, number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_CONTAIN_LETTER_MSG);
        }
    }

    private static void UnderLottoStartNumber(int number) {
        if (number < LOTTO_START_NUMBER) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_IS_UNDER_LOTTO_START_NUMBER_MSG);
        }
    }

    private static void ExceedLottoEndNumber(int number) {
        if (number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_MSG_INFIX + ERROR_EXCEED_LOTTO_END_NUMBER_MSG);
        }
    }

    private static void isDuplicatedLottoNumber(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(ERROR_INIT + ERROR_IS_DUPLICATED_LOTTO_NUMBER_MSG);
        }
    }
}
