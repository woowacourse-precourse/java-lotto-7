package lotto.view;

import static lotto.domain.InputErrorMessage.BONUS_LOTTO_ONLY_ONE_NUMBER;
import static lotto.domain.InputErrorMessage.PURCHASE_AMOUNT_ONLY_NUMBER;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(PURCHASE_AMOUNT_ONLY_NUMBER.getMessage());
        }
    }

    public static String inputMainSixLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        try {
            return Console.readLine();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static int inputBonusLotto() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(BONUS_LOTTO_ONLY_ONE_NUMBER.getMessage());
        }
    }

}
