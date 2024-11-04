package lotto.domain;

import static lotto.exception.ExceptionCode.DUPICATED_ERROR;
import static lotto.exception.ExceptionCode.OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoException;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 이미_당첨_번호로_입력한_번호를_보너스_번호로_입력한다() {
        assertThatThrownBy(() -> new WinningNumbers(new SixNumbers(List.of(1,2,3,4,5,6)), new BonusNumber(1)))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(DUPICATED_ERROR.getMessage());
    }
}
