package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.InvalidLottoNumberRangeException;

public class InputView {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    public String inputValue() {
        return Console.readLine();
    }

    protected void validateLottoNumberRange(int number) {
        if (MIN_LOTTO_NUMBER > number || MAX_LOTTO_NUMBER < number) {
            throw new InvalidLottoNumberRangeException();
        }
    }
}
