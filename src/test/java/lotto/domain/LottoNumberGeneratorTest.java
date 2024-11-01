package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("로또 번호 생성기")
class LottoNumberGeneratorTest {

    @Test
    @DisplayName("1~45 사이의 중복되지 않은 6개의 로또 번호를 생성한다")
    void 성공_생성() {
        // Given
        LottoNumberGenerator generator = new LottoNumberGenerator();

        // When
        List<Integer> numbers = generator.generateNumbers();

        // Then
        assertAll(
                () -> assertThat(numbers).hasSize(6),
                () -> assertThat(numbers.stream().distinct().count()).isEqualTo(6),
                () -> assertThat(numbers.stream().allMatch(i -> i >= 1 && i <= 45)).isTrue()
        );
    }
}
