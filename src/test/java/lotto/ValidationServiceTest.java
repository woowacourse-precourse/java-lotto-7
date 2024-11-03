package lotto;

import lotto.domain.model.ErrorMessages;
import lotto.domain.service.ValidationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidationServiceTest {

    @Test
    @DisplayName("구입금액이_0이면_예외_발생")
    void 구입금액이_0이면_예외_발생() {
        String input = "0";
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validatePurchaseAmount(input),
                ErrorMessages.ZERO_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구입금액이_음수면_예외_발생")
    void 구입금액이_음수면_예외_발생() {
        String input = "-1000";
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validatePurchaseAmount(input),
                ErrorMessages.ZERO_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구입금액이_1000원_미만이면_예외_발생")
    void 구입금액이_1000원_미만이면_예외_발생() {
        String input = "500";
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validatePurchaseAmount(input),
                ErrorMessages.MINIMUM_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구입금액이_1000원_단위가_아니면_예외_발생")
    void 구입금액이_1000원_단위가_아니면_예외_발생() {
        String input = "1500";
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validatePurchaseAmount(input),
                ErrorMessages.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("당첨번호가_6개가_아니면_예외_발생")
    void 당첨번호가_6개가_아니면_예외_발생() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validateWinningNumbers(numbers),
                ErrorMessages.INVALID_LOTTO_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("당첨번호가_범위를_벗어나면_예외_발생")
    void 당첨번호가_범위를_벗어나면_예외_발생() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        assertThrows(IllegalArgumentException.class, () -> ValidationService.validateWinningNumbers(numbers),
                ErrorMessages.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스번호가_당첨번호와_중복되면_예외_발생")
    void 보너스번호가_당첨번호와_중복되면_예외_발생() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String bonusNumber = "3";
        assertThrows(IllegalArgumentException.class,
                () -> ValidationService.validateBonusNumber(bonusNumber, winningNumbers),
                ErrorMessages.BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @Test
    @DisplayName("유효한_구입_금액이면_검증_통과")
    void 유효한_구입_금액이면_검증_통과() {
        String validInput = "2000";
        int result = ValidationService.validatePurchaseAmount(validInput);
        assertEquals(2000, result);
    }

    @Test
    @DisplayName("유효한_보너스번호면_검증_통과")
    void 유효한_보너스번호면_검증_통과() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String validBonusNumber = "7";
        int result = ValidationService.validateBonusNumber(validBonusNumber, winningNumbers);
        assertEquals(7, result);
    }
}
