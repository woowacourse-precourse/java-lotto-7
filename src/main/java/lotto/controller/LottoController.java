package lotto.controller;

import static lotto.view.ViewConstants.VIEW_DELIMITER;

import java.util.Arrays;
import java.util.List;
import lotto.view.InputValidator;
import lotto.view.InputView;

public class LottoController {
    private final InputView inputView;
    private final InputValidator inputValidator;

    public LottoController(InputView inputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.inputValidator = inputValidator;
    }

    public List<Integer> deliverNumbers() {
        String input = inputView.requestWinningLottoNumbers();
        inputValidator.validateDigitAndDelimiterOnly(input);
        return extractNumbers(input);
    }

    private List<Integer> extractNumbers(String input) {
        return Arrays.stream(input.split(VIEW_DELIMITER))
                .map(this::convertToInteger)
                .toList();
    }

    private int convertToInteger(String input) {
        return Integer.parseInt(input);
    }
}
