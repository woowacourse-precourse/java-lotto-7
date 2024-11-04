package lotto;

import lotto.domain.Lotto;
import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1부터 45까지 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_1부터_45까지_외의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5, 199)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호에 1부터 45까지 외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호에_1부터_45까지_외의_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("10,40,30,20,50,41"))
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호에_중복이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("10,40,24,24,20,30"))
                .hasMessageContaining("[ERROR] 로또 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
    }

    @DisplayName("로또 당첨 번호와 보너스 번호가 중복이 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호와_보너스_번호가_중복이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningBonusNumbers(List.of(10,40,24,21,25,26), 26))
                .hasMessageContaining("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
    }

    @DisplayName("로또 당첨 번호에 정수가 아닌 문자가 있으면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호에_정수가_아닌_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("10,40,24,21,25,ui"))
                .hasMessageContaining("[ERROR] 로또 당첨 번호는 정수로 이루어져야 합니다.");
    }

    @DisplayName("로또 당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 로또_당첨_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("10,40,24,21,25"))
                .hasMessageContaining("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 보너스 번호가 정수가 아닌 문자면 예외가 발생한다.")
    @Test
    void 로또_보너스_번호가_정수가_아닌_문자면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("9o"))
                .hasMessageContaining("[ERROR] 로또 보너스 번호는 정수로 이루어져야 합니다.");
    }

    @DisplayName("로또 보너스 번호가 1부터 45까지 외의 숫자면 예외가 발생한다.")
    @Test
    void 로또_보너스_번호가_1부터_45까지_외의_숫자면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("46"))
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("로또 구입 금액이 정수가 아니면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_정수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchasePrice("14000j"))
                .hasMessageContaining("[ERROR] 로또 구입 금액은 정수여야 합니다.");
    }

    @DisplayName("로또 구입 금액이 1000원 미만이면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000원_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchasePrice("900"))
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원 이상이어야 합니다.");
    }

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchasePrice("10007"))
                .hasMessageContaining("[ERROR] 로또 구입 금액은 1000원으로 나누어 떨어져야 합니다.");
    }
}
