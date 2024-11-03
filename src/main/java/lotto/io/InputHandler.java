package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public Integer getPurchaseCost() {
        Integer purchaseCost = Integer.valueOf(Console.readLine());

        if (purchaseCost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }

        return purchaseCost;
    }
    
}
