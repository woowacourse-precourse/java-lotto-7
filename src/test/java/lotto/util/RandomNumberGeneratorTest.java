package lotto.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @Test
    @DisplayName("중복되지 않는 1 ~ 45 사이의 숫자 6개를 만들 수 있다.")
    void 난수_생성_테스트() throws Exception {
        // given
        randomNumberGenerator = new RandomNumberGenerator();

        // when
        List<Integer> randomNumbers = randomNumberGenerator.generateLottoNumbers();

        // then
        HashSet<Integer> set = new HashSet<>(randomNumbers);
        assertEquals(6, randomNumbers.size());
        assertEquals(6, set.size());
        assertTrue(randomNumbers.stream().allMatch(num -> num >= 1 && num <= 45));
    }
}
