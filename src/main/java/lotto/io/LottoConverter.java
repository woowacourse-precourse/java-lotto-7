package lotto.io;

import static lotto.validation.LottoValidator.*;

import java.util.Arrays;
import java.util.List;

public class LottoConverter {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String SEPARATOR = ",";

    public int getLottoCount(String amountInput) {
        validateNotEmpty(amountInput, "구매 금액은 필수입니다.");
        validateIsNumber(amountInput, "숫자만 입력 가능합니다.");

        int purchaseAmount = Integer.parseInt(amountInput);
        validateDivisibleBy(purchaseAmount, LOTTO_TICKET_PRICE, "금액은 1,000원 단위어야 합니다.");

        return purchaseAmount / LOTTO_TICKET_PRICE;
    }

    public List<Integer> getWinningNumbers(String userInput) {
        validateNotEmpty(userInput, "당첨 번호는 필수입니다.");

        return Arrays.stream(userInput.split(SEPARATOR))
                .map(String::trim)
                .map(number -> {
                    validateIsNumber(number, "숫자만 입력 가능합니다.");
                    int num = Integer.parseInt(number);
                    validateRange(num,  "로또 번호는 1에서 45 사이여야 합니다.");
                    return num;
                }).toList();
    }

    public int getBonusNumber(String userInput, List<Integer> winningNumbers) {
        validateNotEmpty(userInput, "보너스 번호는 필수입니다.");
        validateIsNumber(userInput, "숫자만 입력 가능합니다.");

        int bonusNumber = Integer.parseInt(userInput);
        validateRange(bonusNumber, "로또 번호는 1에서 45 사이여야 합니다.");
        validateUniqueBonusNumber(winningNumbers, bonusNumber);

        return bonusNumber;
    }

}
