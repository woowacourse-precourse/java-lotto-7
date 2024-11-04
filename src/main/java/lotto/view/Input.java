package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input extends Exception {
    public int requestAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String amount = Console.readLine();

        validateString(amount);
        validateNumber(amount);
        validateUnit(amount);
        return Integer.parseInt(amount);
    }

    public List<Integer> requestWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbers = Console.readLine();

        validateString(winningNumbers);
        validateDelimiter(winningNumbers);

        List<Integer> numbers = refineString(winningNumbers);
        return numbers;
    }

    public int requestBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = Console.readLine();

        validateString(bonusNumber);
        validateNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}