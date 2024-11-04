package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        Validator.validatePurchaseAmount(input);
        return Integer.parseInt(input);
    }

    public WinningLotto inputWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        List<String> inputs = Arrays.asList(input.split(","));
        Validator.validateWinningNumbers(inputs);
        List<Integer> winningNumbers = inputs.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine().trim();
        Validator.validateBonusNumber(bonusInput, winningNumbers);
        int bonusNumber = Integer.parseInt(bonusInput);
        return new WinningLotto(winningNumbers, bonusNumber);
    }
}