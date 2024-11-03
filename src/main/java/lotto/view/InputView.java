package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    public static int getPurcahseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        Validator.purchaseAmount(input);

        return Validator.parseInt(input);
    }

    public static String getWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        return Console.readLine().trim();
    }

    public static int getBonusNumbers() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();

        return Validator.parseInt(input);
    }
}
