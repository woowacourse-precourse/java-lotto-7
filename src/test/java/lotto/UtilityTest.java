package lotto;

import static org.assertj.core.api.Assertions.*;

import lotto.Utility.RandomNumberCreator;
import org.junit.jupiter.api.Test;
import java.util.List;

public class UtilityTest {
    @Test
    public void 랜덤한_6개의_수를_뽑아서_List로_반환한다() {
        List<Integer> randomNumbers = RandomNumberCreator.generateRandomNumbers();

        assertThat(randomNumbers).hasSize(6);
        assertThat(randomNumbers).allMatch(number -> 1 <= number && number <= 45);
    }
}
