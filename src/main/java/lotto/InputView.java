package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

        if (purchaseAmount % 1000 == 0) {
            return purchaseAmount;
        }

        throw new IllegalArgumentException("[ERROR] 구입은 1000원 단위로만 가능합니다.");
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요. ");
        String numbers = Console.readLine();
        try {
            return Arrays.stream(numbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요. ");
        String bonusNumber = Console.readLine();
        try {
            return Integer.parseInt(bonusNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }
}
