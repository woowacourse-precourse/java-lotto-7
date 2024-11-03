package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.validation.LottoPurchaseValidator;
import lotto.validation.WinningNumberValidator;

public class WinningNumberSplitter {

    private static final String NUMBER_DELIMITER = ",";
    private final WinningNumberValidator winningNumberValidator;

    public WinningNumberSplitter() {
        this.winningNumberValidator = new WinningNumberValidator();
    }

    public Lotto split(String winningLottoNumber) {
        winningNumberValidator.validateNumber(winningLottoNumber);
        List<Integer> numbers = Arrays.stream(winningLottoNumber.split(NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        winningNumberValidator.validateNumbers(numbers);
        return new Lotto(numbers);
    }
}
