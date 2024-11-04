package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또가 정상적으로 생산된다.")
    @Test
    void test1() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(numbers, lotto.getNumbers());
    }

    @DisplayName("로또의 번호가 6개 초과일 시 예외 반환한다")
    @Test
    void test2() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 45 초과이면 예외가 발생한다.")
    @Test
    void test3() {
        assertThatThrownBy(() -> new Lotto(List.of(46)))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 번호가 1 미만이면 예외가 발생한다.")
    @Test
    void test4() {
        assertThatThrownBy(() -> new Lotto(List.of(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 다른 로또 번호가 몇 개 일치하는지 반환한다")
    @Test
    void test5() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 41, 42, 43));
        assertEquals(3, lotto.countDuplicatingCount(lottoNumbers));
    }
}
