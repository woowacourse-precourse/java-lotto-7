package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readAmount() {
        return readInput(InputMessage.INPUT_AMOUNT.toString());
    }

    public static String readWinningNumber() {
        return readInput(InputMessage.INPUT_WINNING_NUMBER.toString());
    }

    public static String readBonusNumber() {
        return readInput(InputMessage.INPUT_BONUS_NUMBER.toString());
    }

    private static String readInput(String message) {
        System.out.println(message);
        return Console.readLine(); // 입력을 받는 역할만 수행
    }
}
