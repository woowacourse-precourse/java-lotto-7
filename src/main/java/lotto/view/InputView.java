package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Converter;

import java.util.List;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return Converter.parse(purchaseAmount);
    }

    public List<Integer> inputWinningNumbers() {
        String winningNumbers = Console.readLine();
        return Converter.toNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return Converter.parse(bonusNumber);
    }
}
