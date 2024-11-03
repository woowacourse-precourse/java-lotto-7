package lotto.domain;

import java.util.List;
import lotto.exception.LottoException;

public record WinningNumbers(Lotto lotto, LottoNumber bonusNumber) {

    public WinningNumbers {
        validate(lotto, bonusNumber);
    }

    public static WinningNumbers of(List<Integer> numbers, int number) {
        return new WinningNumbers(Lotto.from(numbers), LottoNumber.from(number));
    }

    private void validate(final Lotto lotto, final LottoNumber bonusNumber) {
        if (lotto.numbers().contains(bonusNumber)) {
            throw new LottoException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
