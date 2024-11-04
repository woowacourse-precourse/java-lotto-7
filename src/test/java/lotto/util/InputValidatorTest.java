package lotto.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lotto.exception.InputException;
import lotto.util.enums.ExceptionMessages;
import lotto.util.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private final InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("구입 금액이 올바를 때 예외가 발생하지 않음")
    void 구입_금액이_올바를때는_예외가_발생하지_않는다() {
        String validPurchaseAmount = "5000";
        assertDoesNotThrow(() -> inputValidator.validatePurchaseAmount(validPurchaseAmount));
    }

    @Test
    @DisplayName("구입 금액이 비어 있을 때 예외 발생")
    void 구입_금액이_비어있을때는_예외가_발생한다() {
        String emptyPurchaseAmount = "";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validatePurchaseAmount(emptyPurchaseAmount));
        assert exception.getMessage().equals(ExceptionMessages.EMPTY_INPUT.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 숫자 형식이 아닐 때 예외 발생")
    void 구입_금액이_숫자_형식이_아닐땐_예외가_발생한다() {
        String invalidPurchaseAmount = "abc";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validatePurchaseAmount(invalidPurchaseAmount));
        assert exception.getMessage().equals(ExceptionMessages.INVALID_PURCHASE_AMOUNT_FORMAT.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위로 나누어지지 않을 때 예외 발생")
    void 구입_금액이_단위에_나누어지지않을때_예외가_발생한다() {
        String invalidPurchaseAmount = "1500";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validatePurchaseAmount(invalidPurchaseAmount));
        assert exception.getMessage().equals(ExceptionMessages.NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 최대 한도를 초과할 때 예외 발생")
    void 구입_금액이_한도를_초과할때_예외가_발생한다() {
        String excessivePurchaseAmount = "200000";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validatePurchaseAmount(excessivePurchaseAmount));
        assert exception.getMessage().equals(ExceptionMessages.EXCEEDS_PURCHASE_LIMIT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 올바를 때 예외가 발생하지 않음")
    void 당첨번호가_올바를때_예외가_발생하지_않는다() {
        String validWinningNumbers = "1, 2, 3, 4, 5, 6";
        assertDoesNotThrow(() -> inputValidator.validateWinningNumbers(validWinningNumbers));
    }

    @Test
    @DisplayName("당첨 번호가 숫자 형식이 아닐 때 예외 발생")
    void 당첨번호가_숫자_형식이_아닐때_예외가_발생한다() {
        String invalidWinningNumbers = "a, b, c, d, e, f";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateWinningNumbers(invalidWinningNumbers));
        assert exception.getMessage().equals(ExceptionMessages.INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호의 개수가 6개가 아닐 때 예외 발생")
    void 당첨번호가_6개가_아닐때_예외가_발생한다() {
        String invalidWinningNumbers = "1, 2, 3, 4, 5";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateWinningNumbers(invalidWinningNumbers));
        assert exception.getMessage().equals(ExceptionMessages.INVALID_WINNING_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 중복된 번호가 있을 때 예외 발생")
    void 당첨번호가_중복될때_예외가_발생한다() {
        String invalidWinningNumbers = "1, 2, 2, 4, 5, 6";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateWinningNumbers(invalidWinningNumbers));
        assert exception.getMessage().equals(ExceptionMessages.DUPLICATE_WINNING_NUMBER.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 1-45 범위 밖일 때 예외 발생")
    void 당첨번호가_범위_밖일때_예외가_발생한다() {
        String outOfRangeWinningNumbers = "0, 2, 3, 4, 5, 46";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateWinningNumbers(outOfRangeWinningNumbers));
        assert exception.getMessage().equals(ExceptionMessages.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 올바를 때 예외가 발생하지 않음")
    void 보너스_번호가_올바를때_예외가_발생한다() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String bonusNumber = "7";
        assertDoesNotThrow(() -> inputValidator.validateBonusNumber(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("보너스 번호가 숫자 형식이 아닐 때 예외 발생")
    void 보너스_번호가_숫자_형식이_아닐때_예외가_발생한다() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String invalidBonusNumber = "a";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateBonusNumber(winningNumbers, invalidBonusNumber));
        assert exception.getMessage().equals(ExceptionMessages.INVALID_BONUS_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1-45 범위 밖일 때 예외 발생")
    void 보너스_번호가_범위_밖일때_예외가_발생한다() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String outOfRangeBonusNumber = "46";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateBonusNumber(winningNumbers, outOfRangeBonusNumber));
        assert exception.getMessage().equals(ExceptionMessages.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복될 때 예외 발생")
    void 보너스_번호가_당첨번호와_중복될때_예외가_발생한다() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        String duplicateBonusNumber = "5";
        InputException exception = assertThrows(InputException.class,
                () -> inputValidator.validateBonusNumber(winningNumbers, duplicateBonusNumber));
        assert exception.getMessage().equals(ExceptionMessages.DUPLICATE_BONUS_NUMBER.getMessage());
    }
}
