package lotto.console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput {

    public static String getTotalPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    public static String getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public static String getBonusNumberInput() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return readLine();
    }
}
