package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {
    @Test
    @DisplayName("입력값이 옳은 경우 정상적으로 작동한다.")
    void 입력값이_옳은_경우_정상적으로_작동한다() {
        // given
        int validAmount = 3000;

        // when // then
        assertThat(new LottoService().validateAmount(validAmount)).isTrue();
    }

    @Test
    @DisplayName("입력값이 양수가 아닐 경우 예외가 발생한다.")
    void 입력값이_양수가_아닐_경우_예외가_발생한다() {
        // given
        int invalidAmount = -1000;

        // when // then
        assertThatThrownBy(() -> new LottoService().validateAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 양수만 입력 가능합니다.");
    }

    @Test
    @DisplayName("입력값이 1,000원 단위가 아닐 경우 예외가 발생한다.")
    void 입력값이_1000원_단위가_아닐_경우_예외가_발생한다() {
        // given
        int invalidAmount = 1500;

        // when // then
        assertThatThrownBy(() -> new LottoService().validateAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
    }

    @Test
    @DisplayName("입력값이 1,000원으로 나누어 떨어지지 않는 경우 예외가 발생한다.")
    void 입력값이_1000원으로_나누어_떨어지지_않는_경우_예외가_발생한다() {
        // given
        int invalidAmount = 2500;

        // when // then
        assertThatThrownBy(() -> new LottoService().validateAmount(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");
    }
}