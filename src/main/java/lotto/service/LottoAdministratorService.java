package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.exception.EmptyInputException;
import lotto.exception.administrator.NotNumberOrCommaException;
import lotto.exception.administrator.OutOfRangeLottoNumberException;
import lotto.model.administrator.Lotto;
import lotto.model.administrator.LottoBonusNumber;
import lotto.model.administrator.WinningLottoNumbersDto;

public class LottoAdministratorService {

    public WinningLottoNumbersDto setUpWinningNumbers(String winningNumbersInput, String bonusNumberInput) {
        return WinningLottoNumbersDto.from(
                new Lotto(parseToInteger(winningNumbersInput)),
                new LottoBonusNumber(bonusNumberInput));
    }

    private List<Integer> parseToInteger(String winningNumbersInput) {
        validateInput(winningNumbersInput);
        return splitByComma(winningNumbersInput);
    }

    private void validateInput(String value) {
        if(value == null || value.isEmpty()) {
            throw new EmptyInputException();
        }

        if(!value.matches("^[\\d,]+$")) {
            throw new NotNumberOrCommaException();
        }
    }

    private List<Integer> splitByComma(String value) {
        try {
            return Arrays.stream(value.split(",")).map(Integer::parseInt).toList();
        } catch (NumberFormatException e) {
            throw new OutOfRangeLottoNumberException();
        }
    }
}
