package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {
    @Test
    void 숫자6개뽑기테스트() {
        // given
        List<Integer> numbers = LottoGenerator.generateLottoNumbers();

        // when
        // then
        assertThat(numbers.size()).isEqualTo(6);

    }
}