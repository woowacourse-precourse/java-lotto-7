package lotto.view;

import lotto.exception.LottoInputFormatException;
import lotto.exception.InputNumberFormatException;
import lotto.util.Parser;

import java.util.Arrays;
import java.util.List;

public class InputView extends InputReader {
    public int inputLottoMoney() {
        String inputLottoMoney = inputMessage();
        validateInputNumberFormat(inputLottoMoney);
        return Parser.stringToInt(inputLottoMoney);
    }

    private void validateInputNumberFormat(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new InputNumberFormatException();
        }
    }

    public List<Integer> inputWinningNumber() {
        String inputWinningNumber = inputMessage();
        validateInputWinningNumber(inputWinningNumber);

        return Arrays.stream(Parser.stringToArray(inputWinningNumber))
                .map(Parser::stringToInt)
                .toList();
    }

    private void validateInputWinningNumber(String inputWinningNumber) {
        if (!inputWinningNumber.matches("^(\\d{1,2},){5}\\d{1,2}$")) {
            throw new LottoInputFormatException();
        }
    }

    public int inputBonusNumber() {
        String inputBonusNumber = inputMessage();
        validateInputNumberFormat(inputBonusNumber);
        return Parser.stringToInt(inputBonusNumber);
    }
}
