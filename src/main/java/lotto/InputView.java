package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int getLottoPurchaseAmount() {
        int lottoPurchaseAmount = Integer.parseInt(Console.readLine());

        return lottoPurchaseAmount;
    }
}