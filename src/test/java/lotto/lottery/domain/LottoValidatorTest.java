package lotto.lottery.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.Stream;
import lotto.global.util.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoValidatorTest {

    @Test
    @DisplayName("1000원 단위라면 정상적으로 작동한다")
    void normalLottoPrice() throws Exception {
        // given
        int amount = 5000;

        // then
        assertDoesNotThrow(() -> LottoValidator.validateAmount(amount));
    }

    @ParameterizedTest
    @DisplayName("1000원 단위가 아니라면 에러를 반환한다")
    @MethodSource("providedInvalidAmount")
    void invalidAmountError(int amount) throws Exception {
        // then
        assertThatThrownBy(() -> LottoValidator.validateAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_AMOUNT.getMessage());
    }

    private static Stream<Arguments> providedInvalidAmount(){
        return Stream.of(
                Arguments.arguments(1500),
                Arguments.arguments(5200),
                Arguments.arguments(8900),
                Arguments.arguments(4100)
        );
    }

}