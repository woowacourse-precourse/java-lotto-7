package lotto.service;

import lotto.domain.LottoTickets;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessor {

    private final InputView inputView;
    private final Validator validator;

    public InputProcessor() {
        this.inputView = new InputView();
        this.validator = new Validator();
    }

    public LottoTickets parsePurchaseAmount() {
        while (true) {
            try {
                String userInput = inputView.inputPurchaseAmount();
                System.out.println();
                return new LottoTickets(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public List<Integer> parseWinningNumbers() {
        while (true) {
            try {
                String userInput = inputView.inputWinningNumbers();
                System.out.println();
                validator.validateWinningNumbers(userInput);
                return getIntegerWinningNumbers(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public int parseBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                String userInput = inputView.inputBonusNumber();
                System.out.println();
                validator.validateBonusNumber(winningNumbers, userInput);
                return getIntegerBonusNumber(userInput);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private List<Integer> getIntegerWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private int getIntegerBonusNumber(String bonusNumber) {
        return Integer.parseInt(bonusNumber);
    }

}
