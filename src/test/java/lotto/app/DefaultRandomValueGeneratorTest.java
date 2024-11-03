package lotto.app;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class DefaultRandomValueGeneratorTest {

    @Test
    void 여섯개의_수를_생성한다() {
        DefaultRandomValueGenerator generator = new DefaultRandomValueGenerator();
        List<Integer> numbers = generator.generate();
        assertThat(numbers.size()).isEqualTo(6);
    }
}