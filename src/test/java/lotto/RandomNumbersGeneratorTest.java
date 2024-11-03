package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.Assertions;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersGeneratorTest {

    @Test
    @DisplayName("generate를 통해 랜덤 번호 6개를 생성한다")
    void generate() {
        RandomNumbersGenerator generator = new RandomNumbersGenerator();
        ArrayList<Integer> mockedNumbers = new ArrayList<>(List.of(25, 12, 42, 3, 34, 19));
        Assertions.assertRandomUniqueNumbersInRangeTest(() -> {
            List<Integer> numbers = generator.generate();
            assertThat(numbers).isEqualTo(mockedNumbers);
        }, mockedNumbers);
    }
}
