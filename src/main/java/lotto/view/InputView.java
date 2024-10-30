package lotto.view;

import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumber;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public static PurchaseAmount inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String inputPurchaseAmount = readLine();
            return new PurchaseAmount(inputPurchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static WinningNumber inputWinningNumber() {
        System.out.println("당첨번호를 입력해 주세요.");
        try {
            String inputWinningNumber = readLine();
            return new WinningNumber(inputWinningNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return inputWinningNumber();
        }
    }

    public static int inputBonusNumber(WinningNumber winningNumber) {
        System.out.println("당첨번호를 입력해 주세요.");
        try {
            String bonusNumber = readLine();
            return winningNumber.makeBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]" + e.getMessage());
            return inputBonusNumber(winningNumber);
        }
    }
}