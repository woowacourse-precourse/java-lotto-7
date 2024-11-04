package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import validator.PurchaseAmountValidator;
import validator.WinningNumbersValidator;

import java.util.List;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return PurchaseAmountValidator.validate(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return WinningNumbersValidator.validate(input);
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
