package lotto.processor;

import lotto.domain.LottoBonusNumber;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusNumberProcessorTest {

    @ParameterizedTest
    @ValueSource(strings = { "0", "a", "46"})
    void 입력값_보너스_번호_예외(String input) {
        assertThatThrownBy(() -> new LottoBonusNumberProcessor().process(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("보너스_번호_입력")
    void 입력값_보너스_번호_처리_성공(String input, int expected) {
        //when
        LottoBonusNumberProcessor lottoBonusNumberProcessor = new LottoBonusNumberProcessor();
        LottoBonusNumber lottoBonusNumber = lottoBonusNumberProcessor.process(input);

        //then
        assertThat(lottoBonusNumber.getNumber()).isEqualTo(expected);
    }

    static Stream<Arguments> 보너스_번호_입력() {
        return Stream.of(
                Arguments.of("12", 12),
                Arguments.of("45", 45),
                Arguments.of("30", 30)
        );
    }
}