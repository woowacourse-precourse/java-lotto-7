package lotto.domain;

import static lotto.exception.ExceptionCode.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    void 허용_숫자_범위_밖의_숫자를_입력한다() {
        assertThatThrownBy(() -> new BonusNumber(50))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(OUT_OF_RANGE.getMessage());
    }
}
