package lotto.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoNumberGeneratorTest {

    @Test
    void numberCountTest() {
        List<Integer> numbers = new LottoNumberGenerator().generate();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void numberRangeTest() {
        List<Integer> numbers = new LottoNumberGenerator().generate();

        for (Integer number : numbers) {
            assertThat(number).isBetween(1, 45);
        }
    }
}