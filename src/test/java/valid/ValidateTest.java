package valid;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.ErrorMessage;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidateTest {

    @DisplayName("구입 금액이 1_000원 단위일 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenPurchaseAmountIsThousandUnit() {
        // given
        int validPurchaseAmount = 3_000;

        // when & then
        assertThatCode(() -> Validate.isThousandUnit(validPurchaseAmount))
                .doesNotThrowAnyException();
    }

    @DisplayName("구입 금액이 1_000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenPurchaseAmountIsNotThousandUnit() {
        // given
        int validPurchaseAmount = 3_333;

        // when & then
        assertThatThrownBy(() -> Validate.isThousandUnit(validPurchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.PURCHASE_AMOUNT_INVALID_UNIT_MSG.getMessage());
    }

    @DisplayName("숫자 형태가 일 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenIsNotNumberFormat() {
        // given
        String validNumber = "12345";

        // when & then
        assertThatCode(() -> Validate.isNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("숫자 형태가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenIsNotNumberFormat() {
        // given
        String validNumber = "NUMBER";

        // when & then
        assertThatThrownBy(() -> Validate.isNumber(validNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_NUMBER_FORMAT_MSG.getMessage());
    }

    @DisplayName("값이 중복이 아닐 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenIsDuplicated() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatCode(() -> Validate.isDuplicated(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("값이 중복일 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenIsDuplicated() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> Validate.isDuplicated(validNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_WINNING_NUMBERS_MSG.getMessage());
    }

    @DisplayName("6개 숫자가 일 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenIsNotSixNumbers() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatCode(() -> Validate.isSixNumbers(validNumbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("6개 숫자가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenIsNotSixNumbers() {
        // given
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> Validate.isSixNumbers(validNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_SIX_WINNING_NUMBERS_MSG.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있지 않을 때 예외가 발생하지 않는다.")
    @Test
    void doseNotThrowExceptionWhenBonusNumberInWinningNumbers() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;

        // when & then
        assertThatCode(() -> Validate.isNotInWinningNumbers(winningNumbers, validBonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있을 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenBonusNumberInWinningNumbers() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 6;

        // when & then
        assertThatThrownBy(() -> Validate.isNotInWinningNumbers(winningNumbers, validBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IN_WINNING_NUMBERS_MSG.getMessage());
    }

    @DisplayName("양수가 일 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenIsPositive() {
        // given
        int validNumber = 5;

        // when & then
        assertThatCode(() -> Validate.isPositiveNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("양수가 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenIsPositive() {
        // given
        int validNumber = -5;

        // when & then
        assertThatThrownBy(() -> Validate.isPositiveNumber(validNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_POSITIVE_NUMBER_MSG.getMessage());
    }

    @DisplayName("1과 45 사잇값 일 때 예외가 발생하지 않는다.")
    @Test
    void doesNotThrowExceptionWhenIsNotOneBetweenFortyFive() {
        // given
        int validNumber = 45;

        // when & then
        assertThatCode(() -> Validate.isPositiveNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("1과 45 사잇값이 아닐 때 예외가 발생한다.")
    @Test
    void throwExceptionWhenIsNotOneBetweenFortyFive() {
        // given
        int validNumber = 49;

        // when & then
        assertThatThrownBy(() -> Validate.isOneBetweenFortyFive(validNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_ONE_BETWEEN_FORTY_FIVE_MSG.getMessage());
    }
}
