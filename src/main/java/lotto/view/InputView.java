package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPriceInput() {
        System.out.println(PRICE_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String readWinningLottoNumber() {
        printWhiteSpace();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String readBonusNumber() {
        printWhiteSpace();
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    private static void printWhiteSpace() {
        System.out.println();
    }

    public static void closeConsole() {
        Console.close();
    }
}
