package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int LottoPurchaseAmount = Integer.parseInt(Console.readLine());

        return LottoPurchaseAmount;
    }

}
