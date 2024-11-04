package lotto.validator;

import lotto.domain.number.LottoNumber;
import lotto.domain.ticket.Lotto;

public class BonusNumberValidator {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final String ERROR_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_DUPLICATE = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.";

    private BonusNumberValidator() {
    }

    public static void validate(int bonusNumber, Lotto winningLotto) {
        validateNumberRange(bonusNumber);
        validateDuplicate(bonusNumber, winningLotto);
    }

    private static void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_RANGE);
        }
    }

    private static void validateDuplicate(int bonusNumber, Lotto winningLotto) {
        LottoNumber lottoNumber = LottoNumber.of(bonusNumber);
        if (winningLotto.contains(lottoNumber)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }
}