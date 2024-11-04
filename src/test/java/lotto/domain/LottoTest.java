package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.service.Random;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoTest {

    private static final Random random = new Random();

    private static final List<Integer> FIVE_NUMBER = random.NumberIssue(1, 45, 5);
    private static final List<Integer> DUPLICATED_NUMBER = Arrays.asList(1, 1, 2, 3, 4, 5);
    private static final List<Integer> OUT_OF_RANGE = random.NumberIssue(45, 90, 6);

    @Test
    void 로또_번호가_6개가_발급되는지_테스트를_진행한다() {
        List<Integer> integers = random.NumberIssue(1, 45, 6);
        Assertions.assertThat(integers.size()).isEqualTo(6);
    }

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