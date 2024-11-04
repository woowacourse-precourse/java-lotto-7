package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class InputView {

    public static List<Integer> getWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분하여 6개 입력)");
            String[] inputs = splitInput(Console.readLine());
            List<Integer> numbers = parseNumbers(inputs);
            validateWinningNumbers(numbers);
            return numbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers(); // 재시도
        }
    }

    public static int getBonusNumber() {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = parseNumber(Console.readLine());
            validateNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(); // 재시도
        }
    }

    public static int getPurchaseAmount() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int amount = parseNumber(Console.readLine());
            validatePurchaseAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount(); // 재시도
        }
    }

    private static String[] splitInput(String input) {
        return input.split(",");
    }

    private static List<Integer> parseNumbers(String[] inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(parseNumber(input));
        }
        return numbers;
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력해 주세요.");
        }
    }

    private static void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복된 숫자가 없어야 합니다.");
        }
    }

    private static void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1,000원 단위여야 합니다.");
        }
    }
}
