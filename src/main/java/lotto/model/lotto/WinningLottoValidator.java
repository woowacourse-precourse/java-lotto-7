package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoValidator {
    private WinningLottoValidator() {
    }

    public static void validate(List<Integer> numbers, int bonusNumber) {
        LottoValidator.validateRange(bonusNumber);

        List<Integer> numbersWithBonusNumber = new ArrayList<>(numbers);
        numbersWithBonusNumber.add(bonusNumber);

        LottoValidator.validateNoDuplicate(numbersWithBonusNumber);
    }
}
