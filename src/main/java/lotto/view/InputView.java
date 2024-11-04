package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자 형식이어야 합니다.");
        }
    }
}