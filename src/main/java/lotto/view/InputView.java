package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exceptions.ValidateError.validateBonusNumber;
import static lotto.exceptions.ValidateError.validatePurchasePrice;

public class InputView {
    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return validatePurchasePrice(readLine());
    }

    public static String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return validateBonusNumber(readLine());
    }
}
