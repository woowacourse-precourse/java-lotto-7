package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;

public class InputView {
    private static final String ERROR_INVALID_AMOUNT = "[ERROR] 유효하지 않은 금액입니다. 숫자를 입력해 주세요.";
    private static final String ERROR_AMOUNT_UNIT = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";
    private static final String ERROR_DUPLICATE_NUMBER = "[ERROR] 당첨 번호는 중복될 수 없습니다.";
    private static final int PURCHASE_UNIT = 1000;

    private static int purchaseAmount;

    public static int getPurchaseAmount() {
        return purchaseAmount;
    }

    public static int purchaseAmount() {
        OutputView.purchaseAmount();
        while (true) {
            try {
                purchaseAmount = Integer.parseInt(Console.readLine());
                if (purchaseAmount % PURCHASE_UNIT != 0) {
                    System.out.println(ERROR_AMOUNT_UNIT);
                    continue;
                }
                return purchaseAmount / PURCHASE_UNIT;
            } catch (NumberFormatException e) {
                System.out.println(ERROR_INVALID_AMOUNT);
            }
        }
    }

    public static List<Integer> winningNumber() {
        OutputView.userNumber();
        while (true) {
            List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .toList();
            if (numbers.size() != new HashSet<>(numbers).size()) {
                System.out.println(ERROR_DUPLICATE_NUMBER);
                continue;
            }
            return numbers;
        }
    }

    public static int bonusNumber() {
        return Integer.parseInt(Console.readLine());
    }
}
