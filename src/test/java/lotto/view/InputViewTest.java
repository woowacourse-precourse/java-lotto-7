package lotto.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("구입 금액이 1,000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입금액_단위_예외발생() {
        // given
        int amount = 1500;

        // when & then
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        ErrorMessage.ERROR_PREFIX + ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND);
    }

    @DisplayName("당첨 번호 입력이 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨번호_개수_예외발생() {
        // given
        String input = "1,2,3,4,5";

        // when & then
        assertThatThrownBy(() -> InputView.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.WINNING_NUMBER_COUNT_INVALID);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_중복_예외발생() {
        // given
        String input = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> InputView.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_DUPLICATED);
    }

    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생한다.")
    @Test
    void 보너스번호_범위_예외발생() {
        // given
        int bonusNumber = 46;
        Lotto winningLotto = new Lotto(InputView.parseNumbers("1,2,3,4,5,6"));

        // when & then
        assertThatThrownBy(() -> InputView.validateBonusNumber(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스번호_중복_예외발생() {
        // given
        int bonusNumber = 6;
        Lotto winningLotto = new Lotto(InputView.parseNumbers("1,2,3,4,5,6"));

        // when & then
        assertThatThrownBy(() -> InputView.validateBonusNumber(bonusNumber, winningLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_DUPLICATED);
    }

    @DisplayName("구입 금액이 0원이면 예외가 발생한다.")
    @Test
    void 구입금액_0원_예외발생() {
        // given
        int amount = 0;

        // when & then
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PREFIX + ErrorMessage.PURCHASE_AMOUNT_INVALID);
    }

    @DisplayName("구입 금액이 음수이면 예외가 발생한다.")
    @Test
    void 구입금액_음수_예외발생() {
        // given
        int amount = -1000;

        // when & then
        assertThatThrownBy(() -> InputView.validatePurchaseAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PREFIX + ErrorMessage.PURCHASE_AMOUNT_INVALID);
    }

    @DisplayName("당첨 번호 입력에 숫자가 아닌 값이 있으면 예외가 발생한다.")
    @Test
    void 당첨번호_숫자가아닌값_예외발생() {
        // given
        String input = "1,2,3,4,5,a";

        // when & then
        assertThatThrownBy(() -> InputView.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PREFIX + ErrorMessage.LOTTO_NUMBER_NOT_NUMBER);
    }

    @DisplayName("보너스 번호 입력에 숫자가 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void 보너스번호_숫자가아닌값_예외발생() {
        // given
        String input = "a";
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when & then
        assertThatThrownBy(() -> InputView.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_PREFIX + ErrorMessage.BONUS_NUMBER_NOT_NUMBER);
    }
}
