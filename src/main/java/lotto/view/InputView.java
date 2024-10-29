package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.vo.PurchaseAmount;
import lotto.model.vo.WinningNumbers;

public class InputView {
    public int inputPurchaseAmount() {  // 로또 구입 금액을 입력받는다.
        PurchaseAmount purchaseAmount = PurchaseAmount.toInteger(Console.readLine());
        return purchaseAmount.amount();
    }

    public int[] inputWinningNumbers() {  // 당첨번호를 입력받는다.
        WinningNumbers winningNumbers = WinningNumbers.toArray(Console.readLine());
        return winningNumbers.num();
    }

}
