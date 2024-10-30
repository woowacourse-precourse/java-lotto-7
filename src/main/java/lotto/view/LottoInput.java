package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoInput {

    private LottoInput() {
    }

    public static int inputMoney() {
        printInputMoney();
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    private static void printInputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
