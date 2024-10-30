package lotto.service;

public class InputHandler {
    public static int purchaseAmountHandle(String input) {
        if ( !input.matches("[0-9]*") ) {
            throw new IllegalArgumentException("[ERROR] 자연수만 입력할 수 있습니다");
        }
        int inputAmount = Integer.parseInt(input);
        if ( inputAmount < 1000 ) {
            throw new IllegalArgumentException("[ERROR] 한 장 이상 구매해야 합니다");
        }
        if ( inputAmount % 1000 != 0 ) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로만 구매할 수 있습니다");
        }

        return inputAmount/1000;
    }
}
