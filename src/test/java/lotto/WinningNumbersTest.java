package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @DisplayName("당첨 번호와 보너스 번호는 중복이 되면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스_번호는_중복이_되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("당첨 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void 당첨_번호가_6개면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5), 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("6개여야");
    }
    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 4, 6), 7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복될 수 없습니다");
    }

}
