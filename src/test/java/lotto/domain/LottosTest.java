package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 중복된_로또가_존재하면_예외가_발생한다() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto1 = new Lotto(numbers);
        Lotto lotto2 = new Lotto(numbers);  // 같은 번호의 로또

        // when & then
        assertThatThrownBy(() -> new Lottos(Arrays.asList(lotto1, lotto2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 중복되지_않은_로또들로_생성할_수_있다() {
        // given
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));

        // when & then
        assertDoesNotThrow(() -> new Lottos(Arrays.asList(lotto1, lotto2)));
    }
}
