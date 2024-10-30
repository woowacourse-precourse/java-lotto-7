package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoWinningNumbersTest {
    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로또_번호에_3이_포함되어_있다() {
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertTrue(lottoWinningNumbers.contains(3), "숫자 3이 포함되어 있습니다.");
    }

    @Test
    public void 로또_번호에_7이_포함되어_있지않다() {
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertFalse(lottoWinningNumbers.contains(7), "숫자 7이 포함되어 있지 않습니다.");
    }

}