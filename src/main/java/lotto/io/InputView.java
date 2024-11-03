package lotto.io;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.global.util.Validator;

public class InputView {
    public String readPrice() {
        String price = readLine();
        Validator.validatePrice(price);
        return price;
    }

    public String[] readWinningNumber() {
        return readLine().split(",");
    }

    public String readBonusNumber() {
        return readLine();
    }
}
