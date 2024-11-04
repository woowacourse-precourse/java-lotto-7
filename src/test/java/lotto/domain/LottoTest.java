package lotto.domain;

import static lotto.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;


class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .withMessage(LOTTO_COUNT_LIMIT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .withMessage(DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호가 1 ~ 45를 벗어나면 예외가 발생한다.")
    @Test
    void 로또_번호가_특정_범위를_넘어가면_예외가_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() ->  new Lotto(List.of(1, 2, 3, 4, 5, 48)))
                .withMessage(OUT_OF_RANGE_NUMBER.getMessage());
    }

    @DisplayName("올바르게 입력했을 때 - 오름차순으로 정렬해서 List로 반환")
    @Test
    void 로또_번호가_바르게_입력됐을_때_오름차순해서_보여준다(){
        // given
        List<Integer> numbers = List.of(10, 5, 18, 3, 44, 20);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        List<Integer> expected = List.of(3, 5, 10, 18, 20, 44);
        assertEquals(expected, lotto.getNumbers());
    }


}
