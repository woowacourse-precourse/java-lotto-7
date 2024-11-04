package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private InputView() {
    }

    public static String readInput() {
        String purchaseAmount = readLine().trim();

        if (purchaseAmount.isEmpty()) {
            throw new IllegalArgumentException("빈 값을 입력할 수 없습니다.");
        }

        return purchaseAmount;
    }
}
