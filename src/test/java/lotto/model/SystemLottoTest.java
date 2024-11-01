package lotto.model;

import lotto.util.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SystemLottoTest {
    private SystemLotto systemLotto;

    @BeforeEach
    void setUp() {
         systemLotto = new SystemLotto();
    }

    @Test
    void 생성된_숫자_범위_확인() {
        List<Integer> numbers = systemLotto.getNumbers();
        assertTrue(numbers.stream().allMatch(num -> num >= Constants.MIN_LOTTO_NUMBER && num <= Constants.MAX_LOTTO_NUMBER));
    }

    @Test
    void 생성된_숫자_개수_확인() {
        List<Integer> numbers = systemLotto.getNumbers();
        assertEquals(Constants.LOTTO_NUMBER_COUNT, numbers.size());
    }

    @Test
    void 중복_없는_숫자_확인() {
        List<Integer> numbers = systemLotto.getNumbers();
        long uniqueCount = numbers.stream().distinct().count();
        assertEquals(Constants.LOTTO_NUMBER_COUNT, uniqueCount);
    }

    @Test
    void 오름차순_메소드_확인() {
        String sortedNumbers = systemLotto.getSortedNumbers();

        List<Integer> numbers = Arrays.stream(sortedNumbers.split(Constants.DELIMITER_COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        assertTrue(isSorted(numbers));
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
