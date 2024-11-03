package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public static void closeStream() {
        Console.close();
    }

}
