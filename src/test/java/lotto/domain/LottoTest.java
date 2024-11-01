package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 오름차순으로 정렬한다.")
    @Test
    void 로또_번호를_오름차순으로_정렬한다() {
        List<Integer> unorderedNumbers = new ArrayList<>(Arrays.asList(6, 5, 4, 3, 2, 1));

        Lotto lotto = new Lotto(unorderedNumbers);

        Assertions.assertThat(lotto)
                .isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
