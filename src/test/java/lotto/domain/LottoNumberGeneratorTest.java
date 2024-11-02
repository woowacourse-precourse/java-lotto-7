package lotto.domain;

import static lotto.domain.LottoConstants.COUNT_OF_LOTTO_NUMBERS;
import static lotto.domain.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoConstants.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoNumberGeneratorTest {
    @DisplayName("주어진 범위 내의 중복되지 않는 숫자를 원하는 개수만큼 생성한다.")
    @ParameterizedTest
    @MethodSource()
    void generateUniqueNumbersInRange(int minNumber, int maxNumber, int count) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(minNumber, maxNumber, count);

        List<Integer> actualNumbers = lottoNumberGenerator.generateLottoNumber();

        assertThat(actualNumbers.size()).isEqualTo(count);
        assertThat(actualNumbers.stream().distinct().count()).isEqualTo(count);
        for (Integer actualNumber : actualNumbers) {
            assertThat(actualNumber)
                    .isGreaterThanOrEqualTo(minNumber)
                    .isLessThanOrEqualTo(maxNumber);
        }
    }

    private static Stream<Arguments> generateUniqueNumbersInRange() {
        return Stream.of(
                Arguments.of(0, 50, 10),
                Arguments.of(0, 950000, 100000),
                Arguments.of(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, COUNT_OF_LOTTO_NUMBERS)
        );
    }
}