package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {
    @Test
    @DisplayName("보너스_번호가_1부터_45_내의_양수가_아니면_예외가_발생한다")
    void 보너스_번호가_1부터_45_내의_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("보너스_번호가_당첨_번호와_중복되면_예외가_발생한다")
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto(List.of(1,2,3,4,5,6)),6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복 될 수 없습니다.");
    }

}