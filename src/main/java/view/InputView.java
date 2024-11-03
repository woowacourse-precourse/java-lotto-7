package view;

import camp.nextstep.edu.missionutils.Console;
import lotto.PurchaseAmount;

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

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();
        Console.close();
        return bonusNumber;
    }
}
