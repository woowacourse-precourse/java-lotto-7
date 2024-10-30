package lotto.utils;

import lotto.utils.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {
    @DisplayName("랜덤숫자 6개 생성")
    @Test
    void 랜덤_숫자6개_생성(){
        List<Integer> numbers = RandomNumberGenerator.genreateNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }
}