package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ExceptionMessage;
import lotto.model.Lotto;
import lotto.validation.WinningNumberValidator;

public class WinningNumberParser {

    private static final String NUMBER_DELIMITER = ",";
    private final WinningNumberValidator winningNumberValidator;

    public WinningNumberParser() {
        this.winningNumberValidator = new WinningNumberValidator();
    }

    public Lotto splitWinngNumber(String winningLottoNumber) {
        winningNumberValidator.validateNumber(winningLottoNumber);
        List<Integer> numbers = Arrays.stream(winningLottoNumber.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        winningNumberValidator.validateNumbers(numbers);
        return new Lotto(numbers);
    }

    public int parseBonusWinningNumber(String winningBonusNumber) {
        winningNumberValidator.validateBonusNumber(winningBonusNumber);
        return Integer.parseInt(winningBonusNumber);
    }
}
