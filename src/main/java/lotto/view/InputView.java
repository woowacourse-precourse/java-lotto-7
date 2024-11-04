package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_PRICE = 1000;

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            System.out.println();
            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 0보다 커야 합니다.");
            }
            if (amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 투입한 금액은 " + LOTTO_PRICE + "원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다. 올바른 금액을 입력해 주세요.", e);
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            List<Integer> numbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validateNumbers(numbers);
            System.out.println();
            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 형식이 아닙니다. 올바른 번호를 입력해 주세요.", e);
        }
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            int number = Integer.parseInt(Console.readLine());
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
            }
            System.out.println();
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식이 아닙니다. 올바른 번호를 입력해 주세요.", e);
        }
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 " + MIN_LOTTO_NUMBER + "부터 " + MAX_LOTTO_NUMBER + " 사이여야 합니다.");
            }
        }
    }
}
