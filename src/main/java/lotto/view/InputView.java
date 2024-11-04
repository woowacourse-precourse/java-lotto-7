package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getBudget() {
        System.out.println(Message.INPUT_BUDGET.getMessage());
        return Console.readLine();
    }

    public String getLottoNumbers() {
        System.out.println(Message.INPUT_LOTTO_NUMBERS.getMessage());
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
