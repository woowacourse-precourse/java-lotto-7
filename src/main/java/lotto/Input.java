package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private String purchaseAmount;
    private String winningNumber;
    private String bonusNumber;

    public void purchaseAmount() {
        purchaseAmount = Console.readLine();
    }

    public void winningNumber() {
        winningNumber = Console.readLine();
    }

    public void bonusNumber() {
        bonusNumber = Console.readLine();
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public String getWinningNumber() {
        return winningNumber;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
