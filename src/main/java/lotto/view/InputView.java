package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Validator;

public class InputView {
    public static int getPurcahseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();
        Validator.purchaseAmount(input);
        return Integer.parseInt(input);
    }
}
