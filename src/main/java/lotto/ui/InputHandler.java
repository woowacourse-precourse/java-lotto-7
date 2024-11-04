package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputHandler {

    public Money getPurchaseAmount() {
        try {
            System.out.println("구입 금액을 입력해 주세요.");
            String input = Console.readLine();
            return new Money(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount(); // 잘못된 입력일 경우 재입력 받기
        }
    }
}