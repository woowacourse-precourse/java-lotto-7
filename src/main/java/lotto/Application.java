package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        int purchaseAmount = promptPurchaseAmount();

        List<Integer> winningNumbers = promptWinningNumbers();
    }

    public static int promptPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmount = Console.readLine();

            if (isValidPurchaseAmount(purchaseAmount)) {
                return Integer.parseInt(purchaseAmount.trim());
            }

            handleInvalidPurchaseAmount();
        }
    }

    public static List<Integer> promptWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbers = Console.readLine();

            if (isValidWinningNumbers(winningNumbers)) {
                return Arrays.stream(winningNumbers.split(",", -1))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
            }

            handleInvalidWinningNumbers();
        }
    }

    public static boolean isValidPurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            return false;
        }

        try {
            return Integer.parseInt(purchaseAmount.trim()) >= 1000 && Integer.parseInt(purchaseAmount.trim()) % 1000 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidWinningNumbers(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(",", -1);

        return !isBlank(winningNumbers) &&
                containsComma(winningNumbers) &&
                !hasDuplicates(splitWinningNumbers) &&
                hasSixNumbers(splitWinningNumbers) &&
                areNumbersInRange(splitWinningNumbers);
    }

    public static void handleInvalidPurchaseAmount() {
        try {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위입니다. 유효한 금액을 입력해주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void handleInvalidWinningNumbers() {
        try {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45까지의 중복되지 않는 6개의 숫자이어야 합니다. 번호는 쉼표(,)를 기준으로 구분해주세요");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    private static boolean containsComma(String input) {
        return input.contains(",");
    }

    private static boolean hasDuplicates(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        return uniqueNumbers.size() != numbers.length;
    }

    private static boolean hasSixNumbers(String[] numbers) {
        if (numbers.length != 6) {
            return false;
        }

        for (String number : numbers) {

            if (number.isBlank()) {
                return false;
            }

        }
        return true;
    }

    private static boolean areNumbersInRange(String[] numbers) {
        for (String number : numbers) {

            if (!number.trim().matches("^(?:[1-9]|[1-3][0-9]|4[0-5])$")) {
                return false;
            }

        }
        return true;
    }
}
