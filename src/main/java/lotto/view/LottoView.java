package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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
}
