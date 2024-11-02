package lotto;

import java.util.List;
import utils.Converter;
import utils.Parser;
import validator.Validator;
import view.InputView;
import view.OutputView;

public class LottoController {

    public void startProgram() {
        inputMoneyController();
        winningNumbersController();
    }

    private Long inputMoneyController() {
        try {
            String originalInput = InputView.inputPurchaseMoney();
            Validator.validateMoney(originalInput);
            return Long.parseLong(originalInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return inputMoneyController();
    }

    private List<Integer> winningNumbersController() {
        try {
            String originalInput = InputView.inputWinningNumbers();
            List<String> parsedInput = Parser.parsing(originalInput);
            List<Integer> numbers = Converter.convertStringToNumber(parsedInput);
            Validator.validateLottoNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
        }
        return winningNumbersController();
    }
}
