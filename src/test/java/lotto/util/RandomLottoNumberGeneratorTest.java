package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomLottoNumberGeneratorTest {

    @Test
    void pickUnique6Numbers() {
        //given,when
        List<Integer> integerList = RandomLottoNumberGenerator.pickUnique6Numbers();

        //then
        assertThat(integerList)
                .hasSize(6)
                .doesNotHaveDuplicates()
                .allMatch(num -> num >= 1 && num <= 45);
    }
}
