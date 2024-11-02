package lotto.domain.lotto;

import java.util.List;
import lotto.domain.Number;
import lotto.domain.exception.CustomErrorCode;
import lotto.domain.exception.CustomException;

public class WinningLotto extends BasicLotto {

    public WinningLotto(List<Integer> winningLottoNumber) {
        super(winningLottoNumber);
    }

    public boolean isBonusNumber(List<Number> lotto) {
        return lotto.contains(numbers.getLast());
    }

    public void addBonusNumber(Number bonusNumbers) {
        validateBonusNumberDuplicate(bonusNumbers);
        numbers.add(bonusNumbers);
    }

    private void validateBonusNumberDuplicate(Number bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new CustomException(CustomErrorCode.EXCEPTION_DUPLICATED_LOTTO_NUMBER);
        }
    }
}
