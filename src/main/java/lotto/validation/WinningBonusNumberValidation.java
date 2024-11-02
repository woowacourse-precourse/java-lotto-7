package lotto.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.DuplicateLottoNumberException;
import lotto.model.Lotto;

public final class WinningBonusNumberValidation {
    public static Lotto getValidatedWinningNumbers(String winningNumber) throws IllegalArgumentException {
        InputValidation.isNotBlank(winningNumber);
        List<Integer> winningLottoNumbers = Arrays.stream(winningNumber.split(","))
                .map(Lotto::getNumberIfInRange)
                .collect(Collectors.toList());
        return new Lotto(winningLottoNumbers);
    }
}