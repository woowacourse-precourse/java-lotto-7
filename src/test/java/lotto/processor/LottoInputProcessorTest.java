package lotto.processor;

import lotto.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputProcessorTest {

    @ParameterizedTest
    @ValueSource(strings = { "0,1,2,3,4,5", "1,2,3,4,5", "1,2,3,4,5,6,7", "123,456,789,123,456,789"})
    void 입력값_로또_번호_예외(String input) {
        assertThatThrownBy(() -> new LottoInputProcessor().process(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("로또_번호_입력")
    void 입력값_로또_번호_처리_성공(String input, List<Integer> expected) {
        //when
        LottoInputProcessor lottoInputProcessor = new LottoInputProcessor();
        Lotto lotto = lottoInputProcessor.process(input);

        //then
        assertThat(lotto.getNumbers()).isEqualTo(expected);
    }

    static Stream<Arguments> 로또_번호_입력() {
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of("11, 12, 13, 14, 15, 16", List.of(11, 12, 13, 14, 15, 16)),
                Arguments.of("21, 22, 23, 24, 25, 26", List.of(21, 22, 23, 24, 25, 26)),
                Arguments.of("31, 32, 33, 34, 35, 36", List.of(31, 32, 33, 34, 35, 36))
        );
    }
}