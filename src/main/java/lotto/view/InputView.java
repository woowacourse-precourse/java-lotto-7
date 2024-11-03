package lotto.view;

import static lotto.view.message.InputViewMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public InputView() {}

    public String inputPrice() {
        System.out.println(INPUT_PRICE.message);
        return Console.readLine();
    }

    public String inputLottoNumbers() {
        System.out.println(INPUT_LOTTO_NUMBERS.message);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER.message);
        return Console.readLine();
    }
}
