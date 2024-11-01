package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private int priceInput() {
        int price = Integer.parseInt(Console.readLine());
        priceInputValidator(price);
        return price;
    }
    private void priceInputValidator(int price){
        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위만 가능합니다.");
        }
    }
}
