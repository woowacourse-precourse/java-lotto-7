package lotto.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public final class WinningBonusNumberValidation {
    private WinningBonusNumberValidation() {
    }

    public static Lotto getValidatedWinningNumbers(String winningNumber) throws IllegalArgumentException {
        InputValidation.isNotBlank(winningNumber);
        List<Integer> winningLottoNumbers = Arrays.stream(winningNumber.split(","))
                .map(Lotto::getNumberIfInRange)
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }

    public static int getValidatedBonusNumber(Lotto winningLotto, String winningBonusNumber)
            throws IllegalArgumentException {
        InputValidation.isNotBlank(winningBonusNumber);
        int bonusNumber = Lotto.getNumberIfInRange(winningBonusNumber);
        winningLotto.bonusNumberDuplicate(bonusNumber);
        return bonusNumber;
    }
}