package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lottos.Lotto;
import org.assertj.core.api.AssertionsForClassTypes;
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

    @Test
    void 로또_번호_개수_미달_예외_처리() {
        List<Integer> result = new ArrayList<>(List.of(
                1, 2, 3, 4, 5
        ));
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_개수_초과_예외_처리() {
        List<Integer> result = new ArrayList<>(List.of(
                1, 2, 3, 4, 5, 6, 7, 8
        ));
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_범위_예외_처리() {
        List<Integer> result = new ArrayList<>(List.of(
                48, 1, 2, 3, 4, 5
        ));
        AssertionsForClassTypes.assertThatThrownBy(() -> new Lotto(result))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}
