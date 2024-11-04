package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputProcessor {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int money = parseInteger(input);
        InputValidator.validatePurchaseAmount(money);
        return money;
    }

    public static Lotto getWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> numbers = parseIntegerList(input);
        InputValidator.validateWinningNumbers(numbers);
        return new Lotto(numbers);
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = parseInteger(input);
        InputValidator.validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력해주세요.");
        }
    }

    private static List<Integer> parseIntegerList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(InputProcessor::parseInteger)
                .collect(Collectors.toList());
    }
}