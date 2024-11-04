package lotto.domain;

import static lotto.exception.ExceptionCode.DUPICATED_ERROR;
import static lotto.exception.ExceptionCode.NON_SIX_NUMBERS;
import static lotto.exception.ExceptionCode.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class SixNumbersTest {

    @Test
    void 여섯개_미만의_숫자를_입력한다() {
        assertThatThrownBy(() -> new SixNumbers(List.of(1,2,3,4,5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(OUT_OF_RANGE.getMessage());
    }

    @Test
    void 여섯개_초과의_숫자를_입력한다() {
        assertThatThrownBy(() -> new SixNumbers(List.of(1,2,3,4,5,6,7)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NON_SIX_NUMBERS.getMessage());
    }

    @Test
    void 허용_숫자_범위_밖의_숫자를_입력한다() {
        assertThatThrownBy(() -> new SixNumbers(List.of(1,2,3,4,5,50)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(NON_SIX_NUMBERS.getMessage());
    }

    @Test
    void 중복된_숫자를_입력한다() {
        assertThatThrownBy(() -> new SixNumbers(List.of(1,2,3,4,5,5)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPICATED_ERROR.getMessage());
    }
}
