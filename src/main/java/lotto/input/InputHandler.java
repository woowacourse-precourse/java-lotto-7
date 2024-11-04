package lotto.input;

import lotto.validation.Validation;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputHandler {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputPurchaseAmount = readLine();
        Validation.validatedPurchaseAmount(inputPurchaseAmount);
        Validation.validatedThousandUnitAmount(inputPurchaseAmount);
        return Integer.parseInt(readLine());
    }
    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLine();
    }
    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(readLine());
    }
}
