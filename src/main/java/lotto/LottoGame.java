package lotto;

import camp.nextstep.edu.missionutils.*;

public class LottoGame {

    private int purchaseAmount;

    public void start() {
        purchaseAmountInput();
    }

    private void purchaseAmountInput() {
        System.out.println("구입금액을 입력해 주세요.");
        purchaseAmount = Integer.parseInt(checkPositiveNumber(Console.readLine()));
        checkUnitOfPurchaseAmount(purchaseAmount);
        checkPurchasedAmountExceeded(purchaseAmount);
        System.out.println(purchaseAmount);
    }

    // 100,000원을 초과했는지 확인하는 메서드
    private void checkPurchasedAmountExceeded(int purchaseAmount) {
        if (purchaseAmount > 100000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1인당 100,000원을 넘길 수 없습니다.");
        }
    }

    // 1,000원 단위인지 확인하는 메서드
    private void checkUnitOfPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 양수인지 확인하는 메서드
    private String checkPositiveNumber(String input) {
        if (!input.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자(양수)여야 합니다.");
        }
        return input;
    }
}
