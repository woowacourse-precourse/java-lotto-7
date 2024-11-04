package lotto.entity;

import static lotto.exception.LottoExceptionMessage.DUPLICATE_NUMBERS;
import static lotto.exception.LottoExceptionMessage.INVALID_NUMBER_COUNT;
import static lotto.exception.LottoExceptionMessage.NULL_OR_EMPTY_NUMBERS;
import static lotto.exception.LottoExceptionMessage.NUMBER_OUT_OF_RANGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    void 성공__로또_번호_정상_테스트() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 20, 44, 45);

        // when
        Lotto lotto = new Lotto(integers);

        // then
        assertEquals(integers, lotto.getNumbers());
    }

    @Test
    void 성공__로또_번호_정렬_테스트() {
        // given
        List<Integer> integers = List.of(20, 5, 3, 10, 44, 45);

        // when
        Lotto lotto = new Lotto(integers);

        // then
        assertEquals(integers.stream().sorted().toList(), lotto.getNumbers());
    }

    @Test
    void 실패__로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(INVALID_NUMBER_COUNT.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호의_개수가_부족할떄() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(INVALID_NUMBER_COUNT.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 5);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(DUPLICATE_NUMBERS.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_위로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 46);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호에_정해진_범위를_벗어나는_숫자가_있으면_예외가_발생한다_아래로() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 0);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호에_음수가_들어갔을때() {
        // given
        List<Integer> integers = List.of(1, 2, 3, 4, 5, -10);

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NUMBER_OUT_OF_RANGE.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호_객체가_널이_들어갔을떄() {
        // given
        List<Integer> integers = null;

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NULL_OR_EMPTY_NUMBERS.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호_객체가_비어있을때() {
        // given
        List<Integer> integers = List.of();

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NULL_OR_EMPTY_NUMBERS.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 실패__로또_번호중_NULL이_있을때() {
        // given
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, null));

        // when
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> new Lotto(integers));

        // then
        assertEquals(NULL_OR_EMPTY_NUMBERS.getMessage(), illegalArgumentException.getMessage());
    }

    @Test
    void 성공__로또_contains_테스트() {
        // given
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        boolean contains = new Lotto(integers).contains(4);

        // then
        assertTrue(contains);
    }

    @Test
    void 로또_getter_불변성_확인() {
        // given
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        Lotto lotto = new Lotto(integers);
        List<Integer> numbers = lotto.getNumbers();

        // then
        assertThrowsExactly(UnsupportedOperationException.class, () -> numbers.add(7));
    }

    @Test
    void 로또_정적펙토리_테스트() {
        for (int i = 0; i < 10; i++) {
            Lotto.createRandomLotto();
        }
    }
}