package lotto.util.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

public class RandomNumberGeneratorTest {
    private final int min = 1;
    private final int max = 45;
    private final int count = 6;

    @Test
    void 생성된_숫자가_정상범위에_있는지_검증() {
        List<Integer> generatedNumbers = RandomNumberGenerator.generateUniqueRandomNumbers(min, max, count);

        for (int number : generatedNumbers) {
            assertTrue(number >= min && number <= max);
        }
    }

    @Test
    void 생성된_숫자_개수_검증() {
        List<Integer> generatedNumbers = RandomNumberGenerator.generateUniqueRandomNumbers(min, max, count);

        assertEquals(count, generatedNumbers.size());
    }

    // 생성된 숫자들이 중복이 없는지 테스트
    @Test
    void 생성된_숫자_중복_검증() {
        List<Integer> generatedNumbers = RandomNumberGenerator.generateUniqueRandomNumbers(min, max, count);

        long uniqueCount = generatedNumbers.stream().distinct().count();
        assertEquals(count, uniqueCount);
    }
}
