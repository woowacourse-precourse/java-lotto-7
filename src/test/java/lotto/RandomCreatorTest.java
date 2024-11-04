package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RandomCreatorTest {

    @Test
    void 범위내의_숫자들을_랜덤_생성한다() {
        //given
        RandomCreator randomCreator = new RandomCreator(1, 6, 6);

        //when
        List<Integer> randomNumbers = randomCreator.createRandomNumbers().stream()
                .sorted()
                .toList();

        //then
        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        Assertions.assertThat(randomNumbers).isEqualTo(expectedNumbers);

    }
}
