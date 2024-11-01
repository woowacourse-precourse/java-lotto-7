package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLottoValidator extends LottoValidator {
    private WinningLottoValidator() {
        super();
    }

    public static void validate(List<Integer> numbers, int bonusNumber) {
        validateRange(bonusNumber);

        List<Integer> numbersWithBonusNumber = new ArrayList<>(numbers);
        numbersWithBonusNumber.add(bonusNumber);

        validateNoDuplicate(numbersWithBonusNumber);
    }
}
