package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    @DisplayName("구입 금액이 숫자가 아니면 예외가 발생한다")
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        // given
        String input = "1000a";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_FORMAT.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 최소 금액보다 낮으면 예외가 발생한다")
    void 구입_금액이_최소_금액보다_낮으면_예외가_발생한다() {
        // given
        String input = "500";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.AMOUNT_TOO_LOW.getMessage());
    }

    @Test
    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        // given
        String input = "1500";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT_UNIT.getMessage());
    }

    @Test
    @DisplayName("당첨 번호에 숫자와 쉼표, 공백 이외의 문자가 포함되면 예외가 발생한다")
    void 당첨_번호에_숫자와_쉼표_공백_이외의_문자가_포함되면_예외가_발생한다() {
        // given
        String input = "1, 2, a, 4, 5, 6";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다")
    void 보너스_번호가_숫자가_아니면_예외가_발생한다() {
        // given
        String input = "a";
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        // given
        String input = "6";
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(input, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 1부터 45 사이의 범위를 벗어나면 예외가 발생한다")
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("0", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());

        assertThatThrownBy(() -> InputValidator.validateBonusNumber("46", winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
    }
}
