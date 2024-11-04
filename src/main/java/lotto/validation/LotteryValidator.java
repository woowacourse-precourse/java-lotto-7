package lotto.validation;

import static lotto.constant.LotteryConstant.DEFAULT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.List;

public class LotteryValidator {

    public boolean validateInputPurchaseAmount(final String inputPurchaseAmount) {
        try {
            Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + " 올바른 금액을 입력해주세요.");
            return false;
        }

        return true;
    }

    public boolean validateInputLottoNumbers(final String inputLottoNumbers) {
        try {
            List<Integer> numbers = new ArrayList<>();
            for (final String number : inputLottoNumbers.split(",")) {
                numbers.add(Integer.parseInt(number.trim()));
            }
            return true;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + " 로또 번호는 1부터 45 사이의 정수여야 합니다.");
        }
    }

    public boolean validateInputLottoBonusNumber(final String inputLottoBonusNumber) {
        try {
            Integer.parseInt(inputLottoBonusNumber);
        } catch (NumberFormatException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + "보너스 로또 번호는 정수여야 합니다.");
            return true;
        }
        return true;
    }
}
