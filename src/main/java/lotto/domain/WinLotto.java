package lotto.domain;

import java.util.List;

import static lotto.domain.LottoRule.LOTTO_MAX_NUMBER;
import static lotto.domain.LottoRule.LOTTO_MIN_NUMBER;

public class WinLotto {

    private final Lotto lotto;
    private Integer bonusNumber;

    public WinLotto(List<Integer> numbers) {
        lotto = new Lotto(numbers);
    }

    public void setBonusNumber(Integer number) {
        validateBonusNumber(number);
        bonusNumber = number;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(Integer number) {
        validateDuplicateNumber(number);
        validateNumberRange(number);
    }

    private void validateNumberRange(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d ~ %d 범위여야 합니다.", LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER));
        }
    }

    private void validateDuplicateNumber(Integer number) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 달라야 합니다.");
        }
    }
}
