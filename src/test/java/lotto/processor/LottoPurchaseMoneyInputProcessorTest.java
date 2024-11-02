package lotto.processor;

import lotto.domain.LottoPurchaseMoney;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPurchaseMoneyInputProcessorTest {

    @ParameterizedTest
    @ValueSource(strings = { "a", "0", "120001"})
    void 입력값_구매_금액_예외(String input) {
        assertThatThrownBy(() -> new LottoPurchaseMoneyInputProcessor().process(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("구매_금액_입력")
    void 입력값_구매_금액_처리_성공(String input, long expectedMoney, long expectedCount) {
        //when
        LottoPurchaseMoneyInputProcessor lottoPurchaseMoneyInputProcessor = new LottoPurchaseMoneyInputProcessor();
        LottoPurchaseMoney lottoPurchaseMoney = lottoPurchaseMoneyInputProcessor.process(input);

        //then
        assertThat(lottoPurchaseMoney.getMoney()).isEqualTo(expectedMoney);
        assertThat(lottoPurchaseMoney.getCount()).isEqualTo(expectedCount);
    }

    static Stream<Arguments> 구매_금액_입력() {
        return Stream.of(
                Arguments.of("2000", 2_000L, 2L),
                Arguments.of("14000", 14_000L, 14L),
                Arguments.of("1000", 1_000L, 1L),
                Arguments.of("7000", 7_000L, 7L),
                Arguments.of("390000", 390_000L, 390L)
        );
    }
}