package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.LottoMachine;

public class Input {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            LottoMachine.validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 잘못된 금액 형식입니다. 숫자만 입력해 주세요.");
            return inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            return inputBonusNumber();
        }
    }
}
