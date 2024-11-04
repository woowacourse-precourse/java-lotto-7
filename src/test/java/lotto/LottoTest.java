package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성

    @DisplayName("로또 번호는 불변성을 가지므로 get 메서드는 복사본을 호출함.")
    @Test
    void 로또_번호_호출() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(lotto.getNumbersValue(), List.of(1, 2, 3, 4, 5, 6));

        List<Integer> numbers = lotto.getNumbersValue();
        numbers.set(0, 100);

        assertEquals(lotto.getNumbersValue(), List.of(1, 2, 3, 4, 5, 6));
    }

}
