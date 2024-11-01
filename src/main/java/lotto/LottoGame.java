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
        System.out.println(purchaseAmount);
    }

    // 양수인지 확인하는 메서드
    private String checkPositiveNumber(String number) {
        if (!number.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 입력한 값은 숫자(양수)여야 합니다.");
        }
        return number;
    }
}
