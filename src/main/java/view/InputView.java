package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.BonusNumber;
import lotto.PurchaseAmount;
import lotto.WinningNumbers;

public class InputView {

    public PurchaseAmount inputPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return new PurchaseAmount(Console.readLine());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public WinningNumbers inputWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                return new WinningNumbers(Console.readLine());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public BonusNumber inputBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                return new BonusNumber(Console.readLine(), winningNumbers);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
