package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.exceptions.ValidateError.validateBonusNumber;
import static lotto.exceptions.ValidateError.validatePurchasePrice;
import static lotto.exceptions.ValidateError.validateWinningNumber;

import lotto.model.Lotto;
import lotto.service.ParsingWinningNumberService;

public class InputView {
    public static int inputPurchasePrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                return validatePurchasePrice(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Lotto inputWinningNumber() {
        while (true) {
            System.out.println("\n당첨 번호를 입력해 주세요.");
            String winningNumberStr = readLine();
            try {
                validateWinningNumber(winningNumberStr);
                Lotto winningNumbers = ParsingWinningNumberService.parseWinningNumbers(winningNumberStr);
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                return validateBonusNumber(readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
