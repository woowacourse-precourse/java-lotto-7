package lotto.lotto.object;

import java.util.List;
import lotto.validation.LottoNumberValidation;

public class WinningLotto extends Lotto {
    private int bonusNumber;
    private final LottoNumberValidation lottoNumberValidation;

    public WinningLotto(List<Integer> numbers, LottoNumberValidation lottoNumberValidation) {
        super(numbers);
        this.lottoNumberValidation = lottoNumberValidation;
    }

    public void setBonusNumber(int bonusNumber) {
        lottoNumberValidation.bonusNumberDuplicateValid(this.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
