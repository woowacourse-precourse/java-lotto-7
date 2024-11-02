package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validator.InputValueValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValueValidatorTest {

    @DisplayName("구매 금액이 숫자인지 확인")
    @Test
    void 구매_금액이_숫자인지_확인() {
        assertThat(InputValueValidator.validateAndParseAmount("1000")).isEqualTo(1000);
    }

    @DisplayName("구매 금액이 숫자가 아니면 예외 발생")
    @Test
    void 구매_금액이_숫자가_아니면_예외_발생() {
        assertThatThrownBy(() -> InputValueValidator.validateAndParseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 숫자로 입력해야 합니다.");
    }

    @DisplayName("구매 금액이 음수면 예외 발생")
    @Test
    void 구매_금액이_음수면_예외_발생() {
        assertThatThrownBy(() -> InputValueValidator.validateAndParseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 음수가 될 수 없습니다.");
    }

    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외 발생")
    @Test
    void 구매_금액이_1_000원_단위가_아니면_예외_발생() {
        assertThatThrownBy(() -> InputValueValidator.validateAndParseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 구매 금액은 1,000원 단위로 입력해야 합니다.");
    }

    @DisplayName("당첨 번호가 숫자로만 구성되었는지 확인")
    @Test
    void 당첨_번호가_숫자로만_구성되었는지_확인() {
        assertThat(InputValueValidator.validateAndParseWinningNumbers("1,2,3,4,5,6"))
                .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 값이 포함되면 예외 발생")
    @Test
    void 당첨_번호에_숫자가_아닌_값이_포함되면_예외_발생() {
        assertThatThrownBy(() -> InputValueValidator.validateAndParseWinningNumbers("1,2,a,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 쉼표로 구분된 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호가 중복되면 예외 발생")
    @Test
    void 당첨_번호가_중복되면_예외_발생() {
        assertThatThrownBy(() -> InputValueValidator.validateAndParseWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 당첨 번호는 중복되지 않아야 합니다.");
    }

    @DisplayName("보너스 번호가 음수이면 예외 발생")
    @Test
    void 보너스_번호가_음수이면_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValueValidator.validateAndParseBonusNumber("-1", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 음수가 될 수 없습니다.");
    }

    @DisplayName("보너스 번호가 숫자가 아니면 예외 발생")
    @Test
    void 보너스_번호가_숫자가_아니면_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValueValidator.validateAndParseBonusNumber("abc", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 숫자로 입력해야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외 발생")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValueValidator.validateAndParseBonusNumber("5", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
    }

}
