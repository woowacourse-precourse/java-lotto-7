package lotto.basic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class NumbersGeneratorTest {
    @DisplayName("조건에 맞는 랜덤 숫자를 생성함")
    @Test
    void test1() {
        NumbersGenerator numbersGenerator = new NumbersGenerator();
        final int min = 1;
        final int max = 10;
        final int size = 3;

        List<Integer> result = numbersGenerator.random(min, max, size);

        assertThat(result.size()).isEqualTo(size);
        assertThat(result).allMatch(num -> min <= num && num <= max);
    }

}