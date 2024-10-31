package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoView {
    public int getInputPurchaseAmount() {
        try {
            System.out.println("구매금액을 입력해 주세요.");
            int amount = Integer.parseInt(Console.readLine());
            validateAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputPurchaseAmount();
        }
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    public List<Integer> getInputWinningNumbers() {
        try {
            System.out.println("당첨 번호를 입력해주세요.");
            String input = Console.readLine();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInputWinningNumbers();
        }
    }

    private List<Integer> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
    }
}
