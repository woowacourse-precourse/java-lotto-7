package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InputValidator;
import lotto.util.Converter;

import java.util.List;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        validateInput(purchaseAmount);
        return Converter.parse(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        validateInput(winningNumbers);
        return Converter.toNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        validateInput(bonusNumber);
        return Converter.parse(bonusNumber);
    }

    private void validateInput(String input) {
        InputValidator.validateContainsBlank(input);
        InputValidator.validateEmpty(input);
    }
}
