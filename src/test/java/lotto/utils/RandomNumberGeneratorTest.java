package lotto.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_NUMBERS_TO_DRAW;

public class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤하게 생성된 번호가 정렬된 상태로 반환되는지 테스트")
    void testGenerateOrderedNumbers() {
        List<Integer> generatedNumbers = RandomNumberGenerator.generateOrderedNumbers();

        Assertions.assertTrue(isSorted(generatedNumbers));

        Assertions.assertEquals(LOTTO_NUMBERS_TO_DRAW, generatedNumbers.size());

        for (Integer number : generatedNumbers) {
            Assertions.assertTrue(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER);
        }
    }

    private boolean isSorted(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
