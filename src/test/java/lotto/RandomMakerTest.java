package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomMakerTest {
    @DisplayName("RandomNumber 생성 테스트")
    @Test
    void RandomNumber_생성_테스트() {
        List<Integer> randomNumbers = RandomMaker.getRandomNumbers(6);

        assertThat(randomNumbers)
                .hasSize(6)
                .allMatch(num -> 1 <= num && num <= 45);
    }
}
