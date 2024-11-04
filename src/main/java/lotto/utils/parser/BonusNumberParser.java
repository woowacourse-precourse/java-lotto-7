package lotto.utils.parser;

import static lotto.constants.ErrorMessage.CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBERS;
import static lotto.constants.ErrorMessage.INPUT_BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.constants.ErrorMessage.ONLY_INTEGER_RANGE_BONUS_NUMBER_ALLOWED;
import static lotto.constants.LottoConstant.MAX_LOTTO_NUMBER;
import static lotto.constants.LottoConstant.MIN_LOTTO_NUMBER;

import java.util.List;
import lotto.dto.LottoNumbers;
import lotto.model.Lotto;

public class BonusNumberParser {
    public static int getBonusNumber(Lotto winningNumbers, String userBonusNumber) {
        int bonusNumber = 0;

        try {
            bonusNumber = Integer.parseInt(userBonusNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ONLY_INTEGER_RANGE_BONUS_NUMBER_ALLOWED.getMessage());
        }

        checkBonusNumberRange(bonusNumber);
        checkDuplicatedCheck(winningNumbers, bonusNumber);

        return bonusNumber;
    }

    private static void checkBonusNumberRange(int bonusNumber) {
        if (!(bonusNumber >= MIN_LOTTO_NUMBER && bonusNumber <= MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(INPUT_BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    private static void checkDuplicatedCheck(Lotto winningNumbers, int bonusNumber) {
        LottoNumbers lottoNumbers = winningNumbers.getLottoNumbers();
        List<Integer> winningLottoNumbers = lottoNumbers.getLottoNumbers();

        if (winningLottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBERS.getMessage());
        }
    }

}
