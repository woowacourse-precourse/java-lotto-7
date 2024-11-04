package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        return Integer.parseInt(purchaseAmount);
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        return bonusNumber;
    }
}
