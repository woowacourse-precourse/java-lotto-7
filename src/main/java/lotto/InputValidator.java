package lotto;

import static lotto.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.ErrorCode.DUPLICATE_BONNUS_NUMBER;
import static lotto.ErrorCode.DUPLICATE_WINNIG_NUMBER;
import static lotto.ErrorCode.INVALID_NUMBER_RANGE;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;
import static lotto.ErrorCode.INVALID_WINNIG_NUMBER_COUNT;

import java.util.List;

public class InputValidator {

    private static final int TICKET_PRICE = 1000;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String COMMAS = ",,";

    //구매 금액 검증 (컨트롤러)
    public static void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    //당첨 번호 검증 (컨트롤러)
    public static void validateInputWinnigNumber(final String inputWinnigNumber) {
        if (inputWinnigNumber.contains(COMMAS)) {
            throw new IllegalArgumentException(CONTIGIOUS_COMMA.getMessage());
        }
    }

    //보너스 번호 검증
    public static void validateBonusNumberRange(final int bonusNumber) {
        validateNumberRange(bonusNumber);
    }

    public static void validateBonusNumberDuplicate(final int bonusNumber,
        final List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONNUS_NUMBER.getMessage());
        }
    }

    //헬퍼 메소드
    private static boolean hasDuplicates(final List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    private static void validateNumberRange(final int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }
}