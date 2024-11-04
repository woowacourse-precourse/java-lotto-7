package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getCost() {
        System.out.println(Messages.PAYMENT_INPUT_MSG.getMessage());
        return Console.readLine();
    }

    public String getLottoNumbers() {
        System.out.println(Messages.LOTTO_INPUT_MSG.getMessage());
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(Messages.BONUS_INPUT_MSG.getMessage());
        return Console.readLine();
    }

}
