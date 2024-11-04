package lotto.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest {

    @DisplayName("당첨 번호의 개수가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateWinningLotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_LOTTO_NUMBER_COUNT.getMessage());
    }

    @DisplayName("당첨 번호 중 중복된 숫자가 있는 경우 예외가 발생한다.")
    @Test
    void 당첨_번호_중_중복된_숫자가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateWinningLotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_WINNING_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("당첨 번호의 숫자들이 1부터 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 당첨_번호의_숫자들이_1부터_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateWinningLotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_LOTTO_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_1부터_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복된 경우 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validateBonusNumber(List.of(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
    }

    @DisplayName("구입 금액이 1,000원 단위가 아닌 경우 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validatePurchasePrice(1500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }

    @DisplayName("구입 금액이 0 이하일 경우 예외가 발생한다.")
    @Test
    void 구입_금액이_0_이하일_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Validation.validatePurchasePrice(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_PRICE.getMessage());
    }
}