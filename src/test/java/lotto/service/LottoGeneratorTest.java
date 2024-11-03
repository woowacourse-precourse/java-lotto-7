package lotto.service;

import lotto.ErrorCode;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @Test
    @DisplayName("구입 금액에 맞게 로또를 생성한다")
    void generateLottosWithPrice() {
        // given
        LottoGenerator generator = new LottoGenerator("5000");

        // when
        Lottos lottos = generator.generateLottos();

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("커스텀 번호 생성기로 로또를 생성한다")
    void generateLottosWithCustomNumberGenerator() {
        // given
        List<Integer> fixedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGenerator generator = new LottoGenerator("1000", () -> fixedNumbers);

        // when
        Lottos lottos = generator.generateLottos();

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(1);
        assertThat(lottos.toString()).contains(fixedNumbers.toString());
    }

    @Test
    @DisplayName("잘못된 형식의 금액이 입력될 때 예외 발생")
    void testInvalidPriceFormat() {
        // when & then
        assertThatThrownBy(() -> new LottoGenerator("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PRICE_POSITIVE_INTEGER.getErrorMessage());
    }

    @Test
    @DisplayName("0보다 작은 금액이 입력될 때 예외 발생")
    void testNegativePrice() {
        // when & then
        assertThatThrownBy(() -> new LottoGenerator("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage());
    }

    @Test
    @DisplayName("1000으로 나눠지지 않는 금액이 입력될 때 예외 발생")
    void testNonDivisiblePrice() {
        // when & then
        assertThatThrownBy(() -> new LottoGenerator("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.PRICE_DIVIDABLE_BY_UNIT.getErrorMessage());
    }
}
