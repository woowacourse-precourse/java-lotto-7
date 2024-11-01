package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_AMOUNT = "구입 금액을 입력해주세요.";

    public static String readAmount() {
        System.out.println(INPUT_AMOUNT);

        return Console.readLine();
    }

    public static String readLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return Console.readLine();
    }

    public static String readBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");

        return Console.readLine();
    }

}
