package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input = Console.readLine();
            return parsePurchaseAmount(input);
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
            return parseWinningNumbers(input);
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
            return parseBonusNumber(input, winningNumbers);
    }

    private static int parsePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount < 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0 이상의 숫자여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    private static List<Integer> parseWinningNumbers(String input) {
        List<Integer> winningNumbers = Stream.of(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개의 숫자여야 합니다.");
        }

        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
        }

        if (!winningNumbers.stream().allMatch(num -> num >= 1 && num <= 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        return winningNumbers;
    }

    private static int parseBonusNumber(String input, List<Integer> winningNumbers) {
        try {
            int bonusNumber = Integer.parseInt(input);
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
