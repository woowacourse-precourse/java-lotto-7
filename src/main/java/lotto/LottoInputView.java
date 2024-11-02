package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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
        List<Integer> finalwinningNumbers = splitWinningNumbers(numbers);

        return finalwinningNumbers;
    }

    public static List<Integer> splitWinningNumbers(String numbers) {

    }



    private static void validatePurchaseLotto(int amount) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해주세요.");
        }
    }
}
