package lotto;

import java.util.Arrays;
import java.util.List;

public final class InputConverter {

    private InputConverter() {
    }

    public static int convertToPurchaseAmount(final String purchaseAmountInput) {
        try {
            return Integer.parseInt(purchaseAmountInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다. 다시 입력해주세요.");
        }
    }

    public static List<Integer> convertToWinningLottoNumbers(final String winningLottoNumbersInput) {
        try {
            final String[] splitedWinningLottoNumbers = winningLottoNumbersInput.split(",");
            return Arrays.stream(splitedWinningLottoNumbers)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toList();
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자이어야 합니다. 다시 입력해주세요.");
        }
    }

    public static int convertToBonusNumber(final String bonusNumberInput) {
        try {
            return Integer.parseInt(bonusNumberInput);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자이어야 합니다. 다시 입력해주세요.");
        }
    }
}
