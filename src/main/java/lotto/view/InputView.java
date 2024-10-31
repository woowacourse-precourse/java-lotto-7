package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.global.Error.NOT_INTEGER;
import static lotto.global.Message.BUY_LOTTO_MESSAGE;

import lotto.domain.Buy;

public class InputView {

    public Buy buyLotto() {
        System.out.println(BUY_LOTTO_MESSAGE.getMsg());
        try {
            int money = convertToInt(readLine());
            return new Buy(money);
        } catch (NumberFormatException e) {
            System.out.println(NOT_INTEGER.getErrorMsg());
            return buyLotto();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return buyLotto();
        }
    }

    private int convertToInt(String money) throws NumberFormatException {
        return Integer.parseInt(money);
    }
}
