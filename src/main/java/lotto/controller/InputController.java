package lotto.controller;

import java.util.List;
import lotto.util.NumberConverter;
import lotto.util.StringParser;
import lotto.validator.NumberValidator;
import lotto.view.InputView;

public class InputController {
    private final InputView inputView;
    private final NumberConverter numberConverter;
    private final StringParser stringParser;
    private final NumberValidator numberValidator;

    public InputController(InputView inputView, NumberConverter numberConverter, StringParser stringParser, NumberValidator numberValidator) {
        this.inputView = inputView;
        this.numberConverter = numberConverter;
        this.stringParser = stringParser;
        this.numberValidator = numberValidator;
    }

    public Integer getMoney() {
        String input = inputView.getMoney();

        try {
            numberValidator.isNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getMoney();
        }
        return numberConverter.convertToInteger(input);
    }

    public List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers;

        List<String> input = stringParser.parse(inputView.getWinningNumber());

        try {
            numberValidator.isNumber(input);
            winningNumbers = numberConverter.convertToInteger(input);

            numberValidator.checkCountOfNumber(winningNumbers);
            numberValidator.isDuplicateNumber(winningNumbers);
            numberValidator.checkInRange(winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getWinningNumbers();
        }

        return numberConverter.convertToInteger(input);
    }

    public Integer getBonusNumber(List<Integer> winningNumbers) {
        String input = inputView.getBonusNumber();

        try {
            numberValidator.isNumber(input);
            Integer bonusNumber = numberConverter.convertToInteger(input);

            numberValidator.checkInRange(bonusNumber);
            numberValidator.isDuplicateNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBonusNumber(winningNumbers);
        }

        return numberConverter.convertToInteger(input);
    }
}
