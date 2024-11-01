package lotto;

import java.util.List;

public class LottoPrize {
    private final Lotto lotto;
    private final int bonusNumber;

    public LottoPrize(List<Integer> numbers, Integer bonusNumber) {
        this.lotto = new Lotto(numbers);
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate(int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
