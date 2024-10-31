package lotto.domain.lotto;

import lotto.domain.lotto.vo.LottoNumber;
import lotto.infrastructure.constant.ExceptionMessage;
import lotto.infrastructure.exception.CustomException;

import java.util.List;

public class WinningLottoImpl extends Lotto implements WinningLotto {
    private final LottoNumber bonusNumber;

    private WinningLottoImpl(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = LottoNumber.of(bonusNumber);
    }

    public static WinningLottoImpl of(List<Integer> numbers, int bonusNumber) {
        validateBonusDuplicate(numbers, bonusNumber);
        return new WinningLottoImpl(numbers, bonusNumber);
    }

    private static void validateBonusDuplicate(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new CustomException(ExceptionMessage.DUPLICATE);
        }
    }

    @Override
    public List<Integer> basicNumbers() {
        return this.getNumbers().stream().map(LottoNumber::value).toList();
    }

    @Override
    public int bonusNumber() {
        return this.bonusNumber.value();
    }
}

