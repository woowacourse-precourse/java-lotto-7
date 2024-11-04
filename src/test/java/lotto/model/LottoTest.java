package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @Test
    @DisplayName("로또 번호의 개수가 6개를 넘어가면 예외가 발생한다.")
    void should_ThrowException_When_LottoNumbersException() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 1보다 작은 숫자가 있으면 예외가 발생한다.")
    void should_ThrowException_When_LottoNumberBelowMinimum() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 45보다 큰 숫자가 있으면 예외가 발생한다.")
    void should_ThrowException_When_LottoNumberAboveMaximum() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    void should_ThrowException_When_LottoNumbersHaveDuplicates() {
        // when & then
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호는 오름차순으로 정렬되어야 한다.")
    void should_SortLottoNumbersInAscendingOrder() {
        // given
        List<Integer> descendingNumbers = List.of(6, 5, 4, 3, 2, 1);

        // when
        Lotto lotto = new Lotto(descendingNumbers);

        // then
        assertEquals(lotto.getAllNumbers(), List.of(1, 2, 3, 4, 5, 6));
    }
}
