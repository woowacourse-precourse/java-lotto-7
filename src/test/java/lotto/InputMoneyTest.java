package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import global.errorMessage.BonusNumberErrorMessage;
import global.errorMessage.MoneyErrorMessage;
import global.errorMessage.NumberErrorMessage;
import java.util.stream.Stream;
import lotto.domain.InputMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InputMoneyTest {

    @ParameterizedTest
    @MethodSource("provideInputMoneyArguments")
    @DisplayName("구입 금액 입력 오류")
    void test1(long amount, String errorMessage) {
        assertThatThrownBy(() -> new InputMoney(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideInputMoneyArguments() {
        return Stream.of(
                Arguments.of(1234, MoneyErrorMessage.INVALID_MONEY_FORMAT.getMessage()),
                Arguments.of(-1000,MoneyErrorMessage.OUT_OF_RANGE.getMessage())
        );
    }
}
