package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.Validator;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        return Validator.validatePurchaseAmount(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        return parseNumbers(input);
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        return Validator.validateBonusNumber(input, winningNumbers);
    }

    private static List<Integer> parseNumbers(String input) {
        String[] parts = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            try {
                int number = Integer.parseInt(part.trim());
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해 주세요.");
            }
        }
        new Lotto(numbers);
        return numbers;
    }

}

