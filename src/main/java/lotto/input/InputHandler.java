package lotto.input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {
    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
}
