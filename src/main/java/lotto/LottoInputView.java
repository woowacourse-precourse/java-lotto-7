package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoInputView
{
    public static int lottoPurchaseAmount() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            validatePurchaseLotto(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            // 다시 입력 받는다.
            return lottoPurchaseAmount();
        }
    }

    public static List<Integer> lottoWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String numbers = Console.readLine().trim();
        List<Integer> finalwinningNumbers = tempWinningNumbers(numbers);

        return finalwinningNumbers;
    }

    public static List<Integer> tempWinningNumbers(String numbers) {
        String[] splitNumbers = splitWinningNumbers(numbers);
        List<String> trimNumbers = trimWinningNumbers(splitNumbers);
        List<Integer> finalNums = convertIntegerList(trimNumbers);

        return finalNums;
    }

    public static String[] splitWinningNumbers(String numbers) {
        return numbers.split(",");
    }

    public static List<String> trimWinningNumbers(String[] input) {
        return Arrays.stream(input)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<Integer> convertIntegerList(List<String> trimNumbers){
        return trimNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validatePurchaseLotto(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
