package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    public static int getPurcahseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        Validator.purchaseAmount(input);
        return Integer.parseInt(input);
    }

    public static String getWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine().trim();
    }
}
