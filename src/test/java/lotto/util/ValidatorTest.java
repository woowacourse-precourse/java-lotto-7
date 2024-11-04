package lotto.util;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

public class ValidatorTest {

    @Test
    @DisplayName("유효한 구매 금액은 통과해야 한다.")
    void 유효한_구매_금액은_통과해야_한다() {
        assertThatCode(() -> Validator.validatePurchaseAmount("1000")).doesNotThrowAnyException();
        assertThatCode(() -> Validator.validatePurchaseAmount("5000")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("구매 금액이 숫자가 아니면 예외가 발생해야 한다.")
    void 구매_금액이_숫자가_아니면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("구매 금액이 1,000원 미만이면 예외가 발생해야 한다.")
    void 구매_금액이_1000원_미만이면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount("500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    @DisplayName("구매 금액이 1,000원 단위가 아니면 예외가 발생해야 한다.")
    void 구매_금액이_1000원_단위가_아니면_예외가_발생해야_한다() {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("유효한 당첨 번호는 통과해야 한다.")
    void 유효한_당첨_번호는_통과해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> Validator.validateWinningNumbers(winningNumbers)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생해야 한다.")
    void 당첨_번호가_6개가_아니면_예외가_발생해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 정확히 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 1~45 범위를 벗어나면 예외가 발생해야 한다.")
    void 당첨_번호가_범위를_벗어나면_예외가_발생해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> Validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생해야 한다.")
    void 보너스_번호가_숫자가_아니면_예외가_발생해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validator.validateBonusNumber("abc", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 숫자만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어나면 예외가 발생해야 한다.")
    void 보너스_번호가_범위를_벗어나면_예외가_발생해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validator.validateBonusNumber("0", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생해야 한다.")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> Validator.validateBonusNumber("3", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    @DisplayName("유효한 보너스 번호는 통과해야 한다.")
    void 유효한_보너스_번호는_통과해야_한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatCode(() -> Validator.validateBonusNumber("7", winningNumbers)).doesNotThrowAnyException();
    }
}
