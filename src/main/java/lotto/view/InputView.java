package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Prompts;

public class InputView {
    public String requirePrice() {
        System.out.println(Prompts.INPUT_PRICE_PROMPT);
        return Console.readLine();
    }

    public String requireLottoNumbers() {
        System.out.println(Prompts.INPUT_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String requireBonusNumber() {
        System.out.println(Prompts.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
