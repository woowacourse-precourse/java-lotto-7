package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import global.errorMessage.NumberErrorMessage;
import global.errorMessage.WinningNumberErrorMessage;
import java.util.stream.Stream;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest {

    @ParameterizedTest
    @DisplayName("당첨 금액을 잘못 입력함")
    @MethodSource("provideWinningNumberArguments")
    void test2(String winningNumbers,String errorMessage) {
        assertThatThrownBy(() -> new WinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }


    private static Stream<Arguments> provideWinningNumberArguments() {
        return Stream.of(
                Arguments.of("1.2.3.4.5.6", WinningNumberErrorMessage.INVALID_WINNING_NUMBER_SIZE.getMessage()),
                Arguments.of("1,2,3,4,5", WinningNumberErrorMessage.INVALID_WINNING_NUMBER_SIZE.getMessage()),
                Arguments.of("1,2,3,4,5,r", NumberErrorMessage.NOT_A_NUMBER.getMessage()),
                Arguments.of(" ", WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage()),
                Arguments.of("1,2,3,4,5,200", NumberErrorMessage.OUT_OF_RANGE.getMessage()),
                Arguments.of(",1,3", WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage()),
                Arguments.of("1,3,", WinningNumberErrorMessage.INVALID_WINNING_NUMBER_FORMAT.getMessage())
        );
    }
}
