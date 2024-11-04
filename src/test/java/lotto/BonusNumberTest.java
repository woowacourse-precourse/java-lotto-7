package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import global.errorMessage.BonusNumberErrorMessage;
import global.errorMessage.NumberErrorMessage;
import java.util.stream.Stream;
import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BonusNumberTest {

    @DisplayName("보너스 금액 입력 오류")
    @ParameterizedTest
    @MethodSource("provideBonusNumberArguments")
    void test1(String input,String errorMessage) {
        assertThatThrownBy(() -> new BonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideBonusNumberArguments() {
        return Stream.of(
                Arguments.of("a", NumberErrorMessage.NOT_A_NUMBER.getMessage()),
                Arguments.of(" ", NumberErrorMessage.NOT_A_NUMBER.getMessage()),
                Arguments.of("1,2", BonusNumberErrorMessage.INVALID_FORMAT.getMessage()),
                Arguments.of("10000", BonusNumberErrorMessage.OUT_OF_RANGE.getMessage())
        );
    }
}
