package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public final class InputHandler {

    private InputHandler() {
    }

    public static int inputLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                final int purchaseAmount = InputConverter.convertToPurchaseAmount(Console.readLine());
                InputValidator.validatePurchaseAmountIsZero(purchaseAmount);
                InputValidator.validatePurchaseAmountUnit(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static List<Integer> inputWinningLottoNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                final List<Integer> winningLottoNumbers = InputConverter.convertToWinningLottoNumbers(Console.readLine());
                InputValidator.validateWinningLottoNumbersCount(winningLottoNumbers);
                InputValidator.validateWinningLottoNumbersInRange(winningLottoNumbers);
                return winningLottoNumbers;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int inputBonusNumber(final List<Integer> winningLottoNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                final int bonusNumber = InputConverter.convertToBonusNumber(Console.readLine());
                InputValidator.validateBonusNumber(winningLottoNumbers, bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
