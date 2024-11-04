package lotto.model.number_generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DefaultRandomNumberGenerator 테스트")
public class DefaultRandomNumberGeneratorTest {

    private static final DefaultRandomNumberGenerator defaultRandomNumberGenerator = new DefaultRandomNumberGenerator();

    @ParameterizedTest(name = "startInclusive: {0}, endInclusive: {1}, count: {2}")
    @CsvSource(value = {"1,45,6", "1,10,7", "1,20,8", "20,45,9", "30,45,10"}, delimiter = ',')
    void 범위_내의_중복되지_않는_랜덤_숫자를_생성한다(int startInclusive, int endInclusive, int count) {

        // when
        List<Integer> generatedNumbers =
                defaultRandomNumberGenerator.pickUniqueNumbersInRange(startInclusive, endInclusive, count);

        // then
        assertThat(generatedNumbers).hasSize(count);
        assertThat(generatedNumbers).doesNotHaveDuplicates();
    }
}
