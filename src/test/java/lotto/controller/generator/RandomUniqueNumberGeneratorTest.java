package lotto.controller.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RandomUniqueNumberGeneratorTest {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 6;
    private static final int COUNT = 6;

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("생성된 숫자 리스트의 길이가 요청한 개수와 동일하다.")
        void generatesSize() {
            // given
            RandomUniqueNumberGenerator generator = new RandomUniqueNumberGenerator(MIN_VALUE, MAX_VALUE);

            // when
            List<Integer> generatedNumbers = generator.generate(COUNT);

            // then
            assertThat(generatedNumbers).hasSize(COUNT);
        }

        @Test
        @DisplayName("생성된 숫자 리스트가 고유한 값으로 구성된다.")
        void generatesUniqueNumbers() {
            // given
            RandomUniqueNumberGenerator generator = new RandomUniqueNumberGenerator(MIN_VALUE, MAX_VALUE);

            // when
            List<Integer> generatedNumbers = generator.generate(COUNT);

            // then
            assertThat(generatedNumbers).doesNotHaveDuplicates();
        }

        @Test
        @DisplayName("생성된 숫자가 최소값과 최대값 사이에 값만 존재한다.")
        void generatesNumbersInRange() {
            // given
            RandomUniqueNumberGenerator generator = new RandomUniqueNumberGenerator(MIN_VALUE, MAX_VALUE);

            // when
            List<Integer> generatedNumbers = generator.generate(COUNT);

            // then
            assertThat(generatedNumbers).allMatch(number -> number >= MIN_VALUE && number <= MAX_VALUE);
        }
    }
}
