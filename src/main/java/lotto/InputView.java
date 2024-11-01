package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getLottoPurchaseAmount() {
        int lottoPurchaseAmount = Integer.parseInt(Console.readLine());

        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로만 입력이 가능합니다.");
        }

        return lottoPurchaseAmount;
    }
}