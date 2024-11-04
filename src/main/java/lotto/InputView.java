package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Validation.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public WinningNumbers readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = Validation.validateWinningNumbers(input);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();
        int bonus = Validation.validateBonusNumber(bonusInput, numbers);
        return new WinningNumbers(numbers, bonus);
    }
}
