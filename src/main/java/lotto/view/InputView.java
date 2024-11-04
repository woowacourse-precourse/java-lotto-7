package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.BonusNumberValidator;
import lotto.util.validator.PurchaseAmountValidator;
import lotto.util.validator.WinningNumberValidator;

public class InputView {

    public void requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public String inputPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        PurchaseAmountValidator.validateInput(purchaseAmount);
        return purchaseAmount;

    }

    public void requestWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public String inputWinningNumber() {
        String winNum = Console.readLine();
        WinningNumberValidator.validateInput(winNum);
        return winNum;
    }

    public void requestWinningBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public String inputWinningBonusNumber() {
        String winBonusNum = Console.readLine();
        BonusNumberValidator.validateInput(winBonusNum);
        return winBonusNum;
    }


}
