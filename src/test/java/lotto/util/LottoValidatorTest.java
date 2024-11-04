package lotto.util;

import lotto.constants.LottoConstants;
import lotto.error.LottoError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @Test
    @DisplayName("구매 금액이 0 이하일 때 예외 발생")
    void 구매금액이_0이하일_때_예외발생() {
        // given
        int invalidAmount = 0;

        // when & then
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NON_POSITIVE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("구매 금액이 로또 가격의 배수가 아닐 때 예외 발생")
    void 구매금액이_로또가격의_배수가_아닐_때_예외발생() {
        // given
        int invalidAmount = 1001;

        // when & then
        assertThatThrownBy(() -> LottoValidator.validatePurchaseAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    @DisplayName("로또 번호 개수가 요구된 개수와 다를 때 예외 발생")
    void 로또번호_개수가_요구된_개수와_다를_때_예외발생() {
        // given
        int requiredCount = LottoConstants.REQUIRED_LOTTO_NUMBERS;
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validateNumberCount(invalidNumbers, requiredCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER_COUNT.getMessage());
    }

    @Test
    @DisplayName("로또 번호 범위가 올바르지 않을 때 예외 발생")
    void 로또번호_범위가_올바르지_않을_때_예외발생() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validateNumberRange(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("로또 번호에 중복이 있을 때 예외 발생")
    void 로또번호에_중복이_있을_때_예외발생() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validateNoDuplicates(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.DUPLICATE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 올바를 때 예외가 발생하지 않음")
    void 로또번호가_올바를_때_예외가_발생하지_않음() {
        // given
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        LottoValidator.validateLottoNumbers(validNumbers);
    }

    @Test
    @DisplayName("당첨 번호가 올바르지 않을 때 예외 발생")
    void 당첨번호가_올바르지_않을_때_예외발생() {
        // given
        List<Integer> invalidWinningNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validateWinningNumbers(invalidWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 올바르지 않을 때 예외 발생")
    void 보너스번호가_올바르지_않을_때_예외발생() {
        // given
        int invalidBonus = 46;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(invalidBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함될 때 예외 발생")
    void 보너스번호가_당첨번호에_포함될_때_예외발생() {
        // given
        int duplicateBonus = 1;
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when & then
        assertThatThrownBy(() -> LottoValidator.validateBonusNumber(duplicateBonus, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("문자열을 정수로 파싱할 때 올바르지 않으면 예외 발생")
    void 문자열을_정수로_파싱할_때_올바르지_않으면_예외발생() {
        // given
        String invalidNumber = "aaa";

        // when & then
        assertThatThrownBy(() -> LottoValidator.parseNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoError.INVALID_NUMBER_PARSE.getMessage());
    }

    @Test
    @DisplayName("문자열을 정수로 성공적으로 파싱")
    void 문자열을_정수로_성공적으로_파싱() {
        // given
        String validNumber = "42";

        // when
        int result = LottoValidator.parseNumber(validNumber);

        // then
        assertThat(result).isEqualTo(42);
    }
}
