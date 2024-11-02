package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.validator.InputValueValidator;

public class InputView {

    public static int getPurchaseAmount() {
        System.out.println("구매 금액을 입력해 주세요.");
        return InputValueValidator.validateAndParseAmount(Console.readLine().trim());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return InputValueValidator.validateAndParseWinningNumbers(Console.readLine().trim());
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        return InputValueValidator.validateAndParseBonusNumber(Console.readLine().trim(), winningNumbers);
    }

}
