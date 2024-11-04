package lotto.io.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusNumberInputConsoleHandlerTest {
    @ParameterizedTest
    @MethodSource("nonIntegerInputs")
    @DisplayName("보너스 번호는 정수를 입력해야 한다")
    void nonIntegerInputThrowException(String input, String errorMessage) {
        // given
        BonusNumberInputConsoleHandler bonusNumberInputConsoleHandler = new BonusNumberInputConsoleHandler();
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // when, then
        assertThatThrownBy(bonusNumberInputConsoleHandler::askBonusNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);

        System.setIn(System.in);
        Console.close();
    }


    private static Stream<Arguments> nonIntegerInputs() {
        return Stream.of(
                Arguments.arguments("1.5", "[ERROR] 보너스 번호의 형식이 잘못되었습니다."),
                Arguments.arguments("a", "[ERROR] 보너스 번호의 형식이 잘못되었습니다."),
                Arguments.arguments("ㄱ", "[ERROR] 보너스 번호의 형식이 잘못되었습니다."),
                Arguments.arguments("-1.2", "[ERROR] 보너스 번호의 형식이 잘못되었습니다."),
                Arguments.arguments("23.5", "[ERROR] 보너스 번호의 형식이 잘못되었습니다."),
                Arguments.arguments(System.lineSeparator(), "[ERROR] 보너스 번호의 형식이 잘못되었습니다."),
                Arguments.arguments("    ", "[ERROR] 보너스 번호의 형식이 잘못되었습니다.")
        );
    }
}
