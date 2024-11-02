package lotto;

import static lotto.LottoConstants.NUMBER_COUNT;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomMakerTest {
    @DisplayName("RandomNumber 생성 테스트")
    @RepeatedTest(1000)
    void RandomNumber_생성_테스트() {
        List<Integer> randomNumbers = RandomMaker.getRandomNumbers(NUMBER_COUNT);
        Set<Integer> randomUniqueNumbers = new HashSet<>(randomNumbers);
        assertThat(randomUniqueNumbers)
                .hasSize(NUMBER_COUNT)
                .allMatch(num -> 1 <= num && num <= 45);
    }
}
