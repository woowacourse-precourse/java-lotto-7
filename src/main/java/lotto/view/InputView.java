package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.NumberUtils;

public class InputView {
    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return NumberUtils.parseNumber(Console.readLine());
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return NumberUtils.parseNumber(Console.readLine());
    }
}
