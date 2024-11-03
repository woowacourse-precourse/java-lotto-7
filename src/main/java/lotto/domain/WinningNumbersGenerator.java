package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import lotto.dto.WinningNumbers;
import lotto.exception.CustomIllegalArgumentException;

import java.util.HashSet;
import java.util.List;

public class WinningNumbersGenerator {

    private static final int LOTTO_NUMBERS_COUNT = 6;
    private final List<Integer> winningNumbersPool;

    public WinningNumbersGenerator(List<Integer> winningNumbersPool) {
        this.winningNumbersPool = winningNumbersPool;
    }

    public WinningNumbers generate() {
        List<Integer> lottoNumbers = winningNumbersPool.subList(0, LOTTO_NUMBERS_COUNT);
        int bonusNumber = winningNumbersPool.get(LOTTO_NUMBERS_COUNT);
        validateBonusNumberNotInLottoNumbers(lottoNumbers, bonusNumber);
        return new WinningNumbers(lottoNumbers, bonusNumber);
    }

    private void validateBonusNumberNotInLottoNumbers(List<Integer> lottoNumbers, int bonusNumber) {
        if (new HashSet<>(lottoNumbers).contains(bonusNumber)) {
            throw CustomIllegalArgumentException.from(BONUS_NUMBER_DUPLICATE);
        }
    }
}
