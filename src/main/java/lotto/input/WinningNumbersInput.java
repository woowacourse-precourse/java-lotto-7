package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Lotto;
import lotto.input.validator.WinningNumbersValidator;
import lotto.util.ListIntegerConverter;

import java.util.List;

public class WinningNumbersInput {

    private final WinningNumbersValidator winningNumbersValidator;

    public WinningNumbersInput(WinningNumbersValidator winningNumbersValidator) {
        this.winningNumbersValidator = winningNumbersValidator;
    }

    public Lotto run() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        winningNumbersValidator.validate(winningNumbersInput);

        List<Integer> winningNumbers = ListIntegerConverter.convertFromString(winningNumbersInput);
        return new Lotto(winningNumbers);
    }
}
