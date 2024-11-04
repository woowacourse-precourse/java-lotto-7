package lotto.strategy.number;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoNumberGeneratorTest {

    @Test
    @DisplayName("1부터 45 사이의 중복되지 않는 6개의 번호가 생성되는지 테스트")
    void testGenerate() {
        RandomLottoNumberGenerator generator = new RandomLottoNumberGenerator();
        List<Integer> numbers = generator.generate();

        // 번호 개수 확인
        assertEquals(6, numbers.size());

        // 번호가 1부터 45 사이에 있는지 확인
        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 45);
        }

        // 번호 중복 여부 확인
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        assertEquals(6, uniqueNumbers.size());
    }
}
