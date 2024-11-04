package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public int inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return InputConverter.parseToNumber(purchaseAmount);
    }

    public List<Integer> inputWinningLottoNumbers() {
        String winningNumbers = Console.readLine();
        return InputConverter.convertToNumbers(winningNumbers);
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return InputConverter.parseToNumber(bonusNumber);
    }
}
