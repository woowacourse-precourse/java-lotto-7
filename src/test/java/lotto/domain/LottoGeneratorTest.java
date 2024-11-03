package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @DisplayName("금액에 따라 구매 가능한 로또 개수가 올바르게 계산되는지 확인")
    @ParameterizedTest
    @CsvSource({"3000, 3", "10000, 10"})
    void calculateLottoCount(int amount, int expectedCount) {
        assertThat(LottoGenerator.howManyLottos(amount)).isEqualTo(expectedCount);
    }

    @DisplayName("로또 구매 금액이 유효 범위를 벗어나면 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"500", "150000"})
    void amountRangeValidation(int invalidAmount) {
        assertThatThrownBy(() -> LottoGenerator.howManyLottos(invalidAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 1000원 단위가 아니면 예외가 발생한다")
    @Test
    void amountUnitValidation() {
        assertThatThrownBy(() -> LottoGenerator.howManyLottos(1_500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지정된 개수만큼의 로또가 생성되는지 확인")
    @ParameterizedTest
    @CsvSource({"5", "10"})
    void generateLottos(int count) {
        List<Lotto> lottos = LottoGenerator.getLottos(count);
        assertThat(lottos).hasSize(count);

        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(LottoGenerator.NUMBER_COUNT);
            assertThat(lotto.getNumbers()).allMatch(number ->
                    number >= LottoGenerator.MIN_NUMBER && number <= LottoGenerator.MAX_NUMBER);
        }
    }
}