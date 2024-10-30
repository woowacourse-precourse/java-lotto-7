package lotto.io.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class InputView {

    private static final String AMOUNT_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";

    public Money getAmountOfMoney() {
        System.out.println(AMOUNT_INPUT_GUIDE_MESSAGE);
        String input = Console.readLine();

        return new Money(input);
    }
}
