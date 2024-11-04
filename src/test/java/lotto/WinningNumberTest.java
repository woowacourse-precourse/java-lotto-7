package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class WinningNumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @DisplayName("당첨 금액을 잘못 입력함")
    @MethodSource("provideWinningNumberArguments")
    void test2(String inputMoney, String winningNumbers) {
        assertSimpleTest(() -> {
            runException(inputMoney, winningNumbers);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    private static Stream<Arguments> provideWinningNumberArguments() {
        return Stream.of(
                Arguments.of("3000","1.2.3.4.5.6"),
                Arguments.of("3000","1,2,3,4,5"),
                Arguments.of("3000","1,2,3,4,5,r"),
                Arguments.of("3000"," ")
        );
    }
}
