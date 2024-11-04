package lotto.domain;

import static lotto.global.Error.LOTTO_NUMBER_IS_DUPLICATED;
import static lotto.global.Error.LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.domain.LottoBonus;
import org.junit.jupiter.api.Test;

class LottoBonusTest {

    @Test
    void 로또_당첨_번호와_보너스_번호가_중복시_예외가_발생한다() {
        assertThatThrownBy(() -> new LottoBonus(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_IS_DUPLICATED.getErrorMsg());
    }

    @Test
    void 로또_번호가_1과_46_사이가_아닐시_예외가_발생() {
        assertThatThrownBy(() -> new LottoBonus(50, List.of(1, 2, 3, 4, 5, 40)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_IS_NOT_BETWEEN_1_AND_46.getErrorMsg());
    }
}