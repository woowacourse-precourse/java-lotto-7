package lotto.view;

import lotto.exception.LottoInputFormatException;
import lotto.exception.NumberFormatException;
import lotto.util.Parser;

import java.util.Arrays;
import java.util.List;

public class InputView extends InputReader {
    public int inputLottoMoney() {
        String inputLottoMoney = inputMessage();
        validateInputLottoMoney(inputLottoMoney);

        return Parser.stringToInt(inputLottoMoney);
    }

    private void validateInputLottoMoney(String inputLottoMoney) {
        if (!inputLottoMoney.matches("^[0-9]+$")) {
            throw new NumberFormatException();
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
        if (!inputWinningLotto.matches("^(\\d{1,2},){5}\\d{1,2}$")) {
            throw new LottoInputFormatException();
        }
    }
}
