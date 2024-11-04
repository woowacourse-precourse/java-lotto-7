package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.of(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 객체 생성 테스트")
    void 객체_생성_테스트() {
        List<Integer> numbers = List.of(6, 3, 4, 2, 1, 5);
        Lotto lotto = Lotto.of(numbers);

        Assertions.assertEquals("[1, 2, 3, 4, 5, 6]", lotto.toString());
    }

    @Test
    @DisplayName("contains 메서드 테스트")
    void contains_테스트() {
        List<Integer> numbers = List.of(6, 3, 4, 2, 1, 5);
        Lotto lotto = Lotto.of(numbers);

        Assertions.assertTrue(lotto.contains(6));
        Assertions.assertFalse(lotto.contains(7));
    }

    @Test
    @DisplayName("matchingCountWith 메서드 테스트")
    void matchingCountWith_테스트() {
        Lotto lotto1 = Lotto.of(List.of(6, 3, 4, 2, 1, 5));
        Lotto lotto2 = Lotto.of(List.of(1, 8, 4, 35, 21, 7));
        Lotto lotto3 = Lotto.of(List.of(9, 8, 12, 35, 21, 7));

        Assertions.assertEquals(2, lotto1.matchingCountWith(lotto2));
        Assertions.assertEquals(0, lotto1.matchingCountWith(lotto3));
    }
}
