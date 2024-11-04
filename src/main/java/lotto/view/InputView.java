package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int getPurchaseAmount() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }
}
