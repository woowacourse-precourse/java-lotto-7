package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoPurchaseTest {

    @ParameterizedTest
    @ValueSource(longs = {100L, 1L, 20001L, 300L})
    void 구매_금액은_1000으로_나누어_떨어지지_않으면_예외가_발생_한다(long money) {
        assertThatThrownBy(() -> new LottoPurchase(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("구매_금액_및_로또_발행_개수")
    void 구매_금액에_따른_로또_발행_개수를_저장한다(long moeny, long expectedLottoCount) {
        //given
        LottoPurchase lottoPurchase = new LottoPurchase(moeny);

        //when
        long lottoCount = lottoPurchase.getCount();

        //then
        assertThat(lottoCount).isEqualTo(expectedLottoCount);
    }

    static Stream<Arguments> 구매_금액_및_로또_발행_개수() {
        return Stream.of(
                Arguments.of(2_000L, 2L),
                Arguments.of(14_000L, 14L),
                Arguments.of(1_000L, 1L),
                Arguments.of(7_000L, 7L),
                Arguments.of(390_000L, 390L)
        );
    }
}
