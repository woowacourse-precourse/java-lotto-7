package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.validation.Validation.validateStringToInteger;

public class InputView {

    public int readPayAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input_pay = readLine().trim();
        validateStringToInteger(input_pay);
        Integer pay = Integer.valueOf(input_pay);
        return pay;
    }
}
