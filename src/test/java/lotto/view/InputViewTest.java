package lotto.view;

import lotto.validator.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외가 발생한다.")
    @Test
    void 숫자가_아닌_값을_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 유효한 숫자를 입력해 주세요.");
    }

    @DisplayName("유효한 구입 금액을 입력하면 해당 금액을 반환한다.")
    @Test
    void 유효한_구입_금액을_입력하면_해당_금액을_반환한다() {
        int amount = InputValidator.validatePurchaseAmount("3000");
        assertThat(amount).isEqualTo(3000);
    }

    @DisplayName("당첨 번호가 1미만 45초과 라면 예외가 발생한다.")
    @Test
    void 당첨_번호가_1미만_45초과_라면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumber(List.of(-1, 0, 3, 4, 5, 100)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 번호는 1부터 45 사이어야 합니다.");
    }

    @DisplayName("보너스 번호가 1미만 45초과 라면 예외가 발생한다.")
    @Test
    void 보너스_번호가_1미만_45초과_라면_예외가_발생한다() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(0, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이어야 합니다.");
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber(1, winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }
}