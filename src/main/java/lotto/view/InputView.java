package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.validator.BonusNumberInputValidator;
import lotto.validator.MoneyInputValidator;
import lotto.validator.WinningNumberInputValidator;

public class InputView {

    public int getMoneyFromUser() {
        String input = Console.readLine();
        MoneyInputValidator.validateMoneyInput(input);

        int money = Integer.parseInt(input);
        return money;
    }

    public Lotto getLottoWinningNumbersFromUser() {
        String input = Console.readLine();

        WinningNumberInputValidator.validateWinningNumberInput(input);

        String[] splitInput = input.split(",");

        List<Integer> lottoWinningNumbers = Arrays.stream(splitInput)
                .map(Integer::parseInt)
                .toList();

        return Lotto.of(lottoWinningNumbers);
    }

    public int getLottoBonusNumberFromUser() {
        String input = Console.readLine();

        BonusNumberInputValidator.validateBonusNumberInput(input);

        int lottoBonusNumber = Integer.parseInt(input);

        return lottoBonusNumber;
    }
}
