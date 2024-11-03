package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.PurchaseAmount;
import lotto.model.vo.WinningNumbers;

public class InputView {

    public int inputPurchaseAmount() {  // 로또 구입 금액을 입력받는다.
        while (true) {
            try {
                String input = Console.readLine();
                PurchaseAmount purchaseAmount = PurchaseAmount.fromString(input); 
                return purchaseAmount.amount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); 
            }
        }
    }

    public int[] inputWinningNumbers() {  // 당첨번호를 입력받는다.
        while (true) {
            try {
                String input = Console.readLine();
                WinningNumbers winningNumbers = WinningNumbers.fromString(input); 
                return winningNumbers.nums();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); 
            }
        }
    }

    public int inputBonusNumber() {  // 보너스 번호를 입력받는다.
        while (true) {
            try {
                String input = Console.readLine();
                BonusNumber bonusNumber = BonusNumber.fromString(input); 
                return bonusNumber.num();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); 
            }
        }
    }
}
