package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        checkInput(input);
        int purchasePrice = checkNumber(input);
        checkUnit(purchasePrice);
        return purchasePrice;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        checkInput(input);
        List<String> winningNumbersStr = Arrays.asList(input.split(","));
        List<Integer> winningNumbers = checkWinningNumbersStr(winningNumbersStr);
        checkWinningNumbers(winningNumbers);
        return winningNumbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        checkInput(input);
        int bonusNumber = checkNumber(input);
        return bonusNumber;
    }

    private static void checkInput(String input) {
        if (input == null || input.trim().isEmpty())
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
    }

    private static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
    }

    private static void checkUnit(int number) {
        if (number < 1000)
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 이상이어야 합니다." + number);
        if (number % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다." + number);
    }

    private static List<Integer> checkWinningNumbersStr(List<String> winningNumbersStr) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumberStr : winningNumbersStr) {
            checkInput(winningNumberStr);
            winningNumbers.add(checkNumber(winningNumberStr.trim()));
        }
        return winningNumbers;
    }

    private static void checkWinningNumbers(List<Integer> winningNumbers) {
        checkDuplicateNumber(winningNumbers);
        checkRangeNumber(winningNumbers);
    }

    private static void checkDuplicateNumber(List<Integer> numbers) {
        if(numbers.size()!=numbers.stream().distinct().count())
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되지 않는 숫자로 이루어져야 합니다.");
    }

    private static void checkRangeNumber(List<Integer> numbers) {
        for(Integer number:numbers) {
            if(number < 1 || number > 45)
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1~45 범위여야 합니다." + number);
        }
    }
}
