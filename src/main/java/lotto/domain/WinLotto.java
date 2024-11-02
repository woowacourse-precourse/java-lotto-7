package lotto.domain;

import java.util.List;

public class WinLotto {

    private final Lotto lotto;
    private Integer bonusNumber;

    public WinLotto(List<Integer> numbers) {
        lotto = new Lotto(numbers);
    }

    public void setBonusNumber(Integer number) {
        validateBonusNumber();
        bonusNumber = number;
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber() {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호와 보너스 번호는 달라야 합니다.");
        }
    }
}
