package lotto.model;

import static lotto.model.LottoConstants.LOTTO_NUMBERS_SIZE;
import static lotto.model.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.model.LottoConstants.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {

    @Test
    @DisplayName("중복되지 않는 6개의 숫자를 생성한다.")
    void should_GenerateUniqueNumbers() {
        // given
        LottoNumbersGenerator lottoGenerator = new LottoNumbersGenerator();

        // when
        List<Integer> lottoNumbers = lottoGenerator.generate();
        long distinctCount = lottoNumbers.stream()
                .distinct()
                .count();

        // then
        assertAll(
                () -> assertEquals(lottoNumbers.size(), distinctCount),
                () -> assertEquals(lottoNumbers.size(), LOTTO_NUMBERS_SIZE)
        );
    }

    @Test
    @DisplayName("로또 번호는 1~45 사이의 숫자여야 한다.")
    void should_GenerateValidRangeNumbers() {
        // given
        LottoNumbersGenerator lottoGenerator = new LottoNumbersGenerator();

        // when
        List<Integer> lottoNumbers = lottoGenerator.generate();
        boolean allNumbersWithinRange = lottoNumbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);

        // then
        assertThat(allNumbersWithinRange).isTrue();
    }
}
