package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Config;

public class Inputview {
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int money = Integer.parseInt(Console.readLine());
            if (money % 1000 != 0) {
                throw new IllegalArgumentException(Config.ERROR_INVALID_TICKET_COUNT);
            }
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Config.ERROR_INVALID_MONEY_FORMAT);
        }
    }

    public static String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
