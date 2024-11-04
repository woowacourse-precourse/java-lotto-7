package lotto.view;

import lotto.exception.lotto.LottoInputFormatException;
import lotto.exception.InputNumberFormatException;
import lotto.util.Parser;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputView extends InputReader {
    public static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    public static final Pattern WINNING_NUMBER_PATTERN = Pattern.compile("^(\\d{1,2}\\s*,\\s*)+\\d{1,2}$");

    public int inputPurchaseMoney() {
        String inputPurchaseMoney = inputMessage();
        validateInputNumberFormat(inputPurchaseMoney);
        return Parser.stringToInt(inputPurchaseMoney);
    }

    private void validateInputNumberFormat(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new InputNumberFormatException();
        }
    }

    public List<Integer> inputWinningLotto() {
        String inputWinningLotto = inputMessage();
        validateInputWinningLotto(inputWinningLotto);

        return Arrays.stream(Parser.stringToArray(inputWinningLotto))
                .map(Parser::stringToInt)
                .toList();
    }

    private void validateInputWinningLotto(String inputWinningLotto) {
        if (!WINNING_NUMBER_PATTERN.matcher(inputWinningLotto).matches()) {
            throw new LottoInputFormatException();
        }
    }

    public int inputBonusNumber() {
        String inputBonusNumber = inputMessage();
        validateInputNumberFormat(inputBonusNumber);
        return Parser.stringToInt(inputBonusNumber);
    }
}
