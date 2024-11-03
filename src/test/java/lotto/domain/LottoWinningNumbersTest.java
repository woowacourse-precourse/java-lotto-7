package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumbersTest {
    @Test
    void 당첨_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 5), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호가_1에서_45사이가_아니면_예외가_발생한다(){
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 46, -1), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1에서_45사이가_아니라면_예외가_발생한다(){
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호와_보너스_번호가_중복되면_예외가_발생한다(){
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);

    }
}