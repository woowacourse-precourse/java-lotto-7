package lotto.util.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoGeneratorTest {

    @ParameterizedTest(name = "({index}) {0}")
    @MethodSource("argumentsForGenerateLotto")
    @DisplayName("올바른 숫자 리스트를 주입할 경우, 유효한 로또 객체를 생성한다.")
    void generateLotto(
            // given
            List<Integer> givenAvailableNumbers
    ) {
        // when & then
        assertThatCode(() -> LottoGenerator.generateLotto(givenAvailableNumbers))
                .doesNotThrowAnyException();
    }
    static Stream<Arguments> argumentsForGenerateLotto() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 2, 3, 4, 5, 6)
                ),
                Arguments.of(
                        List.of(40, 41, 42, 43, 44, 45)
                )
        );
    }

    @RepeatedTest(value = 100, name = "trial time : {currentRepetition}/{totalRepetitions}")
    @DisplayName("몇 번을 반복하든 자동으로 유효한 로또 객체를 생성한다.")
    void generateAutoLotto() {
        // when & then
        assertThatCode(LottoGenerator::generateAutoLotto)
                .doesNotThrowAnyException();
    }
}