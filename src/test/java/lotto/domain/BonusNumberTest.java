package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    private static final String TWO_BONUS_NUMBER = "2,3";
    private static final String NOT_NUMBER = "a";
    private static final String OUT_OF_RANGE = "46";
    private static final String DUPLICATED_NUMBER = "1";

    @BeforeEach
    void setUp() {
        BonusNumber.resetInstance();
    }

    @Test
    void 보너스_번호에_한개_이상의_숫자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.initialInstance(TWO_BONUS_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호에_숫자가_아닌_값이_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.initialInstance(NOT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_1과_45_사이를_벗어났다면_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> BonusNumber.initialInstance(OUT_OF_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복됐다면_예외가_발생한다() {
        WinningNumbers.initialInstance(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThatThrownBy(() -> BonusNumber.initialInstance(DUPLICATED_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
