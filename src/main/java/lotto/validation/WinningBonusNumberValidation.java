package lotto.validation;

import java.util.Arrays;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public final class WinningBonusNumberValidation {
    public static Lotto winningNumberValidation(String winningNumber) throws IllegalArgumentException {
        InputValidation.isNotBlank(winningNumber);
        return new Lotto(Arrays.stream(winningNumber.split(","))
                .map(InputValidation::parseNumberValidation)
                .collect(Collectors.toList()));
    }
}