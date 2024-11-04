package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String getMoneyInput() {
        System.out.println(INPUT_MONEY);

        return Console.readLine().trim();
    }

    public String getNumbersInput() {
        System.out.println(INPUT_LOTTO_NUMBERS);

        return Console.readLine().trim();
    }

    public String getBonusInput() {
        System.out.println(INPUT_BONUS_NUMBER);

        return Console.readLine().trim();
    }
}
