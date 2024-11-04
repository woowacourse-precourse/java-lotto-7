package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static User inputUserMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
             return new User(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputUserMoney();
        }
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            return new Lotto(Console.readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return inputWinningNumbers();
        }
    }
}
