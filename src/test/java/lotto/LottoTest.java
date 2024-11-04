package lotto;

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

    @Test
    void 당첨_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> Application.validateWinningNums(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Application.validateWinningNums(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 중복될 수 없습니다.");
    }

    @Test
    void 당첨_번호에_범위를_벗어나는_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Application.validateWinningNums(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("당첨 번호는 1부터 45 사이의 숫자 6개여야 합니다.");
    }

    @Test
    void 보너스_번호가_범위를_벗어나는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> Application.validateBonusNum(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    void 보너스_번호가_정상_범위에_있을_경우_성공한다() {
        Application.validateBonusNum(10); // 예외가 발생하지 않으면 성공
    }



}
