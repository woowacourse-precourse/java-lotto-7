package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.ViewConstant.GET_BONUS_NUMBER;
import static lotto.view.ViewConstant.GET_PURCHASE_MONEY;
import static lotto.view.ViewConstant.GET_WIN_LOTTO_NUMBER;

public class Input {
    public Input() {
    }

    public String getPurchaseMoney() {
        System.out.println(GET_PURCHASE_MONEY);

        return getInput();
    }

    public String getWinningLottoNumbers() {
        System.out.println(GET_WIN_LOTTO_NUMBER);

        return getInput();
    }

    public String getBonusNumber() {
        System.out.println(GET_BONUS_NUMBER);

        return getInput();
    }

    private String getInput() {
        return readLine();
    }
}
