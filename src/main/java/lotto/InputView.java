package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final int lottoPurchaseAmount = Integer.parseInt(Console.readLine());

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }
}