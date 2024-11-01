package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static void printPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static String inputPurchaseAmount() {
        printPurchaseAmount();
        return readLine();
    }
}
