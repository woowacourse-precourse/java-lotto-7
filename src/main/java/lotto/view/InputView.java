package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateEmptyOrBlank(purchaseAmount);

        return purchaseAmount;
    }

    public String readWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningLotto = Console.readLine();
        validateEmptyOrBlank(winningLotto);

        return winningLotto;
    }

    public String readBonus() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonus = Console.readLine();
        validateEmptyOrBlank(bonus);

        return bonus;
    }

    private void validateEmptyOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력해 주세요.");
        }
    }
}
