package lotto.support.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("랜덤 정수 생성기 테스트")
class RandomIntegerGeneratorTest {

    @Test
    @DisplayName("1~45 사이의 중복되지 않은 6개의 로또 번호를 생성한다")
    void 성공_생성() {
        // Given
        RandomIntegerGenerator generator = new RandomIntegerGenerator();

        // When
        List<List<? extends Number>> numbers = generator.generateNumbersBy(BigDecimal.ONE);

        // Then
        assertAll(
                () -> assertThat(numbers.size()).isEqualTo(1),
                () -> assertThat(numbers.get(0).stream().distinct().count()).isEqualTo(6),
                () -> assertThat(numbers.get(0).stream().map(Number::intValue).allMatch(i -> i >= 1 && i <= 45)).isTrue()
        );
    }
}
