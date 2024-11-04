package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusNumberTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @DisplayName("보너스 번호를 잘못 입력함")
    @MethodSource("provideBonusNumberArguments")
    void test3(String inputMoney, String winningNumbers, String bonusNumber) {
        assertSimpleTest(() -> {
            runException(inputMoney, winningNumbers, bonusNumber);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    private static Stream<Arguments> provideBonusNumberArguments() {
        return Stream.of(
                Arguments.of("1000","1,2,3,4,5,6","a"),
                Arguments.of("1000","1,2,3,4,5,6"," "),
                Arguments.of("1000","1,2,3,4,5,6","1,2")
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
