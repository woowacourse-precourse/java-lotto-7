package lotto.controller;

import java.util.List;
import lotto.Validator.InputValidator;
import lotto.view.InputView;
import lotto.Validator.BonusNumberValidator;
import lotto.Validator.LottoNumberValidator;
import lotto.Validator.AmountValidator;
import lotto.util.InputParser;
import lotto.util.NumberConverter;

public class InputHandler {
    private final InputView inputView;

    public InputHandler(InputView inputView) {
        this.inputView = inputView;
    }

    public int getPurchaseAmount() {
        while (true) {
            try {
                String input = inputView.readPurchaseAmount();
                InputValidator.validateInput(input);

                int purchaseAmount = NumberConverter.convertToInteger(input);
                AmountValidator.validateAmount(purchaseAmount);

                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Integer> getWinningNumbers() {

        while (true) {
            try {
                String input = inputView.readWinningNumbers();
                InputValidator.validateNullOrBlank(input);

                List<String> parsedInput = InputParser.parseInput(input);
                InputValidator.validateNumbers(parsedInput);

                List<Integer> winningNumbers = NumberConverter.convertToIntegerList(parsedInput);
                LottoNumberValidator.validateLottoNumber(winningNumbers);

                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getBonusNumber(List<Integer> winningNumbers) {

        while (true) {
            try {
                String input = inputView.readBonusNumber();
                InputValidator.validateInput(input);

                Integer bonusNumber = NumberConverter.convertToInteger(input);
                BonusNumberValidator.validateBonusNumber(bonusNumber, winningNumbers);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
