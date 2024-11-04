package lotto.service;

import java.util.Arrays;
import java.util.List;

import lotto.exception.administrator.NotNumberOrCommaException;
import lotto.exception.administrator.OutOfRangeLottoNumberException;
import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;
import lotto.util.ValidateUtil;

public class LottoAdministratorService {

    public Lotto setWinningNumbers(final String winningNumbersInput) {
        return new Lotto(parseToInteger(winningNumbersInput));
    }

    public LottoBonusNumber setBonusNumber(final String bonusNumberInput) {
        return new LottoBonusNumber(bonusNumberInput);
    }

    private List<Integer> parseToInteger(final String winningNumbersInput) {
        validateInput(winningNumbersInput);
        return splitByComma(winningNumbersInput);
    }

    private void validateInput(final String value) {
        ValidateUtil.emptyValue(value);

        if(!value.matches("^[\\d,]+$")) {
            throw new NotNumberOrCommaException();
        }
    }

    private List<Integer> splitByComma(final String value) {
        try {
            return Arrays.stream(value.split(",")).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new OutOfRangeLottoNumberException();
        }
    }
}
