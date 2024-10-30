package lotto.entity;

import static lotto.exception.LottoExceptionMessage.DUPLICATE_NUMBERS;
import static lotto.exception.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.NUMBER_OUT_OF_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 로또_번호_정상_테스트() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 20, 44, 45);

        // when
        Lotto lotto = new Lotto(integers);
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(INVALID_NUMBER_COUNT.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(DUPLICATE_NUMBERS.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 로또_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_위로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 46);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 로또_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_아래로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 0);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }
}