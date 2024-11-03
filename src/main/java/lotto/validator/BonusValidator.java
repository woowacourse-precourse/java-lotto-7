package lotto.validator;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.model.Lotto;
import lotto.view.message.ErrorMessage;

public class BonusValidator {
    public static int validate(String input, Lotto winningLotto) {
        InputValidator.validateNotEmpty(input);
        InputValidator.validateIsNumeric(input);

        int bonus = Integer.parseInt(input);
        InputValidator.validateIsPositive(bonus);

        validateNumberRange(bonus);
        validateDuplicatedNumberInWinningLotto(bonus, winningLotto);

        return bonus;
    }

    private static void validateNumberRange(int bonus) {
        if (bonus < LottoConfig.MIN_NUMBER.getNumber() || bonus > LottoConfig.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_FORM_ONE_TO_FORTY_FIVE.getMessage());
        }
    }

    private static void validateDuplicatedNumberInWinningLotto(int bonus, Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        if (lottoNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.HAS_DUPLICATED_NUMBER.getMessage());
        }
    }
}
