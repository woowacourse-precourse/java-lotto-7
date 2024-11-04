package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    private static final List<Integer> FIVE_NUMBER = Arrays.asList(1, 2, 3, 4, 5);
    private static final List<Integer> DUPLICATED_NUMBER = Arrays.asList(1, 1, 2, 3, 4, 5);
    private static final List<Integer> OUT_OF_RANGE = Arrays.asList(1, 2, 3, 4, 5, 46);


    @Test
    void 로또_번호가_6개가_아닌_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(FIVE_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 중복된_번호가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(DUPLICATED_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위를_벗어난_번호가_있는_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(OUT_OF_RANGE))
                .isInstanceOf(IllegalArgumentException.class);
    }

}