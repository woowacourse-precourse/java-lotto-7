package lotto.validation;

import static lotto.constant.LotteryConstant.DEFAULT_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LotteryValidator {

    public boolean validateInputPurchaseAmount(final String inputPurchaseAmount) {
        try {
            Integer.parseInt(inputPurchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println(DEFAULT_ERROR_MESSAGE + " 숫자로 변환 불가능합니다.");
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
            throw new IllegalArgumentException(DEFAULT_ERROR_MESSAGE + " 로또 번호는 정수여야 합니다.");
        }
    }
}
